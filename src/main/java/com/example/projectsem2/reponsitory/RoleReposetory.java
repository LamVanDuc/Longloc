package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleReposetory extends JpaRepository<tblRole,Long> {
}
