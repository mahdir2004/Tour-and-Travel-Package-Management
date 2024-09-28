package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Files.FileIO;
import GUI.PackageManagementPage;
public class LoginPage extends JFrame implements ActionListener{
	Font font20 = new Font("cambria",Font.PLAIN,20);
	Font font25 = new Font("cambria",Font.BOLD,25);
	Font font30 = new Font("cambria",Font.PLAIN,30);
	
	JLabel userLabel, passLabel, userImage;
	JTextField userTextField;
	JPasswordField userPassField;
	JButton loginBtn,registerBtn;
	
	public LoginPage(){
		super("Login Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,400);//w,h
		this.setLocation(200,100);//w,h
		this.setLayout(null);
		
		this.getContentPane().setBackground(new Color(4,136,143));
		
		
		//User Name
		userImage = new JLabel(new ImageIcon("./images/user.png"));
		userImage.setBounds(190,0,50,50);//x,y,w,h
		//userLabel.setFont(font25);
		this.add(userImage);
		
		
		
		//User Name
		userLabel = new JLabel("User Name");
		userLabel.setBounds(100,50,200,30);//x,y,w,h
		userLabel.setFont(font25);
		this.add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(100,90,200,30);
		userTextField.setFont(font25);
		//userTextField.setBackground(new Color(126,214,169));
		//userTextField.setForeground(Color.BLACK);
		this.add(userTextField);
		
		//User Password
		passLabel = new JLabel("Password");
		passLabel.setBounds(100,130,200,30);//x,y,w,h
		passLabel.setFont(font25);
		this.add(passLabel);
		
		userPassField = new JPasswordField();
		userPassField.setBounds(100,170,200,30);
		userPassField.setFont(font25);
		userPassField.setEchoChar('*');
		this.add(userPassField);
		
		//login button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(100,210,200,30);
		loginBtn.setFont(font25);
		loginBtn.setBackground(new Color(84,150,214));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.addActionListener(this);
		this.add(loginBtn);
		
		//register button
		registerBtn = new JButton("Register");
		registerBtn.setBounds(100,250,200,30);
		registerBtn.setFont(font25);
		registerBtn.setBackground(Color.YELLOW);
		registerBtn.setForeground(Color.BLACK);
		registerBtn.addActionListener(this);
		this.add(registerBtn);
		
		
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == loginBtn){
			//String name = "MJ";
			//String pass = "8498";
			
			String userName = userTextField.getText();
			String password = String.valueOf( userPassField.getPassword());
			
			if(FileIO.checkUser(userName,password)){	
				JOptionPane.showMessageDialog(this,"Hello "+ userTextField.getText());
				PackageManagementPage page = new PackageManagementPage ();
			}
			else{
				JOptionPane.showMessageDialog(this,"Wrong User Name or Password?","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(e.getSource() == registerBtn){
			JOptionPane.showMessageDialog(this,"Do you want to Register?","New User",JOptionPane.WARNING_MESSAGE);
		}
	}
}