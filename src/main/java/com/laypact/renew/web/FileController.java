package com.laypact.renew.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/admin/")
public class FileController {
	@Value("${file.upload.location}")
	private String fileUploadPath;

	@ResponseBody
	@GetMapping(value = "/images")
	public ResponseEntity<Resource> images(@RequestParam("file") String file) {
		
		Resource resource = new FileSystemResource(fileUploadPath + file);
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Content-type", Files.probeContentType(Paths.get(fileUploadPath + file)));
		} catch(IOException e) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	 }
}