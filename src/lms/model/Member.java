package lms.model;

/**
 * Represents a registered library member who can borrow items up to a defined limit.
 */
public class Member {

    private String memberId;
    private String name;
    private int borrowedCount;
    private final int maxBorrowLimit;

    /**
     * Creates a new library member.
     *
     * @param memberId       unique member identifier
     * @param name           full name of the member
     * @param maxBorrowLimit maximum number of items the member can borrow at once
     */
    protected Member(String memberId, String name, int maxBorrowLimit) {
        if (maxBorrowLimit <= 0) {
            throw new IllegalArgumentException("Max borrow limit must be positive.");
        }
        setMemberId(memberId);
        setName(name);
        this.maxBorrowLimit = maxBorrowLimit;
        this.borrowedCount = 0;
    }

    public String getMemberId() {
        return memberId;
    }

    public final void setMemberId(String memberId) {
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be null or blank.");
        }
        this.memberId = memberId.trim();
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.name = name.trim();
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    public boolean canBorrowMore() {
        return borrowedCount < maxBorrowLimit;
    }

    /**
     * Increments the borrowed item count if the member has not reached their limit.
     *
     * @throws IllegalStateException if the borrowing limit has already been reached
     */
    public void incrementBorrowedCount() {
        if (!canBorrowMore()) {
            throw new IllegalStateException(
                    "Member '" + name + "' has reached the maximum borrow limit of " + maxBorrowLimit + "."
            );
        }
        this.borrowedCount++;
    }

    /**
     * Decrements the borrowed item count when an item is returned.
     *
     * @throws IllegalStateException if no items are currently borrowed
     */
    public void decrementBorrowedCount() {
        if (borrowedCount <= 0) {
            throw new IllegalStateException("Borrowed count cannot be negative.");
        }
        this.borrowedCount--;
    }

    @Override
    public String toString() {
        return String.format(
                "%s{id='%s', name='%s', borrowed=%d/%d}",
                getClass().getSimpleName(),
                memberId,
                name,
                borrowedCount,
                maxBorrowLimit
        );
    }
}
