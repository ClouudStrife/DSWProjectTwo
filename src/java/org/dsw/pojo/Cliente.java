/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsw.pojo;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@Entity
@NamedQueries({@NamedQuery(name = "Cliente.findAll", query = "SELECT u FROM Cliente u"),
        @NamedQuery(name = "Cliente.findByCPF", query = "SELECT u FROM Cliente u WHERE u.CPF = :CPF")})
public class Cliente extends Usuario implements Serializable{   
    private String nome;
    private String CPF;
    private String telefone;
    private String sexo;
    private String dataNasc;
    
    
    public Cliente(){
        this.setAtivo(true);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    
    public String getCPF(){
        return this.CPF;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    public void setDataNasc(String dataNasc){
        this.dataNasc = dataNasc;
    }
    
    public String getDataNasc(){
        return this.dataNasc;
    }
}
