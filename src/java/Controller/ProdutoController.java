/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ProdutoDaoImpl;
import Model.Produto;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.persistence.*;
/**
 *
 * @author Invasor
 */
@ManagedBean(name = "produtoController")
@SessionScoped
public class ProdutoController {
    
    private Produto produto;
    private String campoConsulta; 
    private DataModel listaProdutos;
    
    EntityManager em;
    EntityManagerFactory emf;
    
    public ProdutoController(){
        produto = new Produto();
    }
    
    public List pesquisar(){
        em.getTransaction().begin();
        Query consulta = em.createQuery("from Produto p where p.id like : 9"); 
       
        em.getTransaction().commit();
        
        return consulta.getResultList();
        
        
}
  

    public Produto getProduto() {
        return produto;
    }
    
   
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String prepararAdicionarProduto(){
        produto = new Produto();
        return "gerenciarProduto";
    }
    
    public String adicionarProduto(){

        ProdutoDaoImpl dao = new ProdutoDaoImpl();
        dao.save(produto);
        return "index";
        
    }
    
}
