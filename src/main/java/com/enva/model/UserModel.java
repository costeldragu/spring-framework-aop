package com.enva.model;

public class UserModel {
    private Long id;
    private String username;
    private String email;
    private String password;


    public UserModel(final String username, final String email, final String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (id != null ? !id.equals(userModel.id) : userModel.id != null) return false;
        if (username != null ? !username.equals(userModel.username) : userModel.username != null) return false;
        if (email != null ? !email.equals(userModel.email) : userModel.email != null) return false;
        return password != null ? password.equals(userModel.password) : userModel.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}


