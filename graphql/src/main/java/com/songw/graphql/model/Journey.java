package com.songw.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // 테이블에 대응하는 하나의 클래스 (엔티티 클래스, 엔티티 인스턴스, 엔티티 객체)
public class Journey {

	@Id // 해당 칼럼이 식별키
	//주로 @GeneratedValue와 함께 식별키를 어떤 전략으로 생서하는지 명시합니다.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "journeyKey", nullable = false)	
	private String journeyKey;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "origin")	
	private String origin;

	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "destination")	
	private String destination;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "departureDate")
	private String departureDate;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "arriverDate")
	private String arriverDate;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "createId")
	private String createId;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "createDate")	
	private String createDate;
	
	//인스턴스 변수가 컬럼이 되기 때문에,컬럼명을 별도로 지정하거나 컬럼의 사이즈, 제약조건들을 추가하기 위해 사용합니다.
	@Column(name = "pnr")	
	private String pnr;

	public Journey() {
	}
	
	public Journey(Long id) {
		this.id = id;
	}
	
	public Journey(String journeyKey, String origin, String destination, 
			String departureDate, String arriverDate, String createId, 
			String createDate, String pnr) {
		
		this.journeyKey = journeyKey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJourneyKey() {
		return journeyKey;
	}

	public void setJourneyKey(String journeyKey) {
		this.journeyKey = journeyKey;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArriverDate() {
		return arriverDate;
	}

	public void setArriverDate(String arriverDate) {
		this.arriverDate = arriverDate;
	}

	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
}
