package com.zup.orangeTalent.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vacinas")
public class VacModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String name;
	

	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInput = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	private String data;

	
	//Aderindo ao id do usuário em detrimento do email:
	@ManyToOne
	@JsonIgnoreProperties("vacinacao")
	private UserModel usuario;
	
	@NotNull
	private String emailUser;
	
	
	//Getters and Setters


	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UserModel usuario) {
		this.usuario = usuario;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDataInput() {
		return dataInput;
	}

	public void setDataInput(Date dataInput) {
		this.dataInput = dataInput;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}


	
	
	
}
