package login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Client extends JFrame implements ActionListener {
	
	private JButton btnLogin, btnCancel;
	private JTextField inputUsername;
	private JPasswordField inputPassword;
	private JLabel txtUsername, txtPassword;
	
	public Client(){
		
		// Initializing stuff
		
		btnLogin = new JButton("Logg inn");
		btnCancel = new JButton("Avslutt");
		inputUsername = new JTextField(20);
		inputPassword = new JPasswordField(20);
		txtUsername = new JLabel("Brukernavn");
		txtPassword = new JLabel("Passord");
		
		// Action Listener
		
		btnLogin.addActionListener(this);
		btnCancel.addActionListener(this);
		
		add(txtUsername);
		add(inputUsername);
		add(txtPassword);
		add(inputPassword);
		add(btnLogin);
		add(btnCancel);
		 
		
		
		setTitle("Pålogging");
		setLayout(new GridLayout(3,2));
		setVisible(true);
		setResizable(false);
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args){
		
		new Client();
		
	}


	@Override
	public void actionPerformed(ActionEvent hendelse) {
		
		Object hendelseOpphav = hendelse.getSource();
		
		if(hendelseOpphav == btnLogin) {
			
			String givenUsername = (String) inputUsername.getText();
			String givenPassword = (String) inputPassword.getText();
			
			Login log = new Login(givenUsername, givenPassword);
			
			if(log.isValidUser() == false){
				JOptionPane.showMessageDialog(null, "Ugyldig brukernavn eller passord", "Feil!", JOptionPane.ERROR_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "Du er pålogget!", "Login OK", JOptionPane.INFORMATION_MESSAGE);
			}
				
		}
		
		
	}
	

}
