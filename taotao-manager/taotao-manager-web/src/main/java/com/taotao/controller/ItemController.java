package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public @ResponseBody TbItem getItemById(@PathVariable Long itemId) {

		return itemService.getItemById(itemId);

	}

	@RequestMapping("/item/list")
	public @ResponseBody EasyUIDataGridResult getItemList(int page, int rows) {
		return itemService.getItemListByPage(page, rows);
	}

	@RequestMapping(value = "/item/save", method = RequestMethod.POST)
	public @ResponseBody TaotaoResult addItem(TbItem item) {

		return itemService.addItem(item);
	}

}
