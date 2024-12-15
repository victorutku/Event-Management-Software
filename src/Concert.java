import java.time.LocalDate;
import java.util.List;

public class Concert  implements Event {
    private String artist;
    private List<Vips> aVipsList;
    private final String aName;
    private final int aProfit;
    private final Location aLocation;
    private final LocalDate aLocalDate;
    private final double aPrice;
    private int aNumTickets;
    public Concert (String pName ,int pProfit, double pPrice,Location pLocation, LocalDate pLocalDate, int pNumTickets,List<Vips> pVipList) {
        assert pLocation != null && pLocalDate != null;
        aProfit=pProfit;
        aPrice=pPrice;
        aName=pName;
        aLocation= pLocation;
        aLocalDate=pLocalDate;
        aNumTickets=pNumTickets;
        setVipList(pVipList);

    }

    public String getArtistName(){
        return artist;
    }
    public void setArtistName(String pArtistName){
        artist=pArtistName;
    }
    public List<Vips> getVipList(){
        return aVipsList;
    }
    public void setVipList(List<Vips> pVipList){
        aVipsList =pVipList;
    }

    public void setNumTickets(int pNumTickets) {
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

    public int getVipNum() {
        return aVipsList.size();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return aLocation.equals(concert.aLocation) && aLocalDate.equals(concert.aLocalDate);
    }


}
