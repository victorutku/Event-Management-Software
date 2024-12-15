import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilterResult {
    private  List<Event> aFilteredEvents;
    private  List<Event> aEventsList;
    public FilterResult(List<Event> pEventsList) {
        aEventsList=pEventsList;
        aFilteredEvents = new ArrayList<>();
    }
    /**
     * Filters given list according to the price range.
     * @param pMinPrice Minimum price.
     * @param pMaxPrice Maximum price.
     * @return returns a FilterResult object which contains aFilteredEvents.
     */
    public List<Event> filterPrice(int pMinPrice, int pMaxPrice) {
        List<Event> aFilterResult = new ArrayList<>();
        for (Event aEvent :aEventsList) {
            if (pMinPrice <= aEvent.getPrice() && aEvent.getPrice() <= pMaxPrice && !aFilteredEvents.contains(aEvent)) {
                aFilteredEvents.add(aEvent);
                aFilterResult=aFilteredEvents;
            }
        }
        return aFilterResult;
    }
    /**
     * Filters given list according to the preferred Location.
     * @param pLocation preferred Location.
     * @pre pLocation != null.
     * @return returns a FilterResult object which contains aFilteredEvents.
     */
    public List<Event> filterLocation(Location pLocation) {
        assert pLocation != null;
        List<Event> aFilterResult = new ArrayList<>();
        for (Event aEvent : aEventsList) {
            if (pLocation.equals(aEvent.getLocation()) && !aFilteredEvents.contains(aEvent)) {
                int index = aEventsList.indexOf(aEvent);
                aFilteredEvents.add(aEvent);
                aFilterResult=aFilteredEvents;
            }
        }
        return aFilterResult;
    }
    /**
     * Filters given list according to the preferred Date.
     * @param pPrefDate preferred Date.
     * @pre pPrefDate != null.
     * @return returns a FilterResult object which contains aFilteredEvents.
     */
    public List<Event> filterDate(LocalDate pPrefDate) {
        assert pPrefDate != null;
        List<Event> aFilterResult = new ArrayList<>();
        for (Event aEvent : aEventsList) {
            if (pPrefDate.equals(aEvent.getDate())&& !aFilteredEvents.contains(aEvent)) {
                aFilteredEvents.add(aEvent);
                aFilterResult=aFilteredEvents;
            }
        }
        return aFilterResult;
    }
    /**
     * Filters given list according to the preferred ticket number.
     * @param pPrefTicketNum preferred Ticket number.
     * @return returns a FilterResult object which contains aFilteredEvents.
     */
    public List<Event> filterNumTickets(int pPrefTicketNum) {
        List<Event> aFilterResult = new ArrayList<>();
        for (Event aEvent : aEventsList) {
            if (pPrefTicketNum == aEvent.getNumTickets()&& !aFilteredEvents.contains(aEvent)) {
                aFilteredEvents.add(aEvent);
                aFilterResult=aFilteredEvents;
            }
        }
        return aFilterResult;
    }
    /**
     * Filters given list according to the preferred name.
     * @param pPrefName preferred name.
     * @pre pPrefName!= null.
     * @return returns a FilterResult object which contains aFilteredEvents.
     */
    public List<Event> filterName(String pPrefName) {
        List<Event> aFilterResult = new ArrayList<>();
        for (Event aEvent : aEventsList) {
            if (pPrefName.equals(aEvent.getName()) && !aFilteredEvents.contains(aEvent)) {
                aFilteredEvents.add(aEvent);
                aFilterResult = aFilteredEvents;
            }
        }
        return aFilterResult;
    }
    /**
     * @return returns the expected profit of FilterResult.
     */
    public int calculateProfit() {
        int total = 0;
        for (Event aEvent : aFilteredEvents) {
            double price= aEvent.getPrice();
            int profit =aEvent.getProfitPercent();
            int ticketNum= aEvent.getNumTickets();
            total += profit*price*ticketNum;
        }
        return total;
    }
    /**
     * @return returns the number of Vips in filteredList.
     */
    public int calculateVipNum(){
        int total = 0;
        for(Event aEvent :aFilteredEvents){
            if(aEvent instanceof Gala){
                total += ((Gala) aEvent).getVipNum();
            }else if(aEvent instanceof Concert){
                total+= ((Concert) aEvent).getVipNum();
            }else if(aEvent instanceof Festival){
                total+=((Festival) aEvent).getVipNum();
            }
        }
        return total;
    }

}
