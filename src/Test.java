import List.LinkedList;

public class Test {
    public static void lab1tests() {
        IndividualsTariff tariff = new IndividualsTariff();
        Service firstService = new Service("VIP", 500, ServiceTypes.INTERNET);
        Service secondService = new Service("Комфорт", 1200, ServiceTypes.MAIL);
        Service thirdService = new Service("Эконом", 300, ServiceTypes.PHONE);

        System.out.println(tariff);

        tariff.add(firstService, 3);
        tariff.add(secondService);
        System.out.println(tariff);


        tariff.delete(secondService.getTitle());
        //tariff.delete(3);
        System.out.println(tariff);

        tariff.add(thirdService, 7);
        tariff.trim();
        System.out.println(tariff);
    }

    public static void listTest() {
        LinkedList<String> list = new LinkedList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.toString());
        list.delete(2);
        System.out.println("После удаления ");
        System.out.println(list.toString());
        System.out.println(list.getSize());
        System.out.println("После добавления ");
        list.add("4", 2);
        System.out.println(list.toString());
        System.out.println(list.getSize());

    }

    public static void lab4test() {
        Person person1 = new Person("Пупкин", "Петр");
        Person person2 = new Person("Акимов", "Иван");
        System.out.println(person1 + "\n" + person2);
        System.out.println("HashCode для 1 : " + person1.hashCode() + "\n"+ "HashCode для 2 : " + person2.hashCode());
        System.out.println("Проверка на равенство : " + person1.equals(person2));

        IndividualAccount individualAccount = new IndividualAccount(2,person2);
        System.out.println(individualAccount);


    }


}
