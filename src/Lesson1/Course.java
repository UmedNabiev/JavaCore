package Lesson1;

public class Course {
    Obstacle[] course = new Obstacle[3];
    // —оздаем полосу преп¤тствий
    public Course(Obstacle b1, Obstacle b2, Obstacle b3) {
        course[0] = b1;
        course[1] = b2;
        course[2] = b3;
    }

    // ћетод, который просит всю команду пройти полосу преп¤тствий
    public void doIt(Team t) {
        System.out.println("\nTeam \"" + t.nameTeam + "\":\n");
        // ƒл¤ каждого участника команды
        for (Competition com : t.getTeammates()) {
            // ƒл¤ каждого преп¤тстви¤ вызываем метод его прохождени¤ текущим участником команды
            for (Obstacle b: course) {
                b.doIt(com);
            }
        }
    }
}
