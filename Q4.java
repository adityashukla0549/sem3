class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}

public class Q4 {
    public static void main(String[] args) {
        MovieBookingProfile p1 = new MovieBookingProfile("Rahul Dev");
        System.out.println("Name: " + p1.getName());

        p1.setConfirmed(true);
        System.out.println("Confirmed: " + p1.isConfirmed());

        p1.setOtp("4471");
    }
}