import java.time.LocalDate;

public class Screening implements Event{
    private Ratings aRating;
    private final String aName;
    private final int aProfit;
    private final Location aLocation;
    private final LocalDate aLocalDate;
    private final int aPrice;
    private int aNumTickets;
    public Screening (String pName, int pProfit , int pPrice, Location pLocation, LocalDate pLocalDate,  int pNumTickets){
        assert pLocation != null && pLocalDate != null;
        aName=pName;
        aLocation=pLocation;
        aLocalDate=pLocalDate;
        aProfit=pProfit;
        aPrice =pPrice;
        aNumTickets=pNumTickets;
    }

    public void setRating(Ratings pRating){
        aRating=pRating;
    }
    public Ratings getRating(){
        return aRating;
    }

    public void setaNumTickets(int pNumTickets) {
        aNumTickets = aNumTickets;
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public Location getLocation() {
        return aLocation;
    }

    @Override
    public LocalDate getDate() {
        return aLocalDate;
    }

    @Override
    public double getPrice() {
        return aPrice;
    }

    @Override
    public int getNumTickets() {
        return aNumTickets;
    }

    @Override
    public int getProfitPercent() {
        return aProfit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return aLocation.equals(screening.aLocation) && aLocalDate.equals(screening.aLocalDate);
    }
}


