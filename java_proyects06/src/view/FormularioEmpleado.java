package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Empleado;

public class FormularioEmpleado extends JFrame {

    // Componentes de entrada
    private JTextField txtNombre, txtEdad, txtSueldo;
    private JButton btnGuardar;
    
    // Componente de visualización
    private JTextArea txtAreaVisor;
    private int contadorEmpleados = 1; // Para enumerar los registros

    public FormularioEmpleado() {
        // Configuración de la ventana
        setTitle("Registro e Historial de Empleados");
        setSize(520, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Diseño principal: BorderLayout
        setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR (Formulario de captura con GridBagLayout para alineación exacta) ---
        JPanel panelCaptura = new JPanel(new GridBagLayout());
        panelCaptura.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: Nombre
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.1;
        panelCaptura.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.9;
        txtNombre = new JTextField(25);
        panelCaptura.add(txtNombre, gbc);

        // Fila 1: Edad
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.1;
        panelCaptura.add(new JLabel("Edad:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.9;
        txtEdad = new JTextField(25);
        panelCaptura.add(txtEdad, gbc);

        // Fila 2: Sueldo
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.1;
        panelCaptura.add(new JLabel("Sueldo:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.9;
        txtSueldo = new JTextField(25);
        panelCaptura.add(txtSueldo, gbc);

        // Fila 3: Botón Guardar (Alineado a la derecha debajo de los inputs)
        gbc.gridx = 1; gbc.gridy = 3; gbc.weightx = 0.9;
        btnGuardar = new JButton("Guardar Empleado");
        panelCaptura.add(btnGuardar, gbc);
        
        // Agregar el panel de captura en la zona NORTE
        add(panelCaptura, BorderLayout.NORTH);

        // --- PANEL INFERIOR (Visualizador con margen y JTextArea) ---
        JPanel panelVisualizador = new JPanel(new BorderLayout());
        
        // Unimos un margen invisible y el título para que no quede pegado a los bordes de la ventana
        panelVisualizador.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 15, 15, 15),
                BorderFactory.createTitledBorder("Empleados Registrados")
        ));

        // Inicializar el JTextArea
        txtAreaVisor = new JTextArea();
        txtAreaVisor.setEditable(false); 
        txtAreaVisor.setFont(new Font("Monospaced", Font.PLAIN, 12)); 

        // Envolver el JTextArea en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(txtAreaVisor);
        panelVisualizador.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel del visor en la zona CENTRO
        add(panelVisualizador, BorderLayout.CENTER);

        // Evento del botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarYRegistrar();
            }
        });
    }

    private void validarYRegistrar() {
        // 1. Validar campos vacíos
        if (txtNombre.getText().trim().isEmpty() || 
            txtEdad.getText().trim().isEmpty() || 
            txtSueldo.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombre = txtNombre.getText().trim();
        int edad = 0;
        double sueldo = 0.0;

        // 2. Validar entero en Edad
        try {
            edad = Integer.parseInt(txtEdad.getText().trim());
            if (edad <= 0) {
                JOptionPane.showMessageDialog(this, "La edad debe ser mayor a 0.", "Edad Inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número entero válido.", "Error de Tipo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Validar decimal en Sueldo
        try {
            sueldo = Double.parseDouble(txtSueldo.getText().trim());
            if (sueldo < 0) {
                JOptionPane.showMessageDialog(this, "El sueldo no puede ser negativo.", "Sueldo Inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El sueldo debe ser un número decimal válido.", "Error de Tipo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Si todo es correcto, crear el objeto Empleado
        Empleado nuevoEmpleado = new Empleado(nombre, edad, sueldo);

        // 5. ¡Visualizar en el Text Area usando directamente tu toString()!
        txtAreaVisor.append(contadorEmpleados + ". " + nuevoEmpleado.toString() + "\n");
        contadorEmpleados++; // Incrementamos el número de lista

        // 6. Mensaje de éxito rápido y limpiar cajas de texto
        JOptionPane.showMessageDialog(this, "¡Empleado agregado al historial!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtSueldo.setText("");
        txtNombre.requestFocus(); 
    }

    public static void main(String[] args) {
        // Establecer el estilo visual de Windows (Look and Feel nativo)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new FormularioEmpleado().setVisible(true);
        });
    }
}