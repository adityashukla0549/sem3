import java.util.Arrays;

final class ScreeningSchedule {
    private final String movieTitle;
    private final String[] showtimes;

    public ScreeningSchedule(String movieTitle, String[] showtimes) {
        this.movieTitle = movieTitle;
        if (showtimes == null) {
            this.showtimes = new String[0];
        } else {
            this.showtimes = Arrays.copyOf(showtimes, showtimes.length);
        }
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String[] getShowtimes() {
        return Arrays.copyOf(showtimes, showtimes.length);
    }

    public ScreeningSchedule withAddedShowtime(String newTime) {
        if (newTime == null || newTime.trim().isEmpty()) {
            return this;
        }

        String[] updatedShowtimes = Arrays.copyOf(showtimes, showtimes.length + 1);
        updatedShowtimes[updatedShowtimes.length - 1] = newTime;

        return new ScreeningSchedule(this.movieTitle, updatedShowtimes);
    }
}

public class Q5 {
    public static void main(String[] args) {
        String[] originalTimes = {"10:00 AM", "02:30 PM"};
        ScreeningSchedule schedule1 = new ScreeningSchedule("Inception", originalTimes);

        originalTimes[0] = "11:00 AM";
        System.out.println("Schedule 1 First Showtime: " + schedule1.getShowtimes()[0]);

        String[] retrievedTimes = schedule1.getShowtimes();
        retrievedTimes[0] = "09:00 PM";
        System.out.println("Schedule 1 First Showtime (after external change): " + schedule1.getShowtimes()[0]);

        ScreeningSchedule schedule2 = schedule1.withAddedShowtime("06:00 PM");
        System.out.println("Schedule 1 Count: " + schedule1.getShowtimes().length);
        System.out.println("Schedule 2 Count: " + schedule2.getShowtimes().length);
    }
}