package com.springboot.example.dao.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account_settings")
@Data
public class AccountSetting {

    @Id
    @SequenceGenerator(name= "ACCOUNT_SEQUENCE", sequenceName = "ACCOUNT_SEQUENCE", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="ACCOUNT_SEQUENCE")

    private Long id;

    @Column(name = "name", nullable = false)
    private String settingName;

    @Column(name = "value", nullable = false)
    private String settingValue;

    @ManyToOne
    @JoinColumn(name ="account_id", nullable = false)
    private AccountDTO accountDTO;

    // getters and setters
}