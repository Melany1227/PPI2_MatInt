/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author allil
 */
public class Perfil extends javax.swing.JFrame {
    private String id;
    private boolean mostrarContrasena = false;

    /**
     * Creates new form Perfil
     */
     
    public Perfil(String id) {
        initComponents();
        this.setTitle("Perfil"); // Establece el título de la ventana
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.id = id;  // Asigna el ID del usuario
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        Icon iconVolver = setIcono("/img/devolver.png", 46, 41);
        btn_Volver.setIcon(iconVolver);
        Icon iconMPass = setIcono("/img/MPass.png", 27, 26);
        btn_MPass.setIcon(iconMPass);
        
        Icon iconImg = setIcono("/img/User.jpg", 145, 105);
        lbl_ImgUsuario.setIcon(iconImg);
        
        cargarDatosUsuario();  // Llama al método para cargar los datos del usuario
        revalidate();
        repaint();
    }

    public void cargarDatosUsuario() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[2].equals(id)) {
                    String nom = datos[0];
                    String ap = datos[1];
                    txt_Nombre.setText(nom + " " + ap);
                    txt_Correo.setText(datos[3]);
                    txt_Id.setText(datos[2]);
                    txt_Contra.setText(datos[4]);

                   
                    // Cargar la imagen del usuario
                    cargarImagenUsuario();
                    mostrarOcultarContrasena(); // Add this line to show/hide the password initially
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarImagenUsuario() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("imgUsuario.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                    String[] datosImg = linea.split(";");
                if (datosImg.length == 2 && datosImg[0].equals(id)) {
                    String rutaImagen = datosImg[1];
                    mostrarImagenUsuario(rutaImagen);
                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarImagenUsuario(String rutaImagen) {
        ImageIcon icono = new ImageIcon(rutaImagen);
        Image img = icono.getImage().getScaledInstance(lbl_ImgUsuario.getWidth(), lbl_ImgUsuario.getHeight(), Image.SCALE_SMOOTH);
        lbl_ImgUsuario.setText(null);
        lbl_ImgUsuario.setIcon(new ImageIcon(img));
    }



    private Perfil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_Nombre = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JLabel();
        txt_Id = new javax.swing.JLabel();
        txt_Contra = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_Volver = new javax.swing.JButton();
        btn_MPass = new javax.swing.JButton();
        lbl_ImgUsuario = new javax.swing.JLabel();
        btn_foto = new javax.swing.JButton();
        btn_EditarD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Nombre.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        txt_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txt_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 30));

        txt_Correo.setFont(new java.awt.Font("Rockwell", 0, 15)); // NOI18N
        txt_Correo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txt_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 130, 30));

        txt_Id.setFont(new java.awt.Font("Rockwell", 0, 15)); // NOI18N
        txt_Id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(txt_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 130, 30));

        txt_Contra.setFont(new java.awt.Font("Rockwell", 0, 15)); // NOI18N
        txt_Contra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Contra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ContraMousePressed(evt);
            }
        });
        jPanel3.add(txt_Contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 130, 30));

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MIS DATOS");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 220, -1));

        btn_Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/devolver.png"))); // NOI18N
        btn_Volver.setMaximumSize(new java.awt.Dimension(666, 628));
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 46, 41));

        btn_MPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MPass.png"))); // NOI18N
        btn_MPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MPassActionPerformed(evt);
            }
        });
        jPanel3.add(btn_MPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 30, 26));

        lbl_ImgUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_ImgUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/User.jpg"))); // NOI18N
        lbl_ImgUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel3.add(lbl_ImgUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 147, 106));

        btn_foto.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btn_foto.setText("Actualizar foto");
        btn_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fotoActionPerformed(evt);
            }
        });
        jPanel3.add(btn_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 147, -1));

        btn_EditarD.setBackground(new java.awt.Color(55, 100, 121));
        btn_EditarD.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btn_EditarD.setText("Editar datos");
        btn_EditarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarDActionPerformed(evt);
            }
        });
        jPanel3.add(btn_EditarD, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 360, 510));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoPerfil.jpg"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(360, 510));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 534));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EditarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarDActionPerformed
        EditarDatosDialog editarDialog = new EditarDatosDialog(Perfil.this, id);
        editarDialog.setVisible(true);
        cargarDatosUsuario();
    }//GEN-LAST:event_btn_EditarDActionPerformed

    private void btn_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fotoActionPerformed
        String Ruta = "";
        JFileChooser jFileChooser = new JFileChooser();

        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
        jFileChooser.setFileFilter(filtrado);

        int respuesta = jFileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            Ruta = jFileChooser.getSelectedFile().getPath();

            // Mostrar la imagen en el JLabel
            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbl_ImgUsuario.getWidth(), lbl_ImgUsuario.getHeight(), Image.SCALE_SMOOTH));
            lbl_ImgUsuario.setText(null);
            lbl_ImgUsuario.setIcon(mIcono);

            // Guardar la ruta y la ID en un archivo de texto
            guardarRutaEnArchivo(Ruta, id, "imgUsuario.txt");
        }
    }//GEN-LAST:event_btn_fotoActionPerformed

    private void btn_MPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MPassActionPerformed
        mostrarContrasena = !mostrarContrasena;
        mostrarOcultarContrasena();
    }//GEN-LAST:event_btn_MPassActionPerformed

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        cargarDatosUsuario();

        String correo = txt_Correo.getText();
        String contra = obtenerPasswordUsuarioDesdeArchivo(id); // You need to implement this method
        String tipoUsuario = obtenerTipoUsuario(correo, contra);
        String id = obtenerIdUsuarioDesdeArchivo(correo, contra);
        if (tipoUsuario != null) {
            if (tipoUsuario.equals("Docente")) {
                verificarDocente(correo, contra);
                PDocente frame = new PDocente(id);
                frame.setVisible(true);
                this.setVisible(false);

            }else {
                if (tipoUsuario.equals("Estudiante")) {
                    verificarEstudiante(correo, contra);
                    PEstudiante frame = new PEstudiante(id);
                    frame.setVisible(true);
                    this.setVisible(false);

                }
            }

        }else{
            JOptionPane.showMessageDialog(this, "Inicio de sesión fallido. Verifique sus datos.");
        }
    }//GEN-LAST:event_btn_VolverActionPerformed

    private void txt_ContraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ContraMousePressed
                mostrarOcultarContrasena();
    }//GEN-LAST:event_txt_ContraMousePressed

    private void guardarRutaEnArchivo(String ruta, String id, String nombreArchivo) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, true); // Utiliza el segundo parámetro como true para que se añada al final del archivo
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir la ruta y la ID en el archivo
            bufferedWriter.write(id + ";" + ruta);
            bufferedWriter.newLine(); // Agrega un salto de línea para la próxima entrada

            // Cerrar el BufferedWriter
            bufferedWriter.close();

            System.out.println("Ruta y ID guardadas en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public String obtenerIdUsuarioDesdeArchivo(String correo, String contra) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[3].equals(correo) && datos[4].equals(contra)) {
                    br.close(); // Cierra el archivo
                    return datos[2]; // Retorna el ID del usuario
                }
            }
            br.close(); // Cierra el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retorna null si no se encuentra el usuario
    }
    private String obtenerTipoUsuario(String correo, String contra) {
    try {
        FileReader fr = new FileReader("User.txt");
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 7 && datos[3].equals(correo) && datos[4].equals(contra)) {
                
                br.close();
                return datos[6]; // Retorna el tipo de usuario   
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // Si no se encuentra el usuario, retorna null
    }
    private boolean verificarDocente(String correo, String contra) {
        String tipoUsuario = obtenerTipoUsuario(correo, contra);

        try {
            if (tipoUsuario != null) {
                if (tipoUsuario.equals("Docente")) {
                    FileReader fr = new FileReader("Docente.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split(";");
                        if (datos.length == 6 && datos[3].equals(correo) && datos[4].equals(contra)) {
                            br.close();
                            return true;
                        }
                    }
                    br.close();
                }
            }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        return false;
    }
    private boolean verificarEstudiante(String correo, String contra) {
        String tipoUsuario = obtenerTipoUsuario(correo, contra);
        try {
            if (tipoUsuario != null) {
                if (tipoUsuario.equals("Estudiante")) {
                
                FileReader fr = new FileReader("Estudiante.txt");
                BufferedReader br = new BufferedReader(fr);

                String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split(";");
                        if (datos.length == 6 && datos[3].equals(correo) && datos[4].equals(contra)) {
                            br.close();
                            return true;

                        }
                    }
                br.close();
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Perfil Vframe = new Perfil();
                Vframe.setVisible(true);            }
        });
    }
    public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_EditarD;
    private javax.swing.JButton btn_MPass;
    private javax.swing.JButton btn_Volver;
    private javax.swing.JButton btn_foto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_ImgUsuario;
    private javax.swing.JLabel txt_Contra;
    private javax.swing.JLabel txt_Correo;
    private javax.swing.JLabel txt_Id;
    private javax.swing.JLabel txt_Nombre;
    // End of variables declaration//GEN-END:variables

private void labelcolor(JLabel label){
    label.setBackground(new java.awt.Color(53,162,107));
}

private void resetlabelcolor(JLabel label){
    label.setBackground(new java.awt.Color(54,70,78));

}

    private void mostrarOcultarContrasena() {
        if (mostrarContrasena) {
            // Show the actual password (retrieve from your data)
            String password = obtenerPasswordUsuarioDesdeArchivo(id); // You need to implement this method
            txt_Contra.setText(password);
        } else {
            txt_Contra.setText("****"); 
        }
    }

    private String obtenerPasswordUsuarioDesdeArchivo(String id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[2].equals(id)) {
                    br.close(); // Close the file
                    return datos[4]; // Return the password
                }
            }
            br.close(); // Close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if the user is not found
    }

}
