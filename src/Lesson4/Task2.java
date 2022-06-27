package Lesson4;

public class Task2 {
    public static void main(String[] args){
        System.out.println("Create phonebook");
        Phonebook phonebook = new Phonebook();
        System.out.println("-----------------");

        System.out.println("Entering names into phonebook");
        phonebook.add("Sergeev", "145632");
        phonebook.add("Valiev", "123654");
        phonebook.add("Aldo", "147852");
        phonebook.add("Fiziev", "258963");
        phonebook.add("Valiev", "369852");
        System.out.println("-----------------");

        System.out.println("Receiving numbers");
        System.out.println("Valiev");
        System.out.println(phonebook.get("Valiev"));
        System.out.println("Valiev");
        System.out.println(phonebook.get("Valiev"));
        System.out.println("Aldo");
        System.out.println(phonebook.get("Aldo"));
        System.out.println("-----------------");

        System.out.println("No data for");
        System.out.println("Carukyan");
        System.out.println(phonebook.get("Carukyan"));
        System.out.println("-----------------");

        System.out.println("Trying to write down an existing number");
        phonebook.add("Valiev", "223344");
        System.out.println("Valiev");
        System.out.println(phonebook.get("Valiev"));
    }
}
