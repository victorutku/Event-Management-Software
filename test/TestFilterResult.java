import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class TestFilterResult {
    @Test
    public void TestFilterLocation(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("myGala",5,60,l1,d1,6,aList);
        Event e2 = new Concert("secondGala",10,6,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,6,l2,d2,10,aList);
        List<Event> eventlist = new ArrayList<>();
        eventlist.add(e1);
        eventlist.add(e2);
        eventlist.add(e3);
        FilterResult myFilterResult = new FilterResult(eventlist);
        List<Event> aFilter= myFilterResult.filterLocation(l1);
        List<Event> expectedList = new ArrayList<>();
        expectedList.add(e1);
        expectedList.add(e2);
        assertEquals(expectedList,aFilter);
    }
    @Test
    public void TestFilterDate(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("myGala",5,60,l1,d1,6,aList);
        Event e2 = new Concert("secondGala",10,6,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,6,l2,d2,10,aList);
        List<Event> eventlist = new ArrayList<>();
        eventlist.add(e1);
        eventlist.add(e2);
        eventlist.add(e3);
        FilterResult myFilterResult = new FilterResult(eventlist);
        List<Event> aFilter= myFilterResult.filterDate(d2);
        List<Event> expectedList = new ArrayList<>();
        expectedList.add(e2);
        expectedList.add(e3);
        assertEquals(expectedList,aFilter);
    }
    @Test
    public void TestFilterPrice(){
            Location l1 = Location.BellCentre;
            Location l2 = Location.OlympicStadium;
            Location l3 = Location.Multiple;
            LocalDate d1 = LocalDate.EPOCH;
            LocalDate d2 = LocalDate.now();
            List<Vips> aList = new ArrayList<>();
            aList.add(Vips.GANDALF);
            aList.add(Vips.FRODO);
            aList.add(Vips.ARAGORN);
            Event e1 = new Gala("myGala",5,60,l1,d1,6,aList);
            Event e2 = new Concert("secondGala",10,6,l1,d2,10,aList);
            Event e3 = new Gala("secondGala",5,6,l2,d2,10,aList);
            List<Event> eventlist = new ArrayList<>();
            eventlist.add(e1);
            eventlist.add(e2);
            eventlist.add(e3);
            FilterResult myFilterResult = new FilterResult(eventlist);
            List<Event> aFilter= myFilterResult.filterPrice(0,10);
            List<Event> expectedList = new ArrayList<>();
            expectedList.add(e2);
            expectedList.add(e3);
            assertEquals(expectedList,aFilter);
        }
    @Test
    public void TestFilterNumTickets(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("myGala",5,60,l1,d1,6,aList);
        Event e2 = new Concert("secondGala",10,6,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,6,l2,d2,10,aList);
        List<Event> eventlist = new ArrayList<>();
        eventlist.add(e1);
        eventlist.add(e2);
        eventlist.add(e3);
        FilterResult myFilterResult = new FilterResult(eventlist);
        List<Event> aFilter= myFilterResult.filterNumTickets(10);
        List<Event> expectedList = new ArrayList<>();
        expectedList.add(e2);
        expectedList.add(e3);
        assertEquals(expectedList,aFilter);
    }
    @Test
    public void TestFilterName(){
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("myGala",5,60,l1,d1,6,aList);
        Event e2 = new Concert("secondGala",10,6,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,6,l2,d2,10,aList);
        List<Event> eventlist = new ArrayList<>();
        eventlist.add(e1);
        eventlist.add(e2);
        eventlist.add(e3);
        FilterResult myFilterResult = new FilterResult(eventlist);
        List<Event> aFilter= myFilterResult.filterName("myGala");
        List<Event> expectedList = new ArrayList<>();
        expectedList.add(e1);
        assertEquals(expectedList,aFilter);
    }
    @Test
    public void TestCalculateProfit(){
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
        Event e2 = new Concert("secondGala",10,5,l1,d2,10,aList);
        Event e3 = new Gala("secondGala",5,5,l2,d2,10,aList);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        FilterResult myFilterResult = new FilterResult(eventList);
        myFilterResult.filterLocation(l1);
        int profit= myFilterResult.calculateProfit();
        assertEquals(800,profit);
    }
    @Test
    public void TestCalculateVipNum() {
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        Location l3 = Location.Multiple;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        Event e1 = new Gala("myGala", 5, 10, l2, d1, 6, aList);
        Event e2 = new Concert("secondGala", 10, 5, l1, d2, 10, aList);
        Event e3 = new Screening("secondGala", 5, 5, l1, d2, 10);
        List<Event> eventList = new ArrayList<>();
        eventList.add(e1);
        eventList.add(e2);
        eventList.add(e3);
        FilterResult myFilterResult = new FilterResult(eventList);
        myFilterResult.filterLocation(l1);
        int vipNum = myFilterResult.calculateVipNum();
        assertEquals(3, vipNum);
    }

}
