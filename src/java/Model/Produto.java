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

@Entity
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private int quantidadeEmEstoque;
    
    @Column(nullable = false)
    private double precoCustoProduto;
    
    @Column(nullable = false)
    private double precoVendaProduto;
    
    @Column(nullable = false)
    private String fabricante;
   
    @Column(nullable = false)
    private String fornecedor;

    public Produto() {
    }

    public Produto(int id, String descricao, int quantidadeEmEstoque, double precoCustoProduto, double precoVendaProduto, String fabricante, String fornecedor) {
        this.id = id;
        this.descricao = descricao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.precoCustoProduto = precoCustoProduto;
        this.precoVendaProduto = precoVendaProduto;
        this.fabricante = fabricante;
        this.fornecedor = fornecedor;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public double getPrecoCustoProduto() {
        return precoCustoProduto;
    }

    public void setPrecoCustoProduto(double precoCustoProduto) {
        this.precoCustoProduto = precoCustoProduto;
    }

    public double getPrecoVendaProduto() {
        return precoVendaProduto;
    }

    public void setPrecoVendaProduto(double precoVendaProduto) {
        this.precoVendaProduto = precoVendaProduto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    
    
    
    
}
