package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Persona;

public class FormularioPersona extends JFrame {

    // Componentes del formulario
    private JTextField txtApellidos, txtNombre, txtRFC, txtTelefono, txtCorreo;
    private JFormattedTextField txtFechaNac;
    private JRadioButton rbtnMasculino, rbtnFemenino, rbtnOtro;
    private ButtonGroup grupoSexo;
    private JComboBox<String> comboEscolaridad;
    private JButton btnGuardar;

    public FormularioPersona() {
        // Configuración de la ventana
        setTitle("Registro de Persona");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new GridBagLayout()); // Para un diseño ordenado y flexible
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Margen entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- FILA 0: Apellidos ---
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1; txtApellidos = new JTextField(20);
        add(txtApellidos, gbc);

        // --- FILA 1: Nombre ---
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Nombre(s):"), gbc);
        gbc.gridx = 1; txtNombre = new JTextField(20);
        add(txtNombre, gbc);

        // --- FILA 2: Sexo (Radio Buttons) ---
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Sexo:"), gbc);
        
        JPanel panelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rbtnMasculino = new JRadioButton("M");
        rbtnFemenino = new JRadioButton("F");
        rbtnOtro = new JRadioButton("Otro");
        grupoSexo = new ButtonGroup();
        grupoSexo.add(rbtnMasculino);
        grupoSexo.add(rbtnFemenino);
        grupoSexo.add(rbtnOtro);
        panelSexo.add(rbtnMasculino);
        panelSexo.add(rbtnFemenino);
        panelSexo.add(rbtnOtro);
        
        gbc.gridx = 1;
        add(panelSexo, gbc);

        // --- FILA 3: RFC ---
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("RFC:"), gbc);
        gbc.gridx = 1; txtRFC = new JTextField(20);
        add(txtRFC, gbc);

        // --- FILA 4: Fecha de Nacimiento ---
        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Fecha Nac. (AAAA-MM-DD):"), gbc);
        gbc.gridx = 1; txtFechaNac = new JFormattedTextField(DateTimeFormatter.ofPattern("yyyy-MM-dd").toFormat());
        txtFechaNac.setToolTipText("Ejemplo: 1995-12-25");
        add(txtFechaNac, gbc);

        // --- FILA 5: Escolaridad (Lista desplegable) ---
        gbc.gridx = 0; gbc.gridy = 5;
        add(new JLabel("Escolaridad:"), gbc);
        String[] opcionesEscolaridad = {"Seleccione...", "Primaria", "Secundaria", "Preparatoria", "Licenciatura", "Posgrado"};
        comboEscolaridad = new JComboBox<>(opcionesEscolaridad);
        gbc.gridx = 1;
        add(comboEscolaridad, gbc);

        // --- FILA 6: Teléfono ---
        gbc.gridx = 0; gbc.gridy = 6;
        add(new JLabel("Número Telefónico:"), gbc);
        gbc.gridx = 1; txtTelefono = new JTextField(20);
        add(txtTelefono, gbc);

        // --- FILA 7: Correo ---
        gbc.gridx = 0; gbc.gridy = 7;
        add(new JLabel("Correo Electrónico:"), gbc);
        gbc.gridx = 1; txtCorreo = new JTextField(20);
        add(txtCorreo, gbc);

        // --- FILA 8: Botón Guardar ---
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnGuardar = new JButton("Guardar Persona");
        add(btnGuardar, gbc);

        // Evento del botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
        try {
            // 1. Validar y capturar el sexo
            String sexoEscogido = "";
            if (rbtnMasculino.isSelected()) sexoEscogido = "Masculino";
            else if (rbtnFemenino.isSelected()) sexoEscogido = "Femenino";
            else if (rbtnOtro.isSelected()) sexoEscogido = "Otro";
            else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione el sexo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Validar escolaridad
            String escolaridad = (String) comboEscolaridad.getSelectedItem();
            if (escolaridad.equals("Seleccione...")) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una escolaridad.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Parsear la fecha de nacimiento
            LocalDate fechaNac = LocalDate.parse(txtFechaNac.getText());

            // 4. Crear la instancia de Persona con los datos de la interfaz
            Persona nuevaPersona = new Persona(
                    txtApellidos.getText().trim(),
                    txtNombre.getText().trim(),
                    sexoEscogido,
                    txtRFC.getText().trim().toUpperCase(),
                    fechaNac,
                    escolaridad,
                    txtTelefono.getText().trim(),
                    txtCorreo.getText().trim()
            );

            // 5. Mostrar éxito y los datos en consola
            JOptionPane.showMessageDialog(this, "¡Persona guardada con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Objeto Creado:\n" + nuevaPersona);
            
            // Opcional: limpiar el formulario aquí
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos. Revisa el formato de la fecha (AAAA-MM-DD).", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método Main para ejecutar la aplicación
    public static void main(String[] args) {
        // Asegura que la UI se ejecute en el Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new FormularioPersona().setVisible(true);
        });
    }
}