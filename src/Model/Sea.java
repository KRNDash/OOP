package Model;

//Море
public class Sea extends Reservoir {
    //Конструктор
    public Sea(int number, String name, int portCount, int daysCount) {
        super(number, name, portCount, daysCount);
    }
    
    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Маршрут № " + this.number + "\n");
        sb.append("Место: " + this.name + " море" + "\n");
        sb.append("Кол-во портов: " + this.portCount + "\n");
        sb.append("Кол-во дней в море: " + this.daysCount + "\n");
        
        System.out.println(sb.toString());
    }

}
