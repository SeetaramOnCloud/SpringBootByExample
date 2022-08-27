package com.springboot.example.service;

import com.springboot.example.dao.entities.AccountDTO;
import com.springboot.example.dao.entities.AccountSetting;
import com.springboot.example.model.Account;
import com.springboot.example.dao.repositories.AccountRepository;
import lombok.AllArgsConstructor;
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
        List<AccountDTO> accountDTODAOS = accounts.stream().map(account -> {
                    AccountDTO accountDTODAO = new AccountDTO();
                    accountDTODAO.setName("testName" + account.getAccountNumber());
                    accountDTODAO.setEmailAddress("testName@" + account.getAccountNumber());
                    List<AccountSetting> accountSettings = new ArrayList<>();
                    AccountSetting as = new AccountSetting();
                    as.setAccountDTO(accountDTODAO);
                    as.setSettingName("test-setting");
                    as.setSettingValue("test-value");
                    accountSettings.add(as);
                    accountDTODAO.setAccountSettings(accountSettings);
                    return accountDTODAO;
                }).collect(Collectors.toList());

        accountRepository.saveAll(accountDTODAOS);
    }

    public List<AccountDTO> mapToAccount(List<Account> accounts){
        List<AccountDTO> accountDTOlist=new ArrayList<>();
        for (Account account :accounts) {
        	accountDTOlist.add(convertFromAccount(account));
        }
        return accountDTOlist;


    }

    private AccountDTO convertFromAccount(Account account) {
        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setName(account.getAccountNumber());
        accountDTO.setEmailAddress(account.getArn());
        accountDTO.setAccountSettings(null);
        return accountDTO;

    }


}
