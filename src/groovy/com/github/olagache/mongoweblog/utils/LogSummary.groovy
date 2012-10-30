package com.github.olagache.mongoweblog.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import org.apache.commons.lang.StringUtils

class LogSummary {

    private static String DATE_FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";    // 2012-10-30T12:15:23.192Z

    /** Application names list contains in this logger */
    public List<String> applicationNames

    /** log count in this logger */
    public long count

    private Date startDate
    private Date endDate

    /* Getter / setter */

    Date getStartDate() {
        return startDate
    }

    void setStartDate(Date startDate) {
        this.startDate = startDate
    }

    void setStartDate(String startDate) {
        this.startDate = toDate(startDate)
    }

    Date getEndDate() {
        return endDate
    }

    void setEndDate(Date endDate) {
        this.endDate = endDate
    }

    void setEndDate(String endDate) {
        this.endDate = toDate(endDate)
    }

    private Date toDate(String dateAsString) {
        Date parsingDate = null;

        try {
            parsingDate = new SimpleDateFormat(DATE_FORMAT_1).parse(normalize(dateAsString))
        }
        catch (ParseException e1) {
                return null;
            }
        return parsingDate;
    }

    private String normalize(String dateAsString) {
        String millis = StringUtils.substringAfterLast(dateAsString,".");
        if(millis.length() > 4 && millis.endsWith("000Z")) {
            String normalizedDate = StringUtils.replace(dateAsString, "000Z", "Z");
            return normalizedDate;
        }
        return dateAsString;
    }
}
