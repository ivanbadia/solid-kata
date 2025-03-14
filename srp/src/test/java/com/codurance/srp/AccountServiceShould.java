package com.codurance.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountServiceShould {

    private static final int POSITIVE_AMOUNT = 100;
    private static final int NEGATIVE_AMOUNT = -POSITIVE_AMOUNT;
    private static final LocalDate TODAY = LocalDate.of(2017, 9, 6);
    private static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(LocalDate.of(2014, 4, 1), 1000),
            new Transaction(LocalDate.of(2014, 4, 2), -100),
            new Transaction(LocalDate.of(2014, 4, 10), 500)
    );

    @Mock
    private Clock clock;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private Console console;

    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountService(transactionRepository, clock, console);
        lenient().doReturn(TODAY).when(clock).today();
    }


    @Test
    public void deposit_amount_into_the_account() {

        accountService.deposit(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, POSITIVE_AMOUNT)));
    }


    @Test
    public void withdraw_amount_from_the_account() {

        accountService.withdraw(POSITIVE_AMOUNT);

        verify(transactionRepository).add(refEq(new Transaction(TODAY, NEGATIVE_AMOUNT)));
    }

    @Test
    public void print_statement() {
        given(transactionRepository.all()).willReturn(TRANSACTIONS);

        accountService.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
