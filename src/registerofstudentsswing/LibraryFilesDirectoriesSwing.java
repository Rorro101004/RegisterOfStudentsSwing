/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registerofstudentsswing;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import static registerofstudentsswing.RegisterOfStudentsSwing.interfaz;

/**
 *
 * @author roroc
 */
public class LibraryFilesDirectoriesSwing {

    public static ArrayList<StudentS> students = new ArrayList<>();
    public static File register;

    /**
     * Makes the register, if it´s not created yet
     *
     * @return
     */
    public static File makeRegister() {
        String proyectDirection = System.getProperty("user.dir");
        String separator = File.separator;
        String fileDirection = proyectDirection + separator + "registroSwing.txt";
        register = new File(fileDirection);
        try {
            if (!register.exists()) {
                register.createNewFile();
            }

            //initStudentsArray(register);
        } catch (IOException ex) {
            System.err.println("No se puede crear el archivo");
        }
        return register;
    }

    /**
     * Read the lines of the students in the register, show the read if you want
     * to show them, or just hold it all on a variable
     *
     * @param showInfo
     * @return
     */
    public static ArrayList<String> readRegisterStudents(boolean showInfo) {

        ArrayList<String> studentsStr = new ArrayList<>();
        try {
            FileReader fr = new FileReader(register);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                studentsStr.add(linea);
                if (showInfo) {
                    System.out.println(linea);
                    System.out.println("");
                }
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el archivo");
        } catch (IOException ex) {
            System.err.println("No se pueden ingresar o salir los datos");
        }
        return studentsStr;
//
    }

    /**
     * Init the students, it means reading the students of the register, which
     * was previusly stored on a array of strings, and init them on an array of
     * students
     *
     * @param registerOfStudents
     */
    public static void initStudents(ArrayList<String> registerOfStudents) {

        for (int i = 0; i < registerOfStudents.size(); i++) {
            String[] parts = registerOfStudents.get(i).split(",");
            StudentS s = new StudentS(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
            students.add(s);
//            for (int j = 0; j < parts.length; j++) {
//                System.out.println(parts[j]);
//            }
        }
    }

    /**
     * Ask for parameters to create a student, create the student and then
     * stored them on an array of students
     *
     * @param register
     */
    public static void writeStudent(File register) {
        Scanner escaner = new Scanner(System.in);
        System.out.println("Give me the name");
        String nombre = escaner.nextLine();
        System.out.println("Give me the surname");
        String apellido = escaner.nextLine();
        boolean correct = false;
        String br = System.getProperty("line.separator");
        int edad = -1;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Give me the age");
                edad = sc.nextInt();
                while (edad < 0 || edad > 80) {
                    System.out.println("Give a good value for age");
                    edad = sc.nextInt();
                }
                correct = true;
            } catch (InputMismatchException e) {
                System.err.println("Tell me an age valuable");

            }

        } while (!correct);
        escaner = new Scanner(System.in);
        System.out.println("Give me your curse");
        String curso = escaner.nextLine();
        System.out.println("Give me your DNI");
        String dni = escaner.nextLine();
        if (!findStudent(dni, students)) {
            StudentS student1 = new StudentS(nombre, apellido, edad, curso, dni);
            students.add(student1);
            addStudent(students, register);
            System.out.println(students.size());
        } else {
            System.out.println("No se pueden agregar dos alumnos con el mismo DNI");
        }
    }

    /**
     * Write a student with to String on the register
     *
     * @param students
     * @param register
     */
    public static void addStudent(ArrayList<StudentS> students, File register) {
        try {
            FileWriter fw = new FileWriter(register);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < students.size(); i++) {
                bw.write(students.get(i).toString());
                bw.newLine();
            }
            // borra el buffer
            bw.flush();
            //cierra la lectura
            bw.close();
        } catch (IOException ex) {
            System.err.println("Error de escritura");

        }

    }
