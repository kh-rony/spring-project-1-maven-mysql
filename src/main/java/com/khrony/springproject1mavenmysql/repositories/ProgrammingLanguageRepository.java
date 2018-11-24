package com.khrony.springproject1mavenmysql.repositories;

import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long>
{
	List<ProgrammingLanguage> findByName(String name);
}
