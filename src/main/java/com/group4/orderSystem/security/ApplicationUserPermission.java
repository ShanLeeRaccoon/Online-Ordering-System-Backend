package com.group4.orderSystem.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserPermission {
    ITEM_READ("item:read"),
    ITEM_WRITE("item:write"),
    ITEM_DELETE("item:delete"),
    ITEM_EDIT("item:edit"),

    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    ORDER_DELETE("order:delete"),
    ORDER_EDIT("order:edit"),

    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_DELETE("user:delete"),
    USER_EDIT("user:edit")
;


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissions() {
        return permission;
    }
}
