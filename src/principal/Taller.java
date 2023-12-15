package principal;

/**
 *
 * @author allil
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.*;



public class Taller extends JFrame {
    
    private String opcionSeleccionada; // Agrega una variable para almacenar opcionSeleccionada
    private JButton verificarButton;
    private ButtonGroup buttonGroup;
    private String resp1;
    private String resp2;
    private String resp3;
    private String resp4;
    private String respC5;
    private JLabel labelIdentificador;
    private JLabel labelURL;
    private JLabel labelPregunta;
    private int ejercicioActual; // Mover la declaración aquí
    private JPanel panel;
    private JTabbedPane tabbedPane;
    private int respuestasCorrectas = 0;
    private int respuestasIncorrectas = 0;
    private List<String> respuestasUsuario; // Lista para almacenar las respuestas seleccionadas por el usuario




    
    public Taller(String opcionSeleccionada) {
        super("Taller");
        this.opcionSeleccionada = opcionSeleccionada;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 590);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de ejercicios al presionar el botón Cerrar

        tabbedPane = new JTabbedPane();
        getContentPane().add(tabbedPane);

        // Agrega los ejercicios como pestañas
        List<String[]> ejercicios = leerEjercicios("ejercicio.txt", opcionSeleccionada);
        respuestasUsuario = new ArrayList<>(); // Inicializa la lista de respuestas del usuario
        for (String[] ejercicio : ejercicios) {
            agregarPestanaEjercicio(ejercicio);
        }

        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());
    }//Fin método constructor

    // Método para agregar una nueva pestaña con un ejercicio
    private void agregarPestanaEjercicio(String[] elementos) {
        JPanel panelEjercicio = new JPanel();
        panelEjercicio.setLayout(null);
        mostrarEjercicio(elementos, panelEjercicio);

        int numeroEjercicio = tabbedPane.getTabCount() + 1; // obtiene el número de ejercicio
        tabbedPane.addTab("Ejercicio " + numeroEjercicio, panelEjercicio); // usa el número de ejercicio en el título
    }

    // Método para leer todos los ejercicios relacionados con la opción seleccionada
    private List<String[]> leerEjercicios(String archivo, String opcionSeleccionada) {
        List<String[]> ejercicios = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos[0].equals(opcionSeleccionada)) {
                    ejercicios.add(datos);
                }
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ejercicios;
    }

    private void mostrarEjercicio(String[] elementos, JPanel panelEjercicio) {
        labelIdentificador = new JLabel(); 
        labelIdentificador.setText(elementos[0]);
        labelIdentificador.setBounds(4, 5, 800, 80);
        labelIdentificador.setFont(new java.awt.Font("Rockwell", 0, 25)); // NOI18N
        labelIdentificador.setBorder(BorderFactory.createLineBorder(new Color(55, 100, 121), 2));
        labelIdentificador.setHorizontalAlignment(SwingConstants.CENTER);
        labelIdentificador.setOpaque(true);
        labelIdentificador.setBackground(new Color(55, 100, 121));
        labelIdentificador.setForeground(Color.WHITE);

        labelURL = new JLabel(); 
        labelURL.setBounds(300, 110, 200, 115);
        labelURL.setFont(new Font("Rockwell", Font.PLAIN, 16));
        labelURL.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        String imagenPath = elementos[1];
        ImageIcon imagen = new ImageIcon(getClass().getResource("/img/" + imagenPath));
        labelURL.setIcon(imagen);

        labelPregunta = new JLabel(); 
        labelPregunta.setText(elementos[2]);
        labelPregunta.setBounds(50, 220, 400, 50);
        labelPregunta.setFont(new Font("Rockwell", Font.PLAIN, 16));

        resp1 = elementos[3];
        resp2 = elementos[4];
        resp3 = elementos[5];
        resp4 = elementos[6];
        respC5 = elementos[7];

        JRadioButton button1 = new JRadioButton(resp1);
        button1.setBounds(50, 280, 200, 30);
        JRadioButton button2 = new JRadioButton(resp2);
        button2.setBounds(50, 320, 200, 30);
        JRadioButton button3 = new JRadioButton(resp3);
        button3.setBounds(50, 360, 200, 30);
        JRadioButton button4 = new JRadioButton(resp4);
        button4.setBounds(50, 400, 200, 30);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.add(button4);

       

        verificarButton = new JButton("Continuar");
        verificarButton.setBounds(55, 440, 200, 30);
        verificarButton.setBackground(new Color(55, 100, 121));

        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta(buttonGroup);
            }
        });
       
        panelEjercicio.add(labelIdentificador);
        panelEjercicio.add(labelURL);
        panelEjercicio.add(labelPregunta);
        panelEjercicio.add(button1);
        panelEjercicio.add(button2);
        panelEjercicio.add(button3);
        panelEjercicio.add(button4);
        panelEjercicio.add(verificarButton);
    }
    
    private void verificarRespuesta(ButtonGroup buttonGroup) {
        int index = tabbedPane.getSelectedIndex();
        List<String[]> ejercicios = leerEjercicios("ejercicio.txt", opcionSeleccionada);
        String[] elementos = ejercicios.get(index);

        // Verificar si alguna respuesta ha sido seleccionada
        boolean algunaRespuestaSeleccionada = false;
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                algunaRespuestaSeleccionada = true;
                break;
            }
        }

        if (!algunaRespuestaSeleccionada) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una respuesta antes de continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        boolean respuestaCorrecta = false;
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                String respuestaSeleccionadaTexto = button.getText();
                String respuestaCorrectaTexto = elementos[7]; 
                respuestaCorrecta = respuestaSeleccionadaTexto.equals(respuestaCorrectaTexto);
            }
        }

        if (respuestaCorrecta) {
            respuestasCorrectas++;
        } else {
            respuestasIncorrectas++;
        }

        // Guarda la respuesta seleccionada por el usuario
        String respuestaSeleccionada = obtenerRespuestaSeleccionada(buttonGroup);
        respuestasUsuario.add(respuestaSeleccionada);
        cambiarEjercicio();
    }

    private String obtenerRespuestaSeleccionada(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }


    
    private void cambiarEjercicio() {
        if (ejercicioActual < tabbedPane.getTabCount() - 1) {
            int index = tabbedPane.getSelectedIndex();
            JPanel panelEjercicio = (JPanel) tabbedPane.getComponentAt(index);
            ejercicioActual++;
            tabbedPane.setSelectedIndex(ejercicioActual);
        } else {
            mostrarResultados();
        }
    }
    
    private void mostrarResultados() {
        StringBuilder mensajeResultados = new StringBuilder("Resultados del Taller:\n\n");

        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            String[] elementos = leerEjercicios("ejercicio.txt", opcionSeleccionada).get(i);
            String respuestaCorrecta = obtenerRespuestaCorrecta(elementos);

            mensajeResultados.append("Ejercicio ").append(i + 1).append(": ");
            if (respuestasUsuario.get(i).equals(respuestaCorrecta)) {
                mensajeResultados.append("Correcto\n");
            } else {
                mensajeResultados.append("Incorrecto (La respuesta correcta era: ").append(respuestaCorrecta).append(")\n");
            }
        }

        mensajeResultados.append("\nRespuestas correctas: ").append(respuestasCorrectas)
                .append(", Respuestas incorrectas: ").append(respuestasIncorrectas);

        JOptionPane.showMessageDialog(this, mensajeResultados.toString(), "Fin del Taller", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    
    // Método para obtener la respuesta correcta de un ejercicio
    private String obtenerRespuestaCorrecta(String[] elementos) {
        // La respuesta correcta está en la posición 7 del array elementos
        return elementos[7];
    }




    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Taller frame = new Taller("OpcionSeleccionada"); // Reemplaza "OpcionSeleccionada" por la opción deseada
                frame.setVisible(true);
                
                
            }
        });
    }
}
