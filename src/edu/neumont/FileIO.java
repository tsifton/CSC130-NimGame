package edu.neumont;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

	public FileIO() {

	}
	public void writeToFile(ArrayList<BoardState> list, String fileName) {
		try {
			FileOutputStream stream = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(stream);
			oos.writeObject(list);
			oos.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardState> readFromFile(String fileName) {
		File file = new File(fileName);
		ArrayList<BoardState> list = new ArrayList<>();
		try {
			if(file.exists()) {
			InputStream in = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(in);
			list = (ArrayList) ois.readObject();
			ois.close();
			in.close();
			} else {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}