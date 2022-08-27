package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReposetory extends JpaRepository<tblRole,Long> {
}
