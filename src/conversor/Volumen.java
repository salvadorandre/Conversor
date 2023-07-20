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

public class Volumen extends JFrame implements ActionListener{
    private JButton resultado; 
    private JComboBox box1, box2;
    private JTextField entrada1, entrada2; 
    private JMenuBar bar1; 
    private JMenu menu1, menu2;
    private JMenuItem salir, peso, volumen, longitud, menu3;
    
    public Volumen() { 
        setTitle("Volumen"); 
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
        box1.addItem("Galones");
        box1.addItem("Litros");
        box1.addItem("Centimetros cubicos");
        box1.addItem("Metros cubicos");
        
        box1.setBounds(10, 40, 150, 30);
        this.add(box1); 
        
        box2 = new JComboBox(); 
        box2.addItem("Galones");
        box2.addItem("Litros");
        box2.addItem("Centimetros cubicos");
        box2.addItem("Metros cubicos");
        
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
        longitud.addActionListener(this); 
        longitud.setFont(new Font("arial", Font.ITALIC, 13)); 
        
        peso = new JMenuItem("peso"); 
        menu2.add(peso); 
        peso.setFont(new Font("arial", Font.ITALIC, 13)); 
        
        volumen = new JMenuItem("Volumen"); 
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
        salir.setFont(new Font("arial", Font.ITALIC, 13));
        salir.addActionListener(this);
        
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
            
            String caja1 = box1.getSelectedItem().toString().trim(); 
            String caja2 = box2.getSelectedItem().toString().trim(); 
            
            double numero = Double.parseDouble(entrada1.getText().trim()); 
            
            if(caja1.equals("Galones") && caja2.equals("Litros")) { 
                double result = numero * 3.78541; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Litros") && caja2.equals("Galones")) { 
                double result = numero / 3.78541; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Litros") && caja2.equals("Centimetros cubicos")) { 
                double result = numero * 1000; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Centimetros cubicos") && caja2.equals("Litros")) { 
                double result = numero / 1000; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Metros cubicos") && caja2.equals("Centimetros cubicos")) { 
                double result = numero * 1000000;
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Centimetros cubicos") && caja2.equals("Metros cubicos")) { 
                double result = numero / 1000000; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Galones") && caja2.equals("Metros cubicos")) { 
                double result = numero * 219.969152; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Metros cubicos") && caja2.equals("Galones")) { 
                double result = numero / 219.969152; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Galones") && caja2.equals("Centimetros cubicos")) { 
                double result = numero * 3785.411784; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Centimetros cubicos") && caja2.equals("Galones")) { 
                double result = numero / 3785.411784; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Litros") && caja2.equals("Metros cubicos")) { 
                double result = numero / 1000; 
                
                entrada2.setText(String.valueOf(result));
            }
            
            else if(caja1.equals("Metros cubicos") && caja2.equals("Litros")) { 
                double result = numero * 1000; 
                
                entrada2.setText(String.valueOf(result));
            }
    
        
            
        }
    }
    
    public static void main(String [] args) { 
        Volumen vl = new Volumen(); 
        vl.setVisible(true); 
    
    }
    
    
}
