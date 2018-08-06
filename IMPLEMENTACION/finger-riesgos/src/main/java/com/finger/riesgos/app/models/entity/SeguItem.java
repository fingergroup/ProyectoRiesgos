package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the segu_item database table.
 * 
 */
@Entity
@Table(name="segu_item")
@NamedQuery(name="SeguItem.findAll", query="SELECT s FROM SeguItem s")
public class SeguItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ITEM_ID")
	private String itemId;

	@Column(name="ITEM_DESCRICPION")
	private String itemDescricpion;

	@Column(name="ITEM_ESTADO")
	private String itemEstado;

	@Column(name="ITEM_NOMBRE")
	private String itemNombre;

	//bi-directional many-to-one association to SeguMenuItem
	@OneToMany(mappedBy="seguItem")
	private List<SeguMenuItem> seguMenuItems;

	public SeguItem() {
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDescricpion() {
		return this.itemDescricpion;
	}

	public void setItemDescricpion(String itemDescricpion) {
		this.itemDescricpion = itemDescricpion;
	}

	public String getItemEstado() {
		return this.itemEstado;
	}

	public void setItemEstado(String itemEstado) {
		this.itemEstado = itemEstado;
	}

	public String getItemNombre() {
		return this.itemNombre;
	}

	public void setItemNombre(String itemNombre) {
		this.itemNombre = itemNombre;
	}

	public List<SeguMenuItem> getSeguMenuItems() {
		return this.seguMenuItems;
	}

	public void setSeguMenuItems(List<SeguMenuItem> seguMenuItems) {
		this.seguMenuItems = seguMenuItems;
	}

	public SeguMenuItem addSeguMenuItem(SeguMenuItem seguMenuItem) {
		getSeguMenuItems().add(seguMenuItem);
		seguMenuItem.setSeguItem(this);

		return seguMenuItem;
	}

	public SeguMenuItem removeSeguMenuItem(SeguMenuItem seguMenuItem) {
		getSeguMenuItems().remove(seguMenuItem);
		seguMenuItem.setSeguItem(null);

		return seguMenuItem;
	}

}