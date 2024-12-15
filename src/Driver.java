import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    // Bob can calculate expected profit and vip number without calling any Event class
    public static void main(String[] arg) {
        Location l1 = Location.BellCentre;
        Location l2 = Location.OlympicStadium;
        LocalDate d1 = LocalDate.EPOCH;
        LocalDate d2 = LocalDate.now();
        List<Vips> aList = new ArrayList<>();
        aList.add(Vips.GANDALF);
        aList.add(Vips.FRODO);
        aList.add(Vips.ARAGORN);
        EventManagement eventManager = new EventManagement("myManager");
        eventManager.addConcertEvent("aConcert",5,0.5,l1,d1,10,aList);
        eventManager.addGalaEvent("aConcert",5,5,l1,d1,5,aList);
        FilterResult filter = new FilterResult(eventManager.getHostedEvents());
        filter.filterPrice(0,10);
        filter.filterLocation(l1);
       int profit = eventManager.getProfit(filter);
       int vipNum = eventManager.getVipNum(filter);
       System.out.println(profit);
       System.out.println(vipNum);
    }
}
