package com.enva.repository.impl;

import com.enva.model.UserModel;
import com.enva.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, UserModel> userTable = new HashMap<>();
    private static Long nextUserId = 0L;

    @Override
    public UserModel saveUser(final UserModel user) {
        if (user.getId() == null) {
            user.setId(getNextUserId());
        }
        userTable.put(user.getId(), user);
        return user;
    }

    @Override
    public UserModel getUser(final Long id) {
        return userTable.get(id);
    }

    @Override
    public Boolean deleteUser(final UserModel user) {
        UserModel currentUser = getUser(user.getId());
        if (user.equals(currentUser)) {
            userTable.remove(user.getId());
            return true;
        }
        return false;
    }

    @Override
    public String listAllUser() {
        StringBuilder listUser = new StringBuilder();
        userTable.values().forEach(user -> listUser.append(user.toString()).append(System.lineSeparator()));
        return listUser.toString();
    }

    private synchronized Long getNextUserId() {
        return ++nextUserId;
    }

}
