import java.util.Objects;

final class Service implements  Cloneable{
    private final String title;
    private final double cost;
    private final ServiceTypes serviceTypes;

    public Service() {
        this("интернет 100мб\\сек", 300, ServiceTypes.INTERNET);
    }


    public Service(String title, double cost, ServiceTypes serviceType) {
        this.title = title;
        this.cost = cost;
        this.serviceTypes = serviceType;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }
    public ServiceTypes getServiceTypes() {
        return serviceTypes;
    }

    @Override
    public String toString() {
        if( getTitle().length() > 40 )
        {
            throw new RuntimeException("Title too long");
        }
        return "Наименование услуги: " + getTitle() + "\\" + getCost() + " р." ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Double.compare(service.cost, cost) == 0 &&
                Objects.equals(title, service.title) &&
                serviceTypes == service.serviceTypes;
    }

    @Override
    public int hashCode() {
        Double cost = getCost();
        return title.hashCode() * cost.hashCode() * serviceTypes.hashCode();
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
