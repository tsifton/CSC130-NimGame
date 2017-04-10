package edu.neumont;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO {

	public void writeToFile(ArrayList<BoardState> list, String fileName) {
		try {
			FileOutputStream stream = new FileOutputStream(fileName);

			ObjectOutputStream oos = new ObjectOutputStream(stream);
			oos.writeObject(list);
			oos.close();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<BoardState> readFromFile(String fileName) {
		ArrayList<BoardState> list = new ArrayList<BoardState>();

		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			list = (ArrayList) ois.readObject();
			ois.close();
			inputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
