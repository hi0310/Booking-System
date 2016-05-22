/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shotarohariu
 */
public class Coursework2 {

    /**
     * @param args the command line arguments
     */
 
public static void main(String[] args){
Scanner input = new Scanner(System.in);

String roomName;
int roomNum = 0;
String Menu; 
Room[] myHotel = new Room [10];
Queue mq = new Queue();
for (int i = 0; i < myHotel.length; i++){
myHotel[i] = new Room();
}
//myHotel [0] = new Room();
//myHotel [1] = new Room();
//myHotel [2] = new Room();
//myHotel [3] = new Room();
//myHotel [4] = new Room();
//myHotel [5] = new Room();
//myHotel [6] = new Room();
//myHotel [7] = new Room();
//myHotel [8] = new Room();
//myHotel [9] = new Room();

initialise(myHotel);

while(roomNum < myHotel.length){

    System.out.println("Menu");
    System.out.println("A: Add Customer");
    System.out.println("V: View All Rooms");
    System.out.println("D: Delete Customer");
    System.out.println("S: Store Program");
    System.out.println("L: Load Program");
    System.out.println("3: Display Names Of First 3 Customers");
    System.out.println("Q: Quit Program");
    
    Menu = input.next();
    switch(Menu){
        case "A":
            AddCustomer(myHotel,mq);
            
            break;
        case "V":
            ViewRooms(myHotel);
            break;
        case "D":
            DeleteCustomer(myHotel);
            break;
        case "S":
            StoreProgram(myHotel);
            break;
        case "L":
            LoadProgram(myHotel);
            break;
        case "3":
            Display3(mq);
            break;
        case "Q": 
            Quit(myHotel);
            break;
            
    }
    System.out.println("");
}
}
private static void initialise(Room hotelRef[]){
//for (int x = 0; x < hotelRef.length; x++) hotelRef[x].mainName = "e";
    System.out.println("initialise");
}

private static void AddCustomer(Room hotelRef[],Queue mq){
int roomNum = 0;
String roomName;
Scanner input = new Scanner(System.in);
System.out.println("Enter room number between 0 - 9 or 10 to stop"); //stops the program running when 10 is entered.
roomNum = input.nextInt();
if (roomNum >= 0 && roomNum < hotelRef.length){
System.out.println("Enter name for room " + roomNum + " :");
roomName = input.next();
hotelRef[roomNum].setName(roomName);
mq.addqueue(roomName);
}
else {
    System.out.println("Invalid Room Number");
}
}
private static void ViewRooms(Room hotelRef[]){
for (int x = 0; x < 10; x++){
    //System.out.println("room " + x + " occupied by " + myHotel[x].mainName);
    System.out.println("room " + x + " occupied by " + hotelRef[x].getName());
}    
}
private static void DeleteCustomer(Room hotelRef[]){
String DelName;
boolean deleted = false;
Scanner input = new Scanner(System.in);
System.out.println("Enter a customer name checking out");
DelName = input.next();
for (int i = 0; i < hotelRef.length; i++){
    if (hotelRef[i].getName().equals(DelName)){
        hotelRef[i].setName("e");
        System.out.println("Room " + i + " is e");
        deleted = true;
        break;
    } 
   
}
if (!deleted){
    System.out.println("Customer is not found ");
}
}
    

private static void StoreProgram(Room hotelRef[]){
Scanner console = new Scanner(System.in);
        System.out.println("Output file: ");
        String output = console.next();
    File outputFile = new File(output);
        try {
            PrintWriter out = new PrintWriter(outputFile);
            
           for (int i = 0; i<hotelRef.length; i++){
               out.println(hotelRef[i].getName());
           }
           out.close();
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coursework2.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    

private static void LoadProgram(Room hotelRef[]){
Scanner console = new Scanner(System.in);
        System.out.println("Input file: ");
        String input = console.next();
        File inputFile = new File(input);
        Scanner in;
        try {
            in = new Scanner(inputFile);
            int i = 0;
    while (in.hasNextLine())
    {
        
    hotelRef[i].setName(in.nextLine());
        System.out.println(hotelRef[i].getName());
     
    }
    in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Coursework2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }




private static void Display3(Queue mq){
for (int i = 0; i < 3; i++){
    mq.takequeue();
}
}

private static void Quit(Room hotelRef[]){
System.exit(0);

}
}
