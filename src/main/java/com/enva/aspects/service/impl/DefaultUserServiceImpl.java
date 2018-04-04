package com.enva.aspects.service.impl;

import com.enva.aspects.service.UserService;
import com.enva.model.UserModel;
import com.enva.repository.UserRepository;
import com.enva.repository.impl.UserRepositoryImpl;

public class DefaultUserServiceImpl implements UserService {

    private final UserRepository repository;

    public DefaultUserServiceImpl() {
        this.repository = new UserRepositoryImpl();
    }

    @Override
    public Boolean deleteUser(final UserModel user) {
        return repository.deleteUser(user);
    }


}
