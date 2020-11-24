package com.songw.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 테이블에 대응하는 하나의 클래스 (엔티티 클래스, 엔티티 인스턴스, 엔티티 객체)
public class Author {
	
	  @Id // 해당 칼럼이 식별키
	  //주로 @GeneratedValue와 함께 식별키를 어떤 전략으로 생서하는지 명시합니다.
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;

	  //인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	  @Column(name = "name", nullable = false)
	  private String name;

	  @Column(name = "age")
	  private Integer age;

	  public Author() {
	  }

	  public Author(Long id) {
	    this.id = id;
	  }

	  public Author(String name, Integer age) {
	    this.name = name;
	    this.age = age;
	  }

	  public Long getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public Integer getAge() {
	    return age;
	  }

	  public void setAge(Integer age) {
	    this.age = age;
	  }

	  @Override
	  public String toString() {
	    return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	  }
	
}
