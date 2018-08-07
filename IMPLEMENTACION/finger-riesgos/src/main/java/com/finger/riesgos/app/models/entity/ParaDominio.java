package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the para_dominio database table.
 * 
 */
@Entity
@Table(name="para_dominio")
public class ParaDominio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOMI_ID")
	private Long domiId;

	@Column(name="DOMI_DESCRIPCION")
	private String domiDescripcion;

	@Column(name="DOMI_ESTADO")
	private String domiEstado;

	@Column(name="DOMI_NOMBRE")
	private String domiNombre;

	@Column(name="DOMI_TIPO")
	private String domiTipo;

	//bi-directional many-to-one association to ParaDominioValor
	@OneToMany(mappedBy="paraDominio")
	private List<ParaDominioValor> paraDominioValors;

	public ParaDominio() {
	}

	public Long getDomiId() {
		return this.domiId;
	}

	public void setDomiId(Long domiId) {
		this.domiId = domiId;
	}

	public String getDomiDescripcion() {
		return this.domiDescripcion;
	}

	public void setDomiDescripcion(String domiDescripcion) {
		this.domiDescripcion = domiDescripcion;
	}

	public String getDomiEstado() {
		return this.domiEstado;
	}

	public void setDomiEstado(String domiEstado) {
		this.domiEstado = domiEstado;
	}

	public String getDomiNombre() {
		return this.domiNombre;
	}

	public void setDomiNombre(String domiNombre) {
		this.domiNombre = domiNombre;
	}

	public String getDomiTipo() {
		return this.domiTipo;
	}

	public void setDomiTipo(String domiTipo) {
		this.domiTipo = domiTipo;
	}

	public List<ParaDominioValor> getParaDominioValors() {
		return this.paraDominioValors;
	}

	public void setParaDominioValors(List<ParaDominioValor> paraDominioValors) {
		this.paraDominioValors = paraDominioValors;
	}

	public ParaDominioValor addParaDominioValor(ParaDominioValor paraDominioValor) {
		getParaDominioValors().add(paraDominioValor);
		paraDominioValor.setParaDominio(this);

		return paraDominioValor;
	}

	public ParaDominioValor removeParaDominioValor(ParaDominioValor paraDominioValor) {
		getParaDominioValors().remove(paraDominioValor);
		paraDominioValor.setParaDominio(null);

		return paraDominioValor;
	}

}