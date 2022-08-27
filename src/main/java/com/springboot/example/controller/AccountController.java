package com.springboot.example.controller;

import com.springboot.example.model.Account;
import com.springboot.example.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts(){
        List<Account> list = new ArrayList<>();
        Account a = new Account();
        a.setAccountNumber("A111");
        a.setArn("ARN111");
        a.setProductCode("card");
        list.add(a);

        Account a1 = new Account();
        a1.setAccountNumber("A222");
        a1.setArn("ARN222");
        a1.setProductCode("card");
        list.add(a1);

        Account a2 = new Account();
        a2.setAccountNumber("test");
        a2.setArn("test arn");
        a2.setProductCode("test pc");
        list.add(a2);

        Account a3 = new Account();
        a3.setAccountNumber("");
        a3.setArn("");
        a3.setProductCode("");






        accountService.saveAccounts(list);
        return list;
    }
}
