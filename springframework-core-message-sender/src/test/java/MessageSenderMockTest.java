import com.nhnacademy.edu.springframework.MessageSendService;
import com.nhnacademy.edu.springframework.MessageSender;
import com.nhnacademy.edu.springframework.SmsMessageSender;
import com.nhnacademy.edu.springframework.User;
import com.nhnacademy.edu.springframework.aop.TimeLoggingAspect;
import com.nhnacademy.edu.springframework.config.JavaConfig;
import com.nhnacademy.edu.springframework.config.MainConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.mockito.Mockito.*;

public class MessageSenderMockTest {

    @Test
    void testSender(){
        MessageSender smsSender = Mockito.mock(SmsMessageSender.class);
        MessageSendService messageSendService = new MessageSendService(smsSender, "kim");

        User user = new User("b@b.com", "010");

        Mockito.when(smsSender.sendMessage(user, "m")).thenReturn(true);

        boolean actual = messageSendService.doSendMessage(user, "hi");

        Mockito.verify(smsSender, Mockito.times(1)).sendMessage(any(User.class), any(String.class));
    }

}

@SpringJUnitConfig(classes = {MainConfig.class, JavaConfig.class, TimeLoggingAspect.class})
class ConfigClassApplicationContextTests {
    @Autowired
    @InjectMocks
    private MessageSendService messageSendService;

    @Mock
    private MessageSender messageSender;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        when(messageSender.sendMessage(new User("b@b.com", "010"), "this")).thenReturn(false);
    }

    @Test
    void testMessageSender(){
        messageSendService.setMessageSender(messageSender);
        boolean actual = messageSendService.doSendMessage(new User("b@b.com", "010"), "hi");
        Assertions.assertThat(actual).isEqualTo(true);
    }
}