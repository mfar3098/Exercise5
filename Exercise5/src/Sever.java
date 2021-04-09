import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Sever {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			int portNo = 5228;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "";
			
			System.out.println("Please choose the English text you wish to convert to Bahasa Malaysia:");
			System.out.println("1. Good Morning");
			System.out.println("2. Good Night");
			System.out.println("3. How are you?");
			System.out.println("4. Thank you");
			System.out.println("5. Goodbye");
			System.out.println("6. What's up?");
			System.out.println("");
			
			
			Scanner br = new Scanner(System.in); 
			
			System.out.println("Please input choose:");
			int respon;
			respon = br.nextInt();
			br.close();
			
			switch(respon)
			{
			case 1:
				text1 = "Selamat Pagi";
				break;
				
			case 2:
				text1 = "Selamat Malam";
				break;
				
			case 3:
				text1 = "Apa khabar?";
				break;
				
			case 4:
				text1 = "Terima Kasih";
				break;
				
			case 5:
				text1 = "Selamat Tinggal";
				break;
				
			case 6:
				text1 = "Ada apa?";
				break;
				
				default:
					text1 = "Your choice of anwser is not in the list.";
			}
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				outputStream.writeUTF("In Bahasa Malaysia it's: " + text1);
				clientSocket.close();
			}
		} catch (IOException ioe) {
			if (serverSocket != null)
				serverSocket.close();
			
			ioe.printStackTrace();
		}
	}
	}
