package principal;

import principal.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.Docente;
import principal.Estudiante;
import principal.Cursos;


/**
 *
 * @author Melany Suarez
 */
public class Metodos {

    private String nombre;
    private String apellido;
    private String correo;
    private String contra;
    private String contra2;
    private String tUser;
    private String id;
   
    //Método Constructor
    public Metodos(String nombre, String apellido, String correo, String contra, String contra2, String tUser, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contra = contra;
        this.contra2 = contra2;
        this.tUser = tUser;
        this.id = id;
    }
   
   
    Vector vPrincipal = new Vector();

 
   
    public void guardar(User unUser){
        vPrincipal.addElement(unUser);
    }

     public boolean existeUsuario(String nombre, String apellido, String id) {
    try {
        BufferedReader br = new BufferedReader(new FileReader("User.txt"));
        String line;
       
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if (datos.length >= 3) {
                String Nombre = datos[0];
                String Apellido = datos[1];
                String ID = datos[2];
               
                // Comprueba si el nombre, apellido y ID coinciden
                if (nombre.equals(Nombre) && apellido.equals(Apellido) && id.equals(ID)) {
                    br.close();
                    return true; // El usuario ya existe en el archivo
                }
            }
        }
       
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
   
    return false; // El usuario no existe en el archivo
    }
   
    public void guardarArchivo(User user){
        try{
            FileWriter fw = new FileWriter("User.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(user.getNombre() + ";");
            pw.print(user.getApellido() + ";");
            pw.print(user.getId() + ";");
            pw.print(user.getCorreo() + ";");
            pw.print(user.getContra() + ";");
            pw.print(user.getContra2() + ";");
            pw.print(user.gettUser() + "\n");
            pw.close();
           
                   
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Obtener id
    private String obtenerId(String correo, String contra) {
    try {
        FileReader fr = new FileReader("User.txt");
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 7 && datos[3].equals(correo) && datos[4].equals(contra)) {
                br.close();
                String id = datos[2];
                return id; // Retorna el id del usuario  
            }
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null; // Si no se encuentra el usuario, retorna null
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
   
    public void guardarDocente(User user, String correo, String contra) {
       String tipoUsuario = obtenerTipoUsuario(correo, contra);

        try {
                if (tipoUsuario.equals("Docente")) {
                    FileWriter fw = new FileWriter("Docente.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.print(user.getNombre() + ";");
                    pw.print(user.getApellido() + ";");
                    pw.print(user.getId() + ";");
                    pw.print(user.getCorreo() + ";");
                    pw.print(user.getContra() + ";");
                    pw.print(user.getContra2() + "\n");
                    pw.close();
                }
             
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
    public void guardarEstudiante(User user, String correo, String contra) {
       String tipoUsuario = obtenerTipoUsuario(correo, contra);

        try {
                if (tipoUsuario.equals("Estudiante")) {
                    FileWriter fw = new FileWriter("Estudiante.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    pw.print(user.getNombre() + ";");
                    pw.print(user.getApellido() + ";");
                    pw.print(user.getId() + ";");
                    pw.print(user.getCorreo() + ";");
                    pw.print(user.getContra() + ";");
                    pw.print(user.getContra2() + "\n");
                    pw.close();
                }
             
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
                                JOptionPane.showMessageDialog(null, "Bienvenido(a), docente " + datos[0]);
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
                               JOptionPane.showMessageDialog(null, "Bienvenido(a), estudiante " + datos[0]);
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

   
    public static void main(String[] args) {
        System.out.println("Contenido del archivo estudiante.txt:");
        leerArchivoEstudiantes("estudiante.txt");

        System.out.println("\nContenido del archivo docente.txt:");
        leerArchivoDocentes("docente.txt");
    }
   
    public static List<Curso> leerArchivoCursos(String nombreArchivo) {
    List<Curso> cursos = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] datos = line.split(";");
            if (datos.length >= 3) {
                String codigo = datos[0];
                int cantidadEstudiantes = Integer.parseInt(datos[2]);
                String nombre = datos[1];
                Curso curso = new Curso(codigo, nombre, cantidadEstudiantes);
                cursos.add(curso);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return cursos;
    }


    public static void leerArchivoEstudiantes(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                if (datos.length >= 6) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String correoElectronico = datos[2];
                    String contrasena = datos[3];
                    String confirmacion = datos[4];
                    String documento = datos[5];
                    // Crear un objeto Estudiante con estos datos y hacer algo con él
                    Estudiante estudiante = new Estudiante(nombre, apellido, correoElectronico, contrasena, confirmacion, documento);
                    // Puedes almacenar este estudiante en una lista de estudiantes o hacer algo más con él
                    System.out.println("Estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerArchivoDocentes(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                if (datos.length >= 6) {
                    String nombre = datos[0];
                    String apellido = datos[1];
                    String correoElectronico = datos[2];
                    String contrasena = datos[3];
                    String confirmacion = datos[4];
                    String documento = datos[5];
                    // Crear un objeto Docente con estos datos y hacer algo con él
                    Docente docente = new Docente(nombre, apellido, correoElectronico, contrasena, confirmacion, documento);
                    // Puedes almacenar este docente en una lista de docentes o hacer algo más con él
                    System.out.println("Estudiante: " + docente.getNombre() + " " + docente.getApellido());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public static void imprimirContenidoArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean existeUsuarioPorCorreo(String correo) {
        try {
            FileReader fr = new FileReader("User.txt");
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 7 && datos[3].equals(correo)) {
                    br.close();
                    return true; // Ya existe un usuario con ese correo
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // No existe un usuario con ese correo
    }


}