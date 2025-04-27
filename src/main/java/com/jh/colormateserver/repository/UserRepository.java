package com.jh.colormateserver.repository;

import com.jh.colormateserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
