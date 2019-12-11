package com.unisul.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="Endereco")
public class Endereco {
	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		@Column (name="Id_cep")
		private Integer id;
		@Column (name="Cep", nullable = false)
		private String cep;
		@Column (name="NomeRua")
		private String rua;
		@Column (name="NomeBairro")
		private String bairro;
		@Column (name="NomeCidade")
		private String cidade;
		@Column (name="NroCasa")
		private Integer numeroCasa;
		@Column (name="Complemento")
		private String complemento;
		@Column (name="Estado")
		private String uf;
		
		@ManyToOne
		NovoUsuario novoUsuario;
			
		public Endereco(int id) {
			this.id = id;
		}
		public Endereco() {
			
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getRua() {
			return rua;
		}
		public void setRua(String rua) {
			this.rua = rua;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public Integer getNumeroCasa() {
			return numeroCasa;
		}
		public void setNumeroCasa(Integer numeroCasa) {
			this.numeroCasa = numeroCasa;
		}
		public String getComplemento() {
			return complemento;
		}
		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Endereco other = (Endereco) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
		
		
}
