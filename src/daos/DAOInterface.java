/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;

/**
 *
 * @author Ignatius
 */
public interface DAOInterface {
    public boolean doDML(Object object, boolean isDelete);//iud
    public List<Object> doDDL(Object table, String keyword);//sga
    public Object getById(String table,Object id);
}
