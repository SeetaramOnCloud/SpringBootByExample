package com.springboot.example.service;

import com.springboot.example.dao.entities.AccountSetting;
import com.springboot.example.model.Account;
import com.springboot.example.dao.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @Transactional
    public void saveAccounts(List<Account> accounts){
        List<com.springboot.example.dao.entities.Account> accountDAOs = accounts.stream().map( account -> {
                    com.springboot.example.dao.entities.Account accountDAO = new com.springboot.example.dao.entities.Account();
                    accountDAO.setName("testName" + account.getAccountNumber());
                    accountDAO.setEmailAddress("testName@" + account.getAccountNumber());
                    List<AccountSetting> accountSettings = new ArrayList<>();
                    AccountSetting as = new AccountSetting();
                    as.setAccount(accountDAO);
                    as.setSettingName("test-setting");
                    as.setSettingValue("test-value");
                    accountSettings.add(as);
                    accountDAO.setAccountSettings(accountSettings);
                    return accountDAO;
                }).collect(Collectors.toList());

        accountRepository.saveAll(accountDAOs);
    }



}
