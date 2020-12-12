package Model;

//Река
public class River extends Reservoir {
    //Конструктор
    public River(int number, String name, int portCount, int daysCount) {
        super(number, name, portCount, daysCount);
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("");
        sb.append("Маршрут № " + this.number + "\n");
        sb.append("Место: река " + this.name + "\n");
        sb.append("Кол-во причалов: " + this.portCount + "\n");
        sb.append("Кол-во дней на реке: " + this.daysCount + "\n");
        
        System.out.println(sb.toString());
    }

    
}
