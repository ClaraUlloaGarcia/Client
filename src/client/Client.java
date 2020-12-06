/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.net.*;



/**
 *
 * @author ClaraU
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); //Para pedir por teclado
                 System.out.println("Introduce user:");
        String user = scanner.nextLine();
        System.out.println("Password:");
        String password= scanner.nextLine();
        
        /*

       
        System.out.println("Gender:");
        String gender= scanner.nextLine();
        System.out.println("Age:");
        String age= scanner.nextLine();
        System.out.println("Weight:");
        String weight= scanner.nextLine();
        System.out.println("Height:");
        String height= scanner.nextLine();
        
        Socket socket = new Socket("localhost" , 9000);
        //OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw.append("R");
        //socket.getOutputStream().write('R');
        pw.append(user+"\n");
        pw.append(password+"\n");
        pw.append(gender+"\n");
        pw.append(age+"\n");
        pw.append(weight+"\n");
        pw.append(height+"\n");
        pw.flush();
        int response = br.read();
        if(response == 65) {
            System.out.println("OK");
        }
        else{
            System.out.println("ERROR");
        }
        socket.close();

        */
              Socket socket = new Socket("localhost" , 9000);
        //OutputStream outputStream = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        pw.append("L");
        //socket.getOutputStream().write('R');
        pw.append(user+"\n");
        pw.append(password+"\n");
        pw.flush();
         int response = br.read();
        if(response == 65) {
            System.out.println("OK");
        }
        else{
            System.out.println("ERROR");
            System.exit(1);
        }
        
         System.out.println("Bitaline (3):");
        String bit1 = scanner.nextLine();
        String bit2 = scanner.nextLine();
        String bit3 = scanner.nextLine();
        
        System.out.println("Introduce flexing angle:");
        String flex_ang= scanner.nextLine();
        System.out.println("Introduce turning angle:");
        String turn_ang= scanner.nextLine();
        
        

        pw.append("D");
        pw.append("3\n");
        pw.append(bit1 + "\n");
        pw.append(bit2 + "\n");
        pw.append(bit3 + "\n");
        pw.append(flex_ang+"\n");
        pw.append(turn_ang+"\n");
        pw.flush();
        response = br.read();
        if(response == 65) {
            System.out.println("OK");
        }
        else{
            System.out.println("ERROR");
        }
        socket.close();
    }
    
}
