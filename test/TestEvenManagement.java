import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class TestEvenManagement {
   private Location l1;
   private Location l2;
   private Location l3;
   private List<Vips> aList;
   private List<Event> eventList;
   private LocalDate d1;
   private LocalDate d2;
   private Event e1;
   private Event e2;
   private Event e3;
   private Event e4;
   private Event e5;
   private ComingSoon e6;
   private EventManagement manager;
    @BeforeEach
    public void setup(){
        l1 = Location.BellCentre;
        l2 = Location.OlympicStadium;
        l3 = Location.Multiple;
        d1 = LocalDate.EPOCH;
        d2 = LocalDate.now();
        aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        e2 = new Gala("myGala",5,10,l1,d1,6,aList);
        e1 = new Concert("secondGala",10,5,l1,d1,10,aList);
        e3 =new Screening("secondGala",5,5,l2,d2,10);
        e4 =new Workshop("secondGala",5,5,l2,d2,10);
        e5 = new Festival("myFestival",eventList);
        e6 = new ComingSoon("aEvent",d2);
        manager = new EventManagement("mymanager");
    }
    @Test
    public void testAddConcertEvent(){
        manager.addConcertEvent("secondGala",10,5,l1,d1,10,aList);
        assertTrue(manager.getHostedEvents().contains(e1));
    }
    @Test
    public void testAddGalaEvent(){
        manager.addGalaEvent("myGala",5,10,l1,d1,6,aList);
        assertTrue(manager.getHostedEvents().contains(e2));
    }
    @Test
    public void testAddScreening(){
        manager.addScreeningEvent("secondGala",5,5,l2,d2,10);
        assertTrue(manager.getHostedEvents().contains(e3));
    }
    @Test
    public void testAddWorkshop(){
        manager.addWorkshopEvent("secondGala",5,5,l2,d2,10);
        assertTrue(manager.getHostedEvents().contains(e4));
    }
    @Test
    public void testDuplicateEvent(){
        manager.addConcertEvent("aConcert",5,0.5,l1,d1,10,aList);
        manager.addGalaEvent("aConcert",5,5,l1,d1,10,aList);
        assertFalse(manager.getHostedEvents().contains(e2));
    }
    @Test
    public void testAddFestival(){
        manager.addFestivalEvent("myFestival",eventList);
        assertTrue(manager.getHostedEvents().contains(e5));
    }
    @Test
    public void testAddComingSoon(){
        manager.addComingSoonEvent("aEvent",d2);
        assertTrue(manager.getHostedEvents().contains(e6));
    }
    @Test
    public void testGetProfit(){
        manager.addScreeningEvent("secondGala",5,5,l1,d1,10);
        manager.addConcertEvent("secondGala",10,5,l1,d1,10,aList);
        FilterResult myFilterResult = new FilterResult(manager.getHostedEvents());
        myFilterResult.filterPrice(5,10);
        int temp = manager.getProfit(myFilterResult);
        assertEquals(250,temp);

    }
    @Test
    public void testGetVipNum(){
        manager.addGalaEvent("aConcert",5,5,l1,d1,10,aList);
        manager.addConcertEvent("secondGala",10,5,l1,d1,10,aList);
        FilterResult myFilterResult = new FilterResult(manager.getHostedEvents());
        myFilterResult.filterPrice(5,10);
        int temp = manager.getVipNum(myFilterResult);
        assertEquals(3,temp);
    }
    @Test
    public void testDuplicateWorkshop(){
        manager.addWorkshopEvent("aConcert",5,5,l1,d1,10);
        manager.addScreeningEvent("secondGala",5,5,l1,d1,10);
        assertFalse(manager.getHostedEvents().contains(e3));
    }
    @Test
    public void testDuplicateScreening(){
        manager.addScreeningEvent("secondGala",5,5,l1,d1,10);
        manager.addWorkshopEvent("aConcert",5,5,l1,d1,10);
        assertFalse(manager.getHostedEvents().contains(e3));
    }
}
