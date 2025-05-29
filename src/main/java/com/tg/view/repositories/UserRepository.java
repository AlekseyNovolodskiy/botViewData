package com.tg.view.repositories;

import com.tg.view.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserName (String userName);

}
