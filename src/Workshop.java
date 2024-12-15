import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Workshop implements Event {
    private List<Workshop> aPrerequisites;
    private final String aName;
    private final int aProfit;
    private final Location aLocation;
    private final LocalDate aLocalDate;
    private final double aPrice;
    private int aNumTickets;
    public Workshop (String pName, int pProfit, double pPrice, Location pLocation, LocalDate pLocalDate, int pNumTickets){
        assert pLocation != null && pLocalDate != null;
        aName=pName;
        aLocation=pLocation;
        aLocalDate=pLocalDate;
        aProfit=pProfit;
        aPrice =pPrice;
        aNumTickets=pNumTickets;
        aPrerequisites = new ArrayList<>();
    }
   public List<Workshop> getPrerequisites(){
       return aPrerequisites;
   }

    public void setPrerequisites(List<Workshop> pPrerequisites) {
        aPrerequisites = pPrerequisites;
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
    public int getNumTickets() {return aNumTickets;
    }

    @Override
    public int getProfitPercent() {
        return aProfit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workshop Workshop = (Workshop) o;
        return aLocation.equals(Workshop.aLocation) && aLocalDate.equals(Workshop.aLocalDate);
    }
}
