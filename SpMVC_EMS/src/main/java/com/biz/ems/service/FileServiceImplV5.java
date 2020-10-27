package com.biz.ems.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.ImageVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service(value = "fileServiceV5")
public class FileServiceImplV5 extends FileServiceImplV4{
	
	private final ResourceLoader resourceLoader;
	
	@Override
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) {
	
		List<MultipartFile> fileList = files.getFiles("files");
		List<ImageVO> fileNames = new ArrayList<ImageVO>();
		
		for(MultipartFile f : fileList) {
			if(!f.getOriginalFilename().isEmpty()) {
				String fileName = this.fileUp(f);
				ImageVO imageVO = ImageVO.builder()
									.s_org_name(f.getOriginalFilename())
									.s_file_name(fileName)
									.build();
				
				fileNames.add( imageVO );
			}
		}
		return fileNames;
	
	}
	
	

}
