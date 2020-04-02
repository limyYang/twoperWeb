package com.tpsoft.platform.common.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/");
	
	@PostMapping("/upload")
	public String upload(MultipartFile file,HttpServletRequest req) {
		String format = sdf.format(new Date());
		String path = req.getServletContext().getRealPath("/img")+format;
		File folder = new File(path);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		String oldName = file.getOriginalFilename();
		String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
		try {
			file.transferTo(new File(folder,newName));
			String url = req.getScheme() + "://" +req.getServerName() +":" +req.getServerPort() + "/img" + format + newName;
			return url;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "errorPage";
	}
}
