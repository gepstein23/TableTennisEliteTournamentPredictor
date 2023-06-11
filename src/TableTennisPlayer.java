import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableTennisPlayer {
    private String name;
    private int matchesPlayed;
    private int matchesWon;
    private int setsPlayed;
    private int setsWon;
    private int tournamentsWon;

    private List<String> tournamentsPlayed;
    private Map<String, HeadsUpResults> opponentNameToHeadsUpResults;

    public TableTennisPlayer(String name) {
        this.name = name;
        matchesPlayed = 0;
        matchesWon = 0;
        setsPlayed = 0;
        setsWon = 0;
        opponentNameToHeadsUpResults = new HashMap<>();
        tournamentsWon = 0;
        tournamentsPlayed = new ArrayList<String>();
    }

    public HeadsUpResults getHeadsUpResultsForOpponent(TableTennisPlayer opponent) {
        return opponentNameToHeadsUpResults.getOrDefault(opponent.getName(),
                new HeadsUpResults(this.getName(), opponent.getName()));
    }

    public void addMatchData(TableTennisPlayer opponent, int newSetsWonAgainst, int newSetsLostAgainst) {
        final HeadsUpResults headsUpResults = getHeadsUpResultsForOpponent(opponent);
        headsUpResults.addNewMatch(newSetsWonAgainst, newSetsLostAgainst);
        opponentNameToHeadsUpResults.put(opponent.getName(), headsUpResults);
        setsWon += newSetsWonAgainst;
        setsPlayed += newSetsWonAgainst + newSetsLostAgainst;
        matchesPlayed += 1;
        matchesWon = newSetsWonAgainst > newSetsLostAgainst ? matchesWon + 1 : matchesWon;
    }

    public int getNumTournamentsPlayed() {
        return tournamentsPlayed.size();
    }

    public void addTournamentWin() {
        this.tournamentsWon += 1;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public int getSetsPlayed() {
        return setsPlayed;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public int getTournamentsWon() {
        return tournamentsWon;
    }

    public void addTournamentParticipation(String currUrl) {
        tournamentsPlayed.add(currUrl);
    }

    public double getMatchWinPercentage() {
        return getMatchesWon() / getMatchesPlayed() * 100;
    }

    @Override
    public String toString() {
        return String.format("|~[TableTennisPlayer]~~~~~~~~~~~~~~~~~~~~~~|\n" +
                             "| Name         = %s\n" +
                             "| Matches Won  = %s/%s (%s%%)\n" +
                             "| Sets Won     = %s/%s (%s%%)\n" +
                             "| Tourneys Won = %s/%s (%s%%)\n" +
                             "|__________________________________________|\n",
                name, matchesWon, matchesPlayed, getPercentSafe(matchesWon, matchesPlayed), setsWon, setsPlayed,
                getPercentSafe(setsWon, setsPlayed),
                tournamentsWon, tournamentsPlayed.size(), getPercentSafe(tournamentsWon, tournamentsPlayed.size()));
    }

    private String getPercentSafe(int num, int total) {
        return total == 0 ? "NaN" : String.valueOf((float) num / (float) total * 100);
    }
}
