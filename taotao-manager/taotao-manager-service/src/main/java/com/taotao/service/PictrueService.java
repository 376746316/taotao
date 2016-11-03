package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictrueService {
	Map uploadPictrue(MultipartFile uploadFile);
}
