package com.songw.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.songw.graphql.model.Author;
import com.songw.graphql.model.Tutorial;
import com.songw.graphql.repository.AuthorRepository;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
  @Autowired
  private AuthorRepository authorRepository;

  public TutorialResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Tutorial tutorial) {
    return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
  }
}
