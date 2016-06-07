package org.klausur.urlaub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class processClient implements Runnable{
	
	private Socket client;
	
	public processClient(Socket client) {
		super();
		this.client = client;
	}

	@Override
	public void run() {
		try (
		InputStreamReader isr = new InputStreamReader(client.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
		PrintWriter pw = new PrintWriter(osw);
		) {
			UrlaubManager um = new UrlaubManager("/temp/Textdatei1.txt");
			String line;
			while((line = br.readLine()) != null) {
				String[] array = line.split(" ");
					if(array[0].equals("get")) {
						try {								
							ArrayList<Urlaub> list = um.load(array[1]);
							for (Urlaub urlaub1 : list) {
								pw.println(urlaub1.toString());
								pw.flush();
							}
						} catch (DataFileException e) {
							e.printStackTrace();
						}
					}
					else if(array[0].equals("exit")) {
						break;
					}
					else {
						pw.print("wrong input");
						pw.flush();
					}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
