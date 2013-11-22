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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Invasor
 */
@ManagedBean(name = "empresaController")
@SessionScoped
public class EmpresaController {
    private Empresa empresa;
    private DataModel listaEmpresa;
    
    public EmpresaController(){
        empresa = new Empresa();
        emf = Persistence.createEntityManagerFactory("Piloto-BootPU");
        em = emf.createEntityManager();
    }
    
    public List<Empresa> getListarEmpresa() {
//        List<Empresa> lista = new EmpresaDaoImpl().list();
//        listaEmpresa = new ListDataModel(lista);
//        return listaEmpresa;
        em.getTransaction().begin();
        Query qe = em.createQuery("from empresa ");
       
        List<Empresa> empresas = qe.getResultList();
        em.getTransaction().commit();
        return empresas;
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
    
     EntityManager em;
    EntityManagerFactory emf;
    
    
    
     
    public void save(Empresa empresa) {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
    }

    public List<Empresa> list() {

        em.getTransaction().begin();
        Query qe = em.createQuery("from empresa ");
       
        List<Empresa> empresas = qe.getResultList();
        em.getTransaction().commit();
        return empresas;
    }
    
}
