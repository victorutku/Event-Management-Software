import java.time.LocalDate;

/*
Representation of a type of Event that can exist
 */
public interface Event {
    public static Event NULL = new Event(){
        public String getName(){return null;}
        public Location getLocation(){return null;}
        public LocalDate getDate(){return null;}
        public double getPrice(){return 0;}
        public int getNumTickets(){return 0;}
        public int getProfitPercent(){return 0;}
    };
    public String getName();
    public Location getLocation();
    public LocalDate getDate();
    public double getPrice();
    public int getNumTickets();
    public int getProfitPercent();


}
