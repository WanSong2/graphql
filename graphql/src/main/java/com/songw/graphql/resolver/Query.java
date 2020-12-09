package com.songw.graphql.resolver;

import java.util.Optional;

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
	System.out.println("Query !! ");
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
  
  public Optional<Author> findAuthor(Long id) {
	  return authorRepository.findById(id);
  }

  public Optional<Tutorial> findTutorial(Long id) {
	  return tutorialRepository.findById(id);
  }
  
}
