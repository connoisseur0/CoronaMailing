package com.company;

import com.company.model.MailModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailContent {
    private static Logger log = LogManager.getLogger(MailContent.class);
    private String mailBody;
    private String mailSubject;

    public MailContent() {
    }

    public void prepareMailContent(MailModel dataFromApi) {
       if (dataFromApi != null) {
           dataFromApi.prepareMailSubject();
           dataFromApi.prepareMailBodyParagraph();
           dataFromApi.prepareMailBodyHtml();

           setMailSubject(dataFromApi.getMailSubject());
           setMailBody(dataFromApi.getMailBodyHtml());
           log.info(String.format("Prepared new mail dataFromApi with subject: %s", dataFromApi.getMailSubject()));
       }
       else {
           log.error("No data from api");
       }

    }
    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

}
