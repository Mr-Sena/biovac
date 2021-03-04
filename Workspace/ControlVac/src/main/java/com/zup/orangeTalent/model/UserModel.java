package com.zup.orangeTalent.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	private String nome;
	
	@Column(unique = true)
	@NotNull
	private String email;
	
	@Column(unique = true)
	@NotNull
	private String cpf;
	
	@NotNull
	private String birthday;
	
	
	//Estabelecendo a chave estrangeira para cada aplicação da vacina:
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<VacModel> vacinacao;

	
	//Getters and Setters

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<VacModel> getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(List<VacModel> vacinacao) {
		this.vacinacao = vacinacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
	
}
