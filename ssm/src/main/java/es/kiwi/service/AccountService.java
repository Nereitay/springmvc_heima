package es.kiwi.service;

import es.kiwi.model.Account;

import java.util.List;

public interface AccountService {


    List<Account> findAll();

    void saveAccount(Account account);
}
