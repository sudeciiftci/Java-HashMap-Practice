import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Comparator;

public class GameTournamentManager {

public static void main(String[] args) {
    LinkedHashSet<String> players = new LinkedHashSet<>();
    LinkedHashSet<String> tournamentPlayers = new LinkedHashSet<>();
    HashMap<String, Integer> playerScores = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    int option = 0;
    while (option != 9) {
        System.out.println("""
                
                ===== Game Tournament Manager =====
                1. Register Player
                2. Remove Player
                3. Display All Players
                4. Add Player to Tournament
                5. Display Tournament Players
                6. Update Player Score
                7. Display Player Scores
                8. Display Leaderboard
                9. Exit
                Choose an option:
                """);
        option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                System.out.println("Register Player:");
                String player = scanner.nextLine();
                if (players.contains(player)) {
                    System.out.println("This player already exists.");
                    break;
                }
                players.add(player);
                System.out.println("Player registered successfully.");
                break;
            case 2:
                System.out.println("Remove Player:");
                String removerPlayer = scanner.nextLine();
                if (!players.contains(removerPlayer)) {
                    System.out.println("Player not found.");
                    break;
                }
                players.remove(removerPlayer);
                tournamentPlayers.remove(removerPlayer);
                playerScores.remove(removerPlayer);
                System.out.println("Player removed successfully.");
                break;
            case 3:
                System.out.println("===== Registered Players =====");
                if (players.isEmpty()) {
                    System.out.println("No players registered.");
                    break;
                }
                for (String p : players) {
                    System.out.println(p);
                }
                break;
            case 4:
                System.out.println("Add Player to Tournament:");
                String tournamentPlayer = scanner.nextLine();
                if (!players.contains(tournamentPlayer)) {
                    System.out.println("Player is not registered.");
                    break;
                }
                if (tournamentPlayers.contains(tournamentPlayer)) {
                    System.out.println("Player is already in the tournament.");
                    break;
                }
                tournamentPlayers.add(tournamentPlayer);
                System.out.println("Player added to tournament.");
                break;
            case 5:
                System.out.println("===== Tournament Players =====");
                if (tournamentPlayers.isEmpty()) {
                    System.out.println("No players in the tournament.");
                    break;
                }
                for (String p : tournamentPlayers) {
                    System.out.println(p);
                }
                break;
            case 6:
                System.out.println("Enter player name:");
                player = scanner.nextLine();
                if (!players.contains(player)) {
                    System.out.println("Player not found.");
                    break;
                }
                System.out.println("Enter new score:");
                int score = scanner.nextInt();
                scanner.nextLine();
                playerScores.put(player, score);
                System.out.println("Player score updated successfully.");
                break;
            case 7:
                System.out.println("===== Player Scores =====");
                if (playerScores.isEmpty()) {
                    System.out.println("No player scores available.");
                    break;
                }
                for (Map.Entry<String, Integer> entry : playerScores.entrySet()) {
                    System.out.println(
                        entry.getKey() + ": " + entry.getValue() + " points"
                    );
                }
                break;
            case 8:
                System.out.println("===== Leaderboard =====");
                if (playerScores.isEmpty()) {
                    System.out.println("No player scores available.");
                    break;
                }
                ArrayList<Map.Entry<String, Integer>> leaderboard =
                        new ArrayList<>(playerScores.entrySet());
                leaderboard.sort(
                    Comparator.comparing(
                        Map.Entry<String, Integer>::getValue
                    ).reversed()
                );
                int rank = 1;
                for (Map.Entry<String, Integer> entry : leaderboard) {
                    System.out.println(
                        rank + ". " + entry.getKey()
                        + " - " + entry.getValue() + " points"
                    );
                    rank++;
                }
                break;
            case 9:
                System.out.println("Exiting Game Tournament Manager...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    scanner.close();
}

}