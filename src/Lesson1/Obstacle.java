package Lesson1;

public abstract class Obstacle {
    public abstract void doIt(Competition competition);
}

class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competition competition) {
        competition.jump(height);
    }
}

class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competition competition) {
        competition.swim(length);
    }
}

class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competition competition) {
        competition.run(length);
    }
}

class MainCross {
    public static void main(String[] args) {
        Competition [] competition = {new Athlete1("Tony"), new Athlete2("Kevin"), new Athlete3("Bruce"), new Athlete4("Steve")};
        Obstacle[] obstacles = {new Cross(150), new Wall(8), new Water(25)};

        for (Competition c : competition) {
            for (Obstacle b : obstacles) {
                b.doIt(c);
                if (!c.isDistance()) {
                    break;
                }
            }
        }
        for (Competition c : competition) {
            c.info();
        }
    }
}
