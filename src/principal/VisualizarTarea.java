package principal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Enumeration;
import java.util.Random;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author Melany Suarez
 */
public class VisualizarTarea  extends javax.swing.JFrame{
    private String id;
    private  String codigo;
     private JLabel titleLabel;
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
    private String rutaImagen;
    String imagenPath;
    
    public VisualizarTarea(String id, String codigo) {
        super("Tarea");
        this.id = id;
        this.codigo = codigo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(824, 558);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo la ventana de ejercicios al presionar el botón Cerrar
        // Agrega aquí los componentes de la ventana de ejercicios, como etiquetas, botones, etc.
        setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(null);

        labelIdentificador = new JLabel();
        labelIdentificador.setBounds(4, 5, 800, 80);
        labelIdentificador.setFont(new Font("Arial", Font.PLAIN, 25));
        labelIdentificador.setBorder(BorderFactory.createLineBorder(new Color(55, 100, 121), 2));
        labelIdentificador.setHorizontalAlignment(SwingConstants.CENTER);  // Centra el texto horizontalmente
        labelIdentificador.setOpaque(true);  // Permite que el fondo sea coloreado
        labelIdentificador.setBackground(new Color(55, 100, 121));  // Establece el fondo en azul
        labelIdentificador.setForeground(Color.WHITE);  // Establece el texto en blanco
        labelIdentificador.setText("Tarea");
       
       
      
      
      //labelURL.setBounds(/izq-der/300, /arr-aba/110, /tama ancho/300, /tama largo/100);

       labelURL = new JLabel();
       labelURL.setBounds(300, 110, 200, 115);
       labelURL.setFont(new Font("Arial", Font.PLAIN, 16));
       labelURL.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
       

       labelPregunta = new JLabel();
       labelPregunta.setBounds(50, 220, 400, 50);
       labelPregunta.setFont(new Font("Arial", Font.PLAIN, 16));


        panel.add(labelIdentificador);
        panel.add(labelURL);
        panel.add(labelPregunta);
 
        verificarButton = new JButton("Verificar");
        verificarButton.setBounds(50, 440, 200, 30);
        verificarButton.setBackground(new Color(55, 100, 121));
        

        verificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta();
            }
        });

        
       
        
        // Leer el contenido del archivo "ejercicios.txt" y obtener los datos del ejercicio seleccionado
        String[] elementos = leerEjercicio("TareasDocente.txt", codigo);
        
        
        // Cargar la imagen desde el archivo
        String imagenPath = elementos[1];
        ImageIcon imagen = new ImageIcon(getClass().getResource("/img/" + imagenPath));
        Image img = imagen.getImage().getScaledInstance(10,10,Image.SCALE_SMOOTH);
        labelURL.setIcon(imagen); 

        
        
        // Crea un nuevo JLabel para mostrar el nombre de la imagen
        JLabel labelNombreImagen = new JLabel("Ver imagen: " + " " + imagenPath);
        labelNombreImagen.setBounds(300, 225, 200, 30);
        labelNombreImagen.setFont(new Font("Arial", Font.PLAIN, 14));
        labelNombreImagen.setForeground(Color.BLUE);
        labelNombreImagen.setCursor(new Cursor(Cursor.HAND_CURSOR));

        labelNombreImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                  
                    URL imageUrl = getClass().getResource("/img/" + imagenPath);
                    if (imageUrl != null) {
                        Desktop.getDesktop().browse(imageUrl.toURI());
                    } else {
                        System.err.println("El recurso no existe: " + imagenPath);
                    }
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });



        panel.add(labelNombreImagen); // Agrega el JLabel con el nombre de la imagen
        
        labelPregunta.setText(elementos[2]);
        labelPregunta.setBounds(50, 250, 600, 30);
        
        
        resp1 = elementos[3];
        resp2 = elementos[4];
        resp3 = elementos[5];
        resp4 = elementos[6];
        
        // Crear botones de opciones para las respuestas
        JRadioButton button1 = new JRadioButton(resp1);
        button1.setBounds(50, 280, 200, 30);
        JRadioButton button2 = new JRadioButton(resp2);
        button2.setBounds(50, 320, 200, 30);
        JRadioButton button3 = new JRadioButton(resp3);
        button3.setBounds(50, 360, 200, 30);
        JRadioButton button4 = new JRadioButton(resp4);
        button4.setBounds(50, 400, 200, 30);

        // Agrupar los botones de respuesta
        buttonGroup = new ButtonGroup();
        buttonGroup.add(button1);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
        buttonGroup.add(button4);

        // Almacenar la respuesta correcta
        respC5 = elementos[7];
        
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(verificarButton);

        getContentPane().add(panel);
    }

    private VisualizarTarea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        
    
    public void cargarImagenUsuario() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("TareasDocente.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosImg = linea.split(";");
                if (datosImg.length >= 2 && datosImg[0].equals(codigo)) {
                    String rutaImagen = datosImg[1];
                    mostrarImagenUsuario(rutaImagen);
                    ImageIcon imagen = new ImageIcon(rutaImagen);
                    labelURL.setIcon(imagen); 

                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String ruta() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("TareasDocente.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosImg = linea.split(";");
                if (datosImg.length >= 2 && datosImg[0].equals(codigo)) {
                    String rutaImagen = datosImg[1];
                    mostrarImagenUsuario(rutaImagen);
                    ImageIcon imagen = new ImageIcon(rutaImagen);
                    labelURL.setIcon(imagen); 

                    break;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }return rutaImagen;
    }
    
     public void mostrarImagenUsuario(String rutaImagen) {
        ImageIcon icono = new ImageIcon(rutaImagen);
        Image img = icono.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
      
        
    }

    
    
    // Método para leer un ejercicio específico del archivo
    private String[] leerEjercicio(String archivo, String codigo) {
        String[] elementos = new String[8];
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            
            while ((linea = br.readLine()) != null) {               
                String[] datos = linea.split(";");
             if(datos[0].equals(codigo)) {
                    for (int i = 0; i < datos.length; i++) {
                       elementos[i] = datos[i]; 
                       
                    }
                }    
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return elementos;
    }

    // Método para verificar la respuesta seleccionada y mostrar un mensaje
    private void verificarRespuesta() {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                if (button.getText().equals(respC5)) {
                    JOptionPane.showMessageDialog(this, "¡Respuesta Correcta!", "Verificación", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Respuesta Incorrecta!", "Verificación", JOptionPane.ERROR_MESSAGE);
                    this.setVisible(false);
                }
                break;
            }
        }
        
        
    }
    
    
    

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                VisualizarTarea frame = new VisualizarTarea();
                frame.setVisible(true);
               
            }
        });
    }
    
     public Icon setIcono(String ulr, int ancho, int alto) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ulr));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }
}