package com.anz.service;


import com.anz.model.Transaction;
import com.anz.reader.CSVReader;

import java.util.*;
import java.util.stream.Collectors;
import java.text.NumberFormat;

public class RelativeBalanceService {

    public Map<String, String> process(String accountId, Date from, Date to) {

        List<Transaction> transactionList = CSVReader.getRecordFromCSV();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Map<String, String> returnMap = new HashMap<>();

        Double balance = 0.0;

        List<Transaction> filteredTransactionList = transactionList.stream()
                .filter(t -> t.getToAccountId().equals(accountId) || t.getFromAccountId().equals(accountId))
                .filter(t -> t.getTransactionType().equals("PAYMENT"))
                .filter(t -> !transactionList.stream()
                        .filter(r -> r.getTransactionType().equals("REVERSAL"))
                        .map(Transaction::getRelatedTransaction).collect(Collectors.toList()).contains(t.getTransactionId()))
                .filter(t -> from.compareTo(t.getCreateAt()) * t.getCreateAt().compareTo(to) > 0)
                .collect(Collectors.toList());


        for (Transaction transaction : filteredTransactionList) {
            balance = transaction.getToAccountId().trim().equals(accountId) ? balance + transaction.getAmount() : balance - transaction.getAmount();
        }

        Integer count = filteredTransactionList.size();

        returnMap.put("balance", formatter.format(balance));
        returnMap.put("count", count.toString());

        return returnMap;
    }

}
