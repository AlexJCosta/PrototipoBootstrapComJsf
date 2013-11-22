/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Produto;
import Utils.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Invasor
 */
public class ProdutoDaoImpl implements ProdutoDao{
    
    
    EntityManager em;
    EntityManagerFactory emf;
    
    public ProdutoDaoImpl(){
       emf = Persistence.createEntityManagerFactory("Piloto-BootPU");
    }
    
     
    public void save(Produto produto) {
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        
    }


    public Produto getProduto(int idProduto) {
        try{
            em = emf.createEntityManager();
            Query q = em.createQuery("select p from Produto as p where p.id = :idProduto");
            q.setParameter("idProduto", idProduto);
            Produto p = (Produto) q.getSingleResult();
            return p;
        }finally{
            em.close();
        }
    }
    
    public void remove(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(produto);
        t.commit();
    }
    public void update(Produto produto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(produto);
        t.commit();
    }

    public List<Produto> list() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Produto").list();
        t.commit();
        return lista;
    }

    
}
