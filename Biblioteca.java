package pooo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final List<Libro> libros;
    private final List<Usuario> usuarios;

    private JTextField tituloField;
    private JTextField isbnField;
    private JTextField autorNombreField;
    private JTextField autorApellidoField;
    private JTextField categoriaField;

    private JTextField usuarioNombreField;
    private JTextField usuarioApellidoField;
    private JTextField idUsuarioField;

    private JTextField idPrestamoUsuarioField;
    private JTextField tituloPrestamoField;

    private JTextField idDevolucionUsuarioField;
    private JTextField tituloDevolucionField;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        // Panel de Registro de Libro
        JPanel libroPanel = new JPanel();
        libroPanel.setBorder(BorderFactory.createTitledBorder("Registro de Libro"));
        libroPanel.setLayout(new GridLayout(6, 2));
        libroPanel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        libroPanel.add(tituloField);

        libroPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        libroPanel.add(isbnField);

        libroPanel.add(new JLabel("Autor Nombre:"));
        autorNombreField = new JTextField();
        libroPanel.add(autorNombreField);

        libroPanel.add(new JLabel("Autor Apellido:"));
        autorApellidoField = new JTextField();
        libroPanel.add(autorApellidoField);

        libroPanel.add(new JLabel("Categoría:"));
        categoriaField = new JTextField();
        libroPanel.add(categoriaField);

        JButton registrarLibroButton = new JButton("Registrar Libro");
        registrarLibroButton.addActionListener((ActionEvent e) -> {
            registrarLibro();
        });
        libroPanel.add(registrarLibroButton);

        mainPanel.add(libroPanel);

        // Panel de Registro de Usuario
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setBorder(BorderFactory.createTitledBorder("Registro de Usuario"));
        usuarioPanel.setLayout(new GridLayout(4, 2));
        usuarioPanel.add(new JLabel("Nombre:"));
        usuarioNombreField = new JTextField();
        usuarioPanel.add(usuarioNombreField);

        usuarioPanel.add(new JLabel("Apellido:"));
        usuarioApellidoField = new JTextField();
        usuarioPanel.add(usuarioApellidoField);

        usuarioPanel.add(new JLabel("ID de Usuario:"));
        idUsuarioField = new JTextField();
        usuarioPanel.add(idUsuarioField);

        JButton registrarUsuarioButton = new JButton("Registrar Usuario");
        registrarUsuarioButton.addActionListener((ActionEvent e) -> {
            registrarUsuario();
        });
        usuarioPanel.add(registrarUsuarioButton);

        mainPanel.add(usuarioPanel);

        // Panel de Realizar Préstamo
        JPanel prestamoPanel = new JPanel();
        prestamoPanel.setBorder(BorderFactory.createTitledBorder("Realizar Préstamo"));
        prestamoPanel.setLayout(new GridLayout(3, 2));
        prestamoPanel.add(new JLabel("ID Usuario:"));
        idPrestamoUsuarioField = new JTextField();
        prestamoPanel.add(idPrestamoUsuarioField);

        prestamoPanel.add(new JLabel("Título Libro:"));
        tituloPrestamoField = new JTextField();
        prestamoPanel.add(tituloPrestamoField);

        JButton realizarPrestamoButton = new JButton("Realizar Préstamo");
        realizarPrestamoButton.addActionListener((ActionEvent e) -> {
            realizarPrestamo();
        });
        prestamoPanel.add(realizarPrestamoButton);

        mainPanel.add(prestamoPanel);

        // Panel de Devolver Libro
        JPanel devolucionPanel = new JPanel();
        devolucionPanel.setBorder(BorderFactory.createTitledBorder("Devolver Libro"));
        devolucionPanel.setLayout(new GridLayout(3, 2));
        devolucionPanel.add(new JLabel("ID Usuario:"));
        idDevolucionUsuarioField = new JTextField();
        devolucionPanel.add(idDevolucionUsuarioField);

        devolucionPanel.add(new JLabel("Título Libro:"));
        tituloDevolucionField = new JTextField();
        devolucionPanel.add(tituloDevolucionField);

        JButton devolverLibroButton = new JButton("Devolver Libro");
        devolverLibroButton.addActionListener((ActionEvent e) -> {
            devolverLibro();
        });
        devolucionPanel.add(devolverLibroButton);

        mainPanel.add(devolucionPanel);

        // Panel de Opciones adicionales
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setBorder(BorderFactory.createTitledBorder("Opciones"));
        opcionesPanel.setLayout(new FlowLayout());

        JButton mostrarLibrosButton = new JButton("Mostrar Libros");
        mostrarLibrosButton.addActionListener((ActionEvent e) -> {
            mostrarLibros();
        });
        opcionesPanel.add(mostrarLibrosButton);

        JButton mostrarUsuariosButton = new JButton("Mostrar Usuarios");
        mostrarUsuariosButton.addActionListener((ActionEvent e) -> {
            mostrarUsuarios();
        });
        opcionesPanel.add(mostrarUsuariosButton);

        JButton mostrarLibrosPrestadosButton = new JButton("Mostrar Libros Prestados");
        mostrarLibrosPrestadosButton.addActionListener((ActionEvent e) -> {
            mostrarLibrosPrestados();
        });
        opcionesPanel.add(mostrarLibrosPrestadosButton);

        mainPanel.add(opcionesPanel);

        // Añadir mainPanel dentro de JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private void registrarLibro() {
        String titulo = tituloField.getText();
        String isbn = isbnField.getText();
        String autorNombre = autorNombreField.getText();
        String autorApellido = autorApellidoField.getText();
        String categoria = categoriaField.getText();

        Autor autor = new Autor(autorNombre, autorApellido);
        Categoria cat = new Categoria(categoria);
        Libro libro = new Libro(titulo, isbn, autor, cat);

        registrarLibro(libro);
        JOptionPane.showMessageDialog(null, "Libro registrado con éxito");
    }

    private void registrarUsuario() {
        String nombre = usuarioNombreField.getText();
        String apellido = usuarioApellidoField.getText();
        int idUsuario = Integer.parseInt(idUsuarioField.getText());

        Usuario usuario = new Usuario(nombre, apellido, idUsuario);
        registrarUsuario(usuario);
        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
    }

    private void realizarPrestamo() {
        int idUsuario = Integer.parseInt(idPrestamoUsuarioField.getText());
        String tituloLibro = tituloPrestamoField.getText();

        Usuario usuario = getUsuario(idUsuario);
        Libro libro = getLibro(tituloLibro);

        if (usuario != null && libro != null) {
            String resultado = realizarPrestamo(usuario, libro);
            JOptionPane.showMessageDialog(null, resultado);
        } else if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (libro == null) {
            JOptionPane.showMessageDialog(null, "Libro no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void devolverLibro() {
        int idUsuario = Integer.parseInt(idDevolucionUsuarioField.getText());
        String tituloLibro = tituloDevolucionField.getText();

        Usuario usuario = getUsuario(idUsuario);

        if (usuario != null) {
            Prestamo prestamo = usuario.getPrestamo(tituloLibro);
            if (prestamo != null) {
                String resultado = devolverLibro(prestamo);
                JOptionPane.showMessageDialog(null, resultado);
            } else {
                JOptionPane.showMessageDialog(null, "Préstamo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarLibros() {
        StringBuilder sb = new StringBuilder();
        libros.stream().map((libro) -> {
            sb.append("Título: ").append(libro.getTitulo()).append(", ");
            return libro;
        }).map((libro) -> {
            sb.append("ISBN: ").append(libro.getIsbn()).append(", ");
            return libro;
        }).map((libro) -> {
            sb.append("Autor: ").append(libro.getAutor().getNombre()).append(" ").append(libro.getAutor().getApellido()).append(", ");
            return libro;
        }).forEachOrdered((libro) -> {
            sb.append("Categoría: ").append(libro.getCategoria().getNombre()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Libros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarUsuarios() {
        StringBuilder sb = new StringBuilder();
        usuarios.stream().map((usuario) -> {
            sb.append("Nombre: ").append(usuario.getNombre()).append(" ");
            return usuario;
        }).map((usuario) -> {
            sb.append("Apellido: ").append(usuario.getApellido()).append(", ");
            return usuario;
        }).forEachOrdered((usuario) -> {
            sb.append("ID: ").append(usuario.getIdUsuario()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Usuarios", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarLibrosPrestados() {
        StringBuilder sb = new StringBuilder();
        usuarios.stream().map((Usuario usuario) -> {
            sb.append("Usuario: ").append(usuario.getNombre()).append(" ").append(usuario.getApellido()).append("\n");
            return usuario;
        }).map((Usuario usuario) -> {
            sb.append("Libros prestados:\n");
            List<Prestamo> prestamos = usuario.getPrestamos();
            return prestamos;
        }).map((List<Prestamo> prestamos) -> {
            prestamos.forEach((prestamo) -> {
                sb.append("- ").append(prestamo.getLibro().getTitulo()).append("\n");
            });
            return prestamos;
        }).forEachOrdered((_item) -> {
            sb.append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Libros Prestados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void registrarLibro(Libro libro) {
        libros.add(libro);
    }

    private void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    private Usuario getUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    private Libro getLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    private String realizarPrestamo(Usuario usuario, Libro libro) {
        return usuario.realizarPrestamo(libro);
    }

    private String devolverLibro(Prestamo prestamo) {
        return prestamo.devolver();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Biblioteca::new);
    }
}

class Libro {
    private final String titulo;
    private final String isbn;
    private final Autor autor;
    private final Categoria categoria;

    public Libro(String titulo, String isbn, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

class Usuario {
    private final String nombre;
    private final String apellido;
    private final int idUsuario;
    private final List<Prestamo> prestamos;

    public Usuario(String nombre, String apellido, int idUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuario = idUsuario;
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String realizarPrestamo(Libro libro) {
        Prestamo prestamo = new Prestamo(libro);
        prestamos.add(prestamo);
        return "Préstamo realizado correctamente";
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public Prestamo getPrestamo(String tituloLibro) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getTitulo().equals(tituloLibro)) {
                return prestamo;
            }
        }
        return null;
    }
}

class Prestamo {
    private final Libro libro;

    public Prestamo(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public String devolver() {
        return "Libro devuelto correctamente";
    }
}

class Autor {
    private final String nombre;
    private final String apellido;

    public Autor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

class Categoria {
    private final String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
