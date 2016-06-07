package org.klausur.urlaub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class UrlaubManager {
	
	private File file;
	
	public UrlaubManager(String path) {
		super();
		this.file = new File(path);
	}

	public ArrayList<Urlaub> load(String mitarbeiter) throws DataFileException {
		ArrayList<Urlaub> list = new ArrayList<>();
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) {
				String line;
				while((line=br.readLine()) != null) {
					String[] array = line.split(",");
					Urlaub u = new Urlaub(Integer.parseInt(array[0]), array[1], array[2], array[3]);
					if(array[1].equals(mitarbeiter)) {
						list.add(u);
					}
				}
		} catch (IOException e) {
			throw new DataFileException(e);
		}
		Collections.sort(list, new UrlaubComparator());
		return list;
	}

}
