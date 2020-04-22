public class IndividualAccount extends AbstractAccount implements Account{

    public IndividualAccount(long number, Person person) {
        super(number,person);
    }

    public IndividualAccount(long number, Person person, Tariff tariff) {
        super(number, person, tariff);
    }

    @Override
    public String toString() {
        return "Individual account\n" +
                "holder: "+getPerson().toString()+
                '\n'+super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode()*97*getPerson().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
