package Pizza;

public class PizzaOrder {

    private int orderNum;
    Pizza  p1;
    Pizza p2;

    public void setOrderNum(int num) {
    orderNum = num;
    }

    public void setP1(Pizza p1){
        p1 = new Pizza(p1.getSize(), p1.getMeat(), p1.getVegatable());
    }

    public void setP2(Pizza p2){
        p2 = new Pizza(p2.getSize(), p2.getMeat(), p2.getVegatable());
    }

    public int totalCost(){
        return (p1.getCost() + p2.getCost());
    }


}
