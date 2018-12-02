/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "DEPARTMENT_ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentAccount.findAll", query = "SELECT d FROM DepartmentAccount d")
    , @NamedQuery(name = "DepartmentAccount.findByUsername", query = "SELECT d FROM DepartmentAccount d WHERE d.username = :username")
    , @NamedQuery(name = "DepartmentAccount.findByPassword", query = "SELECT d FROM DepartmentAccount d WHERE d.password = :password")})
public class DepartmentAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;

    public DepartmentAccount() {
    }

    public DepartmentAccount(String username) {
        this.username = username;
    }

    public DepartmentAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentAccount)) {
            return false;
        }
        DepartmentAccount other = (DepartmentAccount) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DepartmentAccount[ username=" + username + " ]";
    }
    
}
