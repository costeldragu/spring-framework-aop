package com.enva.repository;

import com.enva.model.UserModel;

public interface UserRepository {

    UserModel saveUser(UserModel user);
    UserModel getUser(Long id);
    Boolean deleteUser(UserModel user);


}
