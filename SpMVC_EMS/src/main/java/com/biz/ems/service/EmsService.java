package com.biz.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.EmsVO;

public interface EmsService {
	
	public List<EmsVO> selectAll();
	
	public void insert(EmsVO bbsVO);
	public List<String> insert(EmsVO emsVO, MultipartHttpServletRequest files);
	
	public EmsVO findBySeq(long long_seq);
	public int delete(long long_seq);
}
