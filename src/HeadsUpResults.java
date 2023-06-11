public class HeadsUpResults {
    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    private String player1;
    private String player2;
    private int player1MatchWins;
    private int player2MatchWins;
    private int player1SetWins;
    private int player2SetWins;


    public int getPlayer1MatchWins() {
        return player1MatchWins;
    }

    public int getPlayer2MatchWins() {
        return player2MatchWins;
    }

    public int getPlayer1SetWins() {
        return player1SetWins;
    }

    public int getPlayer2SetWins() {
        return player2SetWins;
    }

    public HeadsUpResults(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1MatchWins = 0;
        this.player2MatchWins = 0;
        this.player1SetWins = 0;
        this.player2SetWins = 0;
    }

    public int getTotalMatchesTogether() {
        return player1MatchWins + player2MatchWins;
    }

    public int getTotalSetsTogether() {
        return player1SetWins + player2SetWins;
    }

    public double getPlayer1MatchOdds() {
        return (double) getPlayer1MatchWins() / getTotalMatchesTogether() * 100;
    }

    public double getPlayer2MatchOdds() {
        return (double) getPlayer2MatchWins() / getTotalMatchesTogether() * 100;
    }

    public double getPlayer1SetOdds() {
        return (double) getPlayer1SetWins() / getTotalSetsTogether() * 100;
    }

    public double getPlayer2SetOdds() {
        return (double) getPlayer2SetWins()/ getTotalSetsTogether() * 100;
    }

    public void addPlayer1SetWins(int newSetsWonAgainst) {
        player1SetWins += newSetsWonAgainst;
    }

    public void addPlayer2SetWins(int newSetsWonAgainst) {
        player2SetWins += newSetsWonAgainst;
    }

    public void addNewMatch(int player1SetWins, int player2SetWins) {
        addPlayer1SetWins(player1SetWins);
        addPlayer2SetWins(player2SetWins);
        if (player1SetWins > player2SetWins) {
            player1MatchWins += 1;
        } else {
            player2MatchWins += 1;
        }
    }

    @Override
    public String toString() {
        return toString("None", "None");
    }

    public String toString(String player1ShortDescription, String player2ShortDescription) {
        Object player1LastName = player1.split(", ")[0];
        Object player2LastName = player2.split(", ")[0];
        int totalMatchesTogether = getTotalMatchesTogether();
        int totalSetsTogether = getTotalSetsTogether();
        final StringBuilder builder = new StringBuilder();
        builder.append("|================== Heads Up ==================|\n");
        builder.append(String.format("|========                                     [%s]  vs [%s]\n", player1LastName, player2LastName));
        builder.append("|==============================================|\n");
        builder.append(player1ShortDescription);
        builder.append(player2ShortDescription);
        if (totalMatchesTogether > 0) {
            builder.append("|| Odds of winning match:\n");
            builder.append(String.format("||  -- %s: %s%% (%s/%s)\n", player1LastName, getPlayer1MatchOdds(), getPlayer1MatchWins(), totalMatchesTogether));
            builder.append(String.format("||  -- %s: %s%% (%s/%s)\n", player2LastName, getPlayer2MatchOdds(), getPlayer2MatchWins(), totalMatchesTogether));
            builder.append("|| Odds of winning each set:\n");
            builder.append(String.format("||  -- %s: %s%% (%s/%s)\n", player1LastName, getPlayer1SetOdds(), getPlayer1SetWins(), totalSetsTogether));
            builder.append(String.format("||  -- %s: %s%% (%s/%s)\n", player2LastName, getPlayer2SetOdds(), getPlayer2SetWins(), totalSetsTogether));
        } else {
            builder.append("No match history found for the 2 players.\n");
        }
        builder.append("|==============================================|\n\n\n");
        return builder.toString();
    }

    public static String createShortPlayerDescription(TableTennisPlayer player) {
        final StringBuilder builder = new StringBuilder();
        builder.append("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|\n");
        builder.append(String.format("|    %s:\n", player.getName()));
        builder.append(String.format("| - matchWins: %s/%s (%s%%)\n", player.getMatchesWon(),
                player.getMatchesPlayed(), player.getMatchesPlayed() == 0 ? "NaN" : getPercentage(player.getMatchesWon(), player.getMatchesPlayed())));
        builder.append(String.format("| - setWins: %s/%s (%s%%)\n", player.getSetsWon(),
                player.getSetsPlayed(), player.getSetsPlayed() == 0 ? "NaN" : getPercentage(player.getSetsWon(), player.getSetsPlayed())));
        builder.append(String.format("| - tourneyWins: %s/%s (%s%%)\n", player.getTournamentsWon(),
                player.getNumTournamentsPlayed(), getPercentage(player.getTournamentsWon(), player.getNumTournamentsPlayed())));
        builder.append("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|\n");
        return builder.toString();
    }

    public static float getPercentage(int won, int total) {
        final float div = (float) Integer.toUnsignedLong(won) / (float) Integer.toUnsignedLong(total);
        return div * 100;
    }

    public String createHeadsUpString(TableTennisPlayer player1, TableTennisPlayer player2) {
        return this.toString(createShortPlayerDescription(player1), createShortPlayerDescription(player2));
    }
}
