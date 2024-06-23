package pooo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class mundialfut {

    private final List<Equipo> equipos;
    private final List<Jugador> jugadores;
    private final List<Partido> partidos;
    private final List<Grupo> grupos;
    private final List<Estadio> estadios;

    private JTextField equipoNombreField;
    private JTextField entrenadorField;
    private JTextField jugadorNombreField;
    private JTextField edadField;
    private JTextField posicionField;
    private JTextField grupoNombreField;
    private JTextField estadioNombreField;
    private JTextField ciudadField;
    private JTextField capacidadField;
    private JTextField equipoLocalField;
    private JTextField equipoVisitanteField;
    private JTextField resultadoField;

    public mundialfut() {
        equipos = new ArrayList<>();
        jugadores = new ArrayList<>();
        partidos = new ArrayList<>();
        grupos = new ArrayList<>();
        estadios = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Mundial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 1));

        // Panel de Registro de Equipo
        JPanel equipoPanel = new JPanel();
        equipoPanel.setBorder(BorderFactory.createTitledBorder("Registro de Equipo"));
        equipoPanel.setLayout(new GridLayout(3, 2));
        equipoPanel.add(new JLabel("Nombre del Equipo:"));
        equipoNombreField = new JTextField();
        equipoPanel.add(equipoNombreField);

        equipoPanel.add(new JLabel("Entrenador:"));
        entrenadorField = new JTextField();
        equipoPanel.add(entrenadorField);

        JButton registrarEquipoButton = new JButton("Registrar Equipo");
        registrarEquipoButton.addActionListener((ActionEvent e) -> registrarEquipo());
        equipoPanel.add(registrarEquipoButton);

        mainPanel.add(equipoPanel);

        // Panel de Registro de Jugador
        JPanel jugadorPanel = new JPanel();
        jugadorPanel.setBorder(BorderFactory.createTitledBorder("Registro de Jugador"));
        jugadorPanel.setLayout(new GridLayout(4, 2));
        jugadorPanel.add(new JLabel("Nombre del Jugador:"));
        jugadorNombreField = new JTextField();
        jugadorPanel.add(jugadorNombreField);

        jugadorPanel.add(new JLabel("Edad:"));
        edadField = new JTextField();
        jugadorPanel.add(edadField);

        jugadorPanel.add(new JLabel("Posición:"));
        posicionField = new JTextField();
        jugadorPanel.add(posicionField);

        JButton registrarJugadorButton = new JButton("Registrar Jugador");
        registrarJugadorButton.addActionListener((ActionEvent e) -> registrarJugador());
        jugadorPanel.add(registrarJugadorButton);

        mainPanel.add(jugadorPanel);

        // Panel de Registro de Grupo
        JPanel grupoPanel = new JPanel();
        grupoPanel.setBorder(BorderFactory.createTitledBorder("Registro de Grupo"));
        grupoPanel.setLayout(new GridLayout(2, 2));
        grupoPanel.add(new JLabel("Nombre del Grupo:"));
        grupoNombreField = new JTextField();
        grupoPanel.add(grupoNombreField);

        JButton registrarGrupoButton = new JButton("Registrar Grupo");
        registrarGrupoButton.addActionListener((ActionEvent e) -> registrarGrupo());
        grupoPanel.add(registrarGrupoButton);

        mainPanel.add(grupoPanel);

        // Panel de Registro de Estadio
        JPanel estadioPanel = new JPanel();
        estadioPanel.setBorder(BorderFactory.createTitledBorder("Registro de Estadio"));
        estadioPanel.setLayout(new GridLayout(4, 2));
        estadioPanel.add(new JLabel("Nombre del Estadio:"));
        estadioNombreField = new JTextField();
        estadioPanel.add(estadioNombreField);

        estadioPanel.add(new JLabel("Ciudad:"));
        ciudadField = new JTextField();
        estadioPanel.add(ciudadField);

        estadioPanel.add(new JLabel("Capacidad:"));
        capacidadField = new JTextField();
        estadioPanel.add(capacidadField);

        JButton registrarEstadioButton = new JButton("Registrar Estadio");
        registrarEstadioButton.addActionListener((ActionEvent e) -> registrarEstadio());
        estadioPanel.add(registrarEstadioButton);

        mainPanel.add(estadioPanel);

        // Panel de Registro de Partido
        JPanel partidoPanel = new JPanel();
        partidoPanel.setBorder(BorderFactory.createTitledBorder("Registro de Partido"));
        partidoPanel.setLayout(new GridLayout(4, 2));
        partidoPanel.add(new JLabel("Equipo Local:"));
        equipoLocalField = new JTextField();
        partidoPanel.add(equipoLocalField);

        partidoPanel.add(new JLabel("Equipo Visitante:"));
        equipoVisitanteField = new JTextField();
        partidoPanel.add(equipoVisitanteField);

        partidoPanel.add(new JLabel("Resultado:"));
        resultadoField = new JTextField();
        partidoPanel.add(resultadoField);

        JButton registrarPartidoButton = new JButton("Registrar Partido");
        registrarPartidoButton.addActionListener((ActionEvent e) -> registrarPartido());
        partidoPanel.add(registrarPartidoButton);

        mainPanel.add(partidoPanel);

        // Panel de Opciones adicionales
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setBorder(BorderFactory.createTitledBorder("Opciones"));
        opcionesPanel.setLayout(new FlowLayout());

        JButton mostrarEquiposButton = new JButton("Mostrar Equipos");
        mostrarEquiposButton.addActionListener((ActionEvent e) -> mostrarEquipos());
        opcionesPanel.add(mostrarEquiposButton);

        JButton mostrarJugadoresButton = new JButton("Mostrar Jugadores");
        mostrarJugadoresButton.addActionListener((ActionEvent e) -> mostrarJugadores());
        opcionesPanel.add(mostrarJugadoresButton);

        JButton mostrarGruposButton = new JButton("Mostrar Grupos");
        mostrarGruposButton.addActionListener((ActionEvent e) -> mostrarGrupos());
        opcionesPanel.add(mostrarGruposButton);

        JButton mostrarEstadiosButton = new JButton("Mostrar Estadios");
        mostrarEstadiosButton.addActionListener((ActionEvent e) -> mostrarEstadios());
        opcionesPanel.add(mostrarEstadiosButton);

        JButton mostrarPartidosButton = new JButton("Mostrar Partidos");
        mostrarPartidosButton.addActionListener((ActionEvent e) -> mostrarPartidos());
        opcionesPanel.add(mostrarPartidosButton);

        mainPanel.add(opcionesPanel);

        // Añadir mainPanel dentro de JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private void registrarEquipo() {
        String nombre = equipoNombreField.getText();
        String entrenador = entrenadorField.getText();
        Equipo equipo = new Equipo(nombre, entrenador);
        equipos.add(equipo);
        JOptionPane.showMessageDialog(null, "Equipo registrado con éxito");
    }

    private void registrarJugador() {
        String nombre = jugadorNombreField.getText();
        int edad;
        try {
            edad = Integer.parseInt(edadField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Edad debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String posicion = posicionField.getText();
        Jugador jugador = new Jugador(nombre, edad, posicion);
        jugadores.add(jugador);
        JOptionPane.showMessageDialog(null, "Jugador registrado con éxito");
    }

    private void registrarGrupo() {
        String nombre = grupoNombreField.getText();
        Grupo grupo = new Grupo(nombre);
        grupos.add(grupo);
        JOptionPane.showMessageDialog(null, "Grupo registrado con éxito");
    }

    private void registrarEstadio() {
        String nombre = estadioNombreField.getText();
        String ciudad = ciudadField.getText();
        int capacidad;
        try {
            capacidad = Integer.parseInt(capacidadField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Capacidad debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Estadio estadio = new Estadio(nombre, ciudad, capacidad);
        estadios.add(estadio);
        JOptionPane.showMessageDialog(null, "Estadio registrado con éxito");
    }

    private void registrarPartido() {
        String equipoLocal = equipoLocalField.getText();
        String equipoVisitante = equipoVisitanteField.getText();
        String resultado = resultadoField.getText();

        Equipo local = getEquipo(equipoLocal);
        Equipo visitante = getEquipo(equipoVisitante);

        if (local != null && visitante != null) {
            Partido partido = new Partido(local, visitante, resultado);
            partidos.add(partido);
            JOptionPane.showMessageDialog(null, "Partido registrado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error: Equipo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Equipo getEquipo(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    private void mostrarEquipos() {
        StringBuilder sb = new StringBuilder();
        equipos.forEach(equipo -> {
            sb.append("Nombre: ").append(equipo.getNombre()).append(", ");
            sb.append("Entrenador: ").append(equipo.getEntrenador()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Equipos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarJugadores() {
        StringBuilder sb = new StringBuilder();
        jugadores.forEach(jugador -> {
            sb.append("Nombre: ").append(jugador.getNombre()).append(", ");
            sb.append("Edad: ").append(jugador.getEdad()).append(", ");
            sb.append("Posición: ").append(jugador.getPosicion()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Jugadores", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarGrupos() {
        StringBuilder sb = new StringBuilder();
        grupos.forEach(grupo -> {
            sb.append("Nombre: ").append(grupo.getNombre()).append("\n");
            grupo.getEquipos().forEach(equipo -> sb.append(" - ").append(equipo.getNombre()).append("\n"));
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Grupos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarEstadios() {
        StringBuilder sb = new StringBuilder();
        estadios.forEach(estadio -> {
            sb.append("Nombre: ").append(estadio.getNombre()).append(", ");
            sb.append("Ciudad: ").append(estadio.getCiudad()).append(", ");
            sb.append("Capacidad: ").append(estadio.getCapacidad()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Estadios", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarPartidos() {
        StringBuilder sb = new StringBuilder();
        partidos.forEach(partido -> {
            sb.append("Equipo Local: ").append(partido.getEquipoLocal().getNombre()).append(", ");
            sb.append("Equipo Visitante: ").append(partido.getEquipoVisitante().getNombre()).append(", ");
            sb.append("Resultado: ").append(partido.getResultado()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Partidos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(mundialfut::new);
    }
}

class Equipo {
    private final String nombre;
    private final String entrenador;
    private final List<Jugador> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void mostrarInfo() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Entrenador: " + entrenador);
        System.out.println("Jugadores:");
        jugadores.forEach(Jugador::mostrarInfo);
    }
}

class Jugador {
    private final String nombre;
    private final int edad;
    private final String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void mostrarInfo() {
        System.out.println("Jugador: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Posición: " + posicion);
    }
}

class Partido {
    private final Equipo equipoLocal;
    private final Equipo equipoVisitante;
    private final String resultado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, String resultado) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void jugarPartido() {
        System.out.println("Partido jugado entre " + equipoLocal.getNombre() + " y " + equipoVisitante.getNombre());
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarResultado() {
        System.out.println("Resultado del partido: " + resultado);
    }
}

class Grupo {
    private final String nombre;
    private final List<Equipo> equipos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void mostrarInfo() {
        System.out.println("Grupo: " + nombre);
        equipos.forEach(equipo -> System.out.println(" - " + equipo.getNombre()));
    }
}

class Estadio {
    private final String nombre;
    private final String ciudad;
    private final int capacidad;

    public Estadio(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void mostrarInfo() {
        System.out.println("Estadio: " + nombre);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Capacidad: " + capacidad);
    }
}
