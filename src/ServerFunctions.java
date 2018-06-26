import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;
import javax.swing.*;

public class ServerFunctions {
	public static void AddUser(ObjectOutputStream  dataOut, HashMap<String, String> formData)
	{
		try {
			dataOut.writeObject(formData);
			dataOut.flush();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {}
	}
}
