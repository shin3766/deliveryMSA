package com.deliverymsa.users.domain.model;

public enum UserRole {

    MASTER("Master Administrator"),
    HUBMANAGER("Hub Manager"),
    HUBDELIVERYMANAGER("Hub Delivery Manager"),
    HUBSTORE("Hub Store");

    private final String roleDescription;

    UserRole(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    
    public String getAuthority() {
        return "ROLE_" + name();
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }
}
