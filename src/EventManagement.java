import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement {
    private String aName;
    private List<Event> aHostedEvents = new ArrayList<Event>();
    public EventManagement(String pName) {
        aName=pName;
    }


    /**
     * Method to host a new concert event
     * @param pName name.
     * @param pPrice price.
     * @param pLocation location.
     * @param pLocalDate date.
     * @param pNumTickets ticket num.
     * @param pVipList vip list
     *@pre pDate !=null.
     *@pre pLocation != null
     */
    public void addConcertEvent(String pName, int pProfit, double pPrice, Location pLocation, LocalDate pLocalDate, int pNumTickets,List<Vips> pVipList) {
        assert pLocation != null && pLocalDate !=null;
        Concert aConcertEvent = new Concert(pName,pProfit,pPrice,pLocation,pLocalDate,pNumTickets,pVipList);
        for(Event aEvent :aHostedEvents) {
            if (aEvent.getLocation().equals(pLocation) && aEvent.getDate().equals(pLocalDate)) {
                System.out.println("Event with same date and location already exists");
                return;
            }
        }
        aHostedEvents.add(aConcertEvent);
    }


    /**
     *  Method to host a new Gala event
     * @param pName name.
     * @param pPrice price.
     * @param pLocation location.
     * @param pLocalDate date.
     * @param pNumTickets ticket num.
     * @param pVipList vip list
     *@pre pDate !=null.
     *@pre pLocation != null
     */
    public void addGalaEvent(String pName, int pProfit, int pPrice, Location pLocation, LocalDate pLocalDate, int pNumTickets,List<Vips> pVipList) {
        assert pLocation != null && pLocalDate !=null;
        Gala aGalaEvent = new Gala(pName,pProfit,pPrice,pLocation,pLocalDate,pNumTickets,pVipList);
        for(Event aEvent :aHostedEvents){
            if(aEvent.getLocation().equals(pLocation) && aEvent.getDate().equals(pLocalDate)){
                System.out.println("Event with same date and location already exists");
                return;
            }
        }
        aHostedEvents.add(aGalaEvent);
    }


    /**
     *  Method to host a new Screening event
     * @param pName name.
     * @param pPrice price.
     * @param pLocation location.
     * @param pLocalDate date.
     * @param pNumTickets ticket num.
     * @pre pDate !=null.
     * @pre pLocation != null
     */
    public void addScreeningEvent(String pName, int pProfit, int pPrice, Location pLocation, LocalDate pLocalDate, int pNumTickets) {
        assert pLocation != null && pLocalDate !=null;
        Screening aScreeningEvent = new Screening(pName,pProfit,pPrice,pLocation,pLocalDate,pNumTickets);
        for(Event aEvent :aHostedEvents){
            if(aEvent.getLocation().equals(pLocation) && aEvent.getDate().equals(pLocalDate)){
                System.out.println("Event with same date and location already exists");
                return;
            }
        }
        aHostedEvents.add(aScreeningEvent);
    }

    /*
    Method to host a new Workshop event
     */
    /**
     *   Method to host a new Workshop event
     * @param pName name.
     * @param pPrice price.
     * @param pLocation location.
     * @param pLocalDate date.
     * @param pNumTickets ticket num.
     * @pre pDate !=null.
     * @pre pLocation != null
     */
    public void addWorkshopEvent(String pName, int pProfit, int pPrice, Location pLocation, LocalDate pLocalDate, int pNumTickets) {
        assert pLocation != null && pLocalDate !=null;
        Workshop aWorkShopEvent = new Workshop(pName,pProfit,pPrice,pLocation,pLocalDate,pNumTickets);
        for(Event aEvent :aHostedEvents){
            if(aEvent.getLocation().equals(pLocation) && aEvent.getDate().equals(pLocalDate)){
                System.out.println("Event with same date and location already exists");
                return;
            }
        }
        aHostedEvents.add(aWorkShopEvent);
    }
    /**
     *   Method to host a new Festival event
     * @param pName name.
     * @param pList event list
     */
    public void addFestivalEvent(String pName, List<Event> pList) {
        Festival aFestival = new Festival(pName,pList);
        aHostedEvents.add(aFestival);
    }
    /**
     *   Method to host a new ComingSoon event
     * @param pName name.
     * @param pDate date.
     * @pre pDate !=null.
     */
    public void addComingSoonEvent(String pName, LocalDate pDate){
        assert pDate !=null;
        ComingSoon aEvent = new ComingSoon(pName,pDate);
        aHostedEvents.add(aEvent);
    }
    public int getProfit(FilterResult pFilterResult){
        assert pFilterResult != null;
        return pFilterResult.calculateProfit();
    }
    public int getVipNum(FilterResult pFilterResult){
        assert pFilterResult != null;
        return pFilterResult.calculateVipNum();
    }



    /*
        Return the list of hosted events on EventBrite.
        This method assumes that Events are immutable.
         */
    public ArrayList<Event> getHostedEvents() {
        return new ArrayList<Event>(aHostedEvents);
    }

}
