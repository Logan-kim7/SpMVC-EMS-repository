package com.biz.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.mapper.EmsDao;
import com.biz.ems.mapper.ImageDao;
import com.biz.ems.model.ImageVO;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService {
	
	@Autowired
	protected EmsDao emsDao;
	
	@Autowired
	protected ImageDao imageDao;
	
	@Autowired
	@Qualifier("fileServieV1")
	protected FileService fileService;
	
	
	
	
	@Override
	public String fileUp(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fileDelete(String b_file) {
		// TODO Auto-generated method stub
		return false;
	}
	
	


}
