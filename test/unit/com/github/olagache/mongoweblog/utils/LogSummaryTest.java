package com.github.olagache.mongoweblog.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.Assert;

public class LogSummaryTest {

    @Test
    public void setStandardDate() throws Exception {
        String dateAsString = "2012-10-30T12:15:23.192Z";

        LogSummary logSummary = new LogSummary();
        logSummary.setStartDate(dateAsString);

        Assert.assertEquals(getTestingDate(), logSummary.getStartDate());
    }

    @Test
    public void setCatalinaDate() throws Exception {
        String dateAsString = "2012-10-30T12:15:23.192000Z";

        LogSummary logSummary = new LogSummary();
        logSummary.setStartDate(dateAsString);

        Assert.assertEquals(getTestingDate(), logSummary.getStartDate());
    }

/*
    @Test
    public void just4testing() {
        String DATE_FORMAT_1 = "yyyy-MM-dd'T'HH:mm:ss.SSS'000Z'";

        System.out.println(new SimpleDateFormat(DATE_FORMAT_1).format(new Date()));

    }
*/

    /**
     * @return  2012-10-30T12:15:23.192Z as date
     */
    private Date getTestingDate() {
        GregorianCalendar testingDate = new GregorianCalendar(2012,(10-1),30,12,15,23);

        testingDate.add(Calendar.MILLISECOND, 192);

        return testingDate.getTime();
    }
}
