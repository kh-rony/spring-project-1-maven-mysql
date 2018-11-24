package com.khrony.springproject1mavenmysql.repositories;

import com.khrony.springproject1mavenmysql.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LanguageRepository extends JpaRepository<Language, Long>
{
	List<Language> findByName(String name);
}
