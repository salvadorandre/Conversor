/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversor;

/**
 *
 * @author Andre
 */
import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 
public class Conversor extends JFrame implements ActionListener{
    private JLabel bienvenida; 
    private JMenuBar bar1; 
    private JMenu menu1, menu2;
    private JMenuItem salir , peso, volumen, longitud, informacion, menu3;
    
    public Conversor() { 
        setSize(500, 200); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setLayout(null); 
        setResizable(false); 
        setTitle("Conversor"); 
        Componentes(); 
    }
    
    private void Componentes() { 
        MenuBar(); 
        Menu(); 
        Item(); 
        Label(); 
    }
    
    private void MenuBar() {
        bar1 = new JMenuBar(); 
        setJMenuBar(bar1);
    }
    
    private void Menu() {
        menu1 = new JMenu("Opciones");
        menu1.setFont(new Font("arial", Font.ITALIC, 13));
        bar1.add(menu1); 
        
        menu2 = new JMenu("Conversiones"); 
        menu2.setFont(new Font("arial", Font.ITALIC, 13));
        bar1.add(menu2); 
        
        longitud = new JMenuItem("Longitud"); 
        menu2.add(longitud); 
        longitud.addActionListener(this);
        longitud.setFont(new Font("arial", Font.ITALIC, 13)); 
        
        peso = new JMenuItem("peso"); 
        peso.addActionListener(this); 
        menu2.add(peso); 
        peso.setFont(new Font("arial", Font.ITALIC, 13)); 
        
        volumen = new JMenuItem("Volumen"); 
        volumen.addActionListener(this);
        menu2.add(volumen); 
        volumen.setFont(new Font("arial", Font.ITALIC, 13)); 
        
        menu3 = new JMenuItem("Creador"); 
        menu3.setFont(new Font("arial", Font.ITALIC, 13)); 
        bar1.add(menu3); 
        menu3.addActionListener(this); 
        
  
    }
    
    private void Item() { 
        salir = new JMenuItem("Salir"); 
        menu1.add(salir); 
        salir.addActionListener(this); 
        salir.setFont(new Font("arial", Font.ITALIC, 13));
        
        informacion = new JMenuItem("Informacion sobre esto"); 
        informacion.setFont(new Font("arial", Font.ITALIC, 13));
        menu3.add(informacion); 
        
    }
    
    private void Label() { 
        bienvenida = new JLabel("Bienvenido al conversor de unidades"); 
        bienvenida.setBounds(100, 40, 350, 30 );
        bienvenida.setFont(new Font("arial", Font.ITALIC, 18));
        bienvenida.setOpaque(true);
        bienvenida.setLayout(null); 
        this.add(bienvenida);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir) { 
            int opc = JOptionPane.showConfirmDialog(null, "Esta seguro de salir"); 
            if(opc == 0) { 
                System.exit(0);
            }
        }
        
        if(e.getSource() == menu3) {
            JOptionPane.showMessageDialog(null, "Producto elaborado por el ING. Andre Salvador");
        }
        
        if(e.getSource() == peso) { 
            Peso ps = new Peso(); 
            ps.setVisible(true);
            this.setVisible(false);
        }
        
        if(e.getSource() == longitud) { 
            Longitud lon = new Longitud(); 
            lon.setVisible(true);
            this.setVisible(false);
        }
        
        if(e.getSource() == volumen) { 
            Volumen vol = new Volumen(); 
            vol.setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) { 
        Conversor cv = new Conversor(); 
        cv.setVisible(true);
    }

    
    
}
