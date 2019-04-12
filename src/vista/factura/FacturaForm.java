/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.factura;

import controlador.Navegacion;
import controlador.factura.AccionVistaFacturar;
import controlador.factura.AccionFacturar;
import controlador.factura.AccionQueryFactura;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Nizar
 */
public class FacturaForm extends javax.swing.JFrame {

    /**
     * @return the btnAtras
     */
    public javax.swing.JButton getBtnAtras() {
        return btnAtras;
    }

    /**
     * @return the btnDale
     */
  
    
    
    

    public javax.swing.JTextField getTxtCodigoArticulo() {
		return txtCodigoArticulo;
	}

	public javax.swing.JTextField getTxtFechaYhora() {
		return txtFechaYhora;
	}

	public javax.swing.JTextField getTxtIdCliente() {
		return txtIdCliente;
	}

	public javax.swing.JTextField getTxtIdFactura() {
		return txtIdFactura;
	}

	public javax.swing.JTextField getTxtNombreCliente() {
		return txtNombreCliente;
	}

	public javax.swing.JTextField getTxtSubTotal() {
		return txtSubTotal;
	}

	public javax.swing.JTextField getTxtTotalItbis() {
		return txtTotalItbis;
	}

	public javax.swing.JTextField getTxtTotalPagar() {
		return txtTotalPagar;
	}

	
	
	
	/**
     * @return the btnGuardarFactura
     */
    

    public javax.swing.JRadioButton getRadActualizarFactura() {
		return radActualizarFactura;
	}

	public javax.swing.JRadioButton getRadConsultarFactura() {
		return radConsultarFactura;
	}

	public javax.swing.JRadioButton getRadCrearFactura() {
		return radCrearFactura;
	}

	public javax.swing.JRadioButton getRadEliminarFactura() {
		return radEliminarFactura;
	}

	
	
	
	
	
	public javax.swing.JTable getTblProductos() {
		return tblFactura;
	}

	public javax.swing.JRadioButton getRadAgregar() {
		return radAgregar;
	}

	public javax.swing.JRadioButton getRadEliminar() {
		return radEliminar;
	}

	public javax.swing.JSpinner getSpnCantidadAFacturar() {
		return spnCantidadAFacturar;
	}

	
	
	
	public javax.swing.JButton getBtnFacturar() {
		return btnFacturar;
	}

	public javax.swing.JButton getBtnQuery() {
		return btnQuery;
	}

	
	
	
	public javax.swing.JButton getBtnImprimirFactura() {
		return btnImprimirFactura;

	}

	
	public void activarComponentes (boolean activar) 
	{
	
		
		getSpnCantidadAFacturar().setEnabled(activar);
		getRadEliminar().setEnabled(activar);     // Activar o desactivar componentes segun el tipo de operacion en  BD
		getRadAgregar().setEnabled(activar);
		getTxtCodigoArticulo().setEnabled(activar);

		getBtnFacturar().setEnabled(activar);
		getBtnImprimirFactura().setEnabled(activar);
	
	}

	
	
	public void vaciarComponentes() {
		getTxtCodigoArticulo().setText(null);
		getTxtIdFactura().setText(null);
		getTxtNombreCliente().setText(null);
		getTxtFechaYhora().setText(null);
		getSpnCantidadAFacturar().setValue(0);
		getTxtSubTotal().setText(null);
		getTxtTotalItbis().setText(null);
		getTxtTotalPagar().setText(null);
		getTxtIdCliente().setText(null);
	}

    public int[] getSelectedIndex() // Obtener el Id de los elementos correspondientes a la fila de la tabla
    {

		int [] selectedRows = tblFactura.getSelectedRows();

		
		int idSeleccionados[] = new int [selectedRows.length];
		
		
		for(int i = 0 ;i<selectedRows.length;i++) {
			idSeleccionados[i]= (int) tblFactura.getModel().getValueAt(i, 0);
			
		}
			
		return idSeleccionados;
	
	}
	
	
	
	
	
	
	/**
     * Creates new form ImprimirFactura
     */
    public FacturaForm() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btnAtras.addActionListener(new Navegacion(this));
        radCrearFactura.setSelected(true);
        
        buttonGroup1.add(radActualizarFactura);
        buttonGroup1.add(radCrearFactura);
        buttonGroup1.add(radEliminarFactura);
        buttonGroup1.add(radConsultarFactura);
        
