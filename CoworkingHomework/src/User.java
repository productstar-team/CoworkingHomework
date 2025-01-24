import java.util.TreeSet;
import java.util.UUID;

public class User implements Comparable<User> {
    private UUID id;
    private String name;
    private String surname;
    private TreeSet<Workspace> bookedWorkspaces;

    public User(String name, String surname) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.bookedWorkspaces = new TreeSet<>();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void bookWorkspace(Workspace workspace) {
        bookedWorkspaces.add(workspace);
    }

    public void cancelBooking(Workspace workspace) {
        bookedWorkspaces.remove(workspace);
    }

    public TreeSet<Workspace> getBookedWorkspaces() {
        return bookedWorkspaces;
    }

    @Override
    public int compareTo(User other) {
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) return surnameComparison;
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return surname + " " + name + " (ID: " + id + ")";
    }
}