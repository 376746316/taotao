package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.service.PictrueService;

@Controller
public class PictrueController {

	@Autowired
	private PictrueService pictrueService;
	
	@RequestMapping("/pic/upload")
	public @ResponseBody Map  pictrueUpload(MultipartFile uploadFile){
		return pictrueService.uploadPictrue(uploadFile);
	}
}
