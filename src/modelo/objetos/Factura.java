package modelo.objetos;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura extends Identified {

	@Id
	@Column(name = "id")
	private  int id;
	

	public Factura(int idCliente, String fecha, String hora,double totalItbis,double subTotal) {
		super();
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.hora = hora;
		this.totalItbis = totalItbis;
		this.subTotal = subTotal;
		totalApagar= totalItbis + subTotal;
		
	}

	@Column(name = "idcliente")
	private int idCliente;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="hora")
	private String hora;
	
	@Column(name="subtotal")
	private double subTotal;
	
	@Column(name="total_itbis")
	private double totalItbis;
	
	
	@Column(name="total_a_pagar")
	private double totalApagar;
	
	
	
	
 
	
   public Factura() {
	   
   }
   
   


	public int getId() {
		return id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}




	public double getSubTotal() {
		return subTotal;
	}




	public double getTotalItbis() {
		return totalItbis;
	}




	public double getTotalApagar() {
		return totalApagar;
	}
	
	
	
	
	
	
	
	
}
