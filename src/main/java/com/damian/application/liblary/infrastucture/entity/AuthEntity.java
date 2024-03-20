package com.damian.application.liblary.infrastucture.entity;

import com.damian.application.liblary.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "author", schema = "liblary")
public class AuthEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private long user_id;

    @Basic
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;


    @OneToOne
    @JoinColumn(name="user_auth_id", nullable = false)
    private UserEntity user;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
