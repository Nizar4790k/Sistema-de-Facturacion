package controlador.factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import modelo.ManipulaBD;
import modelo.objetos.Factura;
import modelo.objetos.Identified;
import modelo.objetos.Producto;
import modelo.objetos.ProductoFacturado;
import vista.VentanaEmergente;
import vista.factura.FacturaForm;
import vista.VentanaEmergente;

public class AccionFacturar implements ActionListener {

	private FacturaForm form ;
	
	
	private static LinkedList<ProductoFacturado> listaFacturado;
	
	private static int indexSiguiente=0;
	
	private static double subTotal;
	
	private static double totalItbis;

	private static double totalApagar;
	
	private static int idFactura;
	

	
	
	public AccionFacturar(FacturaForm form) {
		this.form = form;
		listaFacturado = new LinkedList();
		totalItbis = 0;
		subTotal = 0;
	
	}
	
	private  static int   getFacturaLastId() throws SQLException {
		
		List<Factura>  lista= ManipulaBD.consultarObjeto(Factura.class);
		
		int i=0;
		
		
		for(Factura fact : lista) {
			i++;
			
		}
		
		return  lista.get(i-1).getId();
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton botonPulsado = (JButton) e.getSource();
		
		if(botonPulsado==form.getBtnFacturar()) {
		int index = indexSiguiente;
		indexSiguiente++;
	
		
		
		DefaultTableModel model = (DefaultTableModel) form.getTblProductos().getModel();
			 
		
		
		if(form.getRadAgregar().isSelected()) {
			
			
			int idArticulo = Integer.parseInt(form.getTxtCodigoArticulo().getText());
			int cantidadPorFacturar = (int) form.getSpnCantidadAFacturar().getValue();
	
			
			Producto producto = ManipulaBD.getObject(idArticulo,Producto.class);
			
			if(producto==null) {
				
			VentanaEmergente.errorEmergente("Producto no encontrado en el inventario");
				return;
				
			} else if(cantidadPorFacturar<=0) {
				VentanaEmergente.errorEmergente("Solo se permiten facturar cantidades mayores o iguales que 1");
					return;
			} else if(producto.getCantidad()<=0) {
				VentanaEmergente.errorEmergente("Producto ya agotado.");
				return;
			} 
			 else if(cantidadPorFacturar>producto.getCantidad()) {
				VentanaEmergente.errorEmergente("La cantidad que ha introducido sobrepasa la cantidad en el inventario");
				return;
			 }
			
			
			
			double cantidad = (double)cantidadPorFacturar;
		
			subTotal +=cantidad*producto.getPrecio(); 
			totalItbis +=round(cantidad*(producto.getPrecio()*producto.getTasaItbis()),3);
	
					
			
			
			form.getTxtSubTotal().setText(String.valueOf(subTotal));
			form.getTxtTotalItbis().setText(String.valueOf(totalItbis));
			form.getTxtTotalPagar().setText(String.valueOf(subTotal+totalItbis));

			
			
			model = new DefaultTableModel();
			

			try {
				
		    
		     
		     List<String> columnas = (List) ManipulaBD.getColumnNames("productos_facturados");
				
				for(String col : columnas) {
					if(col.equals("id_factura")  || col.equals("indice")) {
						continue;
					}
					model.addColumn(col);
			
				
				}
			
				ProductoFacturado productoFacturado = new ProductoFacturado (index,producto.getDescripcion(),producto.getPrecio(),
						producto.getTasaItbis(),idArticulo,cantidadPorFacturar);
				
			
			
				
			
				listaFacturado.add(productoFacturado);
				
			
				
				for(ProductoFacturado prod : listaFacturado) {
					
					
					Object [] productos =  {prod.getIndiceFactura(),prod.getPrecio(),prod.getDescripcion(),prod.getTasaItbis(),prod.getIdProducto(),prod.getCantidadFacturada()};
						
					
					model.addRow(productos);	
						
					}
					
					
				
					form.getTblProductos().setModel(model);
				
				
				
			}catch(SQLException ex) {
				
			}
			
			
			
			
			/*
		
			try {
				ManipulaBD.<ProductoFacturado>guardarObjeto(productoFacturado);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			
			try {
				
			  

				List<ProductoFacturado> lista = ManipulaBD.consultarObjeto(ProductoFacturado.class);
				
				
				
				
				
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
			
			
			
			
					
		
		} else if(form.getRadEliminar().isSelected())  // Eliminar prodcutos de la lista de productos facturados y de la tabla
		{
			
		
			   int selectedRow   = form.getTblProductos().getSelectedRow();
			  
			   if(selectedRow==-1) {
				   	VentanaEmergente.errorEmergente("Ninguna Fila seleccionada");
				   	return;
			   }
			   
			
			   ProductoFacturado productoFacturado = listaFacturado.get(selectedRow);

			 
			
			   
			   
				subTotal -=productoFacturado.getCantidadFacturada()*productoFacturado.getPrecio(); 
				totalItbis -=round(productoFacturado.getCantidadFacturada()*(productoFacturado.getPrecio()*productoFacturado.getTasaItbis()),3);
			   
			   
			   form.getTxtSubTotal().setText(String.valueOf(subTotal));
			   form.getTxtTotalItbis().setText(String.valueOf(totalItbis));
			   
			   form.getTxtTotalPagar().setText(String.valueOf(subTotal+totalItbis));
			   
			   listaFacturado.remove(selectedRow);
				 
			   model.removeRow(selectedRow);
				 form.getTblProductos().setModel(model);
			
				 
				 
			}
		
		} else if(botonPulsado==form.getBtnImprimirFactura()) {
			
			if(form.getRadCrearFactura().isSelected()) {
			
			int idCliente = Integer.parseInt((form.getTxtIdCliente().getText()));
	
	        GregorianCalendar calendario = new GregorianCalendar();
			
			String anio = String.valueOf(calendario.get(GregorianCalendar.YEAR));
			String mes  = String.valueOf(calendario.get(GregorianCalendar.MONTH));
			String dia  = String.valueOf(calendario.get(GregorianCalendar.DAY_OF_MONTH));
			
			String hora = String.valueOf(calendario.get(GregorianCalendar.HOUR_OF_DAY));
			String minutos =String.valueOf(calendario.get(GregorianCalendar.MINUTE));
			String segundos = String.valueOf(GregorianCalendar.SECOND);
			
			
			
			String fecha = anio+ "-" +mes +"-" +dia;
			String time = hora + ":" + minutos + ":" + segundos;
			
			
			
			
			try {
			 if (form.getTblProductos().getModel().getRowCount()==0) {
				 VentanaEmergente.errorEmergente("No hay ningun producto facturado");
				 return;
			 }
				
				Factura factura = new Factura(idCliente,fecha,time,totalItbis,subTotal);  
				
	
				for(ProductoFacturado prod :listaFacturado) { // Recorriendo array de productos Facturados
				
					
					Producto producto = ManipulaBD.getObject(prod.getIdProducto(), Producto.class);
			
					
                                        
                                        ManipulaBD.guardarObjeto(factura);  // Guardando factura en la BD
					prod.setIdFactura((getFacturaLastId()));
					
					int nuevaCantidadDisponible = producto.getCantidad()-prod.getCantidadFacturada();  // Actualizando la cantidad del producto en el inventario
					producto.setCantidad(nuevaCantidadDisponible);
					
					ManipulaBD.actualizarObjeto(producto);
					ManipulaBD.guardarObjeto(prod);	
					
					
				}
				
				VentanaEmergente.exito("Factura creada con exito!" );
			
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
			
			
			} if (form.getRadEliminarFactura().isSelected()) {
				
			
				try {
					
					int idFactura= Integer.parseInt(form.getTxtIdFactura().getText());
					
					ManipulaBD.borrarObjeto(idFactura, Factura.class);
				
					List<ProductoFacturado> lista = ManipulaBD.consultarObjeto(ProductoFacturado.class);
					
					for(ProductoFacturado prod : lista) {
						
						if(idFactura==prod.getIdFactura()) {
						ManipulaBD.borrarObjeto(prod.getId(), ProductoFacturado.class);
					
						}
					
					}
					
					VentanaEmergente.exito("Factura eliminada con exito");
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			
			
			} 

			form.vaciarComponentes();
			resetearAcumuladores();
			form.activarComponentes(false);
			form.getTblProductos().setModel(new DefaultTableModel());
		
			
				
				
				
				
			} else if(form.getBtnAtras()==botonPulsado) {
				
				form.vaciarComponentes();
				resetearAcumuladores();
			
				
			}
		
			
			
			}
			
			
		
			
		
		
			 
			
		
		
		
		
			
			// Crear Factura
			

		private static void resetearAcumuladores() {

			int i=0;
			
			for(ProductoFacturado prod: listaFacturado) {
				listaFacturado.remove(i);
				i++;
			}
			
			indexSiguiente=1;
		}
			
		public static LinkedList getListaFacturado() {
		
		return listaFacturado;
		}
		
		
		
		
		private static double round (double value, int precision) {
		    int scale = (int) Math.pow(10, precision);
		    return (double) Math.round(value * scale) / scale;
		}

		
		
		
		
		
	}


