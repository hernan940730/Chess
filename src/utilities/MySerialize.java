package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MySerialize
{
	public static DataBase deserializeGame(String fileName)
	{
		DataBase p = null;
		try
		{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			p = (DataBase) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i){
			return null;
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("DataBase class not found");
			c.printStackTrace();
			return null;
		}
		return p;
	}
	
	public static void serializeGame(String fileName, DataBase p)
	{		
		try
		{
			FileOutputStream fileOut =
					new FileOutputStream(fileName);
			ObjectOutputStream out =
					new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.close();
			fileOut.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}
}
