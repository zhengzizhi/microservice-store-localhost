package com.contoso.api.v1;

import com.contoso.user.User;
import com.contoso.user.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceV1 {

    private UserRepository userRepository;

    @Autowired
    public UserServiceV1(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000") })
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
    
    public Optional<User> getUserById(Long id) {
    	return userRepository.findById(id);
    }
    
    public Page<User> getUsersByPage(Pageable pageable){
    	return userRepository.findAll(pageable);
    }
}
