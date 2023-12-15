package principal;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContenidoG extends JFrame {
    private JLabel titleLabel;
    private int currentIndex = 0;
    private String id;
    private String opcionSeleccionada;
    private JLabel imagenLabel;
    private String[] imagenes;
    private JButton atrasButton; // Declara atrasButton como una variable de instancia

    public ContenidoG(String id, String opcionSeleccionada) {
        this.id = id;
        this.opcionSeleccionada = opcionSeleccionada;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 590);
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/Logo1.png"));
        this.setIconImage(icono.getImage());

        // Panel de encabezado
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(55, 100, 121));
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        headerPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel(opcionSeleccionada); // Cambia el texto del titleLabel
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        titleLabel.setFont(new java.awt.Font("Rockwell", 5, 30)); // NOI18N
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Panel de cuerpo
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.BLACK);
        bodyPanel.setLayout(new BorderLayout());
        add(bodyPanel, BorderLayout.CENTER);

        imagenLabel = new JLabel();
        bodyPanel.add(imagenLabel, BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(new EmptyBorder(0, 20, 20, 0));
        
        JButton devolverButton = new JButton();
        Icon iconDevolver = setIcono("/img/devolver.png", 40, 40);
        devolverButton.setIcon(iconDevolver);
        devolverButton.setPreferredSize(new Dimension(46, 41)); 
        
        devolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PEstudiante principal = new PEstudiante(id);
                principal.setVisible(true);
                dispose();

            }
        });
        
        JButton sigButton = new JButton();
        Icon iconoSiguiente = setIcono("/img/sig.png", 40, 40);
        sigButton.setIcon(iconoSiguiente);
        sigButton.setPreferredSize(new Dimension(46, 41));
        sigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (imagenes != null && currentIndex < imagenes.length - 1) {
                    currentIndex++;
                    mostrarImagen();
                }
            }
        });

        atrasButton = new JButton();
        Icon iconoRegresar = setIcono("/img/atras.png", 40, 40);
        atrasButton.setIcon(iconoRegresar);
        atrasButton.setPreferredSize(new Dimension(46, 41));
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    mostrarImagen();
                }
            }
        });

        

        buttonPanel.add(atrasButton);
        buttonPanel.add(sigButton);
        headerPanel.add(devolverButton, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.SOUTH);

        // Cargar las imágenes desde el archivo al arreglo imagenes
        cargarImagenes();

        // Mostrar la primera imagen al iniciar
        mostrarImagen();

        setLocationRelativeTo(null);
    }

    private void cargarImagenes() {
        String[] contenido = leerContenidoTxt("contenido.txt");
        for (String linea : contenido) {
            String[] partes = linea.split(";");
            if (partes.length >= 2 && partes[0].equals(opcionSeleccionada)) {
                imagenes = partes[1].split(",");
                break;
            }
        }
    }
    

    private void mostrarImagen() {
        if (imagenes != null && currentIndex < imagenes.length) {
            String nombreImagen = imagenes[currentIndex].trim();
            String rutaImagen = "/img/" + nombreImagen; // Agrega la barra diagonal al inicio
            Icon icono = setIcono(rutaImagen, 808, 400);
            if (icono != null) {
                imagenLabel.setIcon(icono);
            } else {
                System.err.println("Error al cargar la imagen: " + rutaImagen);
            }

            // Deshabilita el botón "atras" si estás en la primera imagen
            atrasButton.setEnabled(currentIndex > 0);

            // Verifica si ya no hay más imágenes disponibles
            if (currentIndex == imagenes.length - 1) {
                JOptionPane.showMessageDialog(this, "¡Ya no hay más contenido!", "Fin del contenido", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    private String[] leerContenidoTxt(String rutaArchivo) {
        try {
            Path archivoPath = Paths.get(rutaArchivo);
            List<String> lineas = Files.readAllLines(archivoPath, StandardCharsets.UTF_8);
            return lineas.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ContenidoG frame = new ContenidoG("yourId", "yourOpcionSeleccionada");
                frame.setVisible(true);
            }
        });
    }

    public Icon setIcono(String url, int ancho, int alto) {
        try {
            URL imgUrl = getClass().getResource(url);
            if (imgUrl != null) {
                //System.out.println("Image URL: " + imgUrl);
                ImageIcon icon = new ImageIcon(imgUrl);
                return new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
            } else {
                System.err.println("Image not found: " + url);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

