import java.util.Vector;

public class Player {
    private String playerName;
    private Vector<Item> inventory;
    private Room currentRoom;

    //EMPTY CONSTRUCTOR
    public Player(){
    }

    //CONSTRUCTOR
    public Player(String name, Room currentRoom){
        this.playerName = name;
        this.inventory = new Vector<Item>();
        this.currentRoom = currentRoom;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setCurrentRoom(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom(){
        return this.currentRoom;
    }

}
