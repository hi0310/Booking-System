/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

/**
 *
 * @author shotarohariu
 */
class Room {
//String mainName;
private String mainName;
int guestsInRoom;
    String getName;

public Room(){
mainName = "k";
    System.out.println("Made a room");
    
}
public void setName(String aName){
    System.out.println("add name class method");
    mainName = aName;
    
}

public String getName(){
return mainName;
}
}
