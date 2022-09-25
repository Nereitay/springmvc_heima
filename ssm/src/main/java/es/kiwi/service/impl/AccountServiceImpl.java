package es.kiwi.service.impl;

import es.kiwi.mapper.AccountDAO;
import es.kiwi.model.Account;
import es.kiwi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户...");
        return accountDAO.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户...");
        accountDAO.saveAccount(account);
    }
}
