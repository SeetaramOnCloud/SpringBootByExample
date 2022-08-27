package com.springboot.example.dao.repositories;

import com.springboot.example.dao.entities.AccountDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountDTO, Long> {
}
