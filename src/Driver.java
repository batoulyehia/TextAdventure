import java.util.Scanner;
import java.util.Vector;

public class Driver {
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);


        //1. Create the item vectors
        Vector<Item> room1Items = new Vector<Item>();
        Vector<Item> room2Items = new Vector<Item>();
        Vector<Item> room3Items = new Vector<Item>();
        Vector<Item> room4Items = new Vector<Item>();
        Vector<Item> room5Items = new Vector<Item>();
        Vector<Item> room6Items = new Vector<Item>();
        Vector<Item> room7Items = new Vector<Item>();
        Vector<Item> room8Items = new Vector<Item>();
        Vector<Item> room9Items = new Vector<Item>();
        Vector<Item> room10Items = new Vector<Item>();

        //2. Create the exit vectors
        Vector<Exit> room1Exits = new Vector<Exit>();

        Vector<Exit> room2Exits = new Vector<Exit>();
        Vector<Exit> room3Exits = new Vector<Exit>();
        Vector<Exit> room4Exits = new Vector<Exit>();
        Vector<Exit> room5Exits = new Vector<Exit>();
        Vector<Exit> room6Exits = new Vector<Exit>();
        Vector<Exit> room7Exits = new Vector<Exit>();
        Vector<Exit> room8Exits = new Vector<Exit>();
        Vector<Exit> room9Exits = new Vector<Exit>();
        Vector<Exit> room10Exits = new Vector<Exit>();

        //3. Create the rooms

        Room room1 = new Room("Bedroom1", "This is a bedroom.", room2Exits, room2Items, false);
        Room room2 = new Room("Entryway","This is an entryway",room1Exits,room1Items,false);
        Room room3 = new Room("Laundry Room", "This is a laundry room", room3Exits, room3Items, false);
        Room room4 = new Room("Bathroom", "This is a bathroom.", room4Exits, room4Items, false);
        Room room5 = new Room("Hallway", "This is a hallway", room5Exits, room5Items, false);
        Room room6 = new Room("Living Room", "This is a living room.", room6Exits, room6Items, false);
        Room room7 = new Room("Bedroom2", "This is another bedroom.", room7Exits, room7Items, false);
        Room room8 = new Room("Kitchen", "This is a kitchen.", room8Exits, room8Items, false);
        Room room9 = new Room("Dining Room", "This is a dining room", room9Exits, room9Items, false);
        Room goal = new Room("Goal", "This is it! Game's over.", room10Exits, room10Items, true);
        // Create 9 rooms


        Exit r1e1 = new Exit("r1e1", false, "East", room2);
        room1.getExits().add(r1e1);

        Exit r2e1 = new Exit("To bed1", false, "West", room2);
        Exit r2e2 = new Exit("To Hall", false, "North", room5);
        Exit r2e3 = new Exit("To Laundry", false, "East", room3);
        room2.getExits().add(r2e1);
        room2.getExits().add(r2e2);
        room2.getExits().add(r2e3);

        Exit r3e1 = new Exit("To Entry", false, "West", room1);
        room3.getExits().add(r3e1);

        Exit r4e1 = new Exit("To hall", false, "West", room5);
        room4.getExits().add(r4e1);

        Exit r5e1 = new Exit("To bathroom", false, "West", room4);
        Exit r5e2 = new Exit("To Kitchen", false, "North", room8);
        Exit r5e3 = new Exit("To Living Room", false, "East", room6);
        room5.getExits().add(r5e1);
        room5.getExits().add(r5e2);
        room5.getExits().add(r5e3);

        Exit r6e1 = new Exit("To hall", false, "West", room5);
        Exit r6e2 = new Exit("To Dining Room", false, "North", room9);
        room6.getExits().add(r6e1);
        room6.getExits().add(r6e2);

        Exit r7e1 = new Exit("To kitchen", false, "East", room8);
        room7.getExits().add(r7e1);

        Exit r8e1 = new Exit("To bedroom2", false, "West", room7);
        Exit r8e2 = new Exit("Goal", false, "North", goal);
        room8.getExits().add(r8e1);
        room8.getExits().add(r8e2);

        Exit r9e1 = new Exit("To kitchenagain",false,"West",room8);
        room9.getExits().add(r9e1);

        Exit r10 = new Exit("Back to kitchen?",false,"South", room8);
        goal.getExits().add(r10);

        //
        // Create the player
        System.out.println("Enter player name:");
        String playerName = kb.nextLine();
        Player player = new Player(playerName, room2);

        boolean victory = false;
        while(!victory) {
            Vector directions = new Vector();

            System.out.println(player.getCurrentRoom().getRoomTitle());
            //give a set of commands, which are the available directions you can go to in every room:
            for (int i = 0; i < player.getCurrentRoom().getExits().size(); i++) {
                System.out.println(player.getCurrentRoom().getExits().elementAt(i).getDirection());
                directions.add(player.getCurrentRoom().getExits().elementAt(i).getDirection());
            }

            String selectedDirection = "";
            do {
                System.out.println("Please select one of the top directions.");
                selectedDirection = kb.nextLine();
                if (!directions.contains((selectedDirection))) {
                    System.out.println("Please enter a CORRECT direction.");
                }
            } while (!directions.contains(selectedDirection));


            for (int i = 0; i < player.getCurrentRoom().getExits().size(); i++) {
                if (selectedDirection.equals(player.getCurrentRoom().getExits().elementAt(i).getDirection())) {
                    player.setCurrentRoom(player.getCurrentRoom().getExits().elementAt(i).getLeadsTo());
                }
            }
            if(player.getCurrentRoom().getIsFinalRoom()){
                victory = true;
                System.out.print("You did it, " + playerName + "! You're finally out!");
            }
        }
    }
}
