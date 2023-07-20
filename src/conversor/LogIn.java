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
import java.sql.*; 
public class LogIn extends JFrame implements ActionListener{
    private JButton regis, iniciar; 
    private JLabel imagen, user, pass; 
    private JTextField usuario, contra; 
    
    public LogIn() { 
        setTitle("Inicia Sesion"); 
        setLayout(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setResizable(false); 
        setSize(600, 600); 
        Componentes();
        this.getContentPane().setBackground(new Color(255, 255, 255));
    }
    
    private void Componentes() {
        Label(); 
        Entrada(); 
        Button();
    }
    
    
    private void Label() { 
        ImageIcon icon = new ImageIcon("C:/Users/Andre/Downloads/business-english-icon_2.png");
        
        imagen = new JLabel(icon, SwingConstants.CENTER);
        imagen.setBounds(160, 1, 250, 200);
        imagen.setBackground(new Color(255, 255, 255));
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
        iniciar = new JButton("Iniciar sesion"); 
        iniciar.setFont(new Font("arial", Font.ITALIC, 14));
        iniciar.setLayout(null);
        iniciar.setOpaque(true);
        iniciar.setBounds(210, 400, 150, 30);
        iniciar.addActionListener(this);
        iniciar.setBorder(null);
        this.add(iniciar);
        
        regis = new JButton("Registrarme"); 
        regis.setFont(new Font("arial", Font.ITALIC, 14));
        regis.setLayout(null);
        regis.setOpaque(true);
        regis.addActionListener(this);
        regis.setBounds(210, 440, 150, 30);
        this.add(regis); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == iniciar) { 
            String usua = usuario.getText().trim(); 
            String pas = contra.getText().trim(); 
            
            if(usua.equals("") || pas.equals("")) { 
                
                JOptionPane.showMessageDialog(null, "Ingrese sus datos");
            }
            
            else { 
                try { 
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
                    PreparedStatement pst = cn.prepareStatement("select * from users where user = ? && password = ?"); 
                    
                    
                    pst.setString(1, usua);
                    pst.setString(2, pas); 
                    
                    ResultSet res = pst.executeQuery(); 
                    
                    if(res.next()) {
                        Conversor cv = new Conversor(); 
                        cv.setVisible(true);
                        this.setVisible(false); 
                        JOptionPane.showMessageDialog(null, "Bienvenido");
                    }
                    else { 
                        JOptionPane.showMessageDialog(null, "No existe el usuario o ingrese correctamente sus datos");
                    }
                }catch(SQLException ex) { 
                    JOptionPane.showMessageDialog(this, "ERROR");
                }
            }
        }
        
        if(e.getSource() == regis) {
            Registrarme res = new Registrarme(); 
            res.setVisible(true);
            this.setVisible(false); 
        }
    }
    
    public static void main(String [] args ) { 
        LogIn in = new LogIn(); 
        in.setVisible(true);
    }

}
