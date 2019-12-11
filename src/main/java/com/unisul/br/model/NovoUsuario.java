package com.unisul.br.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Entity
@Table (name="Usuario")
public class NovoUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column (name="idUsuario")
	private Integer idUsuario;
	@Column (name="NomeUsuario", nullable = false)
	private String nome;
	@Column (name="DtaNasc")
	private Date dataNascimento;
	@Column (name="Idade")
	private String idade;
	@Column (name="Sexo")
	private String sexo;
	@Column (name="Email")
	private String email;
	@Column (name="Senha")
	private String senha;
	@Column (name="ConfirmaSenha")
	private String confirmaSenha;
	//@OneToMany
	private Endereco endereco;
	
	public NovoUsuario (int id) {
		
	}
	
	public NovoUsuario () {
		
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDataNascFormatada() {
		SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
		return dataFormatada.format(this.dataNascimento);
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento){
		SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dataNascimento = (Date) dataFormatada.parse(dataNascimento);
		}catch (ParseException | java.text.ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NovoUsuario)) return false;

        NovoUsuario that = (NovoUsuario) o;

        return getIdUsuario() == that.getIdUsuario();
    }

    @Override
    public int hashCode() {
        return getIdUsuario();
    }
}