        buttonGroup2.add(radAgregar);
        buttonGroup2.add(radEliminar);
        
        btnQuery.addActionListener(new AccionQueryFactura(this));
       
        radEliminar.addActionListener(new AccionVistaFacturar(this));
        radAgregar.addActionListener(new AccionVistaFacturar(this));
        radAgregar.setSelected(true);
        
        radCrearFactura.addActionListener(new AccionVistaFacturar(this));
        radConsultarFactura.addActionListener(new AccionVistaFacturar(this) );
        radEliminarFactura.addActionListener(new AccionVistaFacturar(this) );
        radActualizarFactura.addActionListener(new AccionVistaFacturar(this) );
        
        
        btnFacturar.addActionListener(new AccionFacturar(this));
        btnImprimirFactura.addActionListener(new AccionFacturar(this));
        
        tblFactura.setModel(new DefaultTableModel());
        btnAtras.addActionListener(new AccionFacturar(this));
        
        
        
        
        
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlDatosClientesFactura = new javax.swing.JPanel();
        txtNombreCliente = new javax.swing.JTextField();
        lblNombreCliente = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        lblFechayHora = new javax.swing.JLabel();
        txtFechaYhora = new javax.swing.JTextField();
        lblIdFactura = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        btnQuery = new javax.swing.JButton();
        radCrearFactura = new javax.swing.JRadioButton();
        radConsultarFactura = new javax.swing.JRadioButton();
        radEliminarFactura = new javax.swing.JRadioButton();
        radActualizarFactura = new javax.swing.JRadioButton();
        pnlBotones = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        btnImprimirFactura = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        pnlTable = new javax.swing.JPanel();
        srcTable = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        pnlFacturar = new javax.swing.JPanel();
        pnlComponentesFacturacion = new javax.swing.JPanel();
        lblIntroducirCodigoArticulo = new javax.swing.JLabel();
        txtCodigoArticulo = new javax.swing.JTextField();
        lblCantidadAfacturar = new javax.swing.JLabel();
        spnCantidadAFacturar = new javax.swing.JSpinner();
        btnFacturar = new javax.swing.JButton();
        txtSubTotal = new javax.swing.JTextField();
        txtTotalItbis = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radAgregar = new javax.swing.JRadioButton();
        radEliminar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        txtNombreCliente.setEditable(false);

        lblNombreCliente.setText("Nombre Completo  Cliente");

        lblIdCliente.setText("ID Cliente");

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        lblFechayHora.setText("Fecha y Hora");

