public class Main {
    public static void main(String[] args) throws Exception {
        CoworkingSystem coworkingSystem = new CoworkingSystem();

        // Добавляем рабочие места
        Workspace w1 = new Workspace(1, "стандартное");
        Workspace w2 = new Workspace(2, "переговорная комната");

        coworkingSystem.addWorkspace(w1);
        coworkingSystem.addWorkspace(w2);

        // Регистрируем пользователей
        User user1 = new User("Иван", "Иванов");
        User user2 = new User("Анна", "Смирнова");

        coworkingSystem.registerUser(user1);
        coworkingSystem.registerUser(user2);

        // Бронирование рабочих мест
        coworkingSystem.bookWorkspace(user1, w1); // Иван бронирует место №1
        coworkingSystem.bookWorkspace(user2, w2); // Анна бронирует место №2

        // Вывод доступных рабочих мест
        coworkingSystem.printAvailableWorkspaces();

        // Отмена бронирования
        coworkingSystem.cancelBooking(user1, w1); // Иван отменяет бронирование

        // Вывод доступных рабочих мест после отмены бронирования
        coworkingSystem.printAvailableWorkspaces();

        // Попытка забронировать занятое место (проверка исключений)
        try {
            coworkingSystem.bookWorkspace(user2, w1); // Анна пытается забронировать освобожденное место №1
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}