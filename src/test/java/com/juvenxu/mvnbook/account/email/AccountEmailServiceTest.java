package com.juvenxu.mvnbook.account.email;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.icegreen.greenmail.util.GreenMail;
import com.juvenxu.mvnbook.account.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Component
public class AccountEmailServiceTest {

	private GreenMail greenMail;

	@Autowired
	private AccountEmailService accountEmailService;

	@Autowired
	private AccountMailSender accountMailSender;

	@Before
	public void startMailServer() {
		greenMail = new GreenMail();
		greenMail.setUser("tcwxx@gmail.com", "TC19880822");
		greenMail.start();
	}

	@Value("${wxx}")
	public String wxx;

	@Test
	public void testSendMail() throws Exception {
		String subject = "Test Subject";
		String htmlText = "<h3>Test</h3>";

		System.out.println(accountMailSender.getHost().toString() + "=========================");
		System.out.println(wxx + "=========================");

		accountEmailService.sendMail("tcwangxiaoxi@163.com", subject, htmlText);

		greenMail.waitForIncomingEmail(2000, 1);

		// MimeMessage[] receivedMessages = greenMail.getReceivedMessages();

		// assertEquals(1, receivedMessages.length);
		// assertEquals(subject, receivedMessages[0].getSubject());
		// assertEquals(htmlText,
		// GreenMailUtil.getBody(receivedMessages[0]).trim());

	}
}
