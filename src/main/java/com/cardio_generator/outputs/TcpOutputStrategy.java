package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

/**
 * Creates a client-server socket pair on the same machine and specified port
 * Enables writing data string data to client socket's output stream and printing to console
 */
public class TcpOutputStrategy implements OutputStrategy {

  private ServerSocket serverSocket;
  private Socket clientSocket;
  private PrintWriter out;

  /**
   * Create socket pair, where both client and server are on the same machine
   * All data is sent from the client socket (OutputStream) and then printed to console
   * @param port: port to open serverSocket on
   * @throws IOException: if serverSocket cannot be created, client-server socket pair cannot be formed, if PrintWriter cannot
   * write to client socket's output stream or if client's outputStream cannot be read
   */
  public TcpOutputStrategy(int port) {
    try {
      serverSocket = new ServerSocket(port); //create server on local machine at specified port
      System.out.println("TCP Server started on port " + port);

      // Accept clients in a new thread to not block the main thread
      Executors.newSingleThreadExecutor().submit(() -> {
        try {
          clientSocket = serverSocket.accept(); //Create connection to client
          out = new PrintWriter(clientSocket.getOutputStream(), true); //Set client socket as OutputStream
          System.out.println("Client connected: " + clientSocket.getInetAddress());
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Write patient data to client socket's output stream and print to console
   * @param patientId: arbitrary patient ID
   * @param timestamp: time of output/storage, for example system time
   * @param label: data label, provides context for the data
   * @param data: relevant patient data
   */
  @Override
  public void output(int patientId, long timestamp, String label, String data) {
    if (out != null) {
      String message = String.format("%d,%d,%s,%s", patientId, timestamp, label, data);
      out.println(message);
    }
  }
}
