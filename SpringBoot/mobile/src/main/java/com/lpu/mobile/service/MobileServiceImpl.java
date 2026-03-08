package com.lpu.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.mobile.dto.MobileDTO;
import com.lpu.mobile.entity.Mobile;
import com.lpu.mobile.repository.MobileRepository;

@Service
public class MobileServiceImpl {
	
	@Autowired
	private MobileRepository repository;
	
//	@Override
//	public Mobile addMobile(MobileDTO dto) {
//		Mobile mobile = new Mobile();
//		mapDtoToEntity(dto, mobile);
//		return repository.save(mobile);
//	}
//	
//	@Override
//	@Cacheable("mobiles")
//	public List<Mobile> getAllMobiles(){
//		return repository.findAll();
//	}
	
	
}
