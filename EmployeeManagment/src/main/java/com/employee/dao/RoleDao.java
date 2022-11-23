package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String>{

}
