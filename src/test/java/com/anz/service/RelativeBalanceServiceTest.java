package com.anz.service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class RelativeBalanceServiceTest {

    @Test
    public void testRelativeBalance_ACC334455() throws ParseException {

        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date fromDate = dateFormat.parse("20/10/2018 12:00:00");
        Date toDate = dateFormat.parse("20/10/2018 19:00:00");
        Map<String,String> result=relativeBalanceService.process("ACC334455",fromDate,toDate);
        assertEquals(result.get("balance"),"-$25.00");
        assertEquals("1",result.get("count"));
    }

    @Test
    public void testRelativeBalance_ACC778899() throws ParseException {

        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date fromDate = dateFormat.parse("20/10/2018 12:00:00");
        Date toDate = dateFormat.parse("20/10/2018 19:00:00");
        Map<String,String> result=relativeBalanceService.process("ACC778899",fromDate,toDate);
        assertEquals(result.get("balance"),"$30.00");
        assertEquals("2",result.get("count"));
    }

    @Test
    public void testRelativeBalance_ACC998877() throws ParseException {

        RelativeBalanceService relativeBalanceService = new RelativeBalanceService();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date fromDate = dateFormat.parse("20/10/2018 12:00:00");
        Date toDate = dateFormat.parse("20/10/2018 19:00:00");
        Map<String,String> result=relativeBalanceService.process("ACC998877",fromDate,toDate);
        assertEquals(result.get("balance"),"-$5.00");
        assertEquals("1",result.get("count"));
    }
}
