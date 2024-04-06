package com.codurance.srp.impl;

import com.codurance.srp.AccountManageService;
import com.codurance.srp.AccountReportService;
import com.codurance.srp.AccountService;

public class AccountServiceFacade implements AccountService {

    private final AccountManageService manageService;
    private final AccountReportService reportService;

    public AccountServiceFacade(AccountManageService manageService, AccountReportService reportService) {
        this.manageService = manageService;
        this.reportService = reportService;
    }

    @Override
    public void deposit(int amount) {
        manageService.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        manageService.withdraw(amount);
    }

    @Override
    public void printStatement() {
        reportService.printStatement();
    }

}
