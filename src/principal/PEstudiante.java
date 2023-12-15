/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package principal;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Melany Suarez
 */
public class PEstudiante extends javax.swing.JFrame {
private String id;
    private String opcionSeleccionada;
    private final Timer timer;
    private final List<String> listaImagenes;
    private int indiceImagenActual;
    private JComboBox<String> listaDesplegable;
    private final String[] mensajes = {
       "El conocimiento es el tesoro más grande que puedes adquirir. "
            + "Invirtiendo en tu educación, estás invirtiendo en tu futuro.",
        "El conocimiento es poder, y tú tienes el poder de aprender y crecer cada día.",
        "Los desafíos académicos son oportunidades disfrazadas. Supéralos y te convertirás en una persona más fuerte y sabia.",
        "No te compares con otros. Tu viaje académico es único y a tu propio ritmo. ¡Concéntrate en superarte a ti mismo!",
        "La educación es el pasaporte hacia el futuro; el mañana pertenece a aquellos que se preparan para él hoy.\" - Malcolm X",
        "Cada día es una oportunidad para aprender algo nuevo y acercarte un paso más a tus metas académicas.",
        "El éxito no es el final, el fracaso no es fatal: lo que cuenta es el coraje de seguir adelante.\" - Winston Churchill",
        "La excelencia no es un acto, es un hábito.\" - Aristóteles",
        "Tus sueños son el combustible que te impulsa a lograr grandes cosas. ¡Sigue soñando y trabajando!",
        "La disciplina es el puente entre metas y logros.",
        "La educación es la llave que abre la puerta a un mundo de posibilidades.",
        "Nunca subestimes el poder de tus sueños y tu capacidad para hacerlos realidad.",
        "La actitud determina la altitud. Mantén una actitud positiva y llegarás lejos.",
        "La educación no es preparación para la vida; la educación es la vida en sí misma.\" - John Dewey",
        "El conocimiento es el recurso más valioso que puedes poseer. Nadie puede quitártelo.",
        
    };
    
    
    private int mensajeActual;
    /**
     * Creates new form PEstudiante
     */
    
  
    public PEstudiante(String id) {
        initComponents();
        this.setResizable(false); // Hace que la ventana no sea redimensionable
        this.setLocationRelativeTo(null);//para que la interfaz aparezca en el centro
        this.setTitle("Ventana Estudiante"); // Establece el título de la ventana
        this.id = id; 
        
        
        Icon iconCS = setIcono("/img/cerrar-sesion.png", 39, 39);
        btn_CS.setIcon(iconCS);
        
       
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
        listaImagenes = cargarImagenesDesdeCarpeta("img");
        
        // Configura un temporizador para cambiar los mensajes cada 6 segundos
        timer = new Timer(5000, (ActionEvent e) -> {
            cambiarMensaje();
        });
        timer.start();
        
        
        
    }

