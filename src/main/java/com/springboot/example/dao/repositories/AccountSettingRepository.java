package com.springboot.example.dao.repositories;

import com.springboot.example.dao.entities.AccountSetting;
import org.springframework.data.repository.CrudRepository;

public interface AccountSettingRepository extends CrudRepository<AccountSetting, Long> {
}
