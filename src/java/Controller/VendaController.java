/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Dao.ProdutoDao;
import Dao.ProdutoDaoImpl;
import Model.ItemDeVenda;
import Model.Produto;
import Model.Venda;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * 
 */
@ManagedBean(name = "vendaController")
@SessionScoped
public class VendaController {
    private int idNovoProduto = 0;
    private Venda atual;
    private ProdutoDao daoP;

    public VendaController() {
        daoP = new ProdutoDaoImpl();
        atual = new Venda();
    }

    public void addProdutoAVenda(){
        try{
        Produto pro = daoP.getProduto(idNovoProduto);
        ItemDeVenda item = new ItemDeVenda( pro ,10);
        atual.addItemDeVenda(item);
         }catch(Exception e){
             System.err.println("Produto "+idNovoProduto
                     + " Nao encontrado");
         }
    }

    public int getIdNovoProduto() {
        return idNovoProduto;
    }

    public void setIdNovoProduto(int idNovoProduto) {
        this.idNovoProduto = idNovoProduto;
    }
    
    
    public Venda getVenda() {
        return atual;
    }
    
    
    public String AdicionarVenda(Produto pro){
        atual = new Venda();
        return "venda";
    }
    
    public String prepararAdicionarVenda(){
        return "venda";
    }
    

}
