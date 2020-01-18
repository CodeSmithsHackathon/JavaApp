package com.codesmiths;

import java.util.Date;

public class Email {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private String attachments;
    private Date sendDate;

    public Email(String sender, String recipient, String subject, String body, String attachments, Date sendDate) {
        this.setSender(sender);
        this.setRecipient(recipient);
        this.setSubject(subject);
        this.setBody(body);
        this.setAttachments(attachments);
        this.setSendDate(sendDate);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}