package com.Relearn;

import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalLosses;
    private int totalTies;
    private int totalWins;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(BaseballPlayer player){
        if (!teamMembers.contains(player))
            teamMembers.add(player);
    }

    public void listTeamMembers(){
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers);
    }

    public int ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if (ourScore > theirScore){
            totalWins++;
            message = "beat";
        }
        else if (ourScore == theirScore){
            totalTies++;
            message = "tied";
        }
        else{
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
//        return super.toString();
        return teamName + "(Ranked: " + ranking() + ")";
//        return teamName + "(Ranked: " + ranking() + ")\n" + "Total wins: " + totalWins + "\nTotal losses: " + totalLosses + "\nTotal ties: " + totalTies;
    }


}
