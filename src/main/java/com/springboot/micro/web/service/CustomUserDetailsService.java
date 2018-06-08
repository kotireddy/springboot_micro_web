package com.springboot.micro.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private static final Logger LOGGER = LoggerFactory.
                                            getLogger(CustomUserDetailsService.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*LOGGER.info("<<<<<<< LoadUserByUsername Configuration >>>>>>>");
        Optional<Users> optionalUsers = Optional.of(entityManager.createQuery(QueryConstants.USER_LOGIN_QUERY, Users.class)
                .setParameter("username", username).getSingleResult());
        optionalUsers.
                orElseThrow(() -> new UsernameNotFoundException("Username not found."));*/
        return null; //optionalUsers.map(CustomUserDetails::new).get();
	}
}
