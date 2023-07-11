package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "khoa_hoc")
public class Khoahoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ten;
	private String mota;
	private double gia;
	@ManyToOne
	private Tacgia tacgia;
	public Khoahoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Khoahoc(long id, String ten, String mota, double gia, Tacgia tacgia) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
		this.gia = gia;
		this.tacgia = tacgia;
	}
	public Khoahoc(String ten, String mota, double gia, Tacgia tacgia) {
		super();
		this.ten = ten;
		this.mota = mota;
		this.gia = gia;
		this.tacgia = tacgia;
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
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public Tacgia getTacgia() {
		return tacgia;
	}
	public void setTacgia(Tacgia tacgia) {
		this.tacgia = tacgia;
	}
	@Override
	public String toString() {
		return "Khoahoc [id=" + id + ", ten=" + ten + ", mota=" + mota + ", gia=" + gia + ", tacgia=" + tacgia + "]";
	}
	
	
}
