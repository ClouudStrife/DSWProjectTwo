/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dsw.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = "Locacao.findAll", query = "SELECT u FROM Locacao u"),
@NamedQuery(name = "Locadora.findByClienteId", query = "SELECT u FROM Locadora u WHERE u.clienteId = :clienteId"),
@NamedQuery(name = "Locadora.findByLocadoraId", query = "SELECT u FROM Locadora u WHERE u.locadoraId = :locadoraId")})
public class Locacao implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private Long clienteId;
    private Long locadoraId;
    private Date dataHora;
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public void setClientId(Long clientId){
        this.clientId = clientId;
    }
    
    public Long getClientId(){
        return this.clientId;
    }
    
    public void setLocadoraId(Long locadoraId){
        this.locadoraId = locadoraId;
    }
    
    public Long getLocadoraId(){
        return this.locadoraId;
    }
    
    public void setDataHora(Date dataHora){
        this.dataHora = dataHora;
    }
    
    public String getDataHora(){
        return this.dataHora;
    }
}
