package com.wsy.yamlexe.dao;

import com.wsy.yamlexe.pojo.Department;
import com.wsy.yamlexe.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001,"张三","2502209041@qq.com",0,new Department(101,"教学部")));
        employees.put(1002, new Employee(1002,"李四","2502209042@qq.com",1,new Department(101,"人事部")));
        employees.put(1003, new Employee(1003,"王五","2502209043@qq.com",0,new Department(101,"小卖部")));
        employees.put(1004, new Employee(1004,"赵六","2502209044@qq.com",1,new Department(101,"后勤部")));
        employees.put(1005, new Employee(1005,"牛七","2502209045@qq.com",0,new Department(101,"运营部")));
    }

    private static Integer initId=1006;
//    增加一个员工
    public void save(Employee employee){
    if(employee.getId()==null){
        employee.setId(initId++);
    }

    employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

    employees.put(employee.getId(),employee);
    }
//查询全部
    public Collection<Employee> getAll(){
        return employees.values();
    }
//通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);

    }
//    删除员工
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }
}
