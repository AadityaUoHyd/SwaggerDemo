package org.aadi.swaggerDemo.resource;


import java.util.Arrays;
import java.util.List;

import org.aadi.swaggerDemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value="User Resource REST endpoint", description = "Shows the hello world")
public class UserResource {
	
	@GetMapping("/user")
	public List<User> getUsers() {
		return Arrays.asList(
				new User("Aadi", 40000L),
				new User("Vinod", 80000L),
				new User("Suresh", 90000L),
				new User("Shreya", 50000L));
	}
	
	@GetMapping("/{userName}")
	public User getuser(@PathVariable("userName") final String userName) {
		return new User(userName, 5000L);
	}
	
}
