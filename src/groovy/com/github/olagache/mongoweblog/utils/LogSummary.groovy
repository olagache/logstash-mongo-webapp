package com.github.olagache.mongoweblog.utils

import java.text.ParseException
import java.text.SimpleDateFormat

class LogSummary {

    private static String DATE_FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";    // 2012-10-30T12:15:23.192Z
    private static String DATE_FORMAT_2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'000Z'"; // 2012-10-30T12:15:23.192000Z

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
            parsingDate = new SimpleDateFormat(DATE_FORMAT_2).parse(dateAsString)
        }
        catch (ParseException e1) {
            try {
                parsingDate = new SimpleDateFormat(DATE_FORMAT_1).parse(dateAsString);
            }
            catch (ParseException e2) {
                return null;
            }
        }
        return parsingDate;
    }
}
