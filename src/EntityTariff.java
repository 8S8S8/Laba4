import List.LinkedList;

import java.util.ArrayList;

public class EntityTariff implements Tariff,Cloneable {
    private LinkedList<Service> services;

    public EntityTariff() {
        services = new LinkedList<Service>();
    }

    @Override
    public boolean add(Service service) {
        try {
            services.add(service);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Service service, int number) {
        try {
            services.add(service, number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Service get(int index) {
        return services.get(index);
    }

    @Override
    public Service get(String title) {
        for (int i = 0; i < services.getSize(); i++) {
            if (services.get(i).getTitle().equals(title)) return services.get(i);
        }
        return null;
    }

    @Override
    public boolean isContain(String title) {
        for (int i = 0; i < services.getSize(); i++) {
            if (services.get(i).getTitle().equals(title)) return true;
        }
        return false;
    }

    @Override
    public Service set(int index, Service service) {
        Service forReturn = services.get(index);
        services.set(service, index);
        return forReturn;
    }

    @Override
    public Service delete(int index) {
        Service forReturn = services.get(index);
        services.delete(index);
        return forReturn;
    }

    @Override
    public int getSize() {
        return services.getSize();
    }

    @Override
    public Service[] getServices() {
        Service[] services = new Service[this.services.getSize()];
        for (int i = 0; i < services.length; i++) {
            services[i] = this.services.get(i);
        }
        return services;
    }

    @Override
    public Service[] SortedServicesByCost() {
        Service[] newServices = getServices();
        for (int i = 0; i < newServices.length; i++) {
            for (int j = 0; j < newServices.length - 1; j++) {
                if (newServices[j].getCost() > newServices[j + 1].getCost()) {
                    Service C = newServices[j];
                    newServices[j] = newServices[j + 1];
                    newServices[j + 1] = C;
                }
            }
        }
        return newServices;
    }

    @Override
    public double cost() {
        double cost = 50;
        Service[] newService = getServices();
        for (int i = 0; i < newService.length; i++) {
            cost += newService[i].getCost();
        }
        return cost;
    }

    public Service[] getTypedServices(ServiceTypes serviceTypes) {
        ArrayList<Service> list = new ArrayList<Service>();
        for (int i = 0; i < services.getSize(); i++) {
            if (services.get(i) != null && services.get(i).getServiceTypes().equals(serviceTypes)) {
                list.add(services.get(i));
            }
        }
        return (Service[]) list.toArray();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("services: \n");
        for (int i = 0; i < services.getSize(); i++) {
            sb.append(services.get(i).toString()).append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EntityTariff that = (EntityTariff) obj;
        boolean answer = that.getSize() == this.getSize();
        if (answer) {
            for (int i = 0; i < getSize(); i++) {
                answer &= (that.getServices()[i].equals(this.getServices()[i]));
            }
        }
        return answer;
    }

    @Override
    public int hashCode() {
        int hash = 71;
        for (int i = 0; i < services.getSize(); i++) {
            hash *= services.get(i).hashCode();
        }
        return hash;
    }

    @Override
    public Tariff clone() throws CloneNotSupportedException{
        return (Tariff) super.clone();
    }

    @Override
    public boolean delete(Service service) {
        for(int i = 0; i<services.getSize();i++){
            if(services.get(i).equals(service)){
                services.delete(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Service service) {
        return services.indexOf(service);
    }

    @Override
    public int lastIndexOf(Service service) {
        return services.lastIndexOf(service);
    }
}
