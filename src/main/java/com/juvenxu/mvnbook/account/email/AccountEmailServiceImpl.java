package com.juvenxu.mvnbook.account.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.juvenxu.mvnbook.account.email.exception.AccountEmailException;

@Service
public class AccountEmailServiceImpl implements AccountEmailService {

	@Autowired
	private AccountMailSender accountMailSender;

	@Override
	public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {

		try {
			MimeMessage msg = accountMailSender.createMimeMessage();
			MimeMessageHelper msgHelper = new MimeMessageHelper(msg);

			msgHelper.setFrom(accountMailSender.getSystemEmail());
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(htmlText, true);

			// accountMailSender.send(msg);
			System.out.println("Successed to send mail.(" + msgHelper.toString() + ")");
		} catch (MessagingException e) {
			throw new AccountEmailException("Faild to send mail.", e);
		}

	}
}
