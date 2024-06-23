package pooo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

// Clase Producto
class Producto {
    private final String nombre;
    private final double precio;
    private final Categoria categoria;

    public Producto(String nombre, double precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Producto: " + nombre + "\nPrecio: " + precio + "\nCategoría: " + categoria.getNombre());
    }
}

// Clase Cliente
class Cliente {
    private final String nombre;
    private final String apellido;
    private final int idCliente;

    public Cliente(String nombre, String apellido, int idCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Cliente: " + nombre + " " + apellido + "\nID: " + idCliente);
    }
}

// Clase Orden
class Orden {
    private final Cliente cliente;
    private final List<ItemOrden> items;
    private double total;

    public Orden(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemOrden> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void agregarItem(ItemOrden item) {
        items.add(item);
        calcularTotal();
    }

    public void calcularTotal() {
        total = 0.0;
        items.forEach((item) -> {
            total += item.calcularSubtotal();
        });
    }
}

// Clase ItemOrden
class ItemOrden {
    private final Producto producto;
    private final int cantidad;

    public ItemOrden(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}

// Clase Categoria
class pooo {
    private final String nombre;

    public pooo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Categoría: " + nombre);
    }
}

// Clase Tienda
class Tienda {
    private final List<Producto> productos;
    private final List<Cliente> clientes;
    private final List<Orden> ordenes;
    private final List<Categoria> categorias;

    private JTextField nombreProductoField;
    private JTextField precioProductoField;
    private JTextField categoriaProductoField;

    private JTextField nombreClienteField;
    private JTextField apellidoClienteField;
    private JTextField idClienteField;

    private JTextField idOrdenClienteField;
    private JTextField nombreProductoOrdenField;
    private JTextField cantidadProductoOrdenField;

    public Tienda() {
        productos = new ArrayList<>();
        clientes = new ArrayList<>();
        ordenes = new ArrayList<>();
        categorias = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Tienda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1));

        // Panel de Registro de Producto
        JPanel productoPanel = new JPanel();
        productoPanel.setBorder(BorderFactory.createTitledBorder("Registro de Producto"));
        productoPanel.setLayout(new GridLayout(4, 2));
        productoPanel.add(new JLabel("Nombre:"));
        nombreProductoField = new JTextField();
        productoPanel.add(nombreProductoField);

        productoPanel.add(new JLabel("Precio:"));
        precioProductoField = new JTextField();
        productoPanel.add(precioProductoField);

        productoPanel.add(new JLabel("Categoría:"));
        categoriaProductoField = new JTextField();
        productoPanel.add(categoriaProductoField);

        JButton registrarProductoButton = new JButton("Registrar Producto");
        registrarProductoButton.addActionListener((ActionEvent e) -> registrarProducto());
        productoPanel.add(registrarProductoButton);

        mainPanel.add(productoPanel);

        // Panel de Registro de Cliente
        JPanel clientePanel = new JPanel();
        clientePanel.setBorder(BorderFactory.createTitledBorder("Registro de Cliente"));
        clientePanel.setLayout(new GridLayout(4, 2));
        clientePanel.add(new JLabel("Nombre:"));
        nombreClienteField = new JTextField();
        clientePanel.add(nombreClienteField);

        clientePanel.add(new JLabel("Apellido:"));
        apellidoClienteField = new JTextField();
        clientePanel.add(apellidoClienteField);

        clientePanel.add(new JLabel("ID Cliente:"));
        idClienteField = new JTextField();
        clientePanel.add(idClienteField);

        JButton registrarClienteButton = new JButton("Registrar Cliente");
        registrarClienteButton.addActionListener((ActionEvent e) -> registrarCliente());
        clientePanel.add(registrarClienteButton);

        mainPanel.add(clientePanel);

        // Panel de Crear Orden
        JPanel ordenPanel = new JPanel();
        ordenPanel.setBorder(BorderFactory.createTitledBorder("Crear Orden"));
        ordenPanel.setLayout(new GridLayout(4, 2));
        ordenPanel.add(new JLabel("ID Cliente:"));
        idOrdenClienteField = new JTextField();
        ordenPanel.add(idOrdenClienteField);

        ordenPanel.add(new JLabel("Nombre Producto:"));
        nombreProductoOrdenField = new JTextField();
        ordenPanel.add(nombreProductoOrdenField);

