package com.songw.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.songw.graphql.model.Author;
import com.songw.graphql.model.Contact;
import com.songw.graphql.model.Journey;
import com.songw.graphql.model.Tutorial;
import com.songw.graphql.repository.AuthorRepository;
import com.songw.graphql.repository.ContactRepository;
import com.songw.graphql.repository.JourneyRepository;
import com.songw.graphql.repository.TutorialRepository;

import javassist.NotFoundException;

@Component //개발자가 직접 개발한 클래스를 Bean으로 등록하고자 하는 경우 @Component 어노테이션을 활용
public class Mutation implements GraphQLMutationResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;
  private ContactRepository contactRepository;
  private JourneyRepository journeyRepository;
  
  @Autowired
  public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository, ContactRepository contactRepository, JourneyRepository journeyRepository) {  
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
    this.contactRepository = contactRepository;
    this.journeyRepository = journeyRepository;
  }

  public Author createAuthor(String name, Integer age) {
	  
	System.out.println("name : " + name);
	System.out.println("age : " + age);	
	  
    Author author = new Author();
    author.setName(name);
    author.setAge(age);
    authorRepository.save(author);

    return author;
  }
  
  public Tutorial createTutorial(String title, String description, Long journeyId, Long authorId, Long contactId) throws RuntimeException {
    Tutorial tutorial = new Tutorial();

    tutorial.setJourney(new Journey(journeyId));
    tutorial.setContact(new Contact(contactId));
    tutorial.setAuthor(new Author(authorId));
    tutorial.setTitle(title);
    tutorial.setDescription(description);

    tutorialRepository.save(tutorial);

    return tutorial;
  }
  
  public Contact createContact(String customerNumber, String email, String phoneNumber) throws RuntimeException {
	  	Contact contact = new Contact();

	  	
	  	contact.setCustomerNumber(customerNumber);
	  	contact.setEmail(email);
	  	contact.setPhoneNumber(phoneNumber);

	  	contactRepository.save(contact);

	    return contact;
  }  

  public Journey createJourney(String journeyKey, String origin, String destination, String departureDate, String arriverDate, String createId, String createDate, String pnr) throws RuntimeException {
	  	Journey journey = new Journey();

	  	
	  	journey.setJourneyKey(journeyKey);
	  	journey.setOrigin(origin);
	  	journey.setDestination(destination);
	  	journey.setDepartureDate(departureDate);
	  	journey.setArriverDate(arriverDate);
	  	journey.setCreateId(createId);
	  	journey.setCreateDate(createDate);
	  	journey.setPnr(pnr);

	  	journeyRepository.save(journey);

	    return journey;
  }   
  
  @Transactional
  public boolean deleteTutorial(Long id) throws RuntimeException {

	  boolean isSuccess = true;

	  try {
		  tutorialRepository.deleteById(id);
		  throw new RuntimeException("RuntimeException for rollback");
	  } catch (RuntimeException e) {
		  isSuccess = false;
	  }
	  
	  return isSuccess;
  }

  public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
    Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

    if (optTutorial.isPresent()) {
      Tutorial tutorial = optTutorial.get();

      if (title != null)
        tutorial.setTitle(title);
      if (description != null)
        tutorial.setDescription(description);

      tutorialRepository.save(tutorial);
      return tutorial;
    }

    throw new NotFoundException("Not found Tutorial to update!");
  }

}
