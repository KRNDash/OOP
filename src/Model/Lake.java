package Model;
public class Lake extends Reservoir {
    //Конструктор
    public Lake(int number, String name, int portCount, int daysCount) {
        super(number, name, portCount, daysCount);
    }
    
    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Маршрут № " + this.number + "\n");
        sb.append("Место: озеро " + this.name + "\n");
        sb.append("Кол-во портов: " + this.portCount + "\n");
        sb.append("Кол-во дней на озере: " + this.daysCount + "\n");
        
        System.out.println(sb.toString());
    }

}
