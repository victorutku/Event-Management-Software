import java.time.LocalDate;

public class ComingSoon implements Event{
    private final String aName;
    private final LocalDate aLocalDate;
    public ComingSoon (String pName, LocalDate pLocalDate) {
        assert pLocalDate != null;
        aName=pName;
        aLocalDate=pLocalDate;
    }
    @Override
    public String getName() {
        return aName;
    }

    @Override
    public Location getLocation() {
        return Event.NULL.getLocation();
    }

    @Override
    public LocalDate getDate() {
        return aLocalDate;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public int getNumTickets() {
        return 0;
    }

    @Override
    public int getProfitPercent() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComingSoon comingSoon= (ComingSoon) o;
        return aLocalDate.equals(comingSoon.aLocalDate);
    }
}
