package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Group;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.GroupRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.resource.GroupRequest;
import net.javaguides.springboot.resource.UserRequest;
import net.javaguides.springboot.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private GroupRepository groupRepository;


    /*public User createUser(User user) {
        return userRepository.save(user);
    }*/

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /*@Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }*/

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public String createUser(UserRequest user_request){
        User user = new User();
        user.setUser_name(user_request.getUser_name());
        user.setEmail_id(user_request.getEmail_id());
        user.setPhone_no(user_request.getPhone_no());
        user.setPassword(user_request.getPassword());
        userRepository.save(user);

        return("Thank you for registering");

    }

    /*public String addUserToGroup(UserToGroup user_request, GroupRequest group_request){
        User user = new User();

    }*/

    @Override
    public List<Object> getGroups(Long userId){
        List<Object> groups =groupRepository.findAllByUserId(userId);
        //for(Group g : groups){

        //}
        System.out.println("reached");
        return groups;
    }

    public double getBalance(Long userId){
        double balance = groupRepository.getbalance(userId);
        System.out.println(balance);
        return balance;
    }

    public String addUserToGroup(Long userId, Long groupId){
        User user = new User(userId);
        Group group = new Group(groupId);

        HashSet<User> user_added_to_group = new HashSet<>();
        user_added_to_group.add(user);
        group.createUsersSet(user_added_to_group);
        return "User Added successfully to group";
    }
}
