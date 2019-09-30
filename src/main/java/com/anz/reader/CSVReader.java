package com.anz.reader;

import com.anz.model.Transaction;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVReader {

    private static final Logger logger = Logger.getLogger("CSVReader.class");

    public static List<Transaction> getRecordFromCSV() {

        List<Transaction> transactions = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("Transaction_data.csv"));
            while (scanner.hasNextLine()) {
                Transaction transaction = getTransaction(scanner.nextLine());
                if (null != transaction)
                    transactions.add(transaction);
            }
        }
        catch (ParseException e)
        {
            logger.log(Level.SEVERE,"Exception while parsing the dates from Transaction_data.csv");
        }
        catch (FileNotFoundException e)
        {
            logger.log(Level.SEVERE,"File Transaction_data.csv could not be found in the path");
        }
            return transactions;
    }

    private static Transaction getTransaction(String line) throws ParseException{
        String[] transactionCsv = line.split(",");
        Transaction transaction = new Transaction();
        if(!transactionCsv[0].equalsIgnoreCase("transactionId")) {
            transaction.setTransactionId(null != transactionCsv[0] ? transactionCsv[0].trim() : null);
            transaction.setFromAccountId(null != transactionCsv[1] ? transactionCsv[1].trim() : null);
            transaction.setToAccountId(null != transactionCsv[2] ? transactionCsv[2].trim() : null);
            Date date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(null != transactionCsv[3] ? transactionCsv[3].trim() : null);
            transaction.setCreateAt(null != date ? date : null);
            transaction.setAmount(null != transactionCsv[4] ? Double.parseDouble(transactionCsv[4].trim()) : null);
            transaction.setTransactionType(null != transactionCsv[5] ? transactionCsv[5].trim() : null);
            if (transactionCsv.length > 6)
                transaction.setRelatedTransaction(null != transactionCsv[6] ? transactionCsv[6].trim() : null);
            return transaction;
        }
        return null;
    }
}
