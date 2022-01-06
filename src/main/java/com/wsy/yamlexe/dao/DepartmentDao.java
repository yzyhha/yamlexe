package com.wsy.yamlexe.dao;

import com.wsy.yamlexe.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
//    模拟数据库
    private static Map<Integer, Department> departments=null;
    static
    {
    departments=new HashMap<Integer,Department>();
    departments.put(101,new Department(101,"教学部"));
    departments.put(102,new Department(102,"人事部"));
    departments.put(103,new Department(103,"小卖部"));
    departments.put(104,new Department(104,"后勤部"));
    departments.put(105,new Department(105,"运营部"));

    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