//

    /**
     * Find a student on the register, with the DNI
     *
     * @param registerOfStudents
     * @return
     */
    public static String findStudent(ArrayList<String> registerOfStudents,String dni) {
        Scanner escaner = new Scanner(System.in);
        //System.out.println("Give the DNI of the student");
        //readRegisterStudents(true);
        //String dni = escaner.nextLine();
        String estudianteToString = null;
        for (int i = 0; i < registerOfStudents.size(); i++) {
            String[] parts = registerOfStudents.get(i).split(",");
            if (dni.equals(parts[4])) {
                //System.out.println("Estudiante: " + registerOfStudents.get(i));
                estudianteToString = registerOfStudents.get(i);
//                System.out.println("Hola");
//                System.out.println("Estudiante encontrado");
                break;
                //seguir aquí, posible cambio 
//            } else if (i == students.size() - 1) {
//                System.out.println("Estudiante no encontrado");
//            }
        }
        }
        return estudianteToString;
        
    }

    /**
     * Find if a especific student exists, by his dni
     *
     * @param dni
     * @param students
     * @return
     */
    public static boolean findStudent(String dni, ArrayList<StudentS> students) {
        boolean encontrado = false;
        for (int i = 0; i < students.size(); i++) {
            //String[] parts = students.get(i).split(",");
            if (dni.equals(students.get(i).getDni())) {
                encontrado = true;
                // JOptionPane.showMessageDialog(interfaz,"Estudiante existente","Ventana indicadora",1);
                //System.out.println("Llego acá");
                break;
                
//            } else if (i == students.size() - 1) {
//                JOptionPane.showMessageDialog(interfaz,"Estudiante existente","Ventana indicadora",1);
//                System.out.println("Estudiante no existe");
//            }
        }
    }
        return encontrado;
    }

    /**
     * Delet a student from the array of students and on the register
     *
     * @param register
     * @param registerOfStudents
     */
    public static void deleteStudent(File register, ArrayList<String> registerOfStudents, String estudianteBorrado) {
        //String estudianteBorrado = findStudent(registerOfStudents);
        if (estudianteBorrado != null) {
            System.out.println("El estudiante con DNI: " + estudianteBorrado + " será borrado");
            for (int i = 0; i < students.size(); i++) {
                StudentS estudianteAborrar = students.get(i);
                if (estudianteAborrar.toString().equals(estudianteBorrado)) {
                    registerOfStudents.remove(estudianteBorrado);
                    students.remove(i);
                    break;
                }
            }
            try {
                FileWriter fw = new FileWriter(register);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < registerOfStudents.size(); i++) {
                    bw.write(registerOfStudents.get(i));
                    bw.newLine();
                }
                bw.flush();
                bw.close();
                System.out.println("Estudiante eliminado");
            } catch (IOException ex) {
                System.err.println("Error generico");
            }
        } else {
            System.out.println("No se puede borrar lo que no existe");
        }
    }

    public static String readRegisterStudentsSwing() {

        ArrayList<String> studentsStr = new ArrayList<>();
        String estudianteToString = "";
        for (int i = 0; i < students.size(); i++) {
            String[] parts = students.get(i).toString().split(",");
            estudianteToString += System.lineSeparator()+ "Alumno: " + parts[0] + " Apellido: "+ parts[1] + " Edad: " +parts[2] +  " DNI: " +parts[3] +  " Curso: "+parts[4];
        }
        return estudianteToString;
    }
     public static String readRegisterStudentSwing(String dni) {
        //ArrayList<String> studentsStr = new ArrayList<>();
        String estudianteToString = "";
        for (int i = 0; i < students.size(); i++) {
            String[] parts = students.get(i).toString().split(",");
            if (dni.equals(parts[4])) {
            estudianteToString = System.lineSeparator()+ "Alumno: " + parts[0] + " Apellido: "+ parts[1] + " Edad: " +parts[2] +  " DNI: " +parts[3] +  " Curso: "+parts[4];       
            }
        }
        return estudianteToString;
    }
    public static String buscarEstudiante(ArrayList<String> registerOfStudents, String dni){
        //String dni = JOptionPane.showInputDialog(null, "Diga el DNI del alumno a eliminar: ", "Eliminar alumno",3);
        String estudiante = findStudent(registerOfStudents, dni);
        boolean encontrado = findStudent(dni, students);
         if (encontrado) {
            JOptionPane.showMessageDialog(null,"Alumno Encontrado " + readRegisterStudentSwing(dni),"Encontrado",1);
            return estudiante;
        } else {
            JOptionPane.showMessageDialog(null,"Alumno no encontrado ","No encontrado",2);
            return null;
        }
    } 
}
