package lms.model;

/**
 * Abstract base class representing a borrowable item in the library.
 * Encapsulates common attributes, validation rules, and borrowing state.
 */
public abstract class LibraryItem {

    private static final double DEFAULT_DAILY_LATE_FEE = 10.0;

    private String itemId;
    private String title;
    private boolean borrowed;

    /**
     * Creates a new library item with validated ID and title.
     *
     * @param itemId unique identifier for the item
     * @param title  title of the item
     */
    protected LibraryItem(String itemId, String title) {
        setItemId(itemId);
        setTitle(title);
        this.borrowed = false;
    }

    public String getItemId() {
        return itemId;
    }

    public final void setItemId(String itemId) {
        if (itemId == null || itemId.isBlank()) {
            throw new IllegalArgumentException("Item ID cannot be null or blank.");
        }
        this.itemId = itemId.trim();
    }

    public String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }
        this.title = title.trim();
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    /**
     * Marks the item as borrowed if it is currently available.
     *
     * @throws IllegalStateException if the item is already borrowed
     */
    public void borrowItem() {
        if (borrowed) {
            throw new IllegalStateException("Item '" + title + "' is already borrowed.");
        }
        this.borrowed = true;
    }

    /**
     * Marks the item as returned if it was previously borrowed.
     *
     * @throws IllegalStateException if the item is not currently borrowed
     */
    public void returnItem() {
        if (!borrowed) {
            throw new IllegalStateException("Item '" + title + "' is not currently borrowed.");
        }
        this.borrowed = false;
    }

    /**
     * Calculates the late return fee for a given number of overdue days.
     * Subclasses can override this to provide item-specific fee rates.
     *
     * @param daysLate number of overdue days (must be non-negative)
     * @return calculated late fee amount
     */
    public double calculateLateFee(int daysLate) {
        validateDaysLate(daysLate);
        return daysLate * DEFAULT_DAILY_LATE_FEE;
    }

    protected void validateDaysLate(int daysLate) {
        if (daysLate < 0) {
            throw new IllegalArgumentException("Days late cannot be negative.");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "%s{id='%s', title='%s', borrowed=%s}",
                getClass().getSimpleName(),
                itemId,
                title,
                borrowed
        );
    }
}
