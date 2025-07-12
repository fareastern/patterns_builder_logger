import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        logger.log("Запуск программы");

        // Ввод размера списка
        logger.log("Введите входные данные для списка");
        int n = 0;
        int m = 0;

        try {
            System.out.print("Размер списка: ");
            n = scanner.nextInt();
            System.out.print("Верхняя граница значений: ");
            m = scanner.nextInt();
        } catch (InputMismatchException e) {
            logger.log("Некорректный ввод данных");
            System.out.println("Ошибка: введите целое число");
            return;
        }

        // Создание и заполнение списка
        logger.log("Генерируем список");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(m));
        }

        System.out.print("Готовый список: ");
        list.forEach(num -> System.out.print(num + " "));
        System.out.println();

        // Ввод порога фильтрации
        logger.log("Введите данные для фильтрации");
        int f = 0;

        try {
            System.out.print("Введите порог для фильтра: ");
            f = scanner.nextInt();
        } catch (InputMismatchException e) {
            logger.log("Некорректный ввод порога фильтра");
            System.out.println("Ошибка: введите целое число");
            return;
        }

        // Фильтрация списка
        Filter filter = new Filter(f);
        List<Integer> filteredList = filter.filterOut(list);

        // Вывод результата
        logger.log("Готовим результат");
        System.out.print("Отфильтрованный список: ");
        filteredList.forEach(num -> System.out.print(num + " "));
        System.out.println();

        logger.log("Завершаем программу");
        scanner.close();
    }
}
