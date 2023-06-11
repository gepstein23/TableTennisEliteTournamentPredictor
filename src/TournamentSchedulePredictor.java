import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TournamentSchedulePredictor {
    private String tourneyUrl;
    private Map<String, TableTennisPlayer> players;

    public TournamentSchedulePredictor(String tourneyUrl, Map<String, TableTennisPlayer> players) {
        this.tourneyUrl = tourneyUrl;
        this.players = players;
    }

    public void predict() throws IOException {
        Document document;
        try {
            document = Jsoup.connect(tourneyUrl).get();
        } catch (IllegalArgumentException argumentException) {
            System.out.println("Invalid tourney URL: " + tourneyUrl);
            return;
        }
        Element scheduleTable = document.select("table").last(); // Select the first table element
        Map<String, String> playerLastNameToFullName = getPlayerLastNamesToFullNames(document.select("table").first());
        Elements rows = scheduleTable.select("tr"); // Select all rows in the table

        List<TournamentMatchUp> unfinishedMatchUps = new ArrayList<>();

        for (int i = 2; i < rows.size(); i++) { // Start from index 2 to skip the first two header rows
            Element row = rows.get(i);
            Elements columns = row.select("td");

            // Extract data from each column
            String matchHour = columns.get(0).text();
            String matchOrder = columns.get(1).text();
            String player1LastName = columns.get(2).text();
            String player2LastName = columns.get(3).text();
            String result = columns.get(4).text();

            // Create a TournamentMatchUp instance with the extracted data
            String player1FullName = playerLastNameToFullName.get(player1LastName);
            String player2FullName = playerLastNameToFullName.get(player2LastName);
            TournamentMatchUp matchUp = new TournamentMatchUp(matchHour, matchOrder, player1FullName, player2FullName, result);

            if (!matchUp.isFinished()) {
                unfinishedMatchUps.add(matchUp);
            }
        }

        performPrediction(unfinishedMatchUps, playerLastNameToFullName);
    }

    private Map<String, String> getPlayerLastNamesToFullNames(Element matchUpTable) {
        Map<String, String> lastNamesToFullNames = new HashMap<>();

        for (Element row : matchUpTable.select("tr")) {
            // Skip the header row
            if (row.select("th").size() > 0) {
                continue;
            }

            // Get the name column
            Element nameColumn = row.select("td").get(1);

            // Extract the full name
            String fullName = nameColumn.text();

            // Use regex to extract the last name
            String lastName = "";
            Pattern pattern = Pattern.compile("^(.+?),");
            Matcher matcher = pattern.matcher(fullName);
            if (matcher.find()) {
                lastName = matcher.group(1);
            }

            // Add the entry to the map
            lastNamesToFullNames.put(lastName, fullName);
        }

        return lastNamesToFullNames;
    }

    private void performPrediction(List<TournamentMatchUp> unfinishedMatchUps, Map<String, String> playerLastNameToFullName) throws IOException {
        List<HeadsUpResults> results = new ArrayList<>();
        for (TournamentMatchUp matchUp : unfinishedMatchUps) {
            String player1FullName = matchUp.getPlayer1FullName();
            String player2FullName = matchUp.getPlayer2FullName();
            TableTennisPlayer player1 = players.computeIfAbsent(player1FullName, TableTennisPlayer::new);
            TableTennisPlayer player2 = players.computeIfAbsent(player2FullName, TableTennisPlayer::new);
            HeadsUpResults player2HeadsUpResults = player1.getHeadsUpResultsForOpponent(player2);
          //  if (player2HeadsUpResults.getTotalMatchesTogether() >= 8 &&
       //             (player2HeadsUpResults.getPlayer2MatchOdds() >= 68
      //                      || player2HeadsUpResults.getPlayer2MatchOdds() <= 27)) {
                results.add(player2HeadsUpResults);
       //     }
        }
        writePredictionsToFile(results, playerLastNameToFullName);
    }

    private void writePredictionsToFile(List<HeadsUpResults> results, Map<String, String> playerLastNameToFullName) throws IOException {
        final String playerStr = getPlayerStr(playerLastNameToFullName);
        final StringBuilder builder = new StringBuilder();
        builder.append("===============================================================\n");
        builder.append("============== Table Tennis Predictions for ===================\n");
        builder.append("= ").append(tourneyUrl).append("\n");
        builder.append("= PLAYERS = \n");
        builder.append(playerStr).append("\n");
        builder.append("===============================================================\n");
        builder.append("===============================================================\n\n");
        for (HeadsUpResults headsUpResults : results) {
            TableTennisPlayer player1 = players.computeIfAbsent(headsUpResults.getPlayer1(), TableTennisPlayer::new);
            TableTennisPlayer player2 = players.computeIfAbsent(headsUpResults.getPlayer2(), TableTennisPlayer::new);
            builder.append(headsUpResults.createHeadsUpString(player1, player2));
        }
        writeStringToFile(builder.toString(), TableTennisTournamentPredictor.getTournamentName(tourneyUrl)
        .replace("https://www.tt-series.com/", "").replace("/", ""));
    }

    private String getPlayerStr(Map<String, String> playerLastNameToFullName) {
        final StringBuilder builder = new StringBuilder();
        for (String lastName : playerLastNameToFullName.keySet()) {
            builder.append(lastName).append(" ");
        }
        return builder.toString();
    }

    public static void writeStringToFile(String content, String tourneyName) throws IOException {
        final String filePath = tourneyName + "__PREDICTIONS" + Main.getTimeStamp() + ".txt";
        final File file = new File("resources/" + filePath);
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath()))) {
            writer.write(content);
        }
        System.out.printf("Saved predictions for [[%s]] to:\n         %s\n", tourneyName, filePath);
    }
}
