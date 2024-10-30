public class Song {
  // Instance variables
  private String title = "Unknown";
  private String artist = "Unknown Artist";
  private String releaseYear = "Unknown Year";
  private String genre = "Unknown Genre";
  private String length = "Unknown Length";
  private String audienceImpact = "Unknown";
  private String obscenity = "Unknown";
  private String danceability = "Unknown";
  private String loudness = "Unknown";
  private String topic = "Unknown Topic";

  // Default constructor
  public Song() {}

  // Overloaded constructor
  public Song(String artist, String title, String releaseYear, String genre, String length, String audienceImpact, String obscenity, String danceability, String loudness, String topic) {
      this.artist = artist;
      this.title = title;
      this.releaseYear = releaseYear;
      this.genre = genre;
      this.length = length;
      this.audienceImpact = audienceImpact;
      this.obscenity = obscenity;
      this.danceability = danceability;
      this.loudness = loudness;
      this.topic = topic;
  }

  // toString for displaying song details
  public String toString() {
      return artist + " - " + title + " - " + releaseYear + " - " + genre + " - " + length + " - " + audienceImpact + " - " + obscenity + " - " + danceability + " - " + loudness + " - " + topic;
  }

  // Getters
  public String getTitle() {
      return title;
  }

  public String getArtist() {
      return artist;
  }

  public String getReleaseYear() {
      return releaseYear;
  }

  public String getGenre() {
      return genre;
  }

  public String getLength() {
      return length;
  }

  public String getAudienceImpact() {
      return audienceImpact;
  }

  public String getObscenity() {
      return obscenity;
  }

  public String getDanceability() {
      return danceability;
  }

  public String getLoudness() {
      return loudness;
  }

  public String getTopic() {
      return topic;
  }

  // Setters
  public void setTitle(String title) {
      this.title = title;
  }

  public void setArtist(String artist) {
      this.artist = artist;
  }

  public void setReleaseYear(String releaseYear) {
      this.releaseYear = releaseYear;
  }

  public void setGenre(String genre) {
      this.genre = genre;
  }

  public void setLength(String length) {
      this.length = length;
  }

  public void setAudienceImpact(String audienceImpact) {
      this.audienceImpact = audienceImpact;
  }

  public void setObscenity(String obscenity) {
      this.obscenity = obscenity;
  }

  public void setDanceability(String danceability) {
      this.danceability = danceability;
  }

  public void setLoudness(String loudness) {
      this.loudness = loudness;
  }

  public void setTopic(String topic) {
      this.topic = topic;
  }
}
