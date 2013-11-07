/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Invasor
 */

@Entity(name = "empresa")
public class Empresa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(nullable = false)
    private String razaoSocial ;
    @Column(nullable = false)
    private String endereco;

    public Empresa() {
    }

    public Empresa(int id, String razaoSocial, String endereco) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }
    
    
    
    
    
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
	
	
    
	
    
}
