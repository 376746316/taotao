package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictrueService;

@Service
public class PictureServiceImpl implements PictrueService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;

	@Value("${FTP_PORT}")
	private Integer FTP_PORT;

	@Value("${FTP_USER}")
	private String FTP_USER;

	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;

	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;

	@Value("${IMAGE_BASE_PATH}")
	private String IMAGE_BASE_PATH;

	@Override
	public Map uploadPictrue(MultipartFile uploadFile) {
		Map resultMap = new HashMap<>();
		try {
			String oldFileName = uploadFile.getOriginalFilename();
			String newFileName = IDUtils.genImageName();
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			newFileName = newFileName + oldFileName.substring(oldFileName.lastIndexOf("."));
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER, FTP_PASSWORD, FTP_BASE_PATH, imagePath,
					newFileName, uploadFile.getInputStream());
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_PATH + imagePath + "/" + newFileName);
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传发生异常");
		}
		return resultMap;
	}

}
