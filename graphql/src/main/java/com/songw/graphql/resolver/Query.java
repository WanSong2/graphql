package com.songw.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.songw.graphql.model.Author;
import com.songw.graphql.model.Contact;
import com.songw.graphql.model.Journey;
import com.songw.graphql.model.Tutorial;
import com.songw.graphql.repository.AuthorRepository;
import com.songw.graphql.repository.ContactRepository;
import com.songw.graphql.repository.JourneyRepository;
import com.songw.graphql.repository.TutorialRepository;

@Component
public class Query implements GraphQLQueryResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;
  private ContactRepository contactRepository;
  private JourneyRepository journeyRepository;

  @Autowired
  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository, ContactRepository contactRepository, JourneyRepository journeyRepository) {
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
    this.contactRepository = contactRepository;
    this.journeyRepository = journeyRepository;
  }

  public Iterable<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public Iterable<Tutorial> findAllTutorials(String customerNumber) {
	Contact contact = contactRepository.findByCustomer(customerNumber);
    return tutorialRepository.findAllTutorialsBycontactId(contact.getId());
  }
  
  public Iterable<Contact> findAllContacts() {
    return contactRepository.findAll();
  }

  public Iterable<Journey> findAllJourneys() {
	return journeyRepository.findAll();
  }
  
  public long countAuthors() {
    return authorRepository.count();
  }

  public long countTutorials() {  
    return tutorialRepository.count();
  }

  public long countContacts() {  
	return contactRepository.count();
  }
  
  public long countJourneys() {  
	return journeyRepository.count();
  }  
  
  public Optional<Author> findAuthor(Long id) {
	  return authorRepository.findById(id);
  }

  public Optional<Tutorial> findTutorial(Long id) {
	  System.out.println("id :" + id);
	  return tutorialRepository.findTutorialDetail(id);
  }
  
  public Optional<Contact> findContact(Long id) {
	  return contactRepository.findById(id);
  }
  
  public Optional<Journey> findJourney(Long id) {
	  return journeyRepository.findById(id);
  } 
}
