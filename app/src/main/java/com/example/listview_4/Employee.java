package com.example.listview_4;

public class Employee {
    private String name;
    private String Id;
    private boolean IsManager;

    public void setId(String id) {
        Id = id;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setManager(boolean manager) {
        IsManager = manager;
    }

    public boolean isManager() {
        return IsManager;
    }
}
