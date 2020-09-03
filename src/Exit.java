/*
    Exit class. Attributes:
        Name and locked status.
 */
public class Exit {
    private String exitName;
    private boolean locked;
    private Item key;
    private String direction;
    private Room leadsTo;

    public Exit(){
    }

    //sets the name and locked status.
    public Exit(String name, boolean locked,String direction, Room leadsTo){
        this.exitName = name;
        this.locked = locked;
        this.direction = direction;
        this.leadsTo = leadsTo;
    }

    public String getDirection() {
        return direction;
    }
}
