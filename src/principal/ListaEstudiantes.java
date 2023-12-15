
package principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Melany Suarez
 */
public class ListaEstudiantes extends JFrame {
    private String id;
    private String courseName;
    private JLabel headerLabel;
    private JLabel courseLabel;
    private JPanel studentsPanel;
    private JButton estudianteButton;

    public ListaEstudiantes(String id, String courseName) {
        this.courseName = courseName;
        this.id = id;
        
        headerLabel = new JLabel("Estudiantes");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        headerLabel.setForeground(Color.BLACK);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerLabel, BorderLayout.NORTH);
        
        setTitle("Lista de Estudiantes");
        setSize(300, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

   

        // Panel para mostrar los botones de estudiantes
        studentsPanel = new JPanel();
        studentsPanel.setLayout(new BoxLayout(studentsPanel, BoxLayout.Y_AXIS));
        studentsPanel.setBackground(Color.BLACK);
        studentsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(studentsPanel), BorderLayout.CENTER);

            //Estudiantes(courseName);
        
        List<String> nombresEstudiantes = Estudiantes(courseName);
        
        

        for (String nombreEstudiante : nombresEstudiantes) {
            JButton estudianteButton = new JButton(nombreEstudiante);
            estudianteButton.setPreferredSize(new Dimension(120, 40));
            estudianteButton.setMargin(new Insets(10, 10, 10, 10));
            estudianteButton.setBackground(new Color(55, 100, 121));
            estudianteButton.setForeground(Color.WHITE);            
            
            
            studentsPanel.add(estudianteButton);
            studentsPanel.revalidate();
            studentsPanel.repaint();
            
            estudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreEstudianteSeleccionado = estudianteButton.getText();
            String idEstudianteSeleccionado = obtenerIdEstudiante(nombreEstudianteSeleccionado);
            
            // Abrir la ventana del perfil del estudiante con el ID correspondiente
            abrirPerfilEstudiante(idEstudianteSeleccionado);
               
            }
        });
            
        }
       
        
    
    }
    
    private void abrirPerfilEstudiante(String idEstudiante) {
    PerfilEst perfilEstudiante = new PerfilEst(id, courseName, idEstudiante);
    perfilEstudiante.setVisible(true);
}
    
    private String obtenerIdEstudiante(String nombreEstudiante) {
    try {
        BufferedReader cursoReader = new BufferedReader(new FileReader("curso.txt"));
        String lineaCurso;
        while ((lineaCurso = cursoReader.readLine()) != null) {
            String[] datosCurso = lineaCurso.split(";");
            for (int i = 3; i < datosCurso.length; i++) {
                String idEstudiante = datosCurso[i];
                String nombreCompleto = NombreCompletoEstudiante(idEstudiante);

                if (nombreCompleto.equals(nombreEstudiante)) {
                    cursoReader.close();
                    return idEstudiante;
                }
            }
        }
        cursoReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // Si no se encuentra el estudiante
}
    

    
     public List<String> Estudiantes(String courseName) {
        List<String> nombresCompletos = new ArrayList<>();
        try {
            BufferedReader cursoReader = new BufferedReader(new FileReader("curso.txt"));
            String lineaCurso;
            while ((lineaCurso = cursoReader.readLine()) != null) {
                String[] datosCurso = lineaCurso.split(";");
                if (datosCurso.length >= 2 && datosCurso[1].equals(courseName)) {
                    for (int i = 3; i < datosCurso.length; i++) {
                        String idEstudiante = datosCurso[i];
                        String nombreCompleto = NombreCompletoEstudiante(idEstudiante);
                        
                        if (!nombreCompleto.isEmpty()) {
                            nombresCompletos.add(nombreCompleto);
                            List<String> nombresEstudiantes = new ArrayList<>();
                            nombresEstudiantes.add(nombreCompleto);
                        }
                        
                    }
                    break;
                }
            }
            cursoReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nombresCompletos;
    }

    
        private String NombreCompletoEstudiante(String idEstudiante) {
        String nombreCompleto = "";

        try {
            BufferedReader estudianteReader = new BufferedReader(new FileReader("Estudiante.txt"));
            String lineaEstudiante;
            while ((lineaEstudiante = estudianteReader.readLine()) != null) {
                String[] datosEstudiante = lineaEstudiante.split(";");
                if (datosEstudiante.length >= 3 && datosEstudiante[2].equals(idEstudiante)) {
                    String nombre = datosEstudiante[0];
                    String apellido = datosEstudiante[1];
                    nombreCompleto = nombre + " " + apellido;

                    break; // Se encontró el ID del estudiante, se detiene la búsqueda
                }
            }
            estudianteReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nombreCompleto;
    }
    


    private ListaEstudiantes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                 new ListaEstudiantes().setVisible(true);
                 
            }
        });
    }
  

   
}




