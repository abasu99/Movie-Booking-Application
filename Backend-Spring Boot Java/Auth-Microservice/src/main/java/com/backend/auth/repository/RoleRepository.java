package com.backend.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.backend.auth.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, String> {

}
