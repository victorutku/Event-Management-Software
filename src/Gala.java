import java.time.LocalDate;
import java.util.List;

public class Gala implements Event {
    private List<Vips> aVipList ;
    private final String aName;
    private final int aProfit;
    private final Location aLocation;
    private final LocalDate aLocalDate;
    private final int aPrice;
    private int aNumTickets;
    public Gala (String pName ,int pProfit, int pPrice,Location pLocation, LocalDate pLocalDate, int pNumTickets, List<Vips> pVipList){
        aName=pName;
        aLocation=pLocation;
        aLocalDate=pLocalDate;
        aProfit=pProfit;
        aPrice=pPrice;
        aNumTickets=pNumTickets;
        setVipList(pVipList);
    }

    public List<Vips> getVipList() {
        return aVipList;
    }

    public void setVipList(List<Vips> pVips) {
        aVipList = pVips;
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

    public int getVipNum() {
        return aVipList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gala gala = (Gala) o;
        return aLocation.equals(gala.getLocation()) && aLocalDate.equals(gala.aLocalDate);
    }

}

