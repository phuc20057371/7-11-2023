package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Khoahoc;
import com.example.demo.repository.KhoahocRepository;
import com.example.demo.service.KhoahocService;

@Service
public class KhoahocServiceImpl implements KhoahocService{
	private KhoahocRepository repository;
	private final RedisTemplate<String, Khoahoc> redisTemplate;
	
	

	public KhoahocServiceImpl(KhoahocRepository repository,RedisTemplate<String, Khoahoc> redisTemplate) {
		super();
		this.repository = repository;
		this.redisTemplate = redisTemplate;
		
	}
	@Override
	public Khoahoc createKhoahoc(Khoahoc kh) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set("khoahoc:" + kh.getId(), kh);
		return repository.save(kh);
	}
	@Override
	public Khoahoc findOne(long id) {
		// TODO Auto-generated method stub
		Optional<Khoahoc> employee = repository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}
	@Override
    public Khoahoc findOneRedis(long id) {
        // Lấy thông tin Khóa Học từ Redis
        return redisTemplate.opsForValue().get("khoahoc:" + id);
    }
	
}
