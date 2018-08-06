package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segu_usuario_rol database table.
 * 
 */
@Entity
@Table(name="segu_usuario_rol")
@NamedQuery(name="SeguUsuarioRol.findAll", query="SELECT s FROM SeguUsuarioRol s")
public class SeguUsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USRO_ID")
	private String usroId;

	@Column(name="USRO_ESTADO")
	private String usroEstado;

	//bi-directional many-to-one association to SeguRol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private SeguRol seguRol;

	//bi-directional many-to-one association to SeguUsuario
	@ManyToOne
	@JoinColumn(name="USUA_ID")
	private SeguUsuario seguUsuario;

	public SeguUsuarioRol() {
	}

	public String getUsroId() {
		return this.usroId;
	}

	public void setUsroId(String usroId) {
		this.usroId = usroId;
	}

	public String getUsroEstado() {
		return this.usroEstado;
	}

	public void setUsroEstado(String usroEstado) {
		this.usroEstado = usroEstado;
	}

	public SeguRol getSeguRol() {
		return this.seguRol;
	}

	public void setSeguRol(SeguRol seguRol) {
		this.seguRol = seguRol;
	}

	public SeguUsuario getSeguUsuario() {
		return this.seguUsuario;
	}

	public void setSeguUsuario(SeguUsuario seguUsuario) {
		this.seguUsuario = seguUsuario;
	}

}