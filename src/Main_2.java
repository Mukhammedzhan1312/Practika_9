interface IPizza{
    String GetDescription();
    double GetCost();
}

class Pizza implements IPizza{

    @Override
    public String GetDescription() {
        return null;
    }

    @Override
    public double GetCost() {
        return 0;
    }
}
abstract class PizzaDecarator implements IPizza{
    private IPizza pizza;
    protected PizzaDecarator(IPizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String GetDescription() {
        return pizza.GetDescription();
    }

    @Override
    public double GetCost() {
        return 0;
    }
}

class Cheese extends PizzaDecarator{

    protected Cheese(IPizza pizza) {
        super(pizza);
    }

    @Override
    public String GetDescription() {
        return super.GetDescription() + "Cheese";
    }

    @Override
    public double GetCost() {
        return super.GetCost() + 50;
    }
}

public class Main_2 {
    public static void main(String[] args) {
        IPizza pizza = new Pizza();
        IPizza Cheese = new Cheese(pizza);
        Cheese.GetCost();
    }
}
