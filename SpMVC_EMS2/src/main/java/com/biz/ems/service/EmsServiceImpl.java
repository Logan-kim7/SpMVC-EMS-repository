package com.biz.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.ems.mapper.EmsDao;
import com.biz.ems.model.EmsVO;

//service interface를  implements 해서 사용
// 반드시 @servic라는 어노테이션이 필요  상속받은EmsService를 2개이상 만들씨 Service어노테이션에 이름이 붙여서  명시해준다.
@Service("emsServiceV1")
public class EmsServiceImpl implements EmsService{
	
	
	// 서버를 실행했을 때 널포인트, 퀄리파이 오류가 생긴다면 @ 부분을 확인 놓쳐을 확률이 높다.
	@Autowired
	private EmsDao emsDao;
	
	@Autowired
	private NaverMailSendService naverMail;
	
	@Override
	public List<EmsVO> selectAll() {
		List<EmsVO> emsList = emsDao.selectAll();
		
		return emsList;
	}

	@Override
	public EmsVO findById(long id) {
		EmsVO emsVO = emsDao.findById(id);
		return emsVO;
	}

	@Override
	public int insert(EmsVO emsVO) {
		
		 naverMail.sendMail(emsVO);
		int ret = emsDao.insert(emsVO);
		
		return ret;
	}

	@Override
	public int update(EmsVO emsVO) {
		
		
		
		return emsDao.update(emsVO);
	}

	@Override
	public int delete(Long id) {
		int ret = emsDao.delete(id);
		
		
		
		return ret;
	}

}
