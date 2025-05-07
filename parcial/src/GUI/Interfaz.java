package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.Parcial;

public class Interfaz extends JFrame implements ActionListener {
    private JLabel lbl_b;
    private JLabel lbl_e;
    
    private JTextField b_value;
    private JTextField e_value;

    private JLabel lbl_resultado;
    
    private JButton btn_execute;

    private Parcial parcial;
    
    public Interfaz() {
        this.parcial = new Parcial();
        this.setTitle("Potencia");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(5, 1)); // 5 filas, 1 columna
        
        this.lbl_b = new JLabel("Ingrese Valor de b");
        this.add(this.lbl_b);

        this.b_value = new JTextField(10);
        this.add(this.b_value);
        
        this.lbl_e = new JLabel("Ingrese Valor de e");
        this.add(this.lbl_e);

        this.e_value = new JTextField(10);
        this.add(this.e_value);

        this.btn_execute = new JButton("Calcular");
        this.btn_execute.addActionListener(this);
        this.add(this.btn_execute);

        this.lbl_resultado = new JLabel("Resultado: ");
        this.add(this.lbl_resultado);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Interfaz();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn_execute) {
            int b = Integer.parseInt(this.b_value.getText());
            int exponent = Integer.parseInt(this.e_value.getText());

            int resultado = this.parcial.potencia(b, exponent);
            this.lbl_resultado.setText("Resultado: " + resultado);
            this.b_value.setText("");
            this.e_value.setText("");
        }
    }
}
