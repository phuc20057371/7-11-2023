package com.example.demo.service;

import com.example.demo.entity.Khoahoc;

public interface KhoahocService {
	Khoahoc createKhoahoc(Khoahoc kh);
	Khoahoc findOne(long id);
	Khoahoc findOneRedis(long id);
}
