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
import org.dsw.dao.PapelDAO;
import org.dsw.dao.UsuarioDAO;
import org.dsw.pojo.Papel;
import org.dsw.pojo.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private Usuario usuario;

    public String listClients() {
        return "/cliente/listaClientes.xhtml?faces-redirect=true";
    }

    public String insertClientForm() {
        cliente = new Cliente();
        return "/cliente/form.xhtml?faces-redirect=true";
    }

    public String update(Long id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        cliente = clienteDAO.get(id);
        return "form.xhtml";
    }

    public String insertClient() {
        ClienteDAO clienteDAO = new ClienteDAO();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        
        if (cliente.getId() == null) {
            cliente.setSenha(encoder.encode(cliente.getSenha()));
            clienteDAO.insert(cliente);
            
            cliente.getPapel().add(new PapelDAO().get(2L));
        }
            clienteDAO.update(cliente);
       

        return "listaClientes.xhtml";
    }

    public List<Cliente> getClientes() throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.getAll();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String deleteClient(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(cliente);
        return "listClients.xhtml";
    }

    private void insertNewUser(Cliente cliente) {
        usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PapelDAO papelDAO = new PapelDAO();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        

        usuario.setEmail(cliente.getEmail());
        usuario.setSenha(encoder.encode(cliente.getSenha()));
        usuario.setAtivo(true);

        usuarioDAO.insert(usuario);
        
        Papel papelUsuario = papelDAO.getRole("ROLE_USER");
        usuario.getPapel().add(papelUsuario);
        usuarioDAO.update(usuario);      
    }
}
