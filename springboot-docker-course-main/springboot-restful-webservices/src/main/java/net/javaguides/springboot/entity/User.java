package net.javaguides.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="Users")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "phone_no")
    private String phone_no;
    @Column(name = "email_id")
    private String email_id;
    @Column(name = "lent")
    private double lent;
    @Column(name = "borrowed")
    private double borrowed;
    @Column(name = "password")
    private String password;

    public User(Long userId){
        this.userId = userId;
    }
    //@ManyToMany()
    @ManyToMany(targetEntity = Group.class,cascade = CascadeType.ALL )


    @JoinTable(
            name = "user_groups",
            joinColumns = {
                    @JoinColumn(name = "userId", referencedColumnName="userId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id", referencedColumnName="group_id")
            }
    )
    Set< Group > groups = new HashSet< Group >();
    public long getuserId() {
        return userId;
    }
    public void setuserId(long userId) {
        this.userId = userId;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail_id() {
        return email_id;
    }
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }


    public double getLent() {
        return lent;
    }
    public void setLent(double lent) {
        this.lent = lent;
    }
    public double getBorrowed() {
        return borrowed;
    }
    public void setBorrowed(double borrowed) {
        this.borrowed = borrowed;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String phone_no) {
        this.password = password;
    }

}