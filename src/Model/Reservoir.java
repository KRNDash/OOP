package Model;

//Абстрактный класс Водоёмов
public abstract class Reservoir {
    

    //Поля названия, кол-ва портов и кол-ва дней в плавании и номера
    protected int number;
    protected String name;
    protected int portCount;
    protected int daysCount;
    
    
    
    //Получение номера
    public int getNumber() {
        return number;
    }

    //Назначение нового номера
    public void setNumber(int number) {
        this.number = number;
    }

    //Получение имени
    public String getName() {
        return name;
    }

    public Reservoir(int number, String name, int portCount, int daysCount) {
        this.number = number;
        this.name = name;
        this.portCount = portCount;
        this.daysCount = daysCount;
    }
    
    //Абстрактный метод вывода
    public abstract void print();
    
    
}
