package unit03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import unit02.Person;

public class ExFile {
	static final String RDFILE = "C:/Temp/sample.txt";
	static final String WRFILE = "C:/Temp/temp.txt";
	public static void main(String[] args) throws Exception {
		// 한 글자씩
		FileReader fr = new FileReader(RDFILE);
		FileWriter fw = new FileWriter(WRFILE);
		int ch;
		while ((ch = fr.read()) != -1) {
			System.out.print((char)ch);
			fw.write(ch);
		}
		fr.close();
		fw.close();
		
		// 한 라인씩
		BufferedReader in = new BufferedReader(new FileReader(RDFILE));
		BufferedWriter out = new BufferedWriter(new FileWriter(WRFILE));
		String line;
		while ((line = in.readLine()) != null) {
			out.write(line+"\n");
			System.out.println(line);
		}
		in.close();
		out.close();
		
		Person james = new Person("James", 24);
		ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("C:/Temp/obj.dat"));
		objOut.writeObject(james);
		objOut.flush();
		objOut.close();
		ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("C:/Temp/obj.dat"));
		Person p = (Person)objIn.readObject();
		System.out.println(p);
		objIn.close();
	}

}
