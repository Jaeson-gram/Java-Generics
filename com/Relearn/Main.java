package com.Relearn;

interface Player{
    String name(); // our records implement this method by default, simply because we have a parameter for that. It is created automatically! So no errors
}
record BaseballPlayer(String name, String position) implements Player{}
record FootballPlayer(String name, String position) implements Player{}
record VolleyPlayer(String name, String position) implements Player{}

public class Main {

    public static void main(String[] args) {
	// write your code here

        BaseballTeam Celtic = new BaseballTeam("Celtic FC");
        BaseballTeam Porto = new BaseballTeam("Porto FC");
        scoreResult(Celtic, 4, Porto, 2);

        //Add team members
        var harper = new BaseballPlayer("Harper", "Midfielder");
        var Marley = new BaseballPlayer("Marley", "Winger");
        Celtic.addTeamMember(harper);
        Celtic.addTeamMember(Marley);

        //Print the team member list
        Celtic.listTeamMembers();

        /*
            If we want to create a new team, say a Baseball team, we have to keep copying and pasting our class. And do so for as many teams as we
            want to create. This is very time-consuming. Another option is to create an interface called player, then make the 'FootballPlayer' record
            implement it, or any kind of player record we wish to create. That way, we can add football players a class which we create to accept PLAYERs,
            and not have to create a new team class whenever we want to have a new team. We can just name the team, then add the type of players in it.
            So a BaseBall Team will just be a SportsTeam with only baseball players. Which is just a copy of our Football team, but accepts 'Player' and
            not just FootballPlayer, or BaseBallPlayer

            Look below for our new class, SportsTeam.
         */

        //Creating football teams..
        SportsTeam Arsenal = new SportsTeam("Arsenal FC");
        SportsTeam ManCity = new SportsTeam("Manchester City FC");
        scoreResult(Arsenal, 4, ManCity, 2);

        System.out.println();

        //creating a new football team and players
        SportsTeam AFC = new SportsTeam("Arsenal FC");
        var Ode = new FootballPlayer("Martin Odegaard", "Midfielder (AM/CM)");
        var saka = new FootballPlayer("Bukayo saka", "Left Winger");
        var nelli = new FootballPlayer("Gabriel Martinelli", "Right Winger");
        var rambo = new FootballPlayer("Aaron Ramsdale", "Goal Keeper");
        var gabi = new FootballPlayer("Gabriel Maghalaes", "Defender (CB)");
        var jesus = new FootballPlayer("Gabriel Jesus", "Striker (CF)");
        var rice = new FootballPlayer("Declan Rice", "Midfielder (DMF)");
        var saliba = new FootballPlayer("William Saliba", "Defender (CB)");
        var benny = new FootballPlayer("Ben White", "Defender (RB)");
        var zin = new FootballPlayer("Oleksander Zinchenko", "Defender (LB)");
        var partey = new FootballPlayer("Thomas Partey", "Midfielder (DMF)");
        var tomi = new FootballPlayer("Tomiyasu", "Defender (RB/LB)");
        var vieira = new FootballPlayer("Fabio Vieira", "Midfieler (AM)");
        var havertz = new FootballPlayer("Kai Havertz", "Midfieler (CM/F9)");
        var raya = new FootballPlayer("David Raya", "Goal Keeper");

        //adding team members to a football team
        AFC.addTeamMember(rambo);
        AFC.addTeamMember(Ode);
        AFC.addTeamMember(saka);
        AFC.addTeamMember(gabi);
        AFC.addTeamMember(nelli);
        AFC.addTeamMember(havertz);
        AFC.addTeamMember(raya);
        AFC.addTeamMember(jesus);
        AFC.addTeamMember(vieira);
        AFC.addTeamMember(partey);
        AFC.addTeamMember(tomi);
        AFC.addTeamMember(rice);
        AFC.addTeamMember(saliba);
        AFC.addTeamMember(zin);
        AFC.addTeamMember(benny);

        //Print the team member list
        AFC.listTeamMembers();

        AFC.addTeamMember(harper); // a baseball player

        /*
        Our issue is that we can add any Player, even a baseball player, to a football team.
        So we still have an issue with this approach. Our Solution? Generics!
         */

        System.out.println("--------- Generic Class ------------");

        Affiliation PH = new Affiliation("Port Harcourt City (PHC)", " City", " 510100");

        Team<BaseballPlayer, Affiliation> buffalos = new Team<>("Buffalos FC", PH);
        Team<BaseballPlayer, Affiliation> sharks = new Team<>("Young Sharks FC", PH);
        scoreResult(buffalos, 4, sharks, 2);

        var gareth = new BaseballPlayer("Gareth B", "Midfield");
        var ron = new BaseballPlayer("Ron B", "Midfield");
        var thereek = new BaseballPlayer("Mario Tee", "Midfield");
        var bale = new FootballPlayer("G Bale", "Right Winger");
        //sharks.addTeamMember(bale); // now this throws an error, because we have specified that our Team 'sharks' is a Team of 'Baseball Players' -> Generics
        buffalos.addTeamMember(gareth); //this one works
        buffalos.addTeamMember(thereek);
        buffalos.addTeamMember(ron);

        buffalos.listTeamMembers();




    }



    public static void scoreResult(BaseballTeam team1, int team1_sScore, BaseballTeam team2, int team2_sScore){
        String message = team1.setScore(team1_sScore, team2_sScore); //sets the score for team 1, assigns the result to a value
        team2.setScore(team2_sScore, team1_sScore); //sets the score for team 2. We are interested in the home team's message in our final output
        System.out.printf("%s %s %s %n", team1, message, team2); // Celtic ... Porto
    }

    public static void scoreResult(SportsTeam team1, int team1_sScore, SportsTeam team2, int team2_sScore){
        String message = team1.setScore(team1_sScore, team2_sScore); //sets the score for team 1, assigns the result to a value
        team2.setScore(team2_sScore, team1_sScore); //sets the score for team 2. We are interested in the home team's message in our final output
        System.out.printf("%s %s %s %n", team1, message, team2); // Celtic ... Porto
    }

    public static void scoreResult(Team<BaseballPlayer, Affiliation> team1, int team1_sScore, Team<BaseballPlayer, Affiliation> team2, int team2_sScore){
        String message = team1.setScore(team1_sScore, team2_sScore); //sets the score for team 1, assigns the result to a value
        team2.setScore(team2_sScore, team1_sScore); //sets the score for team 2. We are interested in the home team's message in our final output
        System.out.printf("%s %s %s %n", team1, message, team2); // Celtic ... Porto
    }
}
