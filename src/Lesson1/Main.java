package Lesson1;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Cross(200), new Water(50), new Wall(7));
        Team team = new Team("Dream Team", new Athlete1("Tony"), new Athlete2("Kevin"), new Athlete3("Bruce"), new Athlete4("Steve"));
        c.doIt(team);

        System.out.println("\nWinners:");
        team.passedTheDistance();

        System.out.println("\nResult:");
        team.showResults();
    }
}
