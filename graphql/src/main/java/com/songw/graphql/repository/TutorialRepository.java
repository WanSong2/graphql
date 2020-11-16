package com.songw.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songw.graphql.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}