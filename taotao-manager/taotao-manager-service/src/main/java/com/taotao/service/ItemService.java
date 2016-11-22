package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	public TbItem getItemById(Long id);

	public EasyUIDataGridResult getItemListByPage(int page, int rows);

	TaotaoResult addItem(TbItem item, String desc, String itemParam) throws Exception;
	
}
