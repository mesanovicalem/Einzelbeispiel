package com.example.einzelbeispiel;

import java.io.*;
import java.net.*;

public class TCPClient implements Runnable {

    String sentence;
    String modifiedSentence;

    TCPClient(String sentence) {
        this.sentence = sentence;
    }

    public void run() {

        Socket clientSocket = null;
        try {
            clientSocket = new Socket("se2-isys.aau.at", 53212);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataOutputStream outToServer = null;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader inFromServer = null;
        try {
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            outToServer.writeBytes(sentence + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            modifiedSentence = inFromServer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("FROM SERVER:" + modifiedSentence);

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
