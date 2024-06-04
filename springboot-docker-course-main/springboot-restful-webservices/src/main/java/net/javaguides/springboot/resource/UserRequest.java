package net.javaguides.springboot.resource;

public class UserRequest {
    private String user_name;
    private String email_id;
    private String phone_no;
    private String password;

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name(){
        return this.user_name;
    }

    public void setEmail_id(String email_id){
        this.email_id = email_id;
    }

    public String getEmail_id(){
        return this.email_id;
    }

    public void setPhone_no(String phone_no){
        this.phone_no = phone_no;
    }

    public String getPhone_no(){
        return this.phone_no;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}

