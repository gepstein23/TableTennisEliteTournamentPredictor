import java.util.Collection;

public class CompletedTournament {
    private String name;
    private String url;
    private Collection<String> players;

    public CompletedTournament(String name, String url, Collection<String> players) {
        this.name = name;
        this.url = url;
        this.players = players;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (String player : players) {
            builder.append(player.split(", ")[0]).append(" ");
        }
        return String.format("[%s: %s]    (%s)", name, builder.toString().trim(), url);
    }
}
