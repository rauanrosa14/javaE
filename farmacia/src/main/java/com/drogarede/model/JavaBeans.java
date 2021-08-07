package com.drogarede.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JavaBeans{
	private static final long serialVersionUID = 1L;
      private String idCon;
      private String nome;
      private String dia;
      private String cpf;
      private String fone;
      private String email;
      private String produto;
    public JavaBeans() {
        super();
    }
    
    public JavaBeans(String idCon,String nome,String produto,String dia, String cpf,String fone, String email) {
    	super();
    	this.idCon = idCon;
    	this.produto =produto;
    	this.nome = nome;
    	this.dia = dia;
    	this.cpf = cpf;
    	this.fone = fone;
    	this.email =email;
    }

   
	public void setIdcon(String idcon) {
		this.idCon = idcon;
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	

	public void setProduto(String prod) {
		this.produto = prod;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	 public String getIdcon() {
			return idCon;
	}
	 
	public String getNome() {
		return nome;
	}
	
	public String getFone() {
		return fone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getDia() {
		return dia;
	} 
	public String getProd() {
		return produto;
	} 
}
