/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.EmpresaDaoImpl;
import Model.Empresa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Invasor
 */
@ManagedBean(name = "empresaControler")
@SessionScoped
public class EmpresaControler {
    private Empresa empresa;
    private DataModel listaEmpresa;
    
    public EmpresaControler(){
        empresa = new Empresa();
    }
    
    public DataModel getListarLivros() {
        List<Empresa> lista = new EmpresaDaoImpl().list();
        listaEmpresa = new ListDataModel(lista);
        return listaEmpresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String prepararAdicionarEmpresa(){
        empresa = new Empresa();
        return "gerenciarEmpresa";
    }
    
    public String adicionarEmpresa(){

        EmpresaDaoImpl dao = new EmpresaDaoImpl();
        dao.save(empresa);
        return "index";
        
    }
    
}
