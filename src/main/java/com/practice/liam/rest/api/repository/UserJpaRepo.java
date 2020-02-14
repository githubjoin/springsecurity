package com.practice.liam.rest.api.repository;

import com.practice.liam.rest.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends JpaRepository<User, Long> {
}
