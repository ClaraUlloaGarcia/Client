
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

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
        Response response = new RegisterCommand (socket).register(user, password, gender, age, weight, height);
         
        if(response.isSuccess()) {
            System.out.println("OK");
        }
        else{
            System.out.println("ERROR");
            System.exit(1);
        }
        
        
        List<Integer> bitalinoList = new ArrayList();
        System.out.println("Bitaline (3):");
        String bit1 = scanner.nextLine();
        bitalinoList.add(Integer.parseInt(bit1));
        String bit2 = scanner.nextLine();
        bitalinoList.add(Integer.parseInt(bit2));
        String bit3 = scanner.nextLine();
        bitalinoList.add(Integer.parseInt(bit3));
        
        System.out.println("Introduce flexing angle:");
        String flex_ang= scanner.nextLine();
        System.out.println("Introduce turning angle:");
        String turn_ang= scanner.nextLine();
        
        response = new VariablesCommand(socket).variableData(bitalinoList, flex_ang, turn_ang);
        
        if(!response.isSuccess()) {
                        System.out.println("ERROR");
            
        }
        else{
            List<String> data = response.getData();
            for (String line: data){
                System.out.println(line); //Ejercicios
            }
            System.out.println("TODO CHACHI PIRULI");
            
            /*
            String total = ""; //Devuelve el total de lineas que tenemos que leer
            do {
            total += (char)response;
            response = br.read();
            } while(response != '\n');
            int totalWorkout = Integer.parseInt(total);
            for (int i = 0; i < totalWorkout; i++){
                String workout = br.readLine();
                System.out.println(workout);
            }
            response = br.read();
            if (response == 0){
                System.out.println("OK");
            }else {
                System.out.println("Error");
            }
            */
        }
        socket.close();
    }  
}
