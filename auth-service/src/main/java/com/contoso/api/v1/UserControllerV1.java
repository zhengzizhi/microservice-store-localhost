package com.contoso.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.contoso.user.User;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping({ "/v1" })
public class UserControllerV1 {

	private UserServiceV1 userService;

	@Autowired
	public UserControllerV1(UserServiceV1 userService) {
		this.userService = userService;
	}

	@RequestMapping(path = "/me")
	public ResponseEntity<?> me(Principal principal) {
		User user = null;
		if (principal != null) {
			user = userService.getUserByUsername(principal.getName());
		}
		return Optional.ofNullable(user).map(a -> new ResponseEntity<User>(a, HttpStatus.OK))
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<User>> getUser(@PathVariable("id") Long id) {
		Optional<User> user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(path = "/users")
	public @ResponseBody ResponseEntity<?> getUsers(
			@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "20") int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
		Page<User> users = userService.getUsersByPage(pageable);
		return ResponseEntity.ok(users);
	}
}
