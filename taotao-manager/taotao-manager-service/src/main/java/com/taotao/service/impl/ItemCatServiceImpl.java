package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> itemCatList = itemCatMapper.selectByExample(example);
		List<EasyUITreeNode> easyUITreeNodeList=new ArrayList<EasyUITreeNode>();
		EasyUITreeNode easyUITreeNode;
		for(TbItemCat itemCat:itemCatList){
			easyUITreeNode=new EasyUITreeNode();
			easyUITreeNode.setText(itemCat.getName());
			easyUITreeNode.setId(itemCat.getId());
			easyUITreeNode.setState(itemCat.getIsParent()?"closed":"open");
			easyUITreeNodeList.add(easyUITreeNode);
		}
		return easyUITreeNodeList;
	}

}
