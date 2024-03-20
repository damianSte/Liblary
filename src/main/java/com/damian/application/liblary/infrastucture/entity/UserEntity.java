package com.damian.application.liblary.infrastucture.entity;


import jakarta.persistence.*;

@Entity
@Table(name="users", schema = "library")
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private long user_id;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private AuthEntity auth;


    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }
}