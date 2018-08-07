package com.finger.riesgos.app.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the segu_item database table.
 * 
 */
@Entity
@Table(name="segu_item")
public class SeguItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private Long itemId;

	@Column(name="ITEM_DESCRICPION")
	private String itemDescricpion;

	@Column(name="ITEM_ESTADO")
	private String itemEstado;

	@Column(name="ITEM_NOMBRE")
	private String itemNombre;

	//bi-directional many-to-one association to SeguMenuItem
//	@OneToMany(mappedBy="seguItem", fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignora atributos que se desean no esten en la serializacion
//	private List<SeguMenuItem> seguMenuItems;

	public SeguItem() {
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
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

//	public List<SeguMenuItem> getSeguMenuItems() {
//		return this.seguMenuItems;
//	}
//
//	public void setSeguMenuItems(List<SeguMenuItem> seguMenuItems) {
//		this.seguMenuItems = seguMenuItems;
//	}

//	public SeguMenuItem addSeguMenuItem(SeguMenuItem seguMenuItem) {
//		getSeguMenuItems().add(seguMenuItem);
//		seguMenuItem.setSeguItem(this);
//
//		return seguMenuItem;
//	}
//
//	public SeguMenuItem removeSeguMenuItem(SeguMenuItem seguMenuItem) {
//		getSeguMenuItems().remove(seguMenuItem);
//		seguMenuItem.setSeguItem(null);
//
//		return seguMenuItem;
//	}

}