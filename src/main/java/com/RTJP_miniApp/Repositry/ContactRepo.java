package com.RTJP_miniApp.Repositry;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.RTJP_miniApp.Entity.CntctEntity;

public interface ContactRepo extends CrudRepository<CntctEntity, Serializable> {
	

}
