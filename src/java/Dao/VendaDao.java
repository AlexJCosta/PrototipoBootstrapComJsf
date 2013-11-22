/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Venda;
import java.util.List;



/**
 *
 * @author Invasor
 */
public interface VendaDao {


    public void save(Venda venda);
    public List<Venda> list();
    public void remove(Venda venda);
    public void update(Venda venda);


    
}
