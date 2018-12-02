/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Department;
import entities.DepartmentAccount;
import entities.Employee;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class DepartmentController1 implements DepartmentControllerInterface{
    private DAOInterface gdao;

    public DepartmentController1(SessionFactory factory) {
        this.gdao = new GeneralDAO(factory);
    }

    public DepartmentController1() {
    }
    
    @Override
    public List<Object> getAlls(Object enitity, String keyword) {
        return gdao.doDDL(enitity, "");
    }

    @Override
    public List<Object> search(Object enitity, String keyword) {
        return gdao.doDDL(enitity, keyword);
    }

    @Override
    public Object getById(Object entity, String id) {
        return gdao.getById(entity, id);
    }

    @Override
    public String insert(String id, String name) {
        Department department = new Department(Short.parseShort(id), name);
        if(gdao.doDML(department, false)){
            return "Insert berhasil!";
        }
        return "insert gagal!";
    }

    @Override
    public String update(String id, String name) {
        Department department = new Department(Short.parseShort(id), name);
        if(gdao.doDML(department, false)){
            return "Update berhasil!";
        }
        return "Update gagal!";
    }

    @Override
    public String delete(String id) {
        Department department = new Department(Short.parseShort(id));
        if(gdao.doDML(department, true)){
            return "Berhasil di hapus!";
        }
        return "gagal menghapus!";
    }

    @Override
    public String register(String username, String password) {
        String result = "Gagal register!";
        DepartmentAccount account = new DepartmentAccount(username, password);
        if(gdao.doDML(account, false)){
            result = "Register berhasil!";
        }
        return result;
    }

    @Override
    public String login(String username, String password) {
        DepartmentAccount account = gdao.login(username, password);
        String x = ""+account;
        if(account == null){
            return "Login gagal!"+x;
        }
        else{
            return "Welcome!"+x;
        }
    }

    @Override
    public List<Object> getManagerId(Object enitity, String keyword) {
        return gdao.doDDL(enitity, "");
    }

    @Override
    public List<Object> getLocationId(Object enitity, String keyword) {
        return gdao.doDDL(enitity, "");
    }
    
}