        txtFechaYhora.setEditable(false);
        txtFechaYhora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaYhoraActionPerformed(evt);
            }
        });

        lblIdFactura.setText("ID Factura");

        txtIdFactura.setEditable(false);
        txtIdFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdFacturaActionPerformed(evt);
            }
        });

        btnQuery.setText("Dale");

        radCrearFactura.setText("Crear Factura");
        radCrearFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCrearFacturaActionPerformed(evt);
            }
        });

        radConsultarFactura.setText("Consultar Factura");

        radEliminarFactura.setText("Eliminar Factura");

        radActualizarFactura.setText("Actualizar Factura");

        javax.swing.GroupLayout pnlDatosClientesFacturaLayout = new javax.swing.GroupLayout(pnlDatosClientesFactura);
        pnlDatosClientesFactura.setLayout(pnlDatosClientesFacturaLayout);
        pnlDatosClientesFacturaLayout.setHorizontalGroup(
            pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                        .addComponent(lblIdCliente)
                        .addGap(95, 95, 95)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblIdFactura))
                    .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                        .addComponent(lblNombreCliente)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                        .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosClientesFacturaLayout.createSequentialGroup()
                        .addComponent(txtFechaYhora, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radConsultarFactura)
                    .addComponent(radCrearFactura))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radEliminarFactura)
                    .addComponent(radActualizarFactura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosClientesFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        pnlDatosClientesFacturaLayout.setVerticalGroup(
            pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreCliente)
                    .addComponent(lblFechayHora)
                    .addComponent(txtFechaYhora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radConsultarFactura)
                    .addComponent(radEliminarFactura))
                .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdCliente)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdFactura)
                            .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosClientesFacturaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlDatosClientesFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radActualizarFactura)
                            .addComponent(radCrearFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnQuery)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlDatosClientesFactura, java.awt.BorderLayout.PAGE_START);

        btnAtras.setText("Atras");
        pnlBotones.add(btnAtras);

        btnImprimirFactura.setText("Imprimir Factura");
        btnImprimirFactura.setEnabled(false);
        pnlBotones.add(btnImprimirFactura);

        pnlPrincipal.add(pnlBotones, java.awt.BorderLayout.PAGE_END);

        pnlCenter.setLayout(new java.awt.GridLayout(2, 1));

        pnlTable.setLayout(new java.awt.BorderLayout());

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        srcTable.setViewportView(tblFactura);

        pnlTable.add(srcTable, java.awt.BorderLayout.CENTER);

        pnlCenter.add(pnlTable);

        pnlFacturar.setLayout(new java.awt.GridLayout(1, 1));

        lblIntroducirCodigoArticulo.setText("Introducir codigo articulo");

        txtCodigoArticulo.setAutoscrolls(false);
        txtCodigoArticulo.setEnabled(false);
        txtCodigoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoArticuloActionPerformed(evt);
            }
        });

        lblCantidadAfacturar.setText("Cantidad a facturar");

        spnCantidadAFacturar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        spnCantidadAFacturar.setEnabled(false);

        btnFacturar.setText("Dale");
        btnFacturar.setEnabled(false);

        txtSubTotal.setEditable(false);

        txtTotalItbis.setEditable(false);
        txtTotalItbis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalItbisActionPerformed(evt);
            }
        });

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtTotalPagar.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("SUB TOTAL:");

        jLabel2.setText("TOTAL ITBIS");

        jLabel3.setText("TOTAL A PAGAR :");

        radAgregar.setText("Agregar");
        radAgregar.setEnabled(false);

        radEliminar.setText("Eliminar");
        radEliminar.setEnabled(false);

        javax.swing.GroupLayout pnlComponentesFacturacionLayout = new javax.swing.GroupLayout(pnlComponentesFacturacion);
        pnlComponentesFacturacion.setLayout(pnlComponentesFacturacionLayout);
        pnlComponentesFacturacionLayout.setHorizontalGroup(
            pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlComponentesFacturacionLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblCantidadAfacturar)
                        .addGap(32, 32, 32)
                        .addComponent(spnCantidadAFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lblIntroducirCodigoArticulo)
                        .addGap(18, 18, 18)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(28, 28, 28)))
                .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radAgregar)
                            .addComponent(radEliminar))
                        .addGap(70, 70, 70)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalItbis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        pnlComponentesFacturacionLayout.setVerticalGroup(
            pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(radAgregar)
                        .addGap(27, 27, 27)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIntroducirCodigoArticulo)
                            .addComponent(txtCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radEliminar))
                        .addGap(33, 33, 33)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFacturar)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlComponentesFacturacionLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantidadAfacturar)
                            .addComponent(jLabel1)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnCantidadAFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlComponentesFacturacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalItbis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pnlFacturar.add(pnlComponentesFacturacion);

        pnlCenter.add(pnlFacturar);

        pnlPrincipal.add(pnlCenter, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaYhoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaYhoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaYhoraActionPerformed

    private void txtIdFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdFacturaActionPerformed

    private void txtCodigoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoArticuloActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtTotalItbisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalItbisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalItbisActionPerformed

    private void radCrearFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCrearFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radCrearFacturaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FacturaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnImprimirFactura;
    private javax.swing.JButton btnQuery;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCantidadAfacturar;
    private javax.swing.JLabel lblFechayHora;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblIdFactura;
    private javax.swing.JLabel lblIntroducirCodigoArticulo;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlComponentesFacturacion;
    private javax.swing.JPanel pnlDatosClientesFactura;
    private javax.swing.JPanel pnlFacturar;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JRadioButton radActualizarFactura;
    private javax.swing.JRadioButton radAgregar;
    private javax.swing.JRadioButton radConsultarFactura;
    private javax.swing.JRadioButton radCrearFactura;
    private javax.swing.JRadioButton radEliminar;
    private javax.swing.JRadioButton radEliminarFactura;
    private javax.swing.JSpinner spnCantidadAFacturar;
    private javax.swing.JScrollPane srcTable;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtCodigoArticulo;
    private javax.swing.JTextField txtFechaYhora;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalItbis;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
}
