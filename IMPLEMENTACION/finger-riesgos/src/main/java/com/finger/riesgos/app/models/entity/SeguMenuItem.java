package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segu_menu_item database table.
 * 
 */
@Entity
@Table(name="segu_menu_item")
@NamedQuery(name="SeguMenuItem.findAll", query="SELECT s FROM SeguMenuItem s")
public class SeguMenuItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MEIT_ID")
	private String meitId;

	@Column(name="MEIT_ESTADO")
	private String meitEstado;

	//bi-directional many-to-one association to SeguItem
	@ManyToOne
	@JoinColumn(name="ITEM_ID")
	private SeguItem seguItem;

	//bi-directional many-to-one association to SeguRol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private SeguRol seguRol;

	public SeguMenuItem() {
	}

	public String getMeitId() {
		return this.meitId;
	}

	public void setMeitId(String meitId) {
		this.meitId = meitId;
	}

	public String getMeitEstado() {
		return this.meitEstado;
	}

	public void setMeitEstado(String meitEstado) {
		this.meitEstado = meitEstado;
	}

	public SeguItem getSeguItem() {
		return this.seguItem;
	}

	public void setSeguItem(SeguItem seguItem) {
		this.seguItem = seguItem;
	}

	public SeguRol getSeguRol() {
		return this.seguRol;
	}

	public void setSeguRol(SeguRol seguRol) {
		this.seguRol = seguRol;
	}

}