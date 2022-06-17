package Lesson1;

public class Athletes implements Competition {

    String type;
    String name;
    int maxRun;
    int maxSwim;
    int maxJump;
    boolean Distance;

    public Athletes(String type, String name, int maxRun,
                    int maxSwim, int maxJump) {
        this.type = type;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.maxJump = maxJump;
        this.Distance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRun) {
            System.out.println(type + " " + name + " successfully finished running");
        } else {
            System.out.println(type + " " + name + " failed to finish running");
            Distance = false;
        }
    }
    @Override
    public void swim(int dist) {
        if (dist <= maxSwim) {
            System.out.println(type + " " + name + " successfully finished swimming");
        } else {
            System.out.println(type + " " + name + " failed swimming");
            Distance = false;
        }
    }
    @Override
    public void jump(int height) {
        if (height <= maxJump) {
            System.out.println(type + " " + name + " successfully overcame an obstacle");
        } else {
            System.out.println(type + " " + name + " failed to overcome an obstacle");
            Distance = false;
        }
    }
    @Override
    public boolean isDistance() {
        return Distance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " + Distance);
    }
}
