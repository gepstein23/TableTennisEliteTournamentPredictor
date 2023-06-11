import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class TableTennisTournamentPredictor {
    private static final String FIRST_TOURNAMENT_RESULTS_URL =
            "https://www.tt-series.com/1168-results-10-06-2023-afternoom-tournament-osp/";
    private Map<String, TableTennisPlayer> players;
    private Collection<CompletedTournament> completedTournaments;
    private int targetNumTourneys;

    public TableTennisTournamentPredictor(int targetNumTourneys) {
        players = new HashMap<>();
        completedTournaments = new ArrayList<>();
        this.targetNumTourneys = targetNumTourneys;
    }

    public void run() {
        try {
            scrapeTournamentData();
            // Save the new TableTennisTournamentPredictor to a new file (append a timestamp to the file name)
            String fileName = "resources/TableTennisTournamentPredictor_" + Main.getTimeStamp() + ".json";
            Main.saveTournamentPredictor(this, fileName);
            System.out.println("Saved data to " + fileName);
        } catch (IOException e) {
            System.out.println("Error scraping tournament data: " + e.getMessage());
            return;
        }
        final CommandHandler commandHandler = new CommandHandler(players);
        commandHandler.runCommands();
    }

    public void scrapeTournamentData() throws IOException {
        // TODO: Find the tournament data table from the HTML and parse it
        // TODO: Add the parsed tournament data to the program's data

        // Find the NextTournamentData URL
        System.out.println("#############################################################");
        System.out.println("#############################################################");
        System.out.println(String.format("######### Parsing %s tournaments                   #########", targetNumTourneys));
        System.out.println("#############################################################");
        System.out.println("#############################################################\n\n");
        final List<String> seenUrls = new ArrayList<>();
        String currUrl = FIRST_TOURNAMENT_RESULTS_URL;
        while (targetNumTourneys > 0) {
            if (seenUrls.contains(currUrl)) {
                return;
            }
            final TableTennisEliteHtmlParser parser = new TableTennisEliteHtmlParser(currUrl);
            final String currTournamentData = parser.execute();
            if (currTournamentData == null) {
                targetNumTourneys -= 1;
                return;
            }
            parseTournamentResults(currTournamentData, currUrl);
            seenUrls.add(currUrl);
            currUrl = parser.getPrevHref();
            targetNumTourneys -= 1;
        }
    }

    public void parseTournamentResults(String results, String currUrl) throws MalformedURLException {
        final String tournamentName = getTournamentName(currUrl);
        Map<Integer, String> playerNumberToName = new HashMap<>();
        Map<Integer, String[]> playerNumberToRowArr = new HashMap<>();
        String[] lines = results.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String[] data = lines[i].split("\t");
            Integer playerNumber = Integer.valueOf(data[0]) - 1;
            String playerName = data[1];
            playerNumberToName.put(playerNumber, playerName);
            playerNumberToRowArr.put(playerNumber, data);
            TableTennisPlayer player = players.computeIfAbsent(playerName, TableTennisPlayer::new);
            player.addTournamentParticipation(currUrl);
            if (data.length >= 11 && data[10].equals("1")) {
                player.addTournamentWin();
            }
        }

        List<List<Boolean>> seenResults = buildSeenResults();
        for (Map.Entry<Integer, String> player1Entry : playerNumberToName.entrySet()) {
            Integer player1Number = player1Entry.getKey();
            String player1Name = player1Entry.getValue();
            for (Map.Entry<Integer, String> player2Entry : playerNumberToName.entrySet()) {
                Integer player2Number = player2Entry.getKey();
                String player2Name = player2Entry.getValue();
                Boolean seen = seenResults.get(player1Number).get(player2Number);
                if (seen == null || seen) {
                    continue;
                }
                String[] player1Data = playerNumberToRowArr.get(player1Number);
                String player12MatchResult = player1Data[player2Number + 2];
                Integer setsWonPlayer1 = safeParseInt(getIntPart(player12MatchResult, 0));
                Integer setsWonPlayer2 = safeParseInt(getIntPart(player12MatchResult, 1));
                if (setsWonPlayer1 == null || setsWonPlayer2 == null || setsWonPlayer1 == -1 || setsWonPlayer2 == -1) {
                    continue;
                }
                TableTennisPlayer player1 = players.computeIfAbsent(player1Name, TableTennisPlayer::new);
                TableTennisPlayer player2 = players.computeIfAbsent(player2Name, TableTennisPlayer::new);
                addMatchData(player1, player2, setsWonPlayer1, setsWonPlayer2);
                seenResults.get(player1Number).set(player2Number, true);
                seenResults.get(player2Number).set(player1Number, true);
            }
        }
        final CompletedTournament tournament = new CompletedTournament(tournamentName, currUrl, playerNumberToName.values());
        addCompletedTournament(tournament);
        System.out.printf("Parsed %s\n", tournament);
    }

    private String getIntPart(String original, int index) {
        if (original.isBlank()) {
            return "-1";
        }
        try {
            return original.split(":|/|\\.")[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                return String.valueOf(original.charAt(index));
            } catch (Exception e2) {
                return "-1";
            }
        }
    }

    public static Integer safeParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Encountered NumberFormatException: " + e);
            return null;
        }
    }

    public static String getTournamentName(String currUrl) throws MalformedURLException {
        final URL url = new URL(currUrl);
        return "Tournament #" + url.getPath()
                .replace("-results-", " ")
                .replace("-tournament-hsc", "")
                .replace("-tournament-osp", "")
                .replace("/", "");
    }

    private void addMatchData(TableTennisPlayer player1, TableTennisPlayer player2, int setsWonPlayer1, int setsWonPlayer2) {
        player1.addMatchData(player2, setsWonPlayer1, setsWonPlayer2);
        player2.addMatchData(player1, setsWonPlayer2, setsWonPlayer1);
    }

    private static List<List<Boolean>> buildSeenResults() {
        final List<List<Boolean>> res = Arrays.asList(
                Arrays.asList(null, false, false, false, false, false),
                Arrays.asList(false, null, false, false, false, false),
                Arrays.asList(false, false, null, false, false, false),
                Arrays.asList(false, false, false, null, false, false),
                Arrays.asList(false, false, false, false, null, false),
                Arrays.asList(false, false, false, false, false, null)
        );
        return res;
    }

    public void addCompletedTournament(CompletedTournament completedTournament) {
        this.completedTournaments.add(completedTournament);
    }
}