/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Produto;
import java.util.List;

/**
 *
 * @author Invasor
 */
public interface ProdutoDao {
    
    public void save(Produto produto);
    public List<Produto> list();
    public void remove(Produto produto);
    public void update(Produto produto);
    public Produto getProduto(int idProduto);
    
}
