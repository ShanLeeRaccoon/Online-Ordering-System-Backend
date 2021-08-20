package com.group4.orderSystem.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.group4.orderSystem.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    BUYER(Sets.newHashSet(ITEM_READ, USER_READ, USER_EDIT, ORDER_READ, ORDER_WRITE, ORDER_DELETE)),
    ADMIN(Sets.newHashSet(ITEM_READ, ITEM_DELETE, ITEM_EDIT, ITEM_WRITE,
            USER_READ, USER_EDIT, USER_WRITE, USER_DELETE, ORDER_READ, ORDER_WRITE, ORDER_DELETE, ORDER_EDIT));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuth(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissions()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
