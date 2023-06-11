public class TournamentMatchUp {
    private String matchHour;
    private String matchOrder;
    private String player1FullName;
    private String player2FullName;
    private String result;
    private HeadsUpResults headsUpResults;

    public TournamentMatchUp(String matchHour, String matchOrder, String player1FullName, String player2FullName, String result) {
        this.matchHour = matchHour;
        this.matchOrder = matchOrder;
        this.player1FullName = player1FullName;
        this.player2FullName = player2FullName;
        this.result = result;
    }

    public boolean isFinished() {
        return !result.equals("");
    }

    public String getMatchHour() {
        return matchHour;
    }

    public void setMatchHour(String matchHour) {
        this.matchHour = matchHour;
    }

    public String getMatchOrder() {
        return matchOrder;
    }

    public void setMatchOrder(String matchOrder) {
        this.matchOrder = matchOrder;
    }

    public String getPlayer1FullName() {
        return player1FullName;
    }

    public void setPlayer1FullName(String player1) {
        this.player1FullName = player1;
    }

    public String getPlayer2FullName() {
        return player2FullName;
    }

    public void setPlayer2FullName(String player2) {
        this.player2FullName = player2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public HeadsUpResults getHeadsUpResults() {
        return headsUpResults;
    }

    public void setHeadsUpResults(HeadsUpResults headsUpResults) {
        this.headsUpResults = headsUpResults;
    }
}
