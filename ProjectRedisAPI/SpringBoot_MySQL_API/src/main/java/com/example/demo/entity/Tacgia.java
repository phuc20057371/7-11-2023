package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tac_gia")
public class Tacgia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ten;
	public Tacgia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tacgia(long id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	public Tacgia(String ten) {
		super();
		this.ten = ten;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	@Override
	public String toString() {
		return "Tacgia [id=" + id + ", ten=" + ten + "]";
	}
	
}