    private PEstudiante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<String> cargarImagenesDesdeCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        String[] archivos = carpeta.list();
        return archivos != null ? new ArrayList<>(Arrays.asList(archivos)) : new ArrayList<>();
    }

    // Método para cambiar la imagen actual
    private void cambiarImagen() {
        if (!listaImagenes.isEmpty()) {
            String nombreImagen = listaImagenes.get(indiceImagenActual);
            ImageIcon icono = new ImageIcon(getClass().getResource("img"));
            

            indiceImagenActual++;
            if (indiceImagenActual >= listaImagenes.size()) {
                indiceImagenActual = 0; // Reinicia al principio cuando alcanza el final de la lista
            }
        }
    }
        
    
     private void cambiarMensaje() {
    jLabel1.setText(StrToHtml(mensajes[mensajeActual]));
    mensajeActual = (mensajeActual + 1) % mensajes.length;
    /* jLabel2.setText(StrToHtml("El propósito es mejorar el aprendizaje de cálculo diferencial en estudiantes universitarios del Politécnico Jaime Isaza Cadavid en 2023 a través de una aplicación interactiva que motive, refuerce la comprensión de conceptos matemáticos y desarrolle habilidades esenciales en matemáticas."));
     // jLabel3.setText(StrToHtml("<html><p>"+"Juan Manuel Cuartas Escobar(Full Stack)." + "<html><p>"
            + "Correo Electrónico: juan_cuartas23231@elpoli.edu.com"  
    ));
    //  jLabel4.setText(StrToHtml("Melany Julieth Suarez Rivera(Full Stack)" + "<html><p>"
            + "Correo Electrónico: melanyjsuarez@gmail.com" ));
    //  jLabel5.setText(StrToHtml("Allison Serna Lopera(Full Stack)" + "<html><p>"
            + "Correo Electrónico: allisonsernalopera@gmail.com" ));*/
    }
    
    public String StrToHtml(String mensajes){
        return "<html><p>" + mensajes + "</p><html>";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPerfil2 = new javax.swing.JButton();
        lblCurso = new javax.swing.JButton();
        lblPractica = new javax.swing.JButton();
        lblCG = new javax.swing.JButton();
        btn_CS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPerfil2.setContentAreaFilled(false);
        lblPerfil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPerfil2ActionPerformed(evt);
            }
        });
        jPanel1.add(lblPerfil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 170, 140));

        lblCurso.setContentAreaFilled(false);
        lblCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCursoActionPerformed(evt);
            }
        });
        jPanel1.add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 160, 140));

        lblPractica.setContentAreaFilled(false);
        lblPractica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPracticaActionPerformed(evt);
            }
        });
        jPanel1.add(lblPractica, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 150, 130));

        lblCG.setContentAreaFilled(false);
        lblCG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCGActionPerformed(evt);
            }
        });
        jPanel1.add(lblCG, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 140, 130));

        btn_CS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CSActionPerformed(evt);
            }
        });
        jPanel1.add(btn_CS, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 50, 50));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 16)); // NOI18N
        jLabel1.setText("Bienvenidos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 420, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PEst.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCursoActionPerformed
        if (existeEstudiante(id)) {
            String codigo = obtenerCurso(id);
            EstudianteCurso frame = new EstudianteCurso(codigo, id);
            frame.setVisible(true);
            dispose();
        } else {
            String codigoCurso =JOptionPane.showInputDialog(this, "Ingrese el código del curso:");

            if (codigoCurso.matches("\\d{4}")) {
                if (existeCurso(codigoCurso)) {
                    registrarEstudiante(codigoCurso, id);
                    actualizarCantidadEstudiantes(codigoCurso);
                    EstudianteCurso frame = new EstudianteCurso(codigoCurso, id);
                    frame.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "El curso no existe.");
                }
            } else {
                JOptionPane.showInputDialog(this, "El código del curso debe ser un número de 4 dígitos.");
            }
        }


    }//GEN-LAST:event_lblCursoActionPerformed

    private void lblCGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCGActionPerformed
        // TODO add your handling code here:
        String[] opciones = {"Seleccione una opción:", "Funciones Lineales", "Límites", "Derivadas", "Inecuaciones Lineales", "Ecuaciones Lineales", "Ecuaciones Cuadráticas"};
        String opcionSeleccionada;
        boolean ventanaAbierta = false; // Mueve la declaración fuera del bucle

        do {
            // Verifica si la ventana ya ha sido abierta
            if (!ventanaAbierta) {
                opcionSeleccionada = (String) JOptionPane.showInputDialog(this,
                        "Selecciona el tema que deseas ver:",
                        "Temas",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opciones,
                        opciones[0]);

                // Verificar si se seleccionó una opción y no es la opción por defecto
                if (opcionSeleccionada != null && !opcionSeleccionada.equals(opciones[0])) {
                    ContenidoG frame = new ContenidoG(id, opcionSeleccionada);
                    frame.setVisible(true);
                    ventanaAbierta = true; // Establece la variable a true después de abrir la ventana
                    dispose();
                } else if (opcionSeleccionada == null) {
                    // Si el usuario presiona "Cancelar" o cierra la ventana emergente, salir del bucle
                    break;
                } else {
                    // Mostrar un mensaje indicando que se debe seleccionar una opción válida
                    JOptionPane.showMessageDialog(this, "Por favor, selecciona un tema válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si la ventana ya ha sido abierta, salir del bucle
                break;
            }
        } while (true);
    }//GEN-LAST:event_lblCGActionPerformed

    private void lblPerfil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPerfil2ActionPerformed
        // TODO add your handling code here:
        Perfil perfil = new Perfil(id);
        perfil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblPerfil2ActionPerformed

    private void lblPracticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPracticaActionPerformed
        // TODO add your handling code here:
        Temario frame = new Temario(id);
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblPracticaActionPerformed

    private void btn_CSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CSActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Sí", "Cancelar"};
        int choice = JOptionPane.showOptionDialog(this, "¿Estás seguro de cerrar sesión?", "Confirmación",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // El índice 0 corresponde a "Sí"
            Login newframe = new Login();
            newframe.setVisible(true);
            this.setVisible(false);
        } else if (choice == 1) { // El índice 1 corresponde a "Cancelar"
            // Realiza las acciones correspondientes si el usuario elige "Cancelar"
        }
    }//GEN-LAST:event_btn_CSActionPerformed

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
            java.util.logging.Logger.getLogger(PEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PEstudiante().setVisible(true);
            }
        });
    }
    
    
     public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
    
    public boolean existeCurso(String courseCode) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("curso.txt"));
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if (datos.length >= 3) {
                String code = datos[0];
              
                    if (courseCode.equals(code)) {
                    br.close();
                    return true; 
                }
            }
        }
        
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    return false;  
    }
    
    public String obtenerCurso(String id) {
        String codigoCurso = "";
        
        try {
            File archivo = new File("curso.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");

                for (int i = 3; i < partes.length; i++) {
                    if (partes[i].equals(id)) {
                        codigoCurso = partes[0];
                        break;
                    }
                }

                if (!codigoCurso.isEmpty()) {
                    break; // Si se encuentra el estudiante, se detiene la búsqueda
                }
            }

            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return codigoCurso;
    
        
    }
    
    private void registrarEstudiante(String courseCode, String id) {
        try {
            File archivo = new File("curso.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            StringBuilder nuevoContenido = new StringBuilder();
            
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                
                if (partes.length >= 3 && partes[0].equals(courseCode)) {
                    // Si el código coincide, agregamos el ID del estudiante
                    linea = linea + ";" + id;
                }
                
                nuevoContenido.append(linea).append("\n");
            }
            
            fr.close();
            
            // Escribir el nuevo contenido de vuelta al archivo
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nuevoContenido.toString());
            bw.close();
            JOptionPane.showMessageDialog(null, "Archivo actualizado correctamente.");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Archivo no pudo ser actualizado.");
        }
    
    }
    
    public boolean existeEstudiante(String id) {
        
        
        try {
           
             BufferedReader br = new BufferedReader(new FileReader("curso.txt"));

            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                
                // Verificar a partir de la posición 3 hasta el final de la línea
                for (int i = 3; i < partes.length; i++) {
                    if (partes[i].equals(id)) {
                        return true;  
                    }
                }
            
            }
            
            br.close();
        } catch (IOException e) {
        }
       
        return false;
    }
    
    private void actualizarCantidadEstudiantes(String codigoCurso) {
        // Nombre del archivo
        try {
            File archivo = new File("curso.txt");
            File archivoTemporal = new File("curso_temp.txt");
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));
            
            String linea;
            boolean modificado = false;
            
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                
                if (partes.length >= 3 && partes[0].equals(codigoCurso)) {
                    // Actualizar la cantidad de estudiantes en la línea correspondiente
                    //partes[2] = String.valueOf(nuevaCantidadEstudiantes);
                    int cantidadEstudiantes = Integer.parseInt(partes[2]);
                    cantidadEstudiantes += 1;
                    partes[2] = String.valueOf(cantidadEstudiantes); 
                    linea = String.join(";", partes);
                    modificado = true;
                }
                
                bw.write(linea + "\n");
            }
            
            br.close();
            bw.close();
            
            // Reemplazar el archivo original con el archivo temporal si se ha modificado alguna línea
            if (modificado) {
                archivo.delete(); // Eliminar el archivo original
                archivoTemporal.renameTo(archivo); // Renombrar el archivo temporal
            } else {
                archivoTemporal.delete(); // Si no se ha modificado, eliminar el archivo temporal
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }

            
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lblCG;
    private javax.swing.JButton lblCurso;
    private javax.swing.JButton lblPerfil2;
    private javax.swing.JButton lblPractica;
    // End of variables declaration//GEN-END:variables
}
