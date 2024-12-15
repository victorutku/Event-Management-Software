import java.time.LocalDate;
import java.util.List;

public class Festival implements Event {
    private final String name;
    private final List<Event> aEventList;
    public Festival (String name, List<Event> pEventList){
        this.name=name;
        aEventList=pEventList;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public Location getLocation() {
        Event firstEvent = aEventList.get(0);
        for(Event aEvent : aEventList){
            if(!firstEvent.getLocation().equals(aEvent.getLocation())){
                return Location.Multiple;
            }
        }
        return firstEvent.getLocation();
    }

    @Override
    public LocalDate getDate() {
        Event firstEvent = aEventList.get(0);
        return firstEvent.getDate();
    }

    @Override
    public double getPrice() {
        double total = 0.0;
        for(Event aEvent : aEventList){
           total += aEvent.getPrice();
        }
        return total*20.0/100.0;
    }

    @Override
    public int getNumTickets() {
        int firstTicket = aEventList.get(0).getNumTickets();
        for(Event aEvent :aEventList) {
            if (firstTicket > aEvent.getNumTickets()) {
                firstTicket = aEvent.getNumTickets();
            }
        }
        return firstTicket;
    }

    @Override
    public int getProfitPercent() {
        int total = 0;
        for(Event aEvent : aEventList){
            total +=aEvent.getProfitPercent();
        }
        return total;
    }

    public int getVipNum() {
        int total =0;
        for(Event aEvent : aEventList) {
            if (aEvent instanceof Gala) {
                total += ((Gala) aEvent).getVipNum();
            } else if (aEvent instanceof Concert) {
                total += ((Concert) aEvent).getVipNum();
            }
        }
        return total;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festival festival= (Festival) o;
        return aEventList.equals(festival.aEventList);
    }



}
