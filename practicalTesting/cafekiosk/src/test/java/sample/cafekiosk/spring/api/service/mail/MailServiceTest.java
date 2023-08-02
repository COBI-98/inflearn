package sample.cafekiosk.spring.api.service.mail;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

    @Mock
    private MailSendClient mailSendClient;

//    @Spy //spy //
//    private MailSendClient mailSendClient;

    @Mock
    private MailSendHistoryRepository mailSendHistoryRepository;

    @InjectMocks // DI
    private MailService mailService;

    @DisplayName("메일을 전송 테스트")
    @Test
    void sendMail() throws Exception {
        //stubbing @Spy 일부만 stubbing 잘 사용하진 않음
//        doReturn(true)
//                .when(mailSendClient)
//                .sendMail(anyString(),anyString(),anyString(),anyString());

        //given
//        stubbing      //anyString() == any(String.class) // 실제 객체 기반
//        when(mailSendClient.sendMail(anyString(),anyString(),anyString(),anyString()))
//                .thenReturn(true);
        given(mailSendClient.sendMail(anyString(),anyString(),anyString(),anyString()))
                .willReturn(true);


        //when
        boolean result = mailService.sendMail("", "", "", "");

        //then
        Assertions.assertThat(result).isTrue();

        // 검증, 몇번 불렸나, 인자로는 mailSendHistory
        verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class)); //
    }
}