package com.userLogins;

public interface UserDetails {
    public void NewUser(String name, String userName, String email, String password);
    public boolean ExistingUser(String email, String password);
}
