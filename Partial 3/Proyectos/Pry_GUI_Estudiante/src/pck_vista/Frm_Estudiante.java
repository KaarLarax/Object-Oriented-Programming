package pck_vista;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pck_modelo.Estudiante;

public class Frm_Estudiante extends javax.swing.JFrame {

    ArrayList<Estudiante> estudiantes;
    Set<Integer> idValidas;
  
    public Frm_Estudiante() {
        initComponents();
        this.estudiantes = new ArrayList();
        this.idValidas = new HashSet();
        this.setLocationRelativeTo(null);
    }

    public void listar() {
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < estudiantes.size(); i++) {
            modelo.addElement(estudiantes.get(i).getNoCuenta() + " - "
                    + estudiantes.get(i).getNombre() + " - "
                    + estudiantes.get(i).getCarrera() + " - "
                    + estudiantes.get(i).getPromGeneral());
        }
        list_Estudiante.setModel(modelo);

    }

    private void limpiar() {
        ct_Cuenta.setText("");
        ct_Nombre.setText("");
        cmb_Semestre.setSelectedIndex(-1);
        cmb_Grupo.setSelectedIndex(-1);
        cmb_Carrera.setSelectedIndex(-1);
        ct_Promedio.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        list_Estudiante.clearSelection();
        ct_Cuenta.requestFocus();
        ct_Cuenta.setEditable(true);
    }

    private void mostrar(int fila) {
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la lista");
        } else {
            JOptionPane.showMessageDialog(null, estudiantes.get(fila).getDatos());
        }
    }

    private void cargarInformacion(int fila) {
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la fila");
        } else {
            ct_Cuenta.setText(String.valueOf(estudiantes.get(fila).getNoCuenta()));
            ct_Nombre.setText(estudiantes.get(fila).getNombre());
            cmb_Semestre.setSelectedItem(String.valueOf(estudiantes.get(fila).getSemestre()));
            cmb_Grupo.setSelectedItem(String.valueOf(estudiantes.get(fila).getGrupo()));
            cmb_Carrera.setSelectedItem(String.valueOf(estudiantes.get(fila).getCarrera()));
            ct_Promedio.setText(String.valueOf(estudiantes.get(fila).getPromGeneral()));

            if (estudiantes.get(fila).getTurno().equals("Matutino")) {
                rdb_matutino.setSelected(true);
            } else {
                rdb_vespertino.setSelected(true);
            }

            if (estudiantes.get(fila).getStatus().equals("Regular")) {
                rdb_regular.setSelected(true);
            } else {
                rdb_irregular.setSelected(true);
            }
            ct_Cuenta.setEditable(false);
        }
    }

    private void agregar_Actualizar(boolean act, int fila) {
        String nombre, pEducativo = null, turno = null, status = null;
        int sem = 0, gpo = 0, noCuenta = 0;
        float promedio = 0.0f;
        boolean valido = true;

        try {
            noCuenta = Integer.parseInt(ct_Cuenta.getText());
            if (!idValidas.isEmpty() && idValidas.contains(noCuenta) && !act) {
                  JOptionPane.showMessageDialog(null, "El número de cuenta no puede repetirse",
                    "Entrada no válida", 2);
                  valido = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de cuenta debe ser númerico",
                    "Entrada no válida", 2);
            ct_Cuenta.setText("");
            ct_Cuenta.requestFocus();
            valido = false;
        }

        nombre = ct_Nombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es un dato requerido",
                    "Entrada no válida", 2);
            ct_Nombre.requestFocus();
        }
        try {
            sem = Integer.parseInt(cmb_Semestre.getSelectedItem().toString());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "El semestre es un dato requerido",
                    "Entrada no válida", 2);
            valido = false;
        }
        try {
            gpo = Integer.parseInt(cmb_Grupo.getSelectedItem().toString());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "El grupo es un dato requerido",
                    "Entrada no válida", 2);
            valido = false;
        }
           
        try {
             pEducativo = cmb_Carrera.getSelectedItem().toString();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "La carrera es un dato requerido",
                    "Entrada no válida", 2);
            valido = false;
        }

        try {
            promedio = Float.parseFloat(ct_Promedio.getText());
            if (promedio < 0.0f || promedio > 10.0f) {
                JOptionPane.showMessageDialog(null, "El promedio debe de estar en un rango del 0 al 10",
                        "Entrada no válida", 2);
                valido = false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El promedio debe de estar en un rango del 0.0 al 10.0",
                    "Entrada no válida", 2);
            valido = false;
            ct_Promedio.setText("");
            ct_Promedio.requestFocus();
        }

        if (!rdb_matutino.isSelected() && !rdb_vespertino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe selesccionar un turno",
                    "Entrada no válida", 2);
            valido = false;
        } else {
            if (rdb_matutino.isSelected()) {
                turno = "Matutino";
            } else {
                turno = "Vespertino";
            }
        }
        if (!rdb_regular.isSelected() && !rdb_irregular.isSelected()) {
            JOptionPane.showMessageDialog(null, "Debe selesccionar un estatus",
                    "Entrada no válida", 2);
            valido = false;
        } else {
            if (rdb_regular.isSelected()) {
                status = "Regular";
            } else {
                status = "Irregular";
            }
        }
        if (valido && !act) {
            estudiantes.add(new Estudiante(noCuenta, nombre, sem, gpo,
                    pEducativo, turno, promedio, status));
            idValidas.add(noCuenta); 
            this.listar();
            JOptionPane.showMessageDialog(null, "Registro agregado con éxito",
                    "Alta de un estudiante", 1);
        } else if (valido && act) {
            estudiantes.set(fila, new Estudiante(noCuenta, nombre, sem, gpo,
                    pEducativo, turno, promedio, status));
            this.limpiar();
            JOptionPane.showMessageDialog(null, "Registro actualizado con éxito",
                    "Actualizar regristro", 1);
            this.listar();
        }
    }

    private void eliminar(int fila) {
        int resp = JOptionPane.showConfirmDialog(null, estudiantes.get(fila).getDatos()
                + "\n\n¿Estás seguro de eliminar este registro?", "Eliminar registro",
                JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            estudiantes.remove(fila);
            listar();
            limpiar();
            JOptionPane.showMessageDialog(null, "Se ha eliminado el registro",
                    "Eliminar registro", JOptionPane.INFORMATION_MESSAGE);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmb_Semestre = new javax.swing.JComboBox<>();
        cmb_Carrera = new javax.swing.JComboBox<>();
        cmb_Grupo = new javax.swing.JComboBox<>();
        ct_Cuenta = new javax.swing.JTextField();
        ct_Nombre = new javax.swing.JTextField();
        rdb_matutino = new javax.swing.JRadioButton();
        rdb_regular = new javax.swing.JRadioButton();
        rdb_vespertino = new javax.swing.JRadioButton();
        rdb_irregular = new javax.swing.JRadioButton();
        ct_Promedio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_Estudiante = new javax.swing.JList<>();
        btn_Agregar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_Mostrar = new javax.swing.JButton();
        btn_Cerrar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_Editar = new javax.swing.JMenu();
        m_EAdmin = new javax.swing.JMenu();
        m_OpAgregar = new javax.swing.JMenuItem();
        m_OpActualizar = new javax.swing.JMenuItem();
        m_Acciones = new javax.swing.JMenu();
        m_OpEliminar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aministración de Estudiantes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Datos del Estudiante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 204));
        jPanel1.setToolTipText("");

        jLabel1.setText("No. Cuenta");

        jLabel2.setText("Nombre");

        jLabel3.setText("Semestre");

        jLabel4.setText("Grupo");

        jLabel5.setText("ProgramaEducativo");

        jLabel6.setText("PromedioGeneral");

        jLabel7.setText("Turno");

        jLabel8.setText("Estatus");

        cmb_Semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmb_Carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lic. Biologia", "Lic. Ciencias Computacionales", "Lic. Ingeniería Industrial", "Lic. Geología Ambiental", "Lic. Matemáticas", "Lic. Física y Tecnología", "Lic. Electrónica", "Lic. Química", "Lic. Química en Alimentos", "Lic. Turismo", "Lic. Enfermeria", "Lic. Médico Cirujano" }));

        cmb_Grupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        ct_Cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ct_CuentaActionPerformed(evt);
            }
        });

        ct_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ct_NombreActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdb_matutino);
        rdb_matutino.setText("Matutino");

        buttonGroup2.add(rdb_regular);
        rdb_regular.setText("Regular");

        buttonGroup1.add(rdb_vespertino);
        rdb_vespertino.setText("Vespertino");

        buttonGroup2.add(rdb_irregular);
        rdb_irregular.setText("Irregular");

        list_Estudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_EstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_Estudiante);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ct_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdb_matutino)
                                    .addComponent(rdb_regular))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdb_irregular)
                                    .addComponent(rdb_vespertino)))
                            .addComponent(ct_Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ct_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmb_Grupo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_Semestre, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(282, 282, 282)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ct_Cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ct_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmb_Semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(cmb_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmb_Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ct_Promedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdb_matutino)
                            .addComponent(rdb_vespertino))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdb_regular)
                            .addComponent(rdb_irregular)
                            .addComponent(jLabel8))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btn_Agregar.setText("Agregar");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        btn_Mostrar.setText("Mostrar");
        btn_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MostrarActionPerformed(evt);
            }
        });

        btn_Cerrar.setText("Cerrar");
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        m_Editar.setText("Editar");

        m_EAdmin.setText("Administrar");

        m_OpAgregar.setText("Agregar");
        m_OpAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_OpAgregarActionPerformed(evt);
            }
        });
        m_EAdmin.add(m_OpAgregar);

        m_OpActualizar.setText("Actualizar");
        m_OpActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_OpActualizarActionPerformed(evt);
            }
        });
        m_EAdmin.add(m_OpActualizar);

        m_Editar.add(m_EAdmin);

        jMenuBar1.add(m_Editar);

        m_Acciones.setText("Acciones");

        m_OpEliminar.setText("Eliminar");
        m_OpEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_OpEliminarActionPerformed(evt);
            }
        });
        m_Acciones.add(m_OpEliminar);

        jMenuBar1.add(m_Acciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_Agregar)
                        .addGap(34, 34, 34)
                        .addComponent(btn_Limpiar)
                        .addGap(32, 32, 32)
                        .addComponent(btn_Mostrar)
                        .addGap(30, 30, 30)
                        .addComponent(btn_Cerrar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Agregar)
                    .addComponent(btn_Limpiar)
                    .addComponent(btn_Mostrar)
                    .addComponent(btn_Cerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        this.agregar_Actualizar(false, -1);
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.limpiar();
    }//GEN-LAST:event_formWindowOpened

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CerrarActionPerformed

    private void btn_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MostrarActionPerformed
        int fila = list_Estudiante.getSelectedIndex();
        this.mostrar(fila);
    }//GEN-LAST:event_btn_MostrarActionPerformed

    private void m_OpAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_OpAgregarActionPerformed
        this.agregar_Actualizar(false, -1);
    }//GEN-LAST:event_m_OpAgregarActionPerformed

    private void m_OpActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_OpActualizarActionPerformed
        int fila = list_Estudiante.getSelectedIndex();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un registro de la lista",
                    "Actualizar registro", 1);
        } else {
            this.agregar_Actualizar(true, fila);
        }
    }//GEN-LAST:event_m_OpActualizarActionPerformed

    private void m_OpEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_OpEliminarActionPerformed
        int fila = list_Estudiante.getSelectedIndex();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un registro de la lista",
                    "Eliminar registro", 1);
        } else {
            this.eliminar(fila);
        }
    }//GEN-LAST:event_m_OpEliminarActionPerformed

    private void list_EstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_EstudianteMouseClicked
        int fila = list_Estudiante.getSelectedIndex();
        this.cargarInformacion(fila);
    }//GEN-LAST:event_list_EstudianteMouseClicked

    private void ct_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ct_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ct_NombreActionPerformed

    private void ct_CuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ct_CuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ct_CuentaActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Estudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Mostrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmb_Carrera;
    private javax.swing.JComboBox<String> cmb_Grupo;
    private javax.swing.JComboBox<String> cmb_Semestre;
    private javax.swing.JTextField ct_Cuenta;
    private javax.swing.JTextField ct_Nombre;
    private javax.swing.JTextField ct_Promedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_Estudiante;
    private javax.swing.JMenu m_Acciones;
    private javax.swing.JMenu m_EAdmin;
    private javax.swing.JMenu m_Editar;
    private javax.swing.JMenuItem m_OpActualizar;
    private javax.swing.JMenuItem m_OpAgregar;
    private javax.swing.JMenuItem m_OpEliminar;
    private javax.swing.JRadioButton rdb_irregular;
    private javax.swing.JRadioButton rdb_matutino;
    private javax.swing.JRadioButton rdb_regular;
    private javax.swing.JRadioButton rdb_vespertino;
    // End of variables declaration//GEN-END:variables
}
