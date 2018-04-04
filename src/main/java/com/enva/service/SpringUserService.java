package com.enva.service;

import com.enva.model.UserModel;

public interface SpringUserService {

    UserModel getUser(Long id);

    UserModel saveUser(UserModel user);

    String listAllUsers();


}
