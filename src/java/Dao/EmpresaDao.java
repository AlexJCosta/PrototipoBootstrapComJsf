/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empresa;
import java.util.List;



/**
 *
 * @author Invasor
 */
public interface EmpresaDao {


    public void save(Empresa empresa);
    public List<Empresa> list();
    public void remove(Empresa empresa);
    public void update(Empresa empresa);


    
}
