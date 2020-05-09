package com.company;

public class Receiver {
    String email;
    String name;

    public Receiver(String email, String name) {
        this.email = email;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
