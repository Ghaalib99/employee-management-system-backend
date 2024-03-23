package com.ghaalib99.ems.controller;

import com.ghaalib99.ems.dto.DepartmentDto;
import com.ghaalib99.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

//    CREATE DEPARTMENT
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return  new ResponseEntity<>(department, HttpStatus.CREATED);
    }

//    GET DEPARTMENT
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("id") Long departmentId) {
       DepartmentDto departmentDto = departmentService.getDepartment(departmentId);
       return ResponseEntity.ok(departmentDto);
    }

//    GET ALL DEPARTMENTS
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

//    UPDATE DEPARTMENT
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDto departmentDto) {
       DepartmentDto departmentDto1 = departmentService.updateDepartment(departmentId, departmentDto);
       return ResponseEntity.ok(departmentDto1);
    }

//    DELETE DEPARTMENT
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
