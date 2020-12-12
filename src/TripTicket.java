import Model.*;
import java.util.ArrayList;

//Класс-группа
public class TripTicket {
    //Динамический массив, хранящий в себе путевой лист
    private ArrayList<Reservoir> routes = new ArrayList<Reservoir>();

    //Получение длины списка
    public int GetSize() {
        return routes.size();
    }

    //Метод добавления нового маршрута
    public void add(Reservoir res) {
        routes.add(res);
    }

    //Метод удаления маршрута
    public void remove(int number) {
        routes.remove(number - 1);
        updateNumber();
    }

    //Метод поиска
    public Reservoir search(int number) {
        for (Reservoir res : routes) {
            if (res.getNumber() == number) {
                return res;
            }
        }
        return null;
    }

    //Метод вывода всех маршрутов
    public void print() {
        updateNumber();
        System.out.println("");
        System.out.println("----ПУТЕВОЙ ЛИСТ----");
        System.out.println("");
        for (Reservoir res : routes) {
            res.print();
        }
        System.out.println("--------------------");
        System.out.println("");
    }

    //Метод обновления номеров маршрутов в путевом листе
    public void updateNumber() {
        int counter = 1;
        for (Reservoir res : routes) {
            res.setNumber(counter++);
        }
    }
}
