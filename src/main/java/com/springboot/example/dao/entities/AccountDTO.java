package com.springboot.example.dao.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
public class AccountDTO {

    @Id
    @SequenceGenerator(name= "ACCOUNT_SEQUENCE", sequenceName = "ACCOUNT_SEQUENCE", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="ACCOUNT_SEQUENCE")
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(mappedBy = "accountDTO", cascade = CascadeType.ALL)
    private List<AccountSetting> accountSettings = new ArrayList<>();

    // getters and setters
}
