package Util;

/**
 * @author SiletFlower
 * @date 2020/12/13 21:11:38
 * @description
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {

    @Autowired
    private MailUtil mailUtil;

    @Test
    public void test1(){
        mailUtil.sendMail("测试","zhaogenting@163.com","测试");
    }
}
