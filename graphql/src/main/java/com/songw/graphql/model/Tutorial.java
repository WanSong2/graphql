package com.songw.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tutorial {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description")
  private String description;

  @ManyToOne  // N:1 관계입니다.
  @JoinColumn(name = "journey_id", nullable = false, updatable = false)
  private Journey journey;
  
  @ManyToOne  // N:1 관계입니다.
  @JoinColumn(name = "author_id", nullable = false, updatable = false)
  private Author author;

  @ManyToOne  // N:1 관계입니다.
  @JoinColumn(name = "contact_id", nullable = true, updatable = false)
  private Contact contact;
  
  
  
  public Tutorial() {
  }

  public Tutorial(String title, String description, Author author) {
    this.title = title;
    this.description = description;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
	public Journey getJourney() {
		return journey;
	}
	
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Author getAuthor() {
	    return author;
	}
	
	public void setAuthor(Author author) {
	    this.author = author;
	}
	  
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", journey=" + journey +", author=" + author + "]";
  }
}
