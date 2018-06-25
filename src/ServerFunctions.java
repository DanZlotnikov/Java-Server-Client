import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import javax.swing.*;

public class ServerFunctions {
	public static void AddUser(Socket socket, HashMap<String, String> formData)
	{
		try {
		PrintWriter dataOut = new PrintWriter(socket.getOutputStream(), true);
		dataOut.println("Added User: " + formData.get("usernameEnglish"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {}
	}
}
