package com.ghaalib99.ems.service.impl;

import com.ghaalib99.ems.dto.DepartmentDto;
import com.ghaalib99.ems.dto.EmployeeDto;
import com.ghaalib99.ems.entity.Department;
import com.ghaalib99.ems.exception.ResourceNotFoundException;
import com.ghaalib99.ems.mapper.DepartmentMapper;
import com.ghaalib99.ems.mapper.EmployeeMapper;
import com.ghaalib99.ems.repository.DepartmentRepository;
import com.ghaalib99.ems.repository.EmployeeRepository;
import com.ghaalib99.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department with given id is not found"));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department)->
                DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department with given Id is not found"));

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department updatedDepartmentObj = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department with given Id is not found"));
        departmentRepository.deleteById(departmentId);
    }


}
