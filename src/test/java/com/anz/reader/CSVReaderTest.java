package com.anz.reader;

import com.anz.model.Transaction;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {

    @Test
    public void testRelativeBalance_ACC334455() throws ParseException {

        List<Transaction> returnedTransactions= CSVReader.getRecordFromCSV();

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("TX10001", "ACC334455", "ACC778899", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("20/10/2018 12:47:55"), 25.00, "PAYMENT",null));
        transactions.add(new Transaction("TX10002", "ACC334455", "ACC998877", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("20/10/2018 17:33:43"), 10.50, "PAYMENT",null));
        transactions.add(new Transaction("TX10003", "ACC998877", "ACC778899", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("20/10/2018 18:00:00"), 5.00, "PAYMENT",null));
        transactions.add(new Transaction("TX10004", "ACC998877", "ACC778899", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("20/10/2018 19:45:00"), 10.50, "REVERSAL","TX10002"));
        transactions.add(new Transaction("TX10005", "ACC334455", "ACC778899", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse("21/10/2018 09:30:00"), 7.25, "PAYMENT",null));
        assertEquals(transactions.size(),returnedTransactions.size());
        assertEquals(transactions.get(0).getFromAccountId(),returnedTransactions.get(0).getFromAccountId());
    }
}
