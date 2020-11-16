package com.songw.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.songw.graphql.model.Author;
import com.songw.graphql.model.Tutorial;
import com.songw.graphql.repository.AuthorRepository;
import com.songw.graphql.repository.TutorialRepository;

@Component
public class Query implements GraphQLQueryResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;

  @Autowired
  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
  }

  public Iterable<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public Iterable<Tutorial> findAllTutorials() {
    return tutorialRepository.findAll();
  }

  public long countAuthors() {
    return authorRepository.count();
  }

  public long countTutorials() {
    return tutorialRepository.count();
  }
}
