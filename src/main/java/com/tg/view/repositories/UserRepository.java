package com.tg.view.repositories;

import com.tg.view.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByUserName (String userName);
}
