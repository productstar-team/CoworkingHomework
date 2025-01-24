import java.util.Objects;

public class Workspace implements Comparable<Workspace> {
    private int number;
    private String type;
    private boolean isAvailable;

    public Workspace(int number, String type) {
        this.number = number;
        this.type = type;
        this.isAvailable = true; // По умолчанию рабочее место доступно
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsBooked() {
        this.isAvailable = false;
    }

    public void markAsAvailable() {
        this.isAvailable = true;
    }

    @Override
    public int compareTo(Workspace other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return "№" + number + ", тип: " + type + ", доступно: " + (isAvailable ? "да" : "нет");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workspace workspace = (Workspace) o;
        return number == workspace.number && Objects.equals(type, workspace.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, type);
    }
}