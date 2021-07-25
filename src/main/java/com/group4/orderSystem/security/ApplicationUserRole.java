package com.group4.orderSystem.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.group4.orderSystem.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    BUYER(Sets.newHashSet(ITEM_READ)),
    ADMIN(Sets.newHashSet(ITEM_READ, ITEM_DELETE, ITEM_EDIT, ITEM_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }
}
