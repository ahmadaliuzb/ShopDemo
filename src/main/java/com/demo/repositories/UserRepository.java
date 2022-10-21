package com.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	

	public User findByUsername(String username);
	

	public List<User> findByStatus(boolean status);

	public long countUserByStatus(boolean status);
	
}
