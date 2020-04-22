public abstract class AbstractAccount implements Account {
    private long number;
    private Person person;
    private Tariff tariff;

    protected AbstractAccount(long number, Person person) {
        setNumber(number);
        setPerson(person);
        Tariff tar = new IndividualsTariff();
        tar.add(new Service());
        setTariff(tar);
    }

    public AbstractAccount(long number, Person person, Tariff tariff) {
        setNumber(number);
        setPerson(person);
        setTariff(tariff);
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    public Tariff getTariff() {

        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("number:" + getNumber() + '\n');
        sb.append(getTariff().toString());
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return (int)number * tariff.getSize();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractAccount absAccount = (AbstractAccount) obj;
        return  absAccount.tariff.equals(this.tariff) &&
                absAccount.person.equals(this.person) ;
    }

}
