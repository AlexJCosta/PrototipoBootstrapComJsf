/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Invasor
 */
@Entity
public class Venda {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    List<ItemDeVenda> itemDeVenda;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    public Venda() {
    }

    public Venda(List<ItemDeVenda> itemDeVenda) {
        this.itemDeVenda = itemDeVenda;
    }
    
    public void addItemDeVenda(ItemDeVenda iv){
        if(this.itemDeVenda == null){
            this.itemDeVenda = new LinkedList<ItemDeVenda>();
        }
        this.itemDeVenda.add(iv);
    }

    public List<ItemDeVenda> getItemDeVenda() {
        return itemDeVenda;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    
    
}
