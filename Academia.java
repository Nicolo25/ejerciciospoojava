package pooo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Academia {

    private final List<Curso> cursos;
    private final List<Profesor> profesores;
    private final List<Estudiante> estudiantes;

    private JTextField nombreCursoField;
    private JTextField nombreProfesorCursoField;
    private JTextField apellidoProfesorCursoField;
    private JTextField nombreProfesorField;
    private JTextField apellidoProfesorField;
    private JTextField nombreEstudianteField;
    private JTextField apellidoEstudianteField;
    private JTextField idEstudianteField;
    private JTextField nombreAsignaturaField;
    private JTextField nombreProfesorAsignaturaField;
    private JTextField idCursoEvaluacionField;
    private JTextField idEstudianteEvaluacionField;
    private JTextField notaEvaluacionField;
    private JTextField diaHorarioField;
    private JTextField horaInicioHorarioField;
    private JTextField horaFinHorarioField;

    public Academia() {
        cursos = new ArrayList<>();
        profesores = new ArrayList<>();
        estudiantes = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Gestión Académica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        mainPanel.add(createCursoPanel());
        mainPanel.add(createProfesorPanel());
        mainPanel.add(createEstudiantePanel());
        mainPanel.add(createAsignaturaPanel());
        mainPanel.add(createEvaluacionPanel());
        mainPanel.add(createHorarioPanel());

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private JPanel createCursoPanel() {
        JPanel cursoPanel = new JPanel();
        cursoPanel.setBorder(BorderFactory.createTitledBorder("Registro de Curso"));
        cursoPanel.setLayout(new GridLayout(4, 2));
        cursoPanel.add(new JLabel("Nombre del Curso:"));
        nombreCursoField = new JTextField();
        cursoPanel.add(nombreCursoField);

        cursoPanel.add(new JLabel("Nombre Profesor:"));
        nombreProfesorCursoField = new JTextField();
        cursoPanel.add(nombreProfesorCursoField);

        cursoPanel.add(new JLabel("Apellido Profesor:"));
        apellidoProfesorCursoField = new JTextField();
        cursoPanel.add(apellidoProfesorCursoField);

        JButton registrarCursoButton = new JButton("Registrar Curso");
        registrarCursoButton.addActionListener((ActionEvent e) -> registrarCurso());
        cursoPanel.add(registrarCursoButton);

        return cursoPanel;
    }

    private JPanel createProfesorPanel() {
        JPanel profesorPanel = new JPanel();
        profesorPanel.setBorder(BorderFactory.createTitledBorder("Registro de Profesor"));
        profesorPanel.setLayout(new GridLayout(3, 2));
        profesorPanel.add(new JLabel("Nombre:"));
        nombreProfesorField = new JTextField();
        profesorPanel.add(nombreProfesorField);

        profesorPanel.add(new JLabel("Apellido:"));
        apellidoProfesorField = new JTextField();
        profesorPanel.add(apellidoProfesorField);

        JButton registrarProfesorButton = new JButton("Registrar Profesor");
        registrarProfesorButton.addActionListener((ActionEvent e) -> registrarProfesor());
        profesorPanel.add(registrarProfesorButton);

        return profesorPanel;
    }

    private JPanel createEstudiantePanel() {
        JPanel estudiantePanel = new JPanel();
        estudiantePanel.setBorder(BorderFactory.createTitledBorder("Registro de Estudiante"));
        estudiantePanel.setLayout(new GridLayout(4, 2));
        estudiantePanel.add(new JLabel("Nombre:"));
        nombreEstudianteField = new JTextField();
        estudiantePanel.add(nombreEstudianteField);

        estudiantePanel.add(new JLabel("Apellido:"));
        apellidoEstudianteField = new JTextField();
        estudiantePanel.add(apellidoEstudianteField);

        estudiantePanel.add(new JLabel("ID de Estudiante:"));
        idEstudianteField = new JTextField();
        estudiantePanel.add(idEstudianteField);

        JButton registrarEstudianteButton = new JButton("Registrar Estudiante");
        registrarEstudianteButton.addActionListener((ActionEvent e) -> registrarEstudiante());
        estudiantePanel.add(registrarEstudianteButton);

        return estudiantePanel;
    }

    private JPanel createAsignaturaPanel() {
        JPanel asignaturaPanel = new JPanel();
        asignaturaPanel.setBorder(BorderFactory.createTitledBorder("Registro de Asignatura"));
        asignaturaPanel.setLayout(new GridLayout(3, 2));
        asignaturaPanel.add(new JLabel("Nombre de la Asignatura:"));
        nombreAsignaturaField = new JTextField();
        asignaturaPanel.add(nombreAsignaturaField);

        asignaturaPanel.add(new JLabel("Nombre Profesor:"));
        nombreProfesorAsignaturaField = new JTextField();
        asignaturaPanel.add(nombreProfesorAsignaturaField);

        JButton registrarAsignaturaButton = new JButton("Registrar Asignatura");
        registrarAsignaturaButton.addActionListener((ActionEvent e) -> registrarAsignatura());
        asignaturaPanel.add(registrarAsignaturaButton);

        return asignaturaPanel;
    }

    private JPanel createEvaluacionPanel() {
        JPanel evaluacionPanel = new JPanel();
        evaluacionPanel.setBorder(BorderFactory.createTitledBorder("Registro de Evaluación"));
        evaluacionPanel.setLayout(new GridLayout(4, 2));
        evaluacionPanel.add(new JLabel("ID Curso:"));
        idCursoEvaluacionField = new JTextField();
        evaluacionPanel.add(idCursoEvaluacionField);

        evaluacionPanel.add(new JLabel("ID Estudiante:"));
        idEstudianteEvaluacionField = new JTextField();
        evaluacionPanel.add(idEstudianteEvaluacionField);

        evaluacionPanel.add(new JLabel("Nota:"));
        notaEvaluacionField = new JTextField();
        evaluacionPanel.add(notaEvaluacionField);

        JButton registrarEvaluacionButton = new JButton("Registrar Evaluación");
        registrarEvaluacionButton.addActionListener((ActionEvent e) -> registrarEvaluacion());
        evaluacionPanel.add(registrarEvaluacionButton);

        return evaluacionPanel;
    }

    private JPanel createHorarioPanel() {
        JPanel horarioPanel = new JPanel();
        horarioPanel.setBorder(BorderFactory.createTitledBorder("Registro de Horario"));
        horarioPanel.setLayout(new GridLayout(4, 2));
        horarioPanel.add(new JLabel("Día:"));
        diaHorarioField = new JTextField();
        horarioPanel.add(diaHorarioField);

        horarioPanel.add(new JLabel("Hora de inicio:"));
        horaInicioHorarioField = new JTextField();
        horarioPanel.add(horaInicioHorarioField);

        horarioPanel.add(new JLabel("Hora de fin:"));
        horaFinHorarioField = new JTextField();
        horarioPanel.add(horaFinHorarioField);

        JButton registrarHorarioButton = new JButton("Registrar Horario");
        registrarHorarioButton.addActionListener((ActionEvent e) -> registrarHorario());
        horarioPanel.add(registrarHorarioButton);

        return horarioPanel;
    }

    private void registrarCurso() {
        String nombreCurso = nombreCursoField.getText();
        String nombreProfesor = nombreProfesorCursoField.getText();
        String apellidoProfesor = apellidoProfesorCursoField.getText();

        Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor);
        Curso curso = new Curso(nombreCurso, profesor, null);

        cursos.add(curso);
        JOptionPane.showMessageDialog(null, "Curso registrado con éxito");
    }

    private void registrarProfesor() {
        String nombre = nombreProfesorField.getText();
        String apellido = apellidoProfesorField.getText();

        Profesor profesor = new Profesor(nombre, apellido);
        profesores.add(profesor);
        JOptionPane.showMessageDialog(null, "Profesor registrado con éxito");
    }

    private void registrarEstudiante() {
        String nombre = nombreEstudianteField.getText();
        String apellido = apellidoEstudianteField.getText();
        int idEstudiante;
        try {
            idEstudiante = Integer.parseInt(idEstudianteField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de Estudiante inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estudiante estudiante = new Estudiante(nombre, apellido, idEstudiante);
        estudiantes.add(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante registrado con éxito");
    }

    private void registrarAsignatura() {
        String nombreAsignatura = nombreAsignaturaField.getText();
        String nombreProfesor = nombreProfesorAsignaturaField.getText();

        Profesor profesor = getProfesor(nombreProfesor);
        if (profesor == null) {
            JOptionPane.showMessageDialog(null, "Profesor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Asignatura asignatura = new Asignatura(nombreAsignatura, profesor);
        profesor.getAsignaturas().add(asignatura);
        JOptionPane.showMessageDialog(null, "Asignatura registrada con éxito");
    }

    private void registrarEvaluacion() {
        int idCurso;
        int idEstudiante;
        double nota;

        try {
            idCurso = Integer.parseInt(idCursoEvaluacionField.getText());
            idEstudiante = Integer.parseInt(idEstudianteEvaluacionField.getText());
            nota = Double.parseDouble(notaEvaluacionField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Curso curso = getCurso(idCurso);
        Estudiante estudiante = getEstudiante(idEstudiante);

        if (curso == null || estudiante == null) {
            JOptionPane.showMessageDialog(null, "Curso o Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Evaluacion evaluacion = new Evaluacion(curso, estudiante, nota);
        curso.getEvaluaciones().add(evaluacion);
        estudiante.getEvaluaciones().add(evaluacion);
        JOptionPane.showMessageDialog(null, "Evaluación registrada con éxito");
    }

    private void registrarHorario() {
        String dia = diaHorarioField.getText();
        String horaInicio = horaInicioHorarioField.getText();
        String horaFin = horaFinHorarioField.getText();

        Horario horario = new Horario(dia, horaInicio, horaFin);
        JOptionPane.showMessageDialog(null, "Horario registrado con éxito");
    }

    private Profesor getProfesor(String nombre) {
        return profesores.stream().filter(profesor -> profesor.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    private Curso getCurso(int id) {
        return cursos.stream().filter(curso -> curso.getId() == id).findFirst().orElse(null);
    }

    private Estudiante getEstudiante(int id) {
        return estudiantes.stream().filter(estudiante -> estudiante.getId() == id).findFirst().orElse(null);
    }

    public static void main(String[] args) {
        Academia academia = new Academia();
    }
}

class Curso {
    private static int idCounter = 1;
    private final int id;
    private final String nombre;
    private final Profesor profesor;
    private final List<Evaluacion> evaluaciones;

    public Curso(String nombre, Profesor profesor, List<Evaluacion> evaluaciones) {
        this.id = idCounter++;
        this.nombre = nombre;
        this.profesor = profesor;
        this.evaluaciones = evaluaciones == null ? new ArrayList<>() : evaluaciones;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
}

class Profesor {
    private final String nombre;
    private final String apellido;
    private final List<Asignatura> asignaturas;

    public Profesor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignaturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}

class Estudiante {
    private final String nombre;
    private final String apellido;
    private final int id;
    private final List<Evaluacion> evaluaciones;

    public Estudiante(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.evaluaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }
}

class Asignatura {
    private final String nombre;
    private final Profesor profesor;

    public Asignatura(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }
}

class Evaluacion {
    private final Curso curso;
    private final Estudiante estudiante;
    private final double nota;

    public Evaluacion(Curso curso, Estudiante estudiante, double nota) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public double getNota() {
        return nota;
    }
}

class Horario {
    private final String dia;
    private final String horaInicio;
    private final String horaFin;

    public Horario(String dia, String horaInicio, String horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getDia() {
        return dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
}
