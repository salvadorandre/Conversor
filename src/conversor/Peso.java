/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversor;

/**
 *
 * @author Andre
 */
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
public class Peso extends JFrame implements ActionListener{
    private JButton resultado; 
    private JComboBox box1, box2;
    private JTextField entrada1, entrada2; 
    private JMenuBar bar1; 
    private JMenu menu1, menu2;
    private JMenuItem salir, peso, volumen, longitud, menu3;
    
    public Peso() { 
        setTitle("Peso"); 
        setSize(500, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setLayout(null); 
        
        Componentes(); 
    }
    
    private void Componentes() { 
        Combos(); 
        Entradas();
        MenuBar(); 
        Menu(); 
        Item(); 
        Button(); 
    }
    
    private void Combos() { 
        box1 = new JComboBox(); 
        box1.addItem("Kilogramos");
        box1.addItem("Gramos");
        box1.addItem("Libras");
        box1.addItem("Onzas");
        
        box1.setBounds(10, 40, 150, 30);
        this.add(box1); 
        
        box2 = new JComboBox(); 
        box2.addItem("Kilogramos");
        box2.addItem("Gramos");
        box2.addItem("Libras");
        box2.addItem("Onzas");
        
        box2.setBounds(10, 150, 150, 30);
        this.add(box2); 
    }
    
    private void Entradas() { 
        entrada1 = new JTextField();
        entrada1.setFont(new Font("arial", Font.ITALIC, 13)); 
        entrada1.setBounds(190, 40, 150, 30);
        this.add(entrada1); 
        
        entrada2 = new JTextField(); 
        entrada2.setFont(new Font("arial", Font.ITALIC, 13));
        entrada2.setBounds(190, 150, 150, 30);
        this.add(entrada2); 
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
        longitud.setFont(new Font("arial", Font.ITALIC, 13)); 
        longitud.addActionListener(this); 
        
        peso = new JMenuItem("peso"); 
        menu2.add(peso);
        peso.addActionListener(this); 
        peso.setFont(new Font("arial", Font.ITALIC, 13)); 
        
        volumen = new JMenuItem("Volumen"); 
        menu2.add(volumen);
        volumen.addActionListener(this); 
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
    }
    
    private void Button() { 
        resultado = new JButton("Calcular"); 
        resultado.setFont(new Font("arial", Font.ITALIC, 13));
        resultado.setLayout(null);
        resultado.setOpaque(true);
        resultado.setBounds(10, 215, 150, 30);
        resultado.addActionListener(this);
        this.add(resultado); 
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
        
        if(e.getSource() == resultado) { 
            String resultado1 = box1.getSelectedItem().toString().trim();
            String resultado2 = box2.getSelectedItem().toString().trim(); 
            double numero = Double.parseDouble(entrada1.getText().trim()); 
            
            if(resultado1.equals("Kilogramos") && resultado2.equals("Gramos")) { 
                double result = numero * 1000; 
                entrada2.setText(String.valueOf(result));
            }
            
            else if(resultado1.equals("Kilogramos") && resultado2.equals("Gramos")) { 
                double result = numero / 1000; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Gramos") && resultado2.equals("Libras")) { 
                double result = numero * 0.00220462; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Libras") && resultado2.equals("Gramos")) { 
                double result = numero * 453.592; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Libras") && resultado2.equals("Onzas")) { 
                double result = numero * 16; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Onzas") && resultado2.equals("Libras")) { 
                double result = numero / 16; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Libras") && resultado2.equals("Kilogramos")) { 
                double result = numero / 2.2; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Kilogramos") && resultado2.equals("Kilogramos")) { 
                double result = numero * 16; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Onzas") && resultado2.equals("Kilogramos")) { 
                double result = numero / 35.27; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Kilogramos") && resultado2.equals("Onzas")) { 
                double result = numero * 35.27; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Onzas") && resultado2.equals("Gramos")) { 
                double result = numero * 28.3495; 
                entrada2.setText(String.valueOf(result)); 
            }
            
            else if(resultado1.equals("Gramos") && resultado2.equals("Onzas")) { 
                double result = numero / 28.3495; 
                entrada2.setText(String.valueOf(result)); 
            }
        }
    }
    
    public static void main(String [] args) { 
        Peso ps = new Peso(); 
        ps.setVisible(true);
    }
    
}