        ordenPanel.add(new JLabel("Cantidad:"));
        cantidadProductoOrdenField = new JTextField();
        ordenPanel.add(cantidadProductoOrdenField);

        JButton crearOrdenButton = new JButton("Crear Orden");
        crearOrdenButton.addActionListener((ActionEvent e) -> crearOrden());
        ordenPanel.add(crearOrdenButton);

        mainPanel.add(ordenPanel);

        // Panel de Mostrar Productos
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setBorder(BorderFactory.createTitledBorder("Opciones"));
        opcionesPanel.setLayout(new FlowLayout());

        JButton mostrarProductosButton = new JButton("Mostrar Productos");
        mostrarProductosButton.addActionListener((ActionEvent e) -> mostrarProductos());
        opcionesPanel.add(mostrarProductosButton);

        JButton mostrarClientesButton = new JButton("Mostrar Clientes");
        mostrarClientesButton.addActionListener((ActionEvent e) -> mostrarClientes());
        opcionesPanel.add(mostrarClientesButton);

        JButton mostrarOrdenesButton = new JButton("Mostrar Ordenes");
        mostrarOrdenesButton.addActionListener((ActionEvent e) -> mostrarOrdenes());
        opcionesPanel.add(mostrarOrdenesButton);

        mainPanel.add(opcionesPanel);

        // Añadir mainPanel dentro de JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private void registrarProducto() {
        String nombre = nombreProductoField.getText();
        double precio;
        try {
            precio = Double.parseDouble(precioProductoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Precio inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String categoriaNombre = categoriaProductoField.getText();
        Categoria categoria = getCategoria(categoriaNombre);

        if (categoria == null) {
            categoria = new Categoria(categoriaNombre);
            categorias.add(categoria);
        }

        Producto producto = new Producto(nombre, precio, categoria);
        productos.add(producto);
        JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
    }

    private void registrarCliente() {
        String nombre = nombreClienteField.getText();
        String apellido = apellidoClienteField.getText();
        int idCliente;
        try {
            idCliente = Integer.parseInt(idClienteField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID Cliente inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nombre, apellido, idCliente);
        clientes.add(cliente);
        JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
    }

    private void crearOrden() {
        int idCliente;
        try {
            idCliente = Integer.parseInt(idOrdenClienteField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID Cliente inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombreProducto = nombreProductoOrdenField.getText();
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadProductoOrdenField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = getCliente(idCliente);
        Producto producto = getProducto(nombreProducto);

        if (cliente != null && producto != null) {
            Orden orden = new Orden(cliente);
            ItemOrden itemOrden = new ItemOrden(producto, cantidad);
            orden.agregarItem(itemOrden);
            ordenes.add(orden);
            JOptionPane.showMessageDialog(null, "Orden creada con éxito\nTotal: " + orden.getTotal());
        } else if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (producto == null) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Categoria getCategoria(String nombre) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equals(nombre)) {
                return categoria;
            }
        }
        return null;
    }

    private Cliente getCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    private Producto getProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private void mostrarProductos() {
        StringBuilder sb = new StringBuilder();
        productos.forEach(producto -> {
            sb.append("Producto: ").append(producto.getNombre()).append(", ");
            sb.append("Precio: ").append(producto.getPrecio()).append(", ");
            sb.append("Categoría: ").append(producto.getCategoria().getNombre()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Productos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        clientes.forEach(cliente -> {
            sb.append("Nombre: ").append(cliente.getNombre()).append(" ");
            sb.append("Apellido: ").append(cliente.getApellido()).append(", ");
            sb.append("ID: ").append(cliente.getIdCliente()).append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarOrdenes() {
        StringBuilder sb = new StringBuilder();
        ordenes.forEach(orden -> {
            sb.append("Cliente: ").append(orden.getCliente().getNombre()).append(" ").append(orden.getCliente().getApellido()).append("\n");
            sb.append("Total: ").append(orden.getTotal()).append("\n");
            sb.append("Items:\n");
            orden.getItems().forEach(item -> {
                sb.append("- Producto: ").append(item.getProducto().getNombre()).append(", ");
                sb.append("Cantidad: ").append(item.getCantidad()).append(", ");
                sb.append("Subtotal: ").append(item.calcularSubtotal()).append("\n");
            });
            sb.append("\n");
        });
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Ordenes", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tienda::new);
    }
}

