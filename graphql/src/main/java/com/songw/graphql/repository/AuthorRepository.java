package com.songw.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.songw.graphql.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	
}
