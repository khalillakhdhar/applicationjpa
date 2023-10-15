package com.relations.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.model.Employee;
//@Repository obligatoire => 2.5.1
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
