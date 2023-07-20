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
import java.awt.*; 
import java.awt.event.*; 
import java.sql.*; 

public class Registrarme extends JFrame implements ActionListener{
    private JButton regis, iniciar; 
    private JLabel imagen, user, pass; 
    private JTextField usuario, contra; 
    
    public Registrarme() { 
        setTitle("Inicia Sesion"); 
        setLayout(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setResizable(false); 
        setSize(600, 600); 
        Componentes();
    }
    
    private void Componentes() {
        Label(); 
        Entrada(); 
        Button(); 
    }
    
    private void Label() { 
        ImageIcon icon = new ImageIcon("C:/Users/Andre/Downloads/form2.jpg");
        imagen = new JLabel(icon, SwingConstants.CENTER);
        imagen.setBounds(160, 10, 250, 200);
        this.add(imagen);
                
        user = new JLabel("User ", SwingConstants.CENTER); 
        user.setFont(new Font("arial", Font.ITALIC, 16));
        user.setBounds(210, 220, 150, 30);
        user.setLayout(null);
        user.setOpaque(true);
        this.add(user); 
        
        pass = new JLabel("Password ", SwingConstants.CENTER); 
        pass.setFont(new Font("arial", Font.ITALIC, 15));
        pass.setLayout(null);
        pass.setBounds(180, 300, 210, 30); 
        pass.setOpaque(true);
        this.add(pass); 
    }
    
     private void Entrada() { 
        usuario = new JTextField(); 
        usuario.setFont((new Font("arial", Font.ITALIC, 14)));
        usuario.setBounds(210, 260, 160, 30);
        this.add(usuario);
        
        contra = new JTextField(); 
        contra.setFont(new Font("arial", Font.ITALIC, 14)); 
        contra.setBounds(210, 340, 160, 30); 
        this.add(contra); 
        
    }
    
    private void Button() { 
        
        regis = new JButton("Registrarme"); 
        regis.setFont(new Font("arial", Font.ITALIC, 14));
        regis.setLayout(null);
        regis.setOpaque(true);
        regis.addActionListener(this);
        regis.setBounds(210, 400, 150, 30);
        this.add(regis); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == regis) { 
            String us = usuario.getText().trim(); 
            String pas = contra.getText().trim();   
            
            if(us.equals("") || pas.equals("")) { 
                JOptionPane.showMessageDialog(null, "Ingrese sus datos...");
            }
            
            else { 
                try { 
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
                    PreparedStatement pst = cn.prepareStatement("insert into users values(?, ?, ?)"); 
                    
                    pst.setString(1, "0");
                    pst.setString(2, us); 
                    pst.setString(3, pas); 
                    
                    pst.executeUpdate(); 
                    
                    JOptionPane.showMessageDialog(null, "Datos enviados");
                }catch(SQLException ex) { 
                   JOptionPane.showMessageDialog(null, "ERROR EN EL SISTEMA");
                }
            }
        }
    }
    
    public static void main(String[] args) { 
        Registrarme res = new Registrarme(); 
        res.setVisible(true);
    }
    
}
