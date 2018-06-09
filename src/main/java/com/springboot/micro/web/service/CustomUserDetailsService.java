package com.springboot.micro.web.service;

import com.springboot.micro.web.bean.CustomUserDetails;
import com.springboot.micro.web.bean.Users;
import com.springboot.micro.web.constants.URIConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private static final Logger LOGGER = LoggerFactory.
                                            getLogger(CustomUserDetailsService.class);
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("<<<<<<< LoadUserByUsername Configuration >>>>>>>");
        ResponseEntity<Users> responseEntity = restTemplate.
                        getForEntity(URIConstants.USER_LOGIN_URI + username, Users.class);
        Optional<Users> optionalUsers = Optional.of(responseEntity.getBody());

        return optionalUsers.map(CustomUserDetails::new).get();
	}
}
