/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.util.Scanner;

/**
 *
 * @author shotarohariu
 */
public class Queue {
   
 String qitems[] = new String [7];
    int front = 0, end = 0;
    int queuecount = 0;
            
    void addqueue(String roomName){
    if (queuecount < qitems.length){
        qitems[end] = roomName;
        end = (end+1)%qitems.length; 
        queuecount++;
    }
     
    else
    {
            System.out.println("The queue is full!");
        System.out.println("Oldest Customer is " + qitems[front]);  
        front = (front + 1)%qitems.length;
        qitems[end] = roomName;
        end = (end+1)%qitems.length; 
        queuecount++;
    }
    }
    
    void takequeue(){
    if(queuecount > 0){
        System.out.println("Item taken : " + qitems[front]);
       front = (front + 1)%qitems.length;
        queuecount--;
        
    }
    else {
        System.out.println("Empty Queue");
        
    }
    }
    
    void displayqueue(){
        System.out.println("Queue Display ");
        for (int i = front; i < end; i++){
            System.out.println(" " + qitems[i]);
            
        }
        System.out.println(" ");
    }
}
