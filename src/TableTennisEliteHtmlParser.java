import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class TableTennisEliteHtmlParser {
    private String url;
    private String prevHref;

    public TableTennisEliteHtmlParser(String url) {
        this.url = url;
        this.prevHref = null;
    }

    public String execute() throws IOException {
        Document document = Jsoup.connect(url).get();
        Element tournamentTable = findTournamentTable(document);
        if (tournamentTable != null) {
            prevHref = findPrevHref(document);
            return extractTournamentData(tournamentTable);
        } else {
            return null; // Table not found
        }
    }

    private Element findTournamentTable(Document document) {
        Elements tables = document.select("table");
        for (Element table : tables) {
            Elements rows = table.select("tr");
            if (rows.size() > 1) {
                Element firstRow = rows.first();
                Elements columns = firstRow.select("td");
                if (columns.size() >= 11) {
                    // Check if the first row has the expected column headers
                    if ("Number".equalsIgnoreCase(columns.get(0).text()) &&
                            //"Name".equalsIgnoreCase(columns.get(1).text()) &&
                            "1".equalsIgnoreCase(columns.get(2).text()) &&
                            "2".equalsIgnoreCase(columns.get(3).text()) &&
                            "3".equalsIgnoreCase(columns.get(4).text()) &&
                            "4".equalsIgnoreCase(columns.get(5).text()) &&
                            "5".equalsIgnoreCase(columns.get(6).text()) &&
                            "6".equalsIgnoreCase(columns.get(7).text()) &&
                            "Matches".equalsIgnoreCase(columns.get(8).text()) &&
                            "Sets".equalsIgnoreCase(columns.get(9).text()) &&
                            "Ranking".equalsIgnoreCase(columns.get(10).text())) {
                        return table;
                    }
                }
            }
        }
        return null; // Table not found
    }

    private String findPrevHref(Document document) {
        Elements prevLinks = document.select("a[rel=prev]");
        if (!prevLinks.isEmpty()) {
            Element prevLink = prevLinks.first();
            return prevLink.attr("abs:href");
        }
        return null; // Prev href not found
    }

    private String extractTournamentData(Element tournamentTable) {
        StringBuilder dataBuilder = new StringBuilder();
        Elements rows = tournamentTable.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements columns = row.select("td");
            for (Element column : columns) {
                dataBuilder.append(column.text()).append("\t");
            }
            dataBuilder.append("\n");
        }
        return dataBuilder.toString();
    }

    public String getPrevHref() {
        return prevHref;
    }
}
