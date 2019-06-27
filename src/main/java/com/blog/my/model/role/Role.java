package com.blog.my.model.role;

import com.blog.my.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity {

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
