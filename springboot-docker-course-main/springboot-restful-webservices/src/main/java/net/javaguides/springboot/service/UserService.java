package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Group;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.resource.UserRequest;

import java.util.List;

public interface UserService {
    String createUser(UserRequest user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    //User updateUser(User user);

    void deleteUser(Long userId);

    public List<Object> getGroups(Long userId);

    public String addUserToGroup(Long userId, Long groupId);
    public double getBalance(Long userId);
}
