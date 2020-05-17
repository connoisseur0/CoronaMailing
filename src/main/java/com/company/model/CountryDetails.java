package com.company.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountryDetails extends MailModel {
    public long updated;
    public int cases;
    public int todayCases;
    public int deaths;
    public int todayDeaths;
    public int recovered;
    public int active;
    public int critical;
    public float casesPerOneMillion;
    public float deathsPerOneMillion;
    public int tests;
    public float testsPerOneMillion;
    public int affectedCountries;

    private static Logger log = LogManager.getLogger(CountryDetails.class);
    private String htmlBodyTitle;
    private String htmlBodyFirstParagraph;
    private String htmlBodyFirstColumnText;
    private String htmlBodySecondColumnsText;

    public CountryDetails() {
    }

    public CountryDetails(long updated, int cases, int todayCases, int deaths, int todayDeaths, int recovered, int active, int critical, int casesPerOneMillion, int deathsPerOneMillion, int tests, float testsPerOneMillion, int affectedCountries) {
        this.updated = updated;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casesPerOneMillion = casesPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.tests = tests;
        this.testsPerOneMillion = testsPerOneMillion;
        this.affectedCountries = affectedCountries;
    }

    public int getCases() {
        return cases;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public float getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(float casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public float getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(float deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public float getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(float testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public int getAffectedCountries() {
        return affectedCountries;
    }

    public void setAffectedCountries(int affectedCountries) {
        this.affectedCountries = affectedCountries;
    }


    @Override
    public String toString() {
        return "CountryDetails{" +
                "cases=" + getCases() +
                ", deaths=" + getDeaths() +
                ", recovered=" + getRecovered() +
                ", updated=" + getUpdated() +
                ", active=" + getActive() +
                '}';
    }


    @Override
    public void prepareMailSubject() {
        setMailSubject("Przyp: " + this.getCases() +
                " Zgony: " + this.getDeaths() +
                " Wyzdr: " + this.getRecovered() +
                " Akt.zach:" + this.getActive());
    }

    @Override
    public void prepareMailBodyHtml() {
        htmlBodyTitle = "<b>Raport COVID-19</b>\n";
        htmlBodyFirstParagraph =  getMailBodyParagraph() + "\n";
        htmlBodyFirstColumnText = "Sprawdź moją stronę internetową. Zawiera linki do serwisów w których jestem aktywny.\n";
        htmlBodySecondColumnsText = "Jeśli chcesz zobaczyć reszte moich projektów sprawdź zakładke Projects na mojej stronie.\n";
        setMailBodyHtml("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "<title>Demystifying Email Design</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; padding: 0;\">\n" +
                "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"> \n" +
                "        <tr>\n" +
                "            <td style=\"padding: 10px 0 30px 0;\">\n" +
                "                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 1px solid #cccccc; border-collapse: collapse;\">\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\" bgcolor=\"#fff\" style=\"padding: 40px 0 30px 0; color: #153643; font-size: 28px; font-weight: bold; font-family: Arial, sans-serif;\">\n" +
                "                            <img src=\"https://wilamowski.it/blog/wp-content/uploads/2020/04/3506_9955_wizyt_wki-ozdobne_602509-e1586986631478.jpg\" alt=\"Creating Email Magic\" style=\"display: block;\" />\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td bgcolor=\"#fRffff\" style=\"padding: 40px 30px 40px 30px;\">\n" +
                "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                <tr>\n" +
                "                                    <td style=\"color: #153643; font-family: Arial, sans-serif; font-size: 24px;\">\n" +
                htmlBodyTitle +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td style=\"padding: 20px 0 30px 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;\">\n" +
                htmlBodyFirstParagraph +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td>\n" +
                "                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                            <tr>\n" +
                "                                                <td width=\"260\" valign=\"top\">\n" +
                "                                                <td style=\"font-size: 0; line-height: 0;\" width=\"20\">\n" +
                "                                                    &nbsp;\n" +
                "                                                </td>\n" +
                "                                                <td width=\"260\" valign=\"top\">\n" +
                "                                                </td>\n" +
                "                                            </tr>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td bgcolor=\"navy\" style=\"padding: 30px 30px 30px 30px;\">\n" +
                "                            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                <tr>\n" +
                "                                        <a href=\"https://wilamowski.it\" style=\"color: #ffffff;\">wilamowski.it<font color=\"#ffffff\"> 2020</font></a> \n" +
                "       <a style=\"color: #ffffff;\">#stayathome<font color=\"#ffffff\"></font></a> \n"+
                "                                    </td>\n" +
                "                                    <td align=\"right\" width=\"25%\">\n" +
                "                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </table>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    public void prepareMailBodyParagraph() {
        setMailBodyParagraph("Do tej pory stwierdzono<br>" +
                " Przypadkow: " + this.getCases() + "<br>" +
                " Zgonow: " + this.getDeaths() + "<br>" +
                " Wyzdrowien: " + this.getRecovered() + "<br>" +
                " Aktualnie chorujacych:" + this.getActive());
    }
}
