package com.company.model;

public abstract class MailModel {
    private String mailBodyHtml;
    private String mailSubject;
    private String mailBodyParagraph;


    public abstract void prepareMailSubject();
    public abstract void prepareMailBodyHtml();
    public abstract void prepareMailBodyParagraph();

    public String getMailBodyHtml() {
        return mailBodyHtml;
    }

    public void setMailBodyHtml(String mailBodyHtml) {
        this.mailBodyHtml = mailBodyHtml;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailBodyParagraph() {
        return mailBodyParagraph;
    }

    public void setMailBodyParagraph(String mailBodyParagraph) {
        this.mailBodyParagraph = mailBodyParagraph;
    }
}
