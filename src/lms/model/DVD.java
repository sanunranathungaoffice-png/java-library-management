package lms.model;

/**
 * Represents a DVD item in the library system with a custom late fee rate.
 */
public class DVD extends LibraryItem {

    private static final double DVD_DAILY_LATE_FEE = 25.0;

    private int durationMinutes;

    /**
     * Creates a new DVD instance.
     *
     * @param itemId          unique identifier for the DVD
     * @param title           title of the DVD
     * @param durationMinutes length of the DVD in minutes (must be positive)
     */
    public DVD(String itemId, String title, int durationMinutes) {
        super(itemId, title);
        setDurationMinutes(durationMinutes);
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public final void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than zero.");
        }
        this.durationMinutes = durationMinutes;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        validateDaysLate(daysLate);
        return daysLate * DVD_DAILY_LATE_FEE;
    }

    @Override
    public String toString() {
        return String.format(
                "DVD{id='%s', title='%s', durationMinutes=%d, borrowed=%s}",
                getItemId(),
                getTitle(),
                durationMinutes,
                isBorrowed()
        );
    }
}
