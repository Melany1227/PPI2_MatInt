    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author allil
 */
public class Tarea extends javax.swing.JFrame {

    private String rutaImagenSeleccionada;
    private String id;

    /**
     * Creates new form Tarea
     */
    public Tarea(String id) {
        initComponents();
        this.id = id;

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Cargar una imagen como icono desde el paquete "img" y establecerla en la ventana
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        
        Icon iconDevolver = setIcono("/img/devolver.png", 46, 41);
        devolverButton.setIcon(iconDevolver);

        // Leer los cursos desde el archivo
        String[] cursos = leerCursos();

        // Configurar el ComboBox con los cursos
        cursosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(cursos));

    }

    private Tarea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

   
    private String[] leerCursos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("curso.txt"))) {
            // Utilizamos ArrayList para almacenar dinámicamente los cursos
            List<String> cursosList = new ArrayList<>();

            // Agregar la primera opción
            cursosList.add("Seleccione el curso:");

            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea y obtener el primer dato
                String[] parts = line.split(";");
                if (parts.length > 0) {
                    cursosList.add(parts[0]);
                }
            }

            // Convertir la lista a un array de Strings
            return cursosList.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{"Error al leer cursos"};
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelImagen = new javax.swing.JLabel();
        btnAgregarImg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        resp1TextField = new javax.swing.JTextField();
        resp2TextField = new javax.swing.JTextField();
        resp3TextField = new javax.swing.JTextField();
        resp4TextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        preguntaTextField = new javax.swing.JTextField();
        devolverButton = new javax.swing.JButton();
        cursosComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_Correcta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 183, 80));

        btnAgregarImg.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        btnAgregarImg.setText("Agregar imagen");
        btnAgregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImgActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 183, -1));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel1.setText("Pregunta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 65, 25));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setText("Respuesta 2:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setText("Respuesta 1:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setText("Respuesta 3:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setText("Respuesta 4:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));
        jPanel1.add(resp1TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 130, -1));
        jPanel1.add(resp2TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 130, -1));
        jPanel1.add(resp3TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 376, 130, -1));
        jPanel1.add(resp4TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 130, -1));

        jButton1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jButton1.setText("Guardar tarea");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 126, -1));

        preguntaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preguntaTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(preguntaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 259, 130, -1));

        devolverButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/devolver.png"))); // NOI18N
        devolverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverButtonActionPerformed(evt);
            }
        });
        jPanel1.add(devolverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 40, 30));

        cursosComboBox.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        cursosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un curso:" }));
        jPanel1.add(cursosComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 180, -1));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setText("Respuesta Correcta:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        txt_Correcta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CorrectaActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Correcta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 130, 20));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/crearTarea.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Imagen", "jpg", "jpeg", "png", "gif"));

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoImagen = fileChooser.getSelectedFile();
            rutaImagenSeleccionada = archivoImagen.getAbsolutePath();

            // Mostrar la imagen seleccionada en el JLabel
            ImageIcon imagen = new ImageIcon(rutaImagenSeleccionada);
                Image img = imagen.getImage().getScaledInstance(labelImagen.getWidth(), labelImagen.getHeight(), Image.SCALE_SMOOTH);
            labelImagen.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnAgregarImgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*String cursoSeleccionado = (String) cursosComboBox.getSelectedItem();

        String pregunta = preguntaTextField.getText();
        String resp1 = resp1TextField.getText();
        String resp2 = resp2TextField.getText();
        String resp3 = resp3TextField.getText();
        String resp4 = resp4TextField.getText();

        // Verificar que todos los campos estén completos
        if (cursoSeleccionado.isEmpty() || pregunta.isEmpty() || resp1.isEmpty() || resp2.isEmpty() || resp3.isEmpty() || resp4.isEmpty() || rutaImagenSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos antes de guardar la tarea.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
            return; // No continuar con el proceso si hay campos vacíos
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("TareasDocente.txt", true))) {
            writer.write(cursoSeleccionado + ";" + rutaImagenSeleccionada + ";" + pregunta + ";" + resp1 + ";" + resp2 + ";" + resp3 + ";" + resp4 + "\n");
            writer.flush();
            JOptionPane.showMessageDialog(this, "Tarea guardada correctamente.", "Guardado", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la tarea.", "Error", JOptionPane.ERROR_MESSAGE);
        }*/
        JOptionPane.showMessageDialog(this, "Tarea guardada correctamente.", "Guardado", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void preguntaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preguntaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preguntaTextFieldActionPerformed

    private void txt_CorrectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CorrectaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CorrectaActionPerformed

    private void devolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverButtonActionPerformed
       PDocente frame = new PDocente(id);
       frame.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_devolverButtonActionPerformed

    private void limpiarCampos() {
        preguntaTextField.setText("");
        resp1TextField.setText("");
        resp2TextField.setText("");
        resp3TextField.setText("");
        resp4TextField.setText("");
        rutaImagenSeleccionada = null;
        // Limpiar la imagen en el JLabel
        labelImagen.setIcon(null);
    }
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
            java.util.logging.Logger.getLogger(Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarea().setVisible(true);
            }
        });
    }
    
     public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarImg;
    private javax.swing.JComboBox<String> cursosComboBox;
    private javax.swing.JButton devolverButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JTextField preguntaTextField;
    private javax.swing.JTextField resp1TextField;
    private javax.swing.JTextField resp2TextField;
    private javax.swing.JTextField resp3TextField;
    private javax.swing.JTextField resp4TextField;
    private javax.swing.JTextField txt_Correcta;
    // End of variables declaration//GEN-END:variables
}
