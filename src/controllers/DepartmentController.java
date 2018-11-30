/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import entities.Department;
import entities.Employee;
import entities.Location;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class DepartmentController {
    private SessionFactory factory;
    private DepartmentDAO ddao;

    public DepartmentController() {
    }

    public DepartmentController(SessionFactory factory) {
        this.factory = factory;
        this.ddao = new DepartmentDAO(factory);
    }
    public List<Department> getAllDepartment() {
        return ddao.getAllDepartment();
    }

    public Department getDepartmentId(Object object) {
        return ddao.getEmployeeId(object);
    }

    public List<Department> getSearch(Object object) {
        return ddao.searchData(object);
    }

    public boolean insertData(Department department) {
        return ddao.insert(department);
    }

    public boolean updateData(Department department) {
        return ddao.update(department);
    }

    public boolean deleteData(Department department) {
        return ddao.delete(department);
    }
    public List<Employee> getManagerId(){
        return ddao.selectManagerId();
    }
    public List<Location> getLocationId(){
        return ddao.selectLocationId();
    }
}
