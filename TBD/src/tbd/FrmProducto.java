/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbd;

import datos.DAOCategoria;
import datos.DAOProveedor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import modelos.Categoria;
import modelos.Producto;
import modelos.Proveedor;
import datos.DAOProducto;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author paveg
 */
public class FrmProducto extends javax.swing.JFrame {

    private FrmListaProductos frmLista;
    private int idProducto;
    /**
     * Creates new form FrmProducto
     */
    public FrmProducto(FrmListaProductos frmLista) {
        initComponents();
        this.frmLista=frmLista;
        try {
            ArrayList<Categoria> categorias=new DAOCategoria().consultarTodos();
            ArrayList<Proveedor> proveedores=new DAOProveedor().consultarTodos();
            
            DefaultComboBoxModel modeloCat=
                    (DefaultComboBoxModel) cboCategoria.getModel();
            for (Categoria categoria : categorias) {
                   modeloCat.addElement(categoria);
            }
            
            DefaultComboBoxModel modeloProv=
                    (DefaultComboBoxModel) cboProveedor.getModel();
            for (Proveedor proveedor: proveedores) {
                    modeloProv.addElement(proveedor);
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }
    
    public FrmProducto(FrmListaProductos frmLista, int idProducto) {
//        initComponents();
//        this.frmLista=frmLista;
        this(frmLista);
        try {
            this.idProducto=idProducto;
            DecimalFormat formato=new DecimalFormat("0.00");
            Producto objProducto=new DAOProducto().consultarUno(idProducto);
            if(objProducto!=null){
                txtNombre.setText(objProducto.getNombre());
                txtCantidadXUnidad.setText(objProducto.getCantidadXUnidad());
                txtPrecio.setText( formato.format(objProducto.getPrecio()));
                txtExistencia.setText(objProducto.getExistencia()+"");
                txtNivelReorden.setText(objProducto.getNivelReorden()+"");
                txtUnidadesOrden.setText(objProducto.getUnidadesEnOrden()+"");
                rbtSi.setSelected(objProducto.getDescontinuado()==1);
                rbtNo.setSelected(objProducto.getDescontinuado()==0);
                Categoria c=new Categoria();
                c.setIdCategoria(objProducto.getIdCategoria());
                cboCategoria.setSelectedItem(c);
                Proveedor p=new Proveedor();
                p.setIdProveedor(objProducto.getIdProveedor());
                cboProveedor.setSelectedItem(p);
            }else{
                JOptionPane.showMessageDialog(this,"El producto solicitado no existe");
                this.setVisible(false);
                frmLista.actualizarTabla();
                frmLista.setVisible(true);
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDescontinuado = new javax.swing.ButtonGroup();
        cboCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadXUnidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        cboProveedor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUnidadesOrden = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNivelReorden = new javax.swing.JTextField();
        rbtSi = new javax.swing.JRadioButton();
        rbtNo = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Cantidad por unidad");

        jLabel3.setText("Precio");

        jLabel4.setText("Categoría");

        jLabel5.setText("Proveedor");

        jLabel6.setText("Existencia");

        jLabel7.setText("Unidades en orden");

        jLabel8.setText("Nivel de reorden");

        grupoDescontinuado.add(rbtSi);
        rbtSi.setText("Si");

        grupoDescontinuado.add(rbtNo);
        rbtNo.setSelected(true);
        rbtNo.setText("No");

        jLabel9.setText("Descontinuado");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadXUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUnidadesOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbtSi)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtNo))
                                    .addComponent(txtNivelReorden, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidadXUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUnidadesOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNivelReorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtSi)
                    .addComponent(rbtNo)
                    .addComponent(jLabel9))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Validar los datos
        
        
        //Llenar producto
        //Llenar un producto con todos los datos de la interfaz gráfica
            Proveedor objProveedor=(Proveedor) cboProveedor.getSelectedItem();
            Categoria objCategoria=(Categoria) cboCategoria.getSelectedItem();

            Producto objProducto=new Producto(0,
                    txtNombre.getText().trim(),
                    objProveedor.getIdProveedor(),
                    objCategoria.getIdCategoria(),
                    txtCantidadXUnidad.getText().trim(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtExistencia.getText()),
                    Integer.parseInt(txtNivelReorden.getText()),
                    Integer.parseInt(txtUnidadesOrden.getText()),
                    (rbtSi.isSelected())?1:0
            );
        //Verificar si voy a agregar
        if(idProducto==0){
            try {
                int idGenerado=new DAOProducto().agregar(objProducto);
                if(idGenerado>0){
                    JOptionPane.showMessageDialog(this, "El producto se ha añadido existosamente");
                    frmLista.actualizarTabla();
                    frmLista.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al tratar de almacenar el producto");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }else{
            objProducto.setId(idProducto);
            try {
                
                if(new DAOProducto().editar(objProducto)){
                    JOptionPane.showMessageDialog(this, "El producto se ha editado existosamente");
                    frmLista.actualizarTabla();
                    frmLista.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Error al tratar de almacenar el producto");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboProveedor;
    private javax.swing.ButtonGroup grupoDescontinuado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbtNo;
    private javax.swing.JRadioButton rbtSi;
    private javax.swing.JTextField txtCantidadXUnidad;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtNivelReorden;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtUnidadesOrden;
    // End of variables declaration//GEN-END:variables
}
