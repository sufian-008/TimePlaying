import java.util.Scanner;
public class  ClockTime {
    private int hour;
    private int minute;
    private String amPm;

    public ClockTime(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        this.amPm = amPm;
    }

    public void advance(int minutes) {
        int totalMinutes = (hour * 60) + minute + minutes;
        int newHour = (totalMinutes / 60) % 12;
        if (newHour == 0) {
            newHour = 12;
        }
        int newMinute = totalMinutes % 60;
        if (totalMinutes >= 720) {
            amPm = amPm.equals("AM") ? "PM" : "AM";
        }
        hour = newHour;
        minute = newMinute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d %s", hour, minute, amPm);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the current time (hh:mm AM/PM): ");
        String currentTimeString = scanner.nextLine();
        String[] currentTimeParts = currentTimeString.split(":|\\s+");
        int currentHour = Integer.parseInt(currentTimeParts[0]);
        int currentMinute = Integer.parseInt(currentTimeParts[1]);
        String currentAmPm = currentTimeParts[2];

        System.out.print("Enter the number of minutes to advance: ");
        int minutesToAdvance = scanner.nextInt();

        ClockTime currentTime = new ClockTime(currentHour, currentMinute, currentAmPm);
        System.out.println("Current time: " + currentTime);

        currentTime.advance(minutesToAdvance);
        System.out.println("Time advanced by " + minutesToAdvance + " minutes: " + currentTime);
    }
}