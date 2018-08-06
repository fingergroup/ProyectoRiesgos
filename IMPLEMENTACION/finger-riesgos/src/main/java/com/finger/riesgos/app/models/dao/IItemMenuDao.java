package com.finger.riesgos.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.finger.riesgos.app.models.entity.SeguItem;

@Service
public interface IItemMenuDao   extends CrudRepository<SeguItem, Long>{
	
	@Query(value = "select distinct it.* from segu_item it  JOIN segu_menu_item mt on it.ITEM_ID=mt.ITEM_ID and mt.MEIT_ESTADO='A' JOIN segu_rol rl on  mt.ROL_ID=rl.ROL_ID and rl.ROL_ESTADO='A' JOIN segu_usuario_rol ur on rl.ROL_ID=ur.ROL_ID and ur.USRO_ESTADO='A' JOIN segu_usuario us on ur.USUA_ID = us.USUA_ID  and us.USUA_ESTADO='A' where it.ITEM_ESTADO='A' and us.USUA_NOMBREUSUARIO=?1 ", nativeQuery = true)
	public List<SeguItem> getItemsByUsuario(String userName );

}
