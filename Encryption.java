import java.util.*;
import java.io.*;

public class Encryption 
{
	
	public Encryption()
	{
	}
	
	public void Encrypt(String x) throws IOException
	{
		//we want to shift the letters either left or right by a random amount, embedded into the file
		
		Random rand = new Random();
		int leftOrRight = rand.nextInt(2);
		int shift = rand.nextInt(1,26);
		int temp = 0;
		String n = x;
		
		FileWriter fw = new FileWriter("Encrypted");
		PrintWriter pw = new PrintWriter(fw);

		pw.println(leftOrRight);
		pw.println(shift);
		pw.println();
				
		//since we only use letters or numbers and they are high up on the ASCII table, there's no need to check if it goes out of bounds
		//it actually helps with encryption if its some weird character
		
		//test if left or right, then loop through the string and shift and add to new string
		//left = 0, right  = 1
		if(leftOrRight == 0)
		{
			for(int i = 0; i < n.length(); i++) 
			{
				temp = (int)n.charAt(i);
				temp -= shift;			
				pw.print((char)temp);
			}
		}
		
		//shift right
		else
		{
			for(int i = 0; i < n.length(); i++) 
			{
				temp = (int)n.charAt(i);
				temp += shift;		
				pw.print((char)temp);
			}
		}
		
		pw.close();
		fw.close();
	}
	
	public void Decrypt(String file) throws IOException
	{
		Scanner sc = new Scanner(new File(file));
		
		int leftOrRight = sc.nextInt();
		int shift = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		String x = sc.nextLine();
		sc.close();
		
		FileWriter fw = new FileWriter("Decrypted.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		int temp;
		
		//shift right
		if(leftOrRight == 0)
		{
			for(int i = 0; i < x.length(); i++) 
			{
				temp = (int)x.charAt(i);
				temp += shift;
				pw.print((char)temp);
			}
		}
		
		//shift left
		else
		{
			for(int i = 0; i < x.length(); i++) 
			{
				temp = (int)x.charAt(i);
				temp -= shift;
				pw.print((char)temp);
			}
		}
		
		pw.close();
		fw.close();
	}

}
