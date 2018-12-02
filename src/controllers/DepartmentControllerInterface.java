/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Department;
import java.util.List;

/**
 *
 * @author yudafatah
 */
public interface DepartmentControllerInterface {
    public List<Object> getAlls(Object enitity, String keyword);
    public List<Object> search(Object enitity, String keyword);
    public Object getById(Object entity, String id);
    public String insert(String id, String name);
    public String update(String id, String name);
    public String delete(String id);
    public String register(String username, String password);
    public String login(String username, String password);
    public List<Object> getManagerId(Object enitity, String keyword);
    public List<Object> getLocationId(Object enitity, String keyword);
}
