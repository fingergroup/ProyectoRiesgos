package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the segu_rol database table.
 * 
 */
@Entity
@Table(name="segu_rol")
@NamedQuery(name="SeguRol.findAll", query="SELECT s FROM SeguRol s")
public class SeguRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROL_ID")
	private String rolId;

	@Column(name="ROL_DESCRIPCION")
	private String rolDescripcion;

	@Column(name="ROL_ESTADO")
	private String rolEstado;

	@Column(name="ROL_NOMBRE")
	private String rolNombre;

	//bi-directional many-to-one association to SeguMenuItem
	@OneToMany(mappedBy="seguRol")
	private List<SeguMenuItem> seguMenuItems;

	//bi-directional many-to-one association to SeguUsuarioRol
	@OneToMany(mappedBy="seguRol")
	private List<SeguUsuarioRol> seguUsuarioRols;

	public SeguRol() {
	}

	public String getRolId() {
		return this.rolId;
	}

	public void setRolId(String rolId) {
		this.rolId = rolId;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public String getRolEstado() {
		return this.rolEstado;
	}

	public void setRolEstado(String rolEstado) {
		this.rolEstado = rolEstado;
	}

	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public List<SeguMenuItem> getSeguMenuItems() {
		return this.seguMenuItems;
	}

	public void setSeguMenuItems(List<SeguMenuItem> seguMenuItems) {
		this.seguMenuItems = seguMenuItems;
	}

	public SeguMenuItem addSeguMenuItem(SeguMenuItem seguMenuItem) {
		getSeguMenuItems().add(seguMenuItem);
		seguMenuItem.setSeguRol(this);

		return seguMenuItem;
	}

	public SeguMenuItem removeSeguMenuItem(SeguMenuItem seguMenuItem) {
		getSeguMenuItems().remove(seguMenuItem);
		seguMenuItem.setSeguRol(null);

		return seguMenuItem;
	}

	public List<SeguUsuarioRol> getSeguUsuarioRols() {
		return this.seguUsuarioRols;
	}

	public void setSeguUsuarioRols(List<SeguUsuarioRol> seguUsuarioRols) {
		this.seguUsuarioRols = seguUsuarioRols;
	}

	public SeguUsuarioRol addSeguUsuarioRol(SeguUsuarioRol seguUsuarioRol) {
		getSeguUsuarioRols().add(seguUsuarioRol);
		seguUsuarioRol.setSeguRol(this);

		return seguUsuarioRol;
	}

	public SeguUsuarioRol removeSeguUsuarioRol(SeguUsuarioRol seguUsuarioRol) {
		getSeguUsuarioRols().remove(seguUsuarioRol);
		seguUsuarioRol.setSeguRol(null);

		return seguUsuarioRol;
	}

}