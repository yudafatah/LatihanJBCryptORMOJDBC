/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Region;
import java.util.List;

/**
 *
 * @author yudafatah
 */
public interface RegionControllerInterface {
    public List<Region> getAlls();
    public List<Region> search(String obj);
    public Region getById(String id);
    public String insert(String id, String name);
    public String update(String id, String name);
    public String delete(String id);
}
