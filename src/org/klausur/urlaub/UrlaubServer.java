package org.klausur.urlaub;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UrlaubServer {

	public static void main(String[] args) {
		
		try (
			ServerSocket server = new ServerSocket(6969);
			) {
				while(true) {
					Socket client = server.accept();
					processClient pc = new processClient(client);
					Thread t = new Thread(pc);
					t.start();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
