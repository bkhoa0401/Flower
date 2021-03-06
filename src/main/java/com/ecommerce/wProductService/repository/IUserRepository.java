package com.ecommerce.wProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wProductService.entity.Role;
import com.ecommerce.wProductService.entity.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String userName);
    List<User> findUserByRoleID(Role role);
}
