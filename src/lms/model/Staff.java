package lms.model;

/**
 * Represents a staff member with an extended borrowing limit of 10 items.
 */
public class Staff extends Member {

    private static final int STAFF_BORROW_LIMIT = 10;

    public Staff(String memberId, String name) {
        super(memberId, name, STAFF_BORROW_LIMIT);
    }
}
