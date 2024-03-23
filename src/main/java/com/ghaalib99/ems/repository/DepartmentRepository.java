package com.ghaalib99.ems.repository;

import com.ghaalib99.ems.dto.DepartmentDto;
import com.ghaalib99.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
