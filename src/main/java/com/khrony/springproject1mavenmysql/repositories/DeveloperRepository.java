package com.khrony.springproject1mavenmysql.repositories;

import com.khrony.springproject1mavenmysql.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DeveloperRepository extends JpaRepository<Developer, Long>
{
	List<Developer> findByEmail(String email);
}
