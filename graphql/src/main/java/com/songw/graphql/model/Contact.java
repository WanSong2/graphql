package com.songw.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 테이블에 대응하는 하나의 클래스 (엔티티 클래스, 엔티티 인스턴스, 엔티티 객체)
public class Contact {
	
	@Id // 해당 칼럼이 식별키
	//주로 @GeneratedValue와 함께 식별키를 어떤 전략으로 생서하는지 명시합니다.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "customerNumber", nullable = false)
	private String customerNumber;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "email")
	private String email;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	public Contact() {
	}

	public Contact(Long id) {
		this.id = id;
	}

	public Contact(String customerNumber, String email, String phoneNumber) {
		this.customerNumber = customerNumber;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", customerNumber=" + customerNumber + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}	
	
}
