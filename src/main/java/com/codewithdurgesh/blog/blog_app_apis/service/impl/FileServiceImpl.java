package com.codewithdurgesh.blog.blog_app_apis.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithdurgesh.blog.blog_app_apis.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		//File Name 
		String name = file.getOriginalFilename();
		//abc.png
		
		//random name generated file
		String randomId = UUID.randomUUID().toString();
		String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//Full path
		String filePath = path + File.separator + fileName1;
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		// File Copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		
		String fullPath = path + File.separator + fileName;
		InputStream is = new FileInputStream(fullPath);
		return is;
	}

}
