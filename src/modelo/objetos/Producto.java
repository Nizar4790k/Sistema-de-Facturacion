package modelo.objetos;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="producto")
@Embeddable
public class Producto extends Identified {


	

	@Column(name="descripcion")
	protected String descripcion;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="tasa_itbis")
	private double tasaItbis;
	
	@Column(name="cantidad_disponible")
	private int cantidad;
	
	@Id
	@Column(name="id")
	private int id;
	
	
	public Producto(String descripcion, double precio, double tasaItbis, int cantidad) {
	
		this.descripcion= descripcion;
		this.precio = precio;
		this.tasaItbis = tasaItbis/100;
		this.cantidad= cantidad;
		
	}

	public Producto() {
		
	}

	
	public Producto(String descripcion, double precio,double tasaItbis) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.tasaItbis = tasaItbis/100;
		
		
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public double getTasaItbis() {
		return tasaItbis;
	}


	public int getCantidad() {
		return cantidad;
	}


	public int getId() {
		return id;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public void setTasaItbis(double tasaItbis) {
		this.tasaItbis = tasaItbis;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void setId(int id) {
		this.id = id;
	}
	



}
