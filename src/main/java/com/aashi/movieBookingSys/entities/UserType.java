package com.aashi.movieBookingSys.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserType {
    @Id
    @GeneratedValue
    private int userTypeId;

    @Column(length = 20, unique = true)
    private String userTypeName = "Customer";

    public UserType() {
    }

    public UserType(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "UserType{" + "userTypeId=" + userTypeId + ", userTypeName='" + userTypeName + '\'' + '}';
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
