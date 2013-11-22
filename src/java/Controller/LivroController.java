/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Dao.LivroDao;
import Dao.LivroDaoImp;
import Model.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelListener;
import javax.faces.model.ListDataModel;

/**
 *
 * 
 */
@ManagedBean
@SessionScoped
public class LivroController {

    private Livro livro;
    private DataModel listaLivros;
    List<Livro> listaDe; 
    public DataModel getListarLivros() {
//        List<Livro> lista = new LivroDaoImp().list();
        listaLivros = new ListDataModel(listaDe);
        return listaLivros;
    }
    
 
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LivroController() {
//        Livro livro = new Livro(2, "", "", 0, "", "", 0);
//        LivroDaoImp dao = new LivroDaoImp();
//        dao.save(livro);
    }
    

    public String prepararAdicionarLivro(){
        livro = new Livro();
        return "gerenciarLivro";
    }

    public String prepararAlterarLivro(){
        livro = (Livro)(listaLivros.getRowData());
        return "gerenciarLivro";
    }

    public String excluirLivro(){

        Livro livroTemp = (Livro)(listaLivros.getRowData());
        LivroDao dao = new LivroDaoImp();
        dao.remove(livroTemp);
        return "index";

    }

    public String adicionarLivro(){

        LivroDao dao = new LivroDaoImp();
        dao.save(livro);
        return "index";
        
    }
    public List<Livro> ListaDeLivro(){
        
        return listaDe;
    }
    public Livro pegarLivro(){
        LivroDaoImp dao = new LivroDaoImp();
        listaDe.add(livro);
        return dao.getLivro(livro.getId());
    }

    public String alterarLivro(){

        LivroDao dao = new LivroDaoImp();
        dao.update(livro);
        return "index";

    }

}
