package com.codesmiths.structures;

import com.codesmiths.priority.Priority;

import java.util.Date;

public class Email {
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private String attachments;
    private Date sendDate;
    private Priority priority;

    public Email(String sender, String recipient, String subject, String body, String attachments, Date sendDate, Priority priority) {
        this.setSender(sender.substring(1, sender.length() - 1));
        this.setRecipient(recipient.substring(1, recipient.length() - 1));
        this.setSubject(subject.substring(1, subject.length() - 1));
        this.setBody(body.substring(1, body.length() - 1));
        this.setAttachments(attachments.substring(1, attachments.length() - 1));
        this.setSendDate(sendDate);
        this.setPriority(priority);
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}