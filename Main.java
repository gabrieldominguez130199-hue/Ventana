import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Estas son un grupo de ventanas que nos van a servir para aprender a manejar
 * muchas ventanas en nuestras aplicaciones.
 */
public class Main extends JFrame implements ActionListener {

    private JButton btnVentana1;
    private JButton btnVentana2;
    private JButton btnVentana3;
    private JButton btnVentana4;
    private JButton btnVentana5;
/*constructor */
    public Main() {
        setLayout(new GridLayout(2, 3));

        btnVentana1 = new JButton("Abrir una ventana");/*addActionListener se le agrega a la ventana que es la accion que realizara */
        btnVentana1.addActionListener(this);
        getContentPane().add(btnVentana1);

        btnVentana2 = new JButton("Abrir un dialogo");
        btnVentana2.addActionListener(this);
        getContentPane().add(btnVentana2);   /*getContentPane para crear un panel visual para estos */

        btnVentana3 = new JButton("Abrir MessageDialog");
        btnVentana3.addActionListener(this);
        getContentPane().add(btnVentana3);

        btnVentana4 = new JButton("Abrir InputDialog");
        btnVentana4.addActionListener(this);
        getContentPane().add(btnVentana4);

        btnVentana5 = new JButton("Abrir InputDialog con opciones");
        btnVentana5.addActionListener(this);
        getContentPane().add(btnVentana5);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Ventanas!");
        setSize(700, 150);
        setVisible(true);
    }

    public Color getButtonBackground() {
        return btnVentana1.getBackground();
    }

    public Color getButtonForeground() {
        return btnVentana1.getForeground();
    }

    public void setButtonBackground(Color c) {
        btnVentana1.setBackground(c);
        btnVentana2.setBackground(c);
        btnVentana3.setBackground(c);
        btnVentana4.setBackground(c);
        btnVentana5.setBackground(c);
    }

    public void setButtonForeground(Color c) {
        btnVentana1.setForeground(c);
        btnVentana2.setForeground(c);
        btnVentana3.setForeground(c);
        btnVentana4.setForeground(c);
        btnVentana5.setForeground(c);
    }

    public static void main(String[] args) {
        Main app = new Main();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVentana1) {
            // Creamos una nueva ventana y la colocamos cerca de la ventana principal.
            Ventana v = new Ventana(this);
            v.setLocationRelativeTo(this);
            v.setVisible(true);

        } else if (e.getSource() == btnVentana2) {
            // Creamos un dialogo modal para cambiar el color de la letra.
            Dialogo d = new Dialogo(this);
            d.setLocationRelativeTo(this);
            d.setVisible(true);

            setButtonForeground(d.getColor());
            d.dispose();

        } else if (e.getSource() == btnVentana3) {
            // Mostramos un mensaje informativo.
            JOptionPane.showMessageDialog(  this,
                    "MessageDialog muestra un mensaje!",
                    "MessageDialog",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else if (e.getSource() == btnVentana4) {
            // Pedimos el nombre del usuario y mostramos un saludo.
            String nombre = (String) JOptionPane.showInputDialog(
                    this,
                    "Cual es tu nombre?",
                    "Log in",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (nombre != null) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + nombre);
            }

        } else if (e.getSource() == btnVentana5) {
            // Mostramos una lista de rangos de edad para que el usuario elija.
            String[] edades = {"0-14", "15-20", "21-30", "31-60", "61+"};

            String edad = (String) JOptionPane.showInputDialog(
                    this,
                    "Cual es tu edad?",
                    "Edades",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    edades,
                    edades[0]
            );

            if (edad != null) {
                if (edad.equals(edades[0])) {
                    JOptionPane.showMessageDialog(this, "Todavia eres joven");
                } else if (edad.equals(edades[1])) {
                    JOptionPane.showMessageDialog(this, "Eres un adolescente");
                } else if (edad.equals(edades[2])) {
                    JOptionPane.showMessageDialog(this, "Eres un adulto joven");
                } else if (edad.equals(edades[3])) {
                    JOptionPane.showMessageDialog(this, "Eres un adulto");
                } else if (edad.equals(edades[4])) {
                    JOptionPane.showMessageDialog(this, "Eres un adulto mayor");
                }
            }
        }
    }
}
