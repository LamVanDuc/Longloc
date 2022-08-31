package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblRole;
import com.example.projectsem2.reponsitory.RoleReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleReposetory roleReposetory;

    @Override
    public tblRole findByTenRole(String name) {
        return roleReposetory.findByTenRole(name);
    }
}
