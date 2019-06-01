package org.dsw;

import org.dsw.pojo.Papel;
import org.dsw.pojo.Usuario;
import org.dsw.dao.PapelDAO;
import org.dsw.dao.UsuarioDAO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        PapelDAO papelDAO = new PapelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Criando Usuario admin com papel ROLE_ADMIN
     
        Usuario u1 = new Usuario();
        u1.setEmail("admin@admin");
        u1.setSenha(encoder.encode("admin"));
        u1.setAtivo(true);
        usuarioDAO.insert(u1);

        Papel p1 = new Papel();
        p1.setNome("ROLE_ADMIN");
        papelDAO.insert(p1);

        u1.getPapel().add(p1);
        usuarioDAO.update(u1);

        Papel p2 = new Papel();
        p2.setNome("ROLE_CLIENTE");
        papelDAO.insert(p2);
    }
}
