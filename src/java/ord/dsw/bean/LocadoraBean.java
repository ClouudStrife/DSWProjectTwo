/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ord.dsw.bean;

import org.dsw.dao.LocadoraDAO;
import org.dsw.pojo.Locadora;

import java.sql.SQLException;
import java.util.List;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class LocadoraBean implements Serializable {
    
    private Locadora locadora;
    
    public String listLocadoras(){
        return "/Locadora/listaLocadoras.xhtml?faces-redirect=true";
    }
    
    public String insertLocadoraForm(){
        locadora = new Locadora();
        return "/Locadora/form.xhtml?faces-redirect=true";
    }
    
    public String update(Long id) {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        locadora = locadoraDAO.get(id);
        return "form.xhtml";
    }
    
    public String insertLocadora(){
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        if (locadora.getId() == null){
            locadoraDAO.insert(locadora);
        }
        else{
            locadoraDAO.update(locadora);
        }
        
        return "listaLocadoras.xhtml";
    }
    
    public List<Locadora> getLocadoras() throws SQLException{
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.getAll();
    }
    
    public Locadora getLocadora(){
        return locadora;
    }
    
    public String deleteLocadora(Locadora locadora) {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        locadoraDAO.delete(locadora);
        return "listaLocadoras.xhtml";
    }    
}
