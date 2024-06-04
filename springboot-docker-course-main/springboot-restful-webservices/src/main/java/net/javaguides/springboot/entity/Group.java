package net.javaguides.springboot.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Splitwise_Groups")
public class Group {

    @Id
    private long group_id;
    private String group_name;
    private long num_members;
    private long num_transactions;

    public Group(Long groupId){
        this.group_id = groupId;
    }

    //@ManyToMany(mappedBy = "Group")
    @ManyToMany(targetEntity = User.class, mappedBy = "groups", cascade = CascadeType.ALL)
    private Set<User> users_set = new HashSet<>();

    //Set<Group> groups = new HashSet<Group>();

    @OneToMany(
            targetEntity=Expense.class,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Expense> group_expenses = new ArrayList<>();

    public void createUsersSet(HashSet<User> users){
        this.users_set = users;
    }

}