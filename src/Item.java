public class Item {
    private String itemName;
    private String itemDescription;

    public Item(){

    }
    public Item(String name, String description){
        this.itemName = name;
        this.itemDescription = description;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
