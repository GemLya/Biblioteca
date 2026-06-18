package view;
import javax.swing.*;
import java.awt.*; //Abstract window
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPersona extends JFrame{
    //Componentes de entrada
    private JTextField txtNombre, txtEst, txtPeso; //Caja de texto para ingresar datos
    private JButton btnCalcular;

    //Constructor de la clase de FormularioPersona 
    public FormularioPersona(){
        //Configuracon de la ventana
        setTitle("Datos de la persona para IMC"); //Titulo de la ventana
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cuando se cierre la ventana 
        setLocationRelativeTo(null);
        setResizable(false); //Para que no se puede agrandar la pantalla

        //Definir tipo de diseño BorderLayout
        setLayout(new BorderLayout(10,10)); //Para darle marco

        //Se agrega un panel para los componentes del formulario
        JPanel panelCaptura = new JPanel(new GridLayout(4,2,5, 5));
        panelCaptura.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCaptura.add(new JLabel("Nombre: "));
        txtNombre = new JTextField();
        panelCaptura.add(txtNombre);

        panelCaptura.add(new JLabel("Peso: "));
        txtPeso = new JTextField();
        panelCaptura.add(txtPeso);

        panelCaptura.add(new JLabel("Estatura: "));
        txtEst = new JTextField();
        panelCaptura.add(txtEst);

        btnCalcular = new JButton("Calcular IMC");
        panelCaptura.add(new Label(""));
        panelCaptura.add(btnCalcular);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Evento del Boton
                JOptionPane.showMessageDialog(panelCaptura,"Aqui se realiza el calculo de IMC");
                
            }
        });

        add(panelCaptura, BorderLayout.NORTH);

        //Manejo de accion 
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(panelCaptura, "Aqui se realliza el calculo de IMC");

                if (txtNombre.getText().trim().isEmpty() || txtPeso.getText().trim().isEmpty()|| txtPeso.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(panelCaptura, "Todos los campos son obligatorios","Campo vacio", 
                    JOptionPane.WARNING_MESSAGE);
                    return;
                    }
                }

            });
        };


    
        
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new FormularioPersona().setVisible(true);
        });
    }
    
}