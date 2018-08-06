package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the segu_usuario database table.
 * 
 */
@Entity
@Table(name="segu_usuario")
public class SeguUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USUA_ID")
	private Long usuaId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_CREACION")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name="PERS_ID")
	private BigInteger persId;

	@Column(name="USUA_ALIAS")
	private String usuaAlias;

	@Column(name="USUA_CLAVE")
	private String usuaClave;

	@Column(name="USUA_EMAIL")
	private String usuaEmail;

	@Column(name="USUA_ESTADO")
	private String usuaEstado;

	@Column(name="USUA_NOMBREUSUARIO")
	private String nombreUsuario;

	@Column(name="USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name="USUARIO_MODIFICACION")
	private String usuarioModificacion;

	//bi-directional many-to-one association to SeguUsuarioRol
	@OneToMany(mappedBy="seguUsuario")
	private List<SeguUsuarioRol> seguUsuarioRols;

	public SeguUsuario() {
	}

	public Long getUsuaId() {
		return this.usuaId;
	}

	public void setUsuaId(Long usuaId) {
		this.usuaId = usuaId;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BigInteger getPersId() {
		return this.persId;
	}

	public void setPersId(BigInteger persId) {
		this.persId = persId;
	}

	public String getUsuaAlias() {
		return this.usuaAlias;
	}

	public void setUsuaAlias(String usuaAlias) {
		this.usuaAlias = usuaAlias;
	}

	public String getUsuaClave() {
		return this.usuaClave;
	}

	public void setUsuaClave(String usuaClave) {
		this.usuaClave = usuaClave;
	}

	public String getUsuaEmail() {
		return this.usuaEmail;
	}

	public void setUsuaEmail(String usuaEmail) {
		this.usuaEmail = usuaEmail;
	}

	public String getUsuaEstado() {
		return this.usuaEstado;
	}

	public void setUsuaEstado(String usuaEstado) {
		this.usuaEstado = usuaEstado;
	}

	

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public List<SeguUsuarioRol> getSeguUsuarioRols() {
		return this.seguUsuarioRols;
	}

	public void setSeguUsuarioRols(List<SeguUsuarioRol> seguUsuarioRols) {
		this.seguUsuarioRols = seguUsuarioRols;
	}

	public SeguUsuarioRol addSeguUsuarioRol(SeguUsuarioRol seguUsuarioRol) {
		getSeguUsuarioRols().add(seguUsuarioRol);
		seguUsuarioRol.setSeguUsuario(this);

		return seguUsuarioRol;
	}

	public SeguUsuarioRol removeSeguUsuarioRol(SeguUsuarioRol seguUsuarioRol) {
		getSeguUsuarioRols().remove(seguUsuarioRol);
		seguUsuarioRol.setSeguUsuario(null);

		return seguUsuarioRol;
	}

	public final String getNombreUsuario() {
		return nombreUsuario;
	}

	public final void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}