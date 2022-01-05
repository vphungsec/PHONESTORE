package web.model;

public class MailObject {
	private String senderName;
	private String recipientMail;
	private String subject;
	private String messageBody;
	
	public MailObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MailObject(String senderName, String recipientMail, String subject, String messageBody) {
		super();
		this.senderName = senderName;
		this.recipientMail = recipientMail;
		this.subject = subject;
		this.messageBody = messageBody;
	}

	public String getSenderName() {
		return senderName;
	}
	
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String getRecipientMail() {
		return recipientMail;
	}

	public void setRecipientMail(String recipientMail) {
		this.recipientMail = recipientMail;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	
}
