import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    public String[] getSongs() {
        // Returns a safe copy of the array containing only the added songs
        return Arrays.copyOf(this.songs, this.songCount);
    }

    // Read-only getter for the count
    public int getSongCount() {
        return this.songCount;
    }
}