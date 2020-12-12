
import Model.*;
import java.util.Scanner;

//Класс псевдо интерфейса
public class Menu {
    //Поле экземпляра класса-группы
    protected static TripTicket tripT;
    //Сканнер для чтения
    protected static Scanner scan = new Scanner(System.in, "Cp1251");
    //Счётчик номера маршрута в списке
    private static int counter = 1;

    //Инициализируем статический класс-группу
    static {
        tripT = new TripTicket();
    }

    public static void MainMenu() {
        int choice = -1;
        do {
            System.out.println("_________________________________");
            System.out.println("Путевой лист по водохранилищам");
            System.out.println("Выберите операцию с маршрутами:");
            System.out.println("1 - Добавить маршрут");
            System.out.println("2 - Удалить маршрут");
            System.out.println("3 - Найти маршрут");
            System.out.println("4 - Вывод всех назначенных маршрутов");
            System.out.println("0 - Выход");
            System.out.println("_________________________________");

            choice = readChoice();

            switch (choice) {
                case 1: {
                    //Меню добавления нового маршрута
                    subAddMenu();
                    break;
                }
                case 2: {
                    int number = 0;
                    try {
                        System.out.println("");
                        System.out.println("Введите номер маршрута для удаления:");
                        number = Integer.parseInt(scan.nextLine());
                        if (tripT.GetSize() < number) {
                            System.out.println("Ошибка. Маршрута с таким номером нет в путевом листе");
                            break;
                        } else {
                            tripT.remove(number);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка. Введите целое число");
                        break;
                    }
                    System.out.println("Маршрут №" + number + " успешно удалён");
                    break;
                }
                case 3: {
                    int number = 0;
                    //Инициализиуем экземпляр родительского класса для результата поиска
                    Reservoir findedRes = null;
                    try {
                        System.out.println("");
                        System.out.println("Введите номер маршрута для поиска:");
                        number = Integer.parseInt(scan.nextLine());
                        //Поиск по номеру
                        findedRes = tripT.search(number);
                        System.out.println("");
                        System.out.println("----РЕЗУЛЬТАТЫ ПОИСКА----");
                        //Вывод результата поиска
                        findedRes.print();
                        System.out.println("-------------------------");
                        System.out.println("");
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка. Введите целое число");
                        break;
                    } catch (NullPointerException e) {
                        System.out.println("Ошибка. Маршрута с таким номером нет в путевом листе");
                        break;
                    }
                    break;
                }
                case 4: {
                    if (tripT.GetSize() == 0) {
                        System.out.println("Не назначено ни одного маршрута");
                        System.out.println("Добавьте маршрут и он отобразится тут");
                        System.out.println("");
                    } else {
                        //Вывод всех точек маршрута
                        tripT.print();
                    }
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Ошибка. Такой команды не обнаружено");
                    break;
                }
            }
        } while (choice != 0);

    }

    private static void subAddMenu() {
        int choice = -1;
        do {
            System.out.println("_________________________________");
            System.out.println("Добавить новый маршрут в :");
            System.out.println("1 - Море");
            System.out.println("2 - Река");
            System.out.println("3 - Озеро");
            System.out.println("0 - Назад");
            System.out.println("_________________________________");
            
            choice = readChoice();

            switch (choice) {
                case 1: {
                    System.out.println("Введите название моря: ");
                    //Вызов метода добавления маршрута (море)
                    createRes(1);
                    break;
                }
                case 2: {
                    System.out.println("Введите название реки: ");
                    //Вызов метода добавления маршрута (река)
                    createRes(2);
                    break;
                }
                case 3: {
                    System.out.println("Введите название озера: ");
                    //Вызов метода добавления маршрута (озеро)
                    createRes(3);
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Ошибка. Такой команды не обнаружено");
                    break;
                }
            }
        } while (choice != 0);

    }

    //Метод для чтения и проверки введённой команды
    private static int readChoice() {
        int readed = -1;
        try {
            readed = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка. Введите целое число");
            readed = readChoice();
        }
        return readed;
    }

    //Метод для добавления нового маршрута
    private static void createRes(int log) {
        //Чтение названия водохранилища
        String name = scan.nextLine();
        try {
            System.out.println("Введите кол-во портов: ");
            int portCount = Integer.parseInt(scan.nextLine());
            System.out.println("Введите кол-во дней в плавании: ");
            int daysCount = Integer.parseInt(scan.nextLine());
            //Отбор по созданию определённого маршрута
            switch (log) {
                case 1: {
                    tripT.add(new Sea(counter++, name, portCount, daysCount));
                    break;
                }
                case 2: {
                    tripT.add(new River(counter++, name, portCount, daysCount));
                    break;
                }
                case 3: {
                    tripT.add(new Lake(counter++, name, portCount, daysCount));
                    break;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Ошибка. Введите целое число");
            System.out.println("");
            return;
        }
    }

}
