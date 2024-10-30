import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // List to store song data
        ArrayList<Song> songList;

        // Import songs from CSV file through SongImporter
        songList = SongImporter.loadSongsFromCSV("songs.csv");

        // Initialize counters and tracking variables
        int count1982 = 0;
        int count1998 = 0;
        int count2011 = 0;
        int highDanceabilityCount = 0;
        int maxSongLength = 0;
        String longestSong = "";
        double minAudienceImpact = Double.MAX_VALUE; 
        String lowImpactSong = "";
        double maxLoudness = Double.NEGATIVE_INFINITY;
        String loudestSong = "";

        // Obscenity level tracking by decade
        double[] obscenityTotalsByDecade = new double[7];
        int[] obscenityCountsByDecade = new int[7];

        // Loop through each song and analyze its data
        for (Song song : songList) {
            String year = song.getReleaseYear();
            String danceability = song.getDanceability();
            String loudness = song.getLoudness();
            String obscenity = song.getObscenity();
            String length = song.getLength();
            String audienceImpact = song.getAudienceImpact();

            // Parse the year and handle any format issues
            try {
                int releaseYear = Integer.parseInt(year);

                // Count songs by specific years
                if (releaseYear == 1982) {
                    count1982++;
                } else if (releaseYear == 1998) {
                    count1998++;
                } else if (releaseYear == 2011) {
                    count2011++;
                }

                // Count songs with high danceability
                if (Double.parseDouble(danceability) > 0.75) {
                    highDanceabilityCount++;
                }

                // Track the song with the longest length
                int songLength = Integer.parseInt(length);
                if (songLength > maxSongLength) {
                    maxSongLength = songLength;
                    longestSong = song.getTitle();
                }

                // Track the song with the lowest audience impact
                double impactScore = Double.parseDouble(audienceImpact);
                if (impactScore < minAudienceImpact) {
                    minAudienceImpact = impactScore;
                    lowImpactSong = song.getTitle();
                }

                // Track the loudest song
                double songLoudness = Double.parseDouble(loudness);
                if (songLoudness > maxLoudness) {
                    maxLoudness = songLoudness;
                    loudestSong = song.getTitle();
                }

                // Calculate average obscenity level by decade
                int decadeIndex = (releaseYear / 10) - 195; 
                if (decadeIndex >= 0 && decadeIndex < 7) { 
                    obscenityTotalsByDecade[decadeIndex] += Double.parseDouble(obscenity);
                    obscenityCountsByDecade[decadeIndex]++;
                }

            } catch (NumberFormatException e) {
                System.out.println("Data format issue in song: " + song.getTitle());
            }
        }

        // Print summary statistics
        System.out.println("Total songs: " + songList.size());
        System.out.println("Songs from 1982: " + count1982);
        System.out.println("Songs from 1998: " + count1998);
        System.out.println("Songs from 2011: " + count2011);
        System.out.println("High danceability songs (> 0.75): " + highDanceabilityCount);
        System.out.println("Longest song: " + longestSong + " (Length: " + maxSongLength + ")");
        System.out.println("Lowest audience impact song: " + lowImpactSong + " (Impact Score: " + minAudienceImpact + ")");
        System.out.println("Loudest song: " + loudestSong + " (Loudness: " + maxLoudness + ")");

        // Print average obscenity levels by decade
        String[] decades = {"1950-1959", "1960-1969", "1970-1979", "1980-1989", "1990-1999", "2000-2009", "2010-2019"};
        for (int i = 0; i < decades.length; i++) {
            if (obscenityCountsByDecade[i] > 0) {
                double avgObscenity = obscenityTotalsByDecade[i] / obscenityCountsByDecade[i];
                System.out.printf("Average obscenity for %s: %.2f%n", decades[i], avgObscenity);
            } else {
                System.out.printf("No data for %s.%n", decades[i]);
            }
        }
    }
}
