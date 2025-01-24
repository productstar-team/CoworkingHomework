import java.util.TreeMap;
import java.util.TreeSet;

public class CoworkingSystem {
    private TreeSet<Workspace> workspaces; // Все рабочие места
    private TreeMap<User, TreeSet<Workspace>> bookings; // Бронирования

    public CoworkingSystem() {
        this.workspaces = new TreeSet<>();
        this.bookings = new TreeMap<>();
    }

    public void addWorkspace(Workspace workspace) {
        workspaces.add(workspace);
        System.out.println("Добавлено рабочее место: " + workspace);
    }

    public void removeWorkspace(Workspace workspace) {
        workspaces.remove(workspace);
        System.out.println("Удалено рабочее место: " + workspace);
    }

    public void registerUser(User user) {
        bookings.put(user, new TreeSet<>());
        System.out.println("Зарегистрирован новый пользователь: " + user);
    }

    public void bookWorkspace(User user, Workspace workspace) throws Exception {
        if (!workspaces.contains(workspace)) throw new Exception("Рабочее место не существует!");

        if (!workspace.isAvailable()) throw new Exception("Рабочее место уже занято!");

        if (!bookings.containsKey(user)) throw new Exception("Пользователь не зарегистрирован!");

        workspace.markAsBooked();
        bookings.get(user).add(workspace);
        System.out.println(user + " забронировал рабочее место: " + workspace);
    }

    public void cancelBooking(User user, Workspace workspace) throws Exception {
        if (!bookings.containsKey(user)) throw new Exception("Пользователь не зарегистрирован!");

        if (!bookings.get(user).contains(workspace)) throw new Exception("Рабочее место не забронировано этим пользователем!");

        workspace.markAsAvailable();
        bookings.get(user).remove(workspace);
        System.out.println(user + " отменил бронирование рабочего места: " + workspace);
    }

    public void printAvailableWorkspaces() {
        System.out.println("Доступные рабочие места:");
        for (Workspace workspace : workspaces) {
            if (workspace.isAvailable()) System.out.println(workspace);
        }
    }
}