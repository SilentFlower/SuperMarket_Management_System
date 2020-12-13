package Util;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

/**
 * @author SiletFlower
 * @date 2020/12/13 20:55:14
 * @description
 */
@Component
public class MailUtil {

    @Autowired
    private JavaMailSender Javamail;

    @Value("${mail.fromAddress}")
    private  String from;

    @SneakyThrows
    public void sendMail(String message, String to, String subject){
        MimeMessage mimeMessage = Javamail.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("747671555@qq.com");
        helper.setText(message,true);
        helper.setTo(to);
        helper.setSubject(subject);
        try {
            Javamail.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
