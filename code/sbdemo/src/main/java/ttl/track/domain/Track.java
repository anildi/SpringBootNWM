package ttl.track.domain;

import java.time.Duration;
import java.time.LocalDate;

public class Track implements Comparable<Track> {
   /*
   1. Id – should be unique and of type int
2. Artist – a String
3. Album – a String
4. Duration – of type java.time.Duration. More on how to use Duration
below.
5. Date – of type java.time.LocalDate. More on how to use LocalDate below.
6. Format – can have one of the following values: CD, MP3 or OGG.
    */

   public enum Format {
      CD,
      MP3,
      OGG
   }

   private int id;

   private String artist;
   private String album;
   private Duration duration;
   private LocalDate releaseDate;
   private Format format;

   public Track(String album, String artist, Format format, Duration duration, LocalDate releaseDate) {
      this.album = album;
      this.artist = artist;
      this.format = format;
      this.duration = duration;
      this.releaseDate = releaseDate;
   }

   public String getAlbum() {
      return album;
   }

   public void setAlbum(String album) {
      this.album = album;
   }

   public LocalDate getReleaseDate() {
      return releaseDate;
   }

   public void setReleaseDate(LocalDate releaseDate) {
      this.releaseDate = releaseDate;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Duration getDuration() {
      return duration;
   }

   public void setDuration(Duration duration) {
      this.duration = duration;
   }

   public String getArtist() {
      return artist;
   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

   public Format getFormat() {
      return format;
   }

   public void setFormat(Format format) {
      this.format = format;
   }

   @Override
   public String toString() {
      return "Track{" +
            "album='" + album + '\'' +
            ", id=" + id +
            ", artist='" + artist + '\'' +
            ", duration=" + duration +
            ", releaseDate=" + releaseDate +
            ", format=" + format +
            '}';
   }

   @Override
   public int compareTo(Track o) {
      return Integer.compare(this.id, o.id);
   }
}
