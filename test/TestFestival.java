import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestFestival {
    @BeforeEach
    public void setup(){


    }
    @Test
    public void testGetLocation(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("mygala",5,60,l1,d1,6,aList);
        Event e2 = new Gala("secondGala",10,6,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,6,l2,d2,10,aList);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        Festival f1 = new Festival("myfestival",eventList);
        Location tempLocation =f1.getLocation();
        assertEquals(Location.Multiple,tempLocation);
        //assertEquals(Location.BellCentre,tempLocation);
    }
    @Test
    public void testGetDate(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("mygala",5,60,l1,d1,6,aList);
        Event e2 = new Concert("secondGala",10,6,l1,d2,10,aList);
        Event e3 = new Screening("secondGala",5,6,l2,d2,10);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        Festival f1 = new Festival("myfestival",eventList);
        LocalDate tempDate= f1.getDate();
        assertEquals(LocalDate.EPOCH,tempDate);
    }

    @Test
    public void testGetPrice(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("myGala",5,10,l1,d1,6,aList);
        Event e2 = new Concert("secondGala",10,100,l1,d2,10,aList);
        Event e3 = new Screening("aEvent",5,50,l2,d2,10);
        Event e4 = new Workshop("event",5,50,l2,d2,10);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        eventList.add(e4);
        Festival f1 = new Festival("myfestival",eventList);
        double tempPrice= f1.getPrice();
        assertEquals(42,tempPrice);
    }
    @Test
    public void testGetNumTicket(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("mygala",5,10,l1,d1,6,aList);
        Event e2 = new Gala("secondGala",10,100,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,50,l2,d2,15,aList);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        Festival f1 = new Festival("myfestival",eventList);
        int tempTicketNum = f1.getNumTickets();
        assertEquals(6,tempTicketNum);

    }
    @Test
    public void testGetProfitPercentage() {
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("mygala", 5, 10, l1, d1, 6, aList);
        Event e2 = new Gala("secondGala", 10, 100, l1, d2, 10, aList);
        Event e3 = new Gala("secondGala", 5, 50, l2, d2, 10, aList);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        Festival f1 = new Festival("myfestival", eventList);
        int tempProfit = f1.getProfitPercent();
        assertEquals(20, tempProfit);
    }
    @Test
    public void testVipNum() {
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("mygala", 5, 10, l1, d1, 6, aList);
        Event e2 = new Gala("secondGala", 10, 100, l1, d2, 10, aList);
        Event e3 = new Gala("secondGala", 5, 50, l2, d2, 10, aList);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        Festival f1 = new Festival("myfestival", eventList);
        int tempVipNum = f1.getVipNum();
        assertEquals(9, tempVipNum);
    }
}
