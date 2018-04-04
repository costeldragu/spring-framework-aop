package com.enva.service.impl;

import com.enva.model.UserModel;
import com.enva.repository.UserRepository;
import com.enva.service.SpringUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringUserServiceImpl implements SpringUserService {

    private final UserRepository userRepository;

    @Autowired
    public SpringUserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getUser(final Long id) {
        return userRepository.getUser(id);
    }


    @Override
    public UserModel saveUser(final UserModel user) {
        return userRepository.saveUser(user);
    }

    @Override
    public String listAllUsers() {
        return userRepository.listAllUser();
    }


}
