import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SongImporter {
    // Load songs from a CSV file into an ArrayList of Song objects
    public static ArrayList<Song> loadSongsFromCSV(String filename) {
        ArrayList<Song> songList = new ArrayList<>();
        int lineNumber = 0;

        try {
            // Open the CSV file
            File file = new File(filename);
            Scanner csvReader = new Scanner(file);

            // Skip the header line
            String header = csvReader.nextLine();
            System.out.println("CSV Header: " + header);

            // Process each line in the CSV file
            while (csvReader.hasNextLine()) {
                lineNumber++;
                String line = csvReader.nextLine();
                String[] fields = line.split(",");

                // Extract each field
                String artist = fields[0];
                String title = fields[1];
                String releaseYear = fields[2];
                String genre = fields[3];
                String length = fields[4];
                String audienceImpact = fields[5];
                String obscenity = fields[6];
                String danceability = fields[7];
                String loudness = fields[8];
                String topic = fields[9];

                // Create a new Song object and add it to the list
                Song song = new Song(artist, title, releaseYear, genre, length, audienceImpact, obscenity, danceability, loudness, topic);
                songList.add(song);
            }

            // Close the scanner after reading
            csvReader.close();

        } catch (Exception ex) {
            // Handle any errors and show the line number
            System.out.println("Error on line: " + lineNumber);
            ex.printStackTrace();
        }

        // Return the list of songs
        return songList;
    }
}
