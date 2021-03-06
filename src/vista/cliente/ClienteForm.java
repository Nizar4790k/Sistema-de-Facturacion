/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.cliente;

import controlador.Navegacion;
import controlador.cliente.AccionCliente;
import controlador.cliente.AccionConsultaAutomaticaCliente;
import controlador.cliente.AccionVistaCliente;
import controlador.cliente.EventoDeMouseCliente;
import modelo.ManipulaBD;
import modelo.objetos.Cliente;

import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nizar4790k
 */
public class ClienteForm extends javax.swing.JFrame {

    /**
     * Creates new form ClienteForm
     */
    public ClienteForm() {
        initComponents();

        btnDale.addActionListener(new AccionCliente(this));
        btnAtras.addActionListener(new Navegacion(this) );      // Poniendo botones a la escucha de los eventos
        radConsultar.addActionListener(new AccionVistaCliente(this));
        radEliminar.addActionListener(new AccionVistaCliente(this));
        radCrear.addActionListener(new AccionVistaCliente(this));
        radActualizar.addActionListener(new AccionVistaCliente(this));
        jTable1.addMouseListener(new EventoDeMouseCliente(this));
        
       
        addWindowListener(new AccionCliente(this));
       
        buttonGroup1.add(radActualizar);
        buttonGroup1.add(radConsultar);
        buttonGroup1.add(radCrear);
        buttonGroup1.add(radEliminar);
       
        radCrear.setSelected(true);
        
        jTable1.getTableHeader().setReorderingAllowed(false);   // Para impedir que el usuario reordene las tablas
        
        radEliminar.addActionListener(new AccionConsultaAutomaticaCliente(this));
        radActualizar.addActionListener(new AccionConsultaAutomaticaCliente(this));
        radConsultar.addActionListener(new AccionConsultaAutomaticaCliente(this));
        radCrear.addActionListener(new AccionConsultaAutomaticaCliente(this));
    }

    public javax.swing.JButton getBtnDale() {
		return btnDale;
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlCampos = new javax.swing.JPanel();
        pnlNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        radActualizar = new javax.swing.JRadioButton();
        radCrear = new javax.swing.JRadioButton();
        radEliminar = new javax.swing.JRadioButton();
        btnDale = new javax.swing.JButton();
        radConsultar = new javax.swing.JRadioButton();
        scrTabla = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlTitulo.setBackground(new java.awt.Color(37, 226, 240));

        jLabel1.setBackground(new java.awt.Color(255, 254, 254));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(253, 9, 6));
        jLabel1.setText("Cliente");
        pnlTitulo.add(jLabel1);

        pnlNombre.setText("Nombre");

        lblApellidos.setText("Apellidos");

        lblTelefono.setText("Telefono");

        lblCorreo.setText("Correo");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        radActualizar.setText("Actualizar");

        radCrear.setText("Crear ");

        radEliminar.setText("Eliminar");

        btnDale.setText("Dale");

