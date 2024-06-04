package net.javaguides.springboot.resource;

public class GroupRequest {

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    private String group_name;
    private String group_id;

    private int num_members;

    private int num_transactions;



}
