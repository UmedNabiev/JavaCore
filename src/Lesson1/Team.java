package Lesson1;

public class Team {
    String nameTeam ;

    Competition[] partner = new Competition[4];
    Athletes[] athletes = {new Athlete1("Tony"), new Athlete2("Kevin"), new Athlete3("Bruce"), new Athlete4("Steve")};

    public Team(String nameTeam, Competition com1, Competition com2, Competition com3, Competition com4 ) {
        this.nameTeam  = nameTeam;

        partner[0] = com1;
        partner[1] = com2;
        partner[2] = com3;
        partner[3] = com4;

    }

    public void passedTheDistance() {
        for (Competition com : partner) {

            if (com.isDistance()) {
                com.info();
            }
        }
    }

    public void showResults() {
        for (Competition com : partner) {
            com.info();
        }
    }

    public Competition[] getTeammates() {
        return partner;
    }
}