        radConsultar.setText("Consulta simple");

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlNombre)
                    .addComponent(lblApellidos))
                .addGap(43, 43, 43)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(txtApellidos))
                .addGap(35, 35, 35)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono)
                    .addComponent(lblCorreo))
                .addGap(30, 30, 30)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(txtTelefono))
                .addGap(38, 38, 38)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(radCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(71, 71, 71))
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(radActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(radEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDale, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addComponent(radConsultar)
                        .addGap(93, 93, 93))))
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pnlNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radCrear, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDale)))))
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellidos)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCorreo)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(radActualizar)
                        .addComponent(radConsultar)))
                .addContainerGap())
        );

        scrTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrTabla.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrTabla.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAtras.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrTabla)
            .addComponent(pnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addGap(368, 368, 368))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JTable getjTable1() {
		return jTable1;
	}

	public void setjTable1(javax.swing.JTable jTable1) {
		this.jTable1 = jTable1;
	}

	public javax.swing.JRadioButton getRadConsultar() {
		return radConsultar;
	}

	public void setRadConsultar(javax.swing.JRadioButton radConsultar) {
		this.radConsultar = radConsultar;
	}

	private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    /**
     * @param args the command line arguments
     */
   
    

    
    
    public javax.swing.JRadioButton getRadActualizar() {
		return radActualizar;
	}

	public void setRadActualizar(javax.swing.JRadioButton radActualizar) {
		this.radActualizar = radActualizar;
	}

	public javax.swing.JRadioButton getRadCrear() {
		return radCrear;
	}

	public void setRadCrear(javax.swing.JRadioButton radCrear) {
		this.radCrear = radCrear;
	}

	public javax.swing.JRadioButton getRadEliminar() {
		return radEliminar;
	}

	public void setRadEliminar(javax.swing.JRadioButton radEliminar) {
		this.radEliminar = radEliminar;
	}

	public javax.swing.JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(javax.swing.JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public javax.swing.JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(javax.swing.JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public javax.swing.JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(javax.swing.JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public javax.swing.JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(javax.swing.JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnDale;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JLabel pnlNombre;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JRadioButton radActualizar;
    private javax.swing.JRadioButton radConsultar;
    private javax.swing.JRadioButton radCrear;
    private javax.swing.JRadioButton radEliminar;
    private javax.swing.JScrollPane scrTabla;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables


    public int[] getSelectedId() // Obtener el Id de los elementos correspondientes a la fila de la tabla
    {

		int [] selectedRows = getjTable1().getSelectedRows();

		
		int idSeleccionados[] = new int [selectedRows.length];
		
		
		for(int i = 0 ;i<selectedRows.length;i++) {
			idSeleccionados[i]= (int) getjTable1().getModel().getValueAt(i, 0);
			
		}
			
		return idSeleccionados;
	
	}
    
    public void txtActivacion(boolean activacion) // Metodo creado para activar o desactivar los campos de textos  simultaneamente.
    {
    	getTxtNombre().setEnabled(activacion);   
		getTxtApellidos().setEnabled(activacion);
		getTxtCorreo().setEnabled(activacion);
		getTxtTelefono().setEnabled(activacion);    
    
    }
    
    public void vaciarTxt() {
    	getTxtNombre().setText(null);
		getTxtApellidos().setText(null);
		getTxtTelefono().setText(null);
		getTxtCorreo().setText(null);
    }
    
    public void exito(String mensaje) { // Ventana de emergente de error
    	
    	 JOptionPane.showMessageDialog(null, mensaje, "Enhorabuena!", JOptionPane.OK_OPTION, new ImageIcon("C:\\Users\\Nizar\\Dropbox\\Eclipse\\Sistema de Facturacion\\src\\vista\\cliente\\Imagenes\\checkIcon.png"));
    }
    
    public void errorEmergente(String mensaje) { // Ventana emergente de error
    	JOptionPane.showMessageDialog(null , mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    
    public boolean camposTextoVacios() 
    
    {
    		
    		boolean txtNombreisNull = txtNombre.getText().equals("");
    		boolean txtApellidoisNull = txtApellidos.getText().equals("");
    		boolean txtCorreoisNull = txtCorreo.getText().equals("");
    		boolean txtTelefonoisNull = txtTelefono.getText().equals("");
    		
    		boolean areNull = txtNombreisNull || txtApellidoisNull ||  txtTelefonoisNull || txtCorreoisNull;
    		
    		if(areNull) {
    		
    		errorEmergente("Asegurese de que no haya campos vacios");
    	
    	
    	}
    		
    		return areNull;
    	
    	
    	
    }

	public void rellenarCamposTexto() {
		// TODO Auto-generated method stub

    	int row = getjTable1().getSelectedRow();
		int id = (int) getjTable1().getModel().getValueAt(row, 0);
		
		Cliente cliente = ManipulaBD.getObject(id, Cliente.class);
		
		getTxtNombre().setText(cliente.getNombre());
		getTxtApellidos().setText(cliente.getApellido());
		getTxtTelefono().setText(cliente.getTelefono());
		getTxtCorreo().setText(cliente.getCorreo());
	}


	public void rellenarTablaConsulta() 
	{  // rellenar la tabla
		try 
		{
		List<Cliente> lista = 	ManipulaBD.<Cliente>consultarObjeto(Cliente.class);
	
		//String[] columnas = Connection3.getColumnNames(Cliente.class);
		
		DefaultTableModel tblModel = new DefaultTableModel();
		List<String> columnas = (List) ManipulaBD.getColumnNames("cliente");
		
		for(String col : columnas) 
		{
		tblModel.addColumn(col);
		}
	
		
		for(Cliente e : lista) 
		{
			Object obj [] = {e.getId(),e.getNombre(),e.getApellido(),e.getCorreo(),e.getTelefono()};
			
			tblModel.addRow(obj);
		}
		
	getjTable1().setModel(tblModel);
		
		
		
		
			
		} 
		
		catch (SQLException e) 
		{
	
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	}
}
