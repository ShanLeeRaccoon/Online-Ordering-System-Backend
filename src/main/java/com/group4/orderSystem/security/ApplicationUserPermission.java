package com.group4.orderSystem.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserPermission {
    ITEM_READ("item:read"),
    ITEM_WRITE("item:write"),
    ITEM_DELETE("item:delete"),
    ITEM_EDIT("item:edit");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissions() {
        return permission;
    }


}
