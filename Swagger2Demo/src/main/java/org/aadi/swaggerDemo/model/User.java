package org.aadi.swaggerDemo.model;

import io.swagger.annotations.ApiModelProperty;

public class User {
	
	@ApiModelProperty(notes="name of the User")
	private String userName;
	
	@ApiModelProperty(notes="salary of the User")
	private Long salary;
	
	public User(String userName, Long salary) {
		super();
		this.userName = userName;
		this.salary = salary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
		
}
