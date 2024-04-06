package com.codurance.srp;

import com.codurance.srp.impl.Transaction;

import java.util.List;

public interface TransactionRepository {
    void add(Transaction transaction);
    List<Transaction> all();
}
