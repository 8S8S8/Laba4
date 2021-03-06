public class EntityAccount extends AbstractAccount implements Account{

    protected EntityAccount(long number, Person person) {
        super(number, person);
    }

    public EntityAccount(long number, Person person, Tariff tariff) {
        super(number, person, tariff);
    }

    @Override
    public int hashCode() {
        return 53*super.hashCode()*getPerson().getfName().hashCode();
    }

    @Override
    public String toString() {
        return "Entity account: \n"
                + "entity " + getPerson()
                + "\n" + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
