package com.lpu.mobile.service;

import java.util.List;

import com.lpu.mobile.dto.MobileDTO;
import com.lpu.mobile.entity.Mobile;

public interface MobileService {
	
	Mobile addMobile(MobileDTO dto);
	
	List<Mobile> getAllMobiles();
	
	Mobile getMobileById(int id);
	
	Mobile updateMobile(int id, MobileDTO dto);
	
	void deleteMobile(int id);
	
	List<Mobile> searchByBrand(String brandName);
}
