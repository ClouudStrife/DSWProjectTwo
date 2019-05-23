/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ord.dsw.bean;

import org.dsw.dao.ClienteDAO;
import org.dsw.pojo.Cliente;

import java.sql.SQLException;
import java.util.List;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {
    
    private Cliente cliente;
    
    public String listClient(){
        return "cliente/index.xhtml";
    }
    
    public String insertClientForm(){
        cliente = new Cliente();
        return "cliente/form.xhtml";
    }
    
    public String insertClient(){
        ClienteDAO clienteDAO = new ClienteDAO();
        if (cliente.getId() == null){
            clienteDAO.insert(cliente);
        }
        else{
            clienteDAO.update(cliente);
        }
        
        return "index.xhtml";
    }
    
    public List<Cliente> getClients() throws SQLException{
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getAll();
    }
    
    public Cliente getClient(){
        return cliente;
    }
    
    public String deleteClient(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(cliente);
        return "index.xhtml";
    }
    
    
}
