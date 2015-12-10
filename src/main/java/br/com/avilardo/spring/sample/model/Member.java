package br.com.avilardo.spring.sample.model;

public class Member {

	private String firstName;
	private String lastName;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
