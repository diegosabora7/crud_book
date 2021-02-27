package com.diegoyandun.exam.repository;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name ="nombre", nullable = false)
	private String nombre;
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	@Column(name = "autor", nullable = false)
	private String autor;
	@Column(name = "fecha_pub", nullable = false)
	private Date fecha_pub;
	@Column(name = "num_ejem", nullable = false)
	private int num_ejem;
	@Column(name = "costo", nullable = false)
	private double costo;
	
	
	
	public Book() {
		
	}
	public Book(Long id, String nombre, String descripcion, String autor, Date fecha_pub, int num_ejem, double costo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.autor = autor;
		this.fecha_pub = fecha_pub;
		this.num_ejem = num_ejem;
		this.costo = costo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getFecha_pub() {
		return fecha_pub;
	}
	public void setFecha_pub(Date fecha_pub) {
		this.fecha_pub = fecha_pub;
	}
	public int getNum_ejem() {
		return num_ejem;
	}
	public void setNum_ejem(int num_ejem) {
		this.num_ejem = num_ejem;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", autor=" + autor
				+ ", fecha_pub=" + fecha_pub + ", num_ejem=" + num_ejem + ", costo=" + costo + "]";
	}
	
	
}
