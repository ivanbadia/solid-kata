package com.codurance.srp.impl;

import com.codurance.srp.AccountManageService;
import com.codurance.srp.Clock;
import com.codurance.srp.TransactionRepository;

class AccountManageServiceImpl implements AccountManageService {

    private final TransactionRepository transactionRepository;
    private final Clock clock;

    public AccountManageServiceImpl(TransactionRepository transactionRepository, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
    }

    public void deposit(int amount) {
        transactionRepository.add(transactionWith(amount));
    }


    public void withdraw(int amount) {
        transactionRepository.add(transactionWith(-amount));
    }

    private Transaction transactionWith(int amount) {
        return new Transaction(clock.today(), amount);
    }

}