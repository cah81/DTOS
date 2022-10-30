package com.dto.modelmapper.repository;

import com.dto.modelmapper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
