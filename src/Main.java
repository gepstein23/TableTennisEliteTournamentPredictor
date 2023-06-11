import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    private static final int DEFAULT_NUM_TOURNEYS = 100;

    public static void main(String[] args) throws Exception {
        final String inputFilePath = getInputFilePath(args);
        final int numTourneysToScrape = getNumTourneysToScrape(args);
        final String saveFilePath;
        final TableTennisTournamentPredictor predictor;
        if (numTourneysToScrape >= 0) {
            predictor = new TableTennisTournamentPredictor(numTourneysToScrape);
            // Save the new TableTennisTournamentPredictor to a new file (append a timestamp to the file name)
            saveFilePath = "resources/TableTennisTournamentPredictor_" + getTimeStamp() + ".json";
        } else if (inputFilePath != null) {
            predictor = loadTournamentPredictor(inputFilePath);
            saveFilePath = inputFilePath;
        } else {
            // Create or get folder called "resources" on the same level as "src"
            File resourcesFolder = new File("resources");
            if (!resourcesFolder.exists()) {
                resourcesFolder.mkdir();
            }
            // Load TableTennisTournamentPredictor from the most recently saved JSON data in the file in "resources"
            predictor = loadTournamentPredictor();
            // Save the new TableTennisTournamentPredictor to a new file (append a timestamp to the file name)
            saveFilePath = "resources/TableTennisTournamentPredictor_" + getTimeStamp() + ".json";
        }
        predictor.run();
        saveTournamentPredictor(predictor, saveFilePath);
    }

    private static int getNumTourneysToScrape(String[] args) {
        if (args.length >=1 && args[0].equals("--new")) {
            if (args.length == 1) {
                return DEFAULT_NUM_TOURNEYS;
            }
            try {
                return Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Cannot parse numTourneys: \""
                        + args[1] + "\". Using default: " + DEFAULT_NUM_TOURNEYS + ".");
                return DEFAULT_NUM_TOURNEYS;
            }
        }
        return -1;
    }

    private static String getInputFilePath(String[] args) {
        if (args.length == 2 && args[0].equals("--saveFile")) {
            return args[1];
        }
        return null;
    }

    private static TableTennisTournamentPredictor loadTournamentPredictor() {
        File resourcesFolder = new File("resources");

        // Get all the files in the "resources" folder
        File[] files = resourcesFolder.listFiles();

        // Sort the files by last modified timestamp in descending order
        Arrays.sort(files, (f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()));

        // Find the first JSON file and load the TableTennisTournamentPredictor from it
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".json")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    TableTennisTournamentPredictor predictor = new Gson().fromJson(reader, TableTennisTournamentPredictor.class);
                    reader.close();
                    return predictor;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // If no JSON file is found, return a new instance of TableTennisTournamentPredictor
        return new TableTennisTournamentPredictor(DEFAULT_NUM_TOURNEYS);
    }

    private static TableTennisTournamentPredictor loadTournamentPredictor(String inputFilePath) throws Exception {
        File file = new File(inputFilePath);
        if (!file.isFile() || !file.getName().endsWith(".json")) {
            throw new Exception("Invalid inputFilePath");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        TableTennisTournamentPredictor predictor = new Gson().fromJson(reader, TableTennisTournamentPredictor.class);
        reader.close();
        return predictor;
    }

    public static void saveTournamentPredictor(TableTennisTournamentPredictor predictor, String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(fileName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(predictor, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTimeStamp() {
        // Get the current timestamp
        Date now = new Date();
        return String.valueOf(now.getTime());
    }
}
