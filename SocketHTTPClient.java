/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockethttpclient;

import java.net.*;
import java.io.*;
/**
 *
 * @author sharan
 */
public class SocketHTTPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String hostName = "www.google.com";
        int portNumber = 80;
        
        try{
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("GET/HTTP/1.1\nHost: www.martinbroadhurst.com\n\n");
            String inputLine;
            while((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
        }
        catch(UnknownHostException e){
            System.err.println("Don't know about host "+hostName);
            System.exit(1);
        }
    }
    
}
