package com.example.services.impl;

import java.util.List;

import org.piros.injection.Injectable;
import org.piros.model.user.User;
import org.piros.security.services.UsersService;

@Injectable
public class UserService implements UsersService {

    @Override
    public User createUser(String arg0, String arg1, boolean arg2, boolean arg3) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean existsUsername(String username) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getById(String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(String username) {
        return new User("id", "admin", "12345");
    }

    @Override
    public void insertUser(User u) {
        // TODO Auto-generated method stub

    }

}