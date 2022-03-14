package com.songw.graphql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.songw.graphql.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	@Query(value =  "select * from tutorial c where c.contact_id = :contactId", nativeQuery=true)
	public Iterable<Tutorial> findAllTutorialsBycontactId(@Param("contactId") Long contactId);

	@Query(value =  "select * from tutorial c where id = :id", nativeQuery=true)
	public Optional<Tutorial> findTutorialDetail(@Param("id") Long id);
	
}