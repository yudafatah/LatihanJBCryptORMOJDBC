/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Department;
import entities.Employee;
import entities.Location;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yudafatah
 */
public class DepartmentDAO {
    private SessionFactory factory;

    public DepartmentDAO() {
    }

    public DepartmentDAO(SessionFactory factory) {
        this.factory = factory;
    }
    public List<Department> data(String query) {
        List<Department> datas = new ArrayList<>();
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            datas = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return datas;
    }
    
    public List<Department> getAllDepartment() {
        return data("from Department");
    }
    
    public Department getEmployeeId(Object id) {
        Department datas = new Department();
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            datas = (Department) session.createQuery("from Department where DepartmentId=" + id).uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return datas;
    }
    
    public List<Department> searchData(Object data) {
        String query = "FROM DEPARTMENT where department_id LIKE '%" + data + "%'"
                + "OR department_name like '%" + data + "%'"
                + " OR manager_id like '%" + data + "%'" + "OR location_id like '%" + data + "%'";
        return data(query);
    }
    
    public List<Department> selectDepartmentId() {
        List<Department> datas = new ArrayList<>();
        String query = "FROM Department";
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            datas = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return datas;
    }
    
    public List<Employee> selectManagerId() {
        List<Employee> datas = new ArrayList<>();
        String query = "FROM Employee";
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            datas = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return datas;
    }
    public List<Location> selectLocationId() {
        List<Location> datas = new ArrayList<>();
        String query = "FROM Location";
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            datas = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return datas;
    }
    public boolean getdatas(Department department, String ef) {
        boolean result = false;
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (ef == "save") {
                session.save(department);
            } else if (ef == "update") {
                session.update(department);
            } else if (ef == "delete") {
                session.delete(department);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
    public boolean insert(Department department) {
        return getdatas(department, "save");
    }

    public boolean update(Department department) {
        return getdatas(department, "update");
    }

    public boolean delete(Department department) {
        return getdatas(department, "delete");
    }
}
