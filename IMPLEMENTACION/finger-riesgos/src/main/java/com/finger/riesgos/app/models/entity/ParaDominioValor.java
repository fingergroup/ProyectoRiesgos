package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the para_dominio_valor database table.
 * 
 */
@Entity
@Table(name="para_dominio_valor")
@NamedQuery(name="ParaDominioValor.findAll", query="SELECT p FROM ParaDominioValor p")
public class ParaDominioValor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOVA_ID")
	private String dovaId;

	@Column(name="DOVA_DESCRIPCION")
	private String dovaDescripcion;

	@Column(name="DOVA_VALOR")
	private String dovaValor;

	//bi-directional many-to-one association to ParaDominio
	@ManyToOne
	@JoinColumn(name="DOMI_ID")
	private ParaDominio paraDominio;

	public ParaDominioValor() {
	}

	public String getDovaId() {
		return this.dovaId;
	}

	public void setDovaId(String dovaId) {
		this.dovaId = dovaId;
	}

	public String getDovaDescripcion() {
		return this.dovaDescripcion;
	}

	public void setDovaDescripcion(String dovaDescripcion) {
		this.dovaDescripcion = dovaDescripcion;
	}

	public String getDovaValor() {
		return this.dovaValor;
	}

	public void setDovaValor(String dovaValor) {
		this.dovaValor = dovaValor;
	}

	public ParaDominio getParaDominio() {
		return this.paraDominio;
	}

	public void setParaDominio(ParaDominio paraDominio) {
		this.paraDominio = paraDominio;
	}

}