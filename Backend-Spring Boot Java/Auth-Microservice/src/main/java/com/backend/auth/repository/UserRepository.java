package com.backend.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.auth.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {

}
