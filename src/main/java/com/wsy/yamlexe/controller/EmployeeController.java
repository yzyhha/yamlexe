package com.wsy.yamlexe.controller;

import com.wsy.yamlexe.dao.DepartmentDao;
import com.wsy.yamlexe.dao.EmployeeDao;
import com.wsy.yamlexe.pojo.Department;
import com.wsy.yamlexe.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
@RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }
    @GetMapping("/add")
    public String add(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
   @PostMapping("/add")
    public String post(Employee employee){
       System.out.println("save"+employee);
       employeeDao.save(employee);
        return "redirect:/emps";
    }

}
