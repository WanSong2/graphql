package com.songw.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songw.graphql.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
