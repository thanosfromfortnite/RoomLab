package Rooms;
import People.Person;


public class CoolerRoom extends Room {

    public CoolerRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Person x) {
        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

        System.out.println("Wow, this room is way cooler than the other ones.");
    }
}
