/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ord.dsw.bean;

import org.dsw.dao.LocacaoDAO;
import org.dsw.pojo.Locacao;
import org.dsw.pojo.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class LocacaoBean implements Serializable {
    
    private Locacao locacao;
    
    public String listLocacoes(){
        return "/Locacao/listaLocacoes.xhtml?faces-redirect=true";
    }
    
    public String insertLocacaoForm(){
        locacao = new Locacao();
        Usuario user = SecurityContextHolder.getContext().getAuthentication();
        // if (user.getPapel().contains("ADMIN")) {
        //    locacao.setLocadoraId(user.getId());
        // } else {
            locacao.setClientId(user.getId());
        // }
        return "/Locacao/form.xhtml?faces-redirect=true";
    }
    
    public String update(Long id) {
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        locacao = locacaoDAO.get(id);
        return "form.xhtml";
    }
    
    public String insertLocacao(){
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        if (locacao.getId() == null){
            locacaoDAO.insert(locacao);
        }
        else{
            locacaoDAO.update(locacao);
        }
        
        return "listaLocacoes.xhtml";
    }
    
    public List<Locacao> getLocacoes() throws SQLException{
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        return locacaoDAO.getAll();
    }
    
    public Locacao getLocacao(){
        return locacao;
    }
    
    public String deleteLocacao(Locacao locacao) {
        LocacaoDAO locacaoDAO = new LocacaoDAO();
        locacaoDAO.delete(locacao);
        return "listaLocacoes.xhtml";
    }    
}
