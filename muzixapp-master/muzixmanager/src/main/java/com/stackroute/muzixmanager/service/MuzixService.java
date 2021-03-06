package com.stackroute.muzixmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.muzixmanager.entity.MuzixEntity;
import com.stackroute.muzixmanager.repository.MuzixRepository;

@Service
public class MuzixService {
	@Autowired
	MuzixRepository muzixRepository;
	
public boolean saveMuzix(MuzixEntity muzixEntity) {
	try {
		muzixRepository.save(muzixEntity);
		return true;
	}catch(Exception e) {
		e.printStackTrace();
		throw e;
	}	
}

public boolean saveMuzixs(List<MuzixEntity> muzixEntity) {
	try {
		muzixRepository.saveAll(muzixEntity);
		return true;
	}catch(Exception e) {
		e.printStackTrace();
		throw e;
	}	
}

	public MuzixEntity getMuzixByMusixId(int muzixId) {
	Optional<MuzixEntity> muzixEntity=muzixRepository.findById(muzixId);
	if(muzixEntity.isPresent()) {
		return muzixEntity.get();
	}else {
		return null;
	}
	
}
	
	
	

}
