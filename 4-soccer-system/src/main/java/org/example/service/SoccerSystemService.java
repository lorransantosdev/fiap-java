package org.example.service;

import org.example.model.Game;
import org.example.model.Player;
import org.example.model.Team;
import org.example.repository.Impl.SoccerSystemRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SoccerSystemService {

    private Scanner scanner = new Scanner(System.in);

    private final SoccerSystemRepositoryImpl repository;

    public SoccerSystemService(SoccerSystemRepositoryImpl repository) { this.repository = repository; }

    public void menu() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Soccer System Menu ---");
            System.out.println("1. Register Team");
            System.out.println("2. Register Player");
            System.out.println("3. Register Match");
            System.out.println("4. Show Classification");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerTeam();
                    break;
                case 2:
                    registerPlayer();
                    break;
                case 3:
                    registerMatch();
                    break;
                case 4:
                    showClassification();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void registerTeam() {
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        Team team = new Team(name, city);
        repository.save(team);

        System.out.println("Team registered successfully!");
    }

    private void registerPlayer() {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        Team team = repository.findTeamByName(teamName);

        if (team == null) {
            System.out.println("Team not found.");
            return;
        }

        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        System.out.print("Enter player age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter player position: ");
        String position = scanner.nextLine();
        System.out.print("Enter shirt number: ");
        int shirt = scanner.nextInt();
        scanner.nextLine();

        Player player = new Player(name, age, position, shirt);
        team.addPlayer(player);

        System.out.println("Player registered successfully!");
    }

    private void registerMatch() {
        System.out.print("Enter home team name: ");
        String homeName = scanner.nextLine();
        Team homeTeam = repository.findTeamByName(homeName);

        System.out.print("Enter visitor team name: ");
        String visitorName = scanner.nextLine();
        Team visitorTeam = repository.findTeamByName(visitorName);

        if (homeTeam == null || visitorTeam == null) {
            System.out.println("One or both teams not found.");
            return;
        }

        System.out.print("Enter home team goals: ");
        int homeGoals = scanner.nextInt();
        System.out.print("Enter visitor team goals: ");
        int visitorGoals = scanner.nextInt();
        scanner.nextLine();

        Game game = new Game(homeTeam, visitorTeam, homeGoals, visitorGoals);
        repository.save(game);

        if (homeGoals > visitorGoals) {
            homeTeam.setScore(homeTeam.getScore() + 3);
        } else if (visitorGoals > homeGoals) {
            visitorTeam.setScore(visitorTeam.getScore() + 3);
        } else {
            homeTeam.setScore(homeTeam.getScore() + 1);
            visitorTeam.setScore(visitorTeam.getScore() + 1);
        }

        System.out.println("Match registered successfully!");
    }

    private void showClassification() {
        List<Team> teams = repository.getTeams();
        teams.sort(Comparator.comparing(Team::getScore).reversed());

        System.out.println("\n--- Classification Table ---");
        for (Team team : teams) {
            System.out.println(team.getName() + " - " + team.getScore() + " points");
        }
    }

}
