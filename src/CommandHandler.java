import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandHandler {

    private static final Options COMMAND_OPTIONS = new Options();
    static {
        COMMAND_OPTIONS.addOption(Option.builder("h")
                .longOpt("help")
                .desc("Print this help message")
                .build());
        COMMAND_OPTIONS.addOption(Option.builder("o")
                .longOpt("odds")
                .numberOfArgs(2)
                .desc("Calculate the odds of one player winning against another")
                .build());
        COMMAND_OPTIONS.addOption(Option.builder("w")
                .longOpt("winrate")
                .hasArg()
                .desc("Calculate the win rate of a player")
                .build());
        COMMAND_OPTIONS.addOption(Option.builder("r")
                .longOpt("rank")
                .hasArg()
                .desc("Get the rank of a player")
                .build());
        COMMAND_OPTIONS.addOption(Option.builder("m")
                .longOpt("matches")
                .hasArg()
                .desc("Get the matches of a player")
                .build());
        COMMAND_OPTIONS.addOption(Option.builder("p")
                .longOpt("predict")
                .hasArg()
                .desc("Predicts the outcomes of a linked tournament")
                .build());
        COMMAND_OPTIONS.addOption(Option.builder("e")
                .longOpt("exit")
                .hasArg()
                .desc("Exits the program")
                .build());
    }

    private Map<String,TableTennisPlayer> players;

    public CommandHandler(Map<String,TableTennisPlayer> players) {
        this.players = players;
    }

    public void runCommands() {
        System.out.printf("Parsed data for %s players, enter commands now:\n", players.size());
        final CommandLineParser parser = new DefaultParser();
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                final String inputCommand = scanner.nextLine();
                final CommandLine cmd = parser.parse(COMMAND_OPTIONS, new String[]{ inputCommand });
                if (cmd.hasOption("h")) {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("TableTennisTournamentPredictor", COMMAND_OPTIONS);
                } else if (cmd.hasOption("o")) {
                    calculateHeadsUpOdds(cmd);
                } else if (cmd.hasOption("w")) {
                    executePlayerWinRateCommand(cmd);
                } else if (cmd.hasOption("r")) {
                    executePlayerRankCommand(cmd);
                } else if (cmd.hasOption("p")) {
                    executePredictCommand(cmd);
                } else if (cmd.hasOption("m")) {
                    executePlayerMatchesCommand(cmd);
                } else if (cmd.hasOption("e")) {
                    System.out.print("Exiting program!");
                    return;
                } else {
                    System.out.println("No valid command specified. Use -h/--help for usage information.");
                }
            } catch (ParseException | IOException e) {
                System.out.println("Error parsing command line arguments: " + e.getMessage());
            }
            System.out.print("\n\n     === Next command! ===\n\n");
        }
    }

    private void executePredictCommand(CommandLine cmd) throws IOException {
        String[] tourneyLink = cmd.getOptionValues("p");
        if (tourneyLink == null || tourneyLink.length < 1) {
            System.out.print("Error parsing command\n");
            return;
        }
        final String[] urls = tourneyLink[0].trim().split("\\s");
        for (String tourneyUrl : urls) {
            String trimmedUrl = tourneyUrl.trim();
            TournamentSchedulePredictor tournamentSchedulePredictor =
                    new TournamentSchedulePredictor(trimmedUrl, players);
            tournamentSchedulePredictor.predict();
        }
    }


    public static TableTennisPlayer findPlayerByLastName(String lastName, Map<String, TableTennisPlayer> players) {
        return players.entrySet().stream().filter(entry -> entry.getKey().split(", ")[0].equals(lastName))
                .map(Map.Entry::getValue).findFirst().orElse(null);
    }

    private TableTennisPlayer getPlayerOne(String[] splitPlayers) {
        if (splitPlayers.length == 2) {
            String player1LastName = splitPlayers[0];
            return findPlayerByLastName(player1LastName, players);
        } else {
            String player1FirstName = splitPlayers[0];
            String player1LastName = splitPlayers[1];
            return players.get(player1LastName + ", " + player1FirstName);
        }
    }

    private TableTennisPlayer getPlayerTwo(String[] splitPlayers) {
        if (splitPlayers.length == 2) {
            String player2LastName = splitPlayers[1];
            return findPlayerByLastName(player2LastName, players);
        } else {
            String player2FirstName = splitPlayers[2];
            String player2LastName = splitPlayers[3];
            return  players.get(player2FirstName + ", " + player2LastName);
        }
    }


    public void calculateHeadsUpOdds(CommandLine cmd) {
        String[] inputPlayers = cmd.getOptionValues("o");
        if (inputPlayers == null || inputPlayers.length != 1) {
            System.out.print("Error parsing command\n");
            return;
        }
        String[] splitPlayers = inputPlayers[0].trim().split("\\s+");
        if (splitPlayers.length != 2 && splitPlayers.length != 4) {
            System.out.print("Unexpected number of players\n");
            return;
        }
        TableTennisPlayer player1 = getPlayerOne(splitPlayers);
        TableTennisPlayer player2 = getPlayerTwo(splitPlayers);

        String player1Name = player1.getName();
        String player2Name = player2.getName();
        if (player1 == null) {
            System.out.println("Could not find player: " + player1Name);
        }
        if (player2 == null) {
            System.out.println("Could not find player: " + player2Name);
        }
        System.out.println("====================Player 1====================");
        System.out.println(player1);
        System.out.println("====================Player 2====================");
        System.out.println(player2);
        if (player1 == null || player2 == null) {
            return;
        }
        System.out.println("====================History====================");

//        int player1MatchWins = player1.getMatchesWonAgainst(player2Name);
//        int player2MatchWins = player2.getMatchesWonAgainst(player1Name);
//        int player1SetWins = player1.getSetsWonAgainst(player2Name);
//        int player2SetWins = player2.getSetsWonAgainst(player1Name);
//        int totalMatchesTogether = player1MatchWins + player2MatchWins;
//        int totalSetsTogether = player1SetWins + player2SetWins;
//
//        double player1MatchOdds = (double) player1MatchWins / totalMatchesTogether * 100;
//        double player2MatchOdds = (double) player2MatchWins / totalMatchesTogether * 100;
//
//        double player1SetOdds = (double) player1SetWins / totalSetsTogether * 100;
//        double player2SetOdds = (double) player2SetWins / totalSetsTogether * 100;
//
//        System.out.printf("| Odds of winning match:\n", totalMatchesTogether);
//        Object player1LastName = player1Name.split(", ")[0];
//        Object player2LastName = player2Name.split(", ")[0];
//        System.out.printf("|  --%s: %s%% (%s/%s)\n", player1LastName, player1MatchOdds, player1MatchWins, totalMatchesTogether);
//        System.out.printf("|  --%s: %s%% (%s/%s)\n", player2LastName, player2MatchOdds, player2MatchWins, totalMatchesTogether);
//        System.out.printf("| Odds of winning each set:\n", totalSetsTogether);
//        System.out.printf("|  --%s: %s%% (%s/%s)\n", player1LastName, player1SetOdds, player1SetWins, totalSetsTogether);
//        System.out.printf("|  --%s: %s%% (%s/%s)\n", player2LastName, player2SetOdds, player2SetWins, totalSetsTogether);
//        System.out.println("|=====================================================");
    }

    private void executePlayerWinRateCommand(CommandLine cmd) {
        String[] inputPlayer = cmd.getOptionValues("w");
        if (inputPlayer == null || inputPlayer.length != 1) {
            System.out.print("Error parsing command\n");
            return;
        }
        String playerFullName = inputPlayer[0].trim();
        TableTennisPlayer tableTennisPlayer = players.get(playerFullName);
        if (tableTennisPlayer == null) {
            System.out.println("Could not find player: " + playerFullName);
            return;
        }
        System.out.println("=====================Player=====================");
        System.out.println(tableTennisPlayer);
    }

    private void executePlayerRankCommand(CommandLine cmd) {
        String[] inputPlayer = cmd.getOptionValues("r");
        if (inputPlayer == null || inputPlayer.length > 1) {
            System.out.print("Error parsing command\n");
            return;
        }
        Map<TableTennisPlayer, Double> playerToWinPercentage = new HashMap<>();
        for (TableTennisPlayer player : players.values()) {
            double matchWinPercentage = player.getMatchWinPercentage();
            playerToWinPercentage.put(player, matchWinPercentage);
        }
        List<TableTennisPlayer> sorted =
                playerToWinPercentage.entrySet().stream().sorted(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        if (inputPlayer.length == 0) {
            System.out.println("==================BestPlayer==================");
            TableTennisPlayer bestPlayer = sorted.get(0);
            System.out.println("Match win %: " + bestPlayer.getMatchWinPercentage());
            System.out.println("Rank: " + bestPlayer.getMatchWinPercentage());
            System.out.println("=================WorstPlayer==================");
            TableTennisPlayer worstPlayer = sorted.get(sorted.size() - 1);
            System.out.println("Match win %: " + worstPlayer.getMatchWinPercentage());
            System.out.println("Rank: " + worstPlayer.getMatchWinPercentage());

        } else {
            String playerFullName = inputPlayer[0].trim();

            TableTennisPlayer tableTennisPlayer = players.get(playerFullName);
            if (tableTennisPlayer == null) {
                System.out.println("Could not find player: " + playerFullName);
                return;
            }

            System.out.println("=================GivenPlayer==================");
            System.out.println(tableTennisPlayer);
            System.out.println("Match win %: " + tableTennisPlayer.getMatchWinPercentage());
            System.out.println("Rank: " + tableTennisPlayer.getMatchWinPercentage());
        }
    }

    private void executePlayerMatchesCommand(CommandLine commandLine) {
        // TODO: Implement player matches command
    }
}
