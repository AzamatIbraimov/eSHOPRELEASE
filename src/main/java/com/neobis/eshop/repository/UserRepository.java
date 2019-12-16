package com.neobis.eshop.repository;

import java.util.List;

import com.neobis.eshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {

    List<User> findByNameLike(String name);

    User findByActivationCode(String code);

    User findByRecoveryCode(String code);

}
