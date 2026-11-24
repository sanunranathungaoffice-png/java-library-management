package lms.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lms.model.LibraryItem;
import lms.model.Member;

/**
 * Service class managing library catalog items, registered members, and fee reporting.
 */
public class Library {

    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    /**
     * Adds a non-null library item to the catalog.
     *
     * @param item library item to add
     */
    public void addItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Library item cannot be null.");
        }
        items.add(item);
    }

    /**
     * Registers a non-null member in the library.
     *
     * @param member member to register
     */
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        members.add(member);
    }

    public List<LibraryItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public void listItems() {
        System.out.println("--- Items in the library ---");
        if (items.isEmpty()) {
            System.out.println("No items available.");
            return;
        }
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void listMembers() {
        System.out.println("--- Registered members ---");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void printAllLateFees(int daysLate) {
        System.out.println("--- Late fees if " + daysLate + " day(s) late ---");
        for (LibraryItem item : items) {
            System.out.printf("%s: %.2f%n", item.getTitle(), item.calculateLateFee(daysLate));
        }
    }
}
