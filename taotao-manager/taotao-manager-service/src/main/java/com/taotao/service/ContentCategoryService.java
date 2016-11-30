package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	List<EasyUITreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
