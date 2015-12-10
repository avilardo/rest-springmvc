package br.com.globosat.spring.sample.model;

public class Channel {

	private String name;
	private String description;
	
	public Channel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Channel(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
