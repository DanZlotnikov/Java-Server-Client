import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import javax.swing.*;


public class Client {

    private BufferedReader dataIn;
    private PrintWriter dataOut;
    private JFrame frame = new JFrame("Mr. App");
    private JTextField dataField = new JTextField(40);
    private JTextArea messageArea = new JTextArea(8, 60);
    Socket socket;

    /**
     * Constructs the client by laying out the GUI and registering a
     * listener with the textfield so that pressing Enter in the
     * listener sends the textfield contents to the server.
     */
    public Client() {
    	
    	JFrame frame=new JFrame("Mr. Java");  
        final JTextField textfield=new JTextField();  
        textfield.setBounds(50,50, 150,20); 
        
        JButton addUserButton=new JButton("Add User");  
        addUserButton.setBounds(20,100,120,30);  
        addUserButton.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                AddUserScreen(frame);
            }  
        });  
        
        JButton updateUserButton=new JButton("Update User");  
        updateUserButton.setBounds(160,100,120,30);  
        updateUserButton.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
    	 		UpdateUserScreen(frame);
            }  
        });  
        
        JButton deleteUserButton=new JButton("Delete User");  
        deleteUserButton.setBounds(300,100,120,30);  
        deleteUserButton.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
    			DeleteUserScreen(frame); 
            }  
        });  
        
        frame.add(addUserButton);  
        frame.add(updateUserButton);
        frame.add(deleteUserButton);
        frame.setSize(500,500);  
        frame.setLayout(null); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);   
    }
    
    
    public void AddUserScreen(JFrame frame)
    {
    	frame=new JFrame("Add User");  
        HashMap<String, String> formData = new HashMap<String, String>();
    	
    	final JLabel usernameHebrewLabel = new JLabel("Username (Hebrew): ");
    	usernameHebrewLabel.setBounds(10,20, 150,20);
        final JTextField usernameHebrew=new JTextField();  
        usernameHebrew.setBounds(150, 20, 150,20);  
        
        final JLabel usernameEnglishLabel = new JLabel("Username (English): ");
        usernameEnglishLabel.setBounds(10,50, 150,20);
        final JTextField usernameEnglish=new JTextField();  
        usernameEnglish.setBounds(150, 50, 150,20);
        
        final JLabel cityLabel = new JLabel("City: ");
        cityLabel.setBounds(10,80, 150,20);
        final JTextField city=new JTextField();  
        city.setBounds(150,80, 150,20);
        
        final JLabel streetLabel = new JLabel("Street: ");
        streetLabel.setBounds(10,110, 150,20);
        final JTextField street=new JTextField();  
        street.setBounds(150,110, 150,20);
        
        final JLabel numberLabel = new JLabel("House no.: ");
        numberLabel.setBounds(10,140, 150,20);
        final JTextField number=new JTextField();  
        number.setBounds(150,140, 150,20);
        
        final JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(10,170, 150,20);
        final JTextField phone=new JTextField();  
        phone.setBounds(150,170, 150,20);
        
        
        String[] choices = { "Active","Inactive"};
        final JLabel activeCodesLabel = new JLabel("Status Code: ");
        activeCodesLabel.setBounds(10,200, 150,20);
        final JComboBox<String> activeCodes = new JComboBox<String>(choices);
        activeCodes.setBounds(150,200, 150,20);
        
        JButton addUserButton=new JButton("Add User");  
        addUserButton.setBounds(10,250,150,30);  
        addUserButton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
    			formData.put("usernameHebrew", usernameHebrew.getText());
                formData.put("usernameEnglish", usernameEnglish.getText());
                formData.put("city", city.getText());
                formData.put("street", street.getText());
                formData.put("number", number.getText());
                formData.put("phone", phone.getText());
                formData.put("activeCode", activeCodes.getSelectedItem().toString());
                ServerFunctions.AddUser(socket, formData);
            	}  
        	}); 
        frame.add(addUserButton);frame.add(usernameHebrew);frame.add(usernameEnglish);frame.add(city);frame.add(street);frame.add(number);frame.add(phone);frame.add(activeCodes);
        frame.add(usernameHebrewLabel);frame.add(usernameEnglishLabel);frame.add(cityLabel);frame.add(streetLabel);frame.add(numberLabel);frame.add(phoneLabel);frame.add(activeCodesLabel);   
        frame.setSize(400,400);  
        frame.setLayout(null); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
        
    }
    
    public void UpdateUserScreen(JFrame frame)
    {
    	frame=new JFrame("Update User");  
    	HashMap<String, String> formData = new HashMap<String, String>();
    	
    	final JLabel usernameHebrewLabel = new JLabel("Username (Hebrew): ");
    	usernameHebrewLabel.setBounds(10,20, 150,20);
        final JTextField usernameHebrew=new JTextField();  
        usernameHebrew.setBounds(150, 20, 150,20);  
        
        final JLabel usernameEnglishLabel = new JLabel("Username (English): ");
        usernameEnglishLabel.setBounds(10,50, 150,20);
        final JTextField usernameEnglish=new JTextField();  
        usernameEnglish.setBounds(150, 50, 150,20);
        
        final JLabel cityLabel = new JLabel("City: ");
        cityLabel.setBounds(10,80, 150,20);
        final JTextField city=new JTextField();  
        city.setBounds(150,80, 150,20);
        
        final JLabel streetLabel = new JLabel("Street: ");
        streetLabel.setBounds(10,110, 150,20);
        final JTextField street=new JTextField();  
        street.setBounds(150,110, 150,20);
        
        final JLabel numberLabel = new JLabel("House no.: ");
        numberLabel.setBounds(10,140, 150,20);
        final JTextField number=new JTextField();  
        number.setBounds(150,140, 150,20);
        
        final JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(10,170, 150,20);
        final JTextField phone=new JTextField();  
        phone.setBounds(150,170, 150,20);
        
        
        String[] choices = { "Active","Inactive"};
        final JLabel activeCodesLabel = new JLabel("Status Code: ");
        activeCodesLabel.setBounds(10,200, 150,20);
        final JComboBox<String> activeCodes = new JComboBox<String>(choices);
        activeCodes.setBounds(150,200, 150,20);
        
        
        JButton updateUserButton=new JButton("Update User");  
        updateUserButton.setBounds(10,250,150,30);  
        updateUserButton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
    			formData.put("usernameHebrew", usernameHebrew.getText());
                formData.put("usernameEnglish", usernameEnglish.getText());
                formData.put("city", city.getText());
                formData.put("street", street.getText());
                formData.put("number", number.getText());
                formData.put("phone", phone.getText());
                formData.put("activeCode", activeCodes.getSelectedItem().toString());
            }  
        }); 
        
        frame.add(updateUserButton);frame.add(usernameHebrew);frame.add(usernameEnglish);frame.add(city);frame.add(street);frame.add(number);frame.add(phone);frame.add(activeCodes);
        frame.add(usernameHebrewLabel);frame.add(usernameEnglishLabel);frame.add(cityLabel);frame.add(streetLabel);frame.add(numberLabel);frame.add(phoneLabel);frame.add(activeCodesLabel);   
        frame.setSize(400,400);  
        frame.setLayout(null); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
    }
    
    public void DeleteUserScreen(JFrame frame)
    {
    	frame=new JFrame("Delete User");  
        final JTextField textfield=new JTextField();  
        textfield.setBounds(50,50, 150,20);  
        JButton b=new JButton("Delete User");  
        b.setBounds(50,100,95,30);  
        b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
                textfield.setText("Welcome to Javatpoint.");  
            }  
        });  
        frame.add(b);frame.add(textfield);  
        frame.setSize(400,400);  
        frame.setLayout(null); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);  
    }
    
    /**
     * Implements the connection logic by prompting the end user for
     * the server's IP address, connecting, setting up streams, and
     * consuming the welcome messages from the server.  The Capitalizer
     * protocol says that the server sends three lines of text to the
     * client immediately after establishing a connection.
     */
    public void connectToServer() throws IOException {

        // Get the server address from a dialog box.
        String serverAddress = "127.0.0.1";

        // Make connection and initialize streams
        this.socket = new Socket(serverAddress, 5050);
        dataIn = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        dataOut = new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * Runs the client application.
     */
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.pack();
        client.frame.setVisible(true);
        client.connectToServer();
    }
}