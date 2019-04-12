package modelo.objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="productos_facturados")
public class ProductoFacturado  extends Identified  {


	
	
	public ProductoFacturado(int index,String descripcion,double precio,double tasaItbis, int idProducto,int cantidadFacturada) {
		
		this.indiceFactura = index;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tasaItbis = tasaItbis;
		this.idProducto = idProducto;
	
		this.cantidadFacturada =cantidadFacturada;
	}
	
	public ProductoFacturado() {
		
	}
	
	
	



	public int getIdProducto() {
		return idProducto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getCantidadFacturada() {
		return cantidadFacturada;
	}


	@Column(name="descripcion")
	private String descripcion;

	@Column(name="precio")
	private double precio;

	@Column(name="tasa_itbis")
	private double tasaItbis;
	
	public double getPrecio() {
		return precio;
	}
	
	
	public int getIndiceFactura() {
		return indiceFactura;
	}


	public double getTasaItbis() {
		return tasaItbis;
	}


	@Column(name="id_producto")
	private int idProducto;
	
	@Column(name="id_factura")
	private int idFactura;
	
	@Id
	@Column(name="indice")
	private int indice;
	
	@Column(name="cantidad_facturada")
	private int cantidadFacturada;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	
	@Column(name="indice_factura")
	private int indiceFactura;

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return indice;
	}
	
	
}
