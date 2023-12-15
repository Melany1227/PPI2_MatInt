package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import java.util.List;

public class CrearTareas extends JFrame {
    private JComboBox<String> cursosComboBox; // ComboBox para los cursos
    private JTextField preguntaTextField;
    private JTextField resp1TextField;
    private JTextField resp2TextField;
    private JTextField resp3TextField;
    private JTextField resp4TextField;
    private JButton guardarButton;
    private JButton btnSeleccionarImagen;
    private JLabel labelImagen;
    private String rutaImagenSeleccionada;

    public CrearTareas(String id) {
        super("Crear tarea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(824, 590);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Leer los cursos desde el archivo
        String[] cursos = leerCursos();

        // Configurar el ComboBox con los cursos
        cursosComboBox = new JComboBox<>(cursos);
        cursosComboBox.setBounds(160, 50, 200, 20);
        panel.add(cursosComboBox);

        JLabel labelPregunta = new JLabel("Pregunta:");
        labelPregunta.setBounds(50, 80, 100, 20);

        preguntaTextField = new JTextField();
        preguntaTextField.setBounds(160, 80, 400, 20);

        JLabel labelRespuestas = new JLabel("Respuestas:");
        labelRespuestas.setBounds(50, 110, 100, 20);

        resp1TextField = new JTextField();
        resp1TextField.setBounds(160, 110, 200, 20);

        resp2TextField = new JTextField();
        resp2TextField.setBounds(160, 140, 200, 20);

        resp3TextField = new JTextField();
        resp3TextField.setBounds(160, 170, 200, 20);

        resp4TextField = new JTextField();
        resp4TextField.setBounds(160, 200, 200, 20);

        // Configuración del JLabel para mostrar la imagen
        labelImagen = new JLabel();
        labelImagen.setBounds(50, 320, 200, 150);
        labelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(labelImagen);

        panel.add(labelPregunta);
        panel.add(preguntaTextField);
        panel.add(labelRespuestas);
        panel.add(resp1TextField);
        panel.add(resp2TextField);
        panel.add(resp3TextField);
        panel.add(resp4TextField);

        guardarButton = new JButton("Guardar Tarea");
        guardarButton.setBounds(50, 240, 150, 30);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarTarea();
            }
        });
        panel.add(guardarButton);

        btnSeleccionarImagen = new JButton("Seleccionar Imagen");
        btnSeleccionarImagen.setBounds(50, 280, 200, 30);
        btnSeleccionarImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarImagen();
            }
        });
        panel.add(btnSeleccionarImagen);

        getContentPane().add(panel);
    }

    private String[] leerCursos() {
    // Lee los cursos desde el archivo cursos.txt y retorna un array de Strings
    try (BufferedReader reader = new BufferedReader(new FileReader("curso.txt"))) {
        // Utilizamos ArrayList para almacenar dinámicamente los cursos
        List<String> cursosList = new ArrayList<>();
        
        

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


    private void seleccionarImagen() {
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
    }

    private void guardarTarea() {
    String cursoSeleccionado = (String) cursosComboBox.getSelectedItem();
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
    }
    }

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
}