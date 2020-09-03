import java.util.Vector;

public class Room {
    private String roomTitle;
    private String roomDescription;
    private Vector<Exit> exits;
    private Vector<Item> items;
    private boolean isFinalRoom; //only one is true, the rest is false

    public Room(){}

    public Room(String roomTitle, String roomDescription, Vector<Exit> exits, Vector<Item> items, boolean isFinalRoom){
        this.roomTitle = roomTitle;
        this.roomDescription = roomDescription;
        this.exits = exits;
        this.isFinalRoom = isFinalRoom;
        this.items = items;
    }

    public String getRoomTitle(){
        return roomTitle;
    }

    public String getRoomDescription(){
        return roomDescription;
    }

    public void setRoomTitle(String roomTitle){
        this.roomTitle = roomTitle;
    }

    public void setRoomDescription(String roomDescription){
        this.roomDescription = roomDescription;
    }

    public void setExits(Vector<Exit> exits) {
        this.exits = exits;
    }

    public void setFinalRoom(boolean finalRoom) {
        isFinalRoom = finalRoom;
    }

    public Vector<Exit> getExits() {
        return exits;
    }
}