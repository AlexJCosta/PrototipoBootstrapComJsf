/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Empresa;
import Utils.HibernateUtil;
import java.util.List;


import javax.persistence.*;
import javax.persistence.Persistence;
/**
 *
 * @author Invasor
 */
public class EmpresaDaoImpl implements EmpresaDao {

    EntityManager em;
    EntityManagerFactory emf;
    
    public EmpresaDaoImpl(){
       emf = Persistence.createEntityManagerFactory("Piloto-BootPU");
       em = emf.createEntityManager();
    }
    
    public void save(Empresa empresa) {
        em.getTransaction().begin();
        em.persist(empresa);
        em.getTransaction().commit();
    }

    public List<Empresa> list() {
        em.getTransaction().begin();
        Query qe = em.createQuery("select empresa from Empresa empresa");
        List<Empresa> empresas = qe.getResultList();
        em.getTransaction().commit();
        return empresas;
    }

    public void remove(Empresa empresa) {
        em.getTransaction().begin();
        em.remove(empresa);
        em.getTransaction().commit();
    }

    public void update(Empresa empresa) {
        em.getTransaction().begin();
        em.merge(empresa);
        em.getTransaction().commit();
    }
    
}
