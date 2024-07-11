package secao10.entities;

import secao10.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;

    private List <OrderItem> itens = new ArrayList <>();

   public Order(){

   }
    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    public void addItem(OrderItem item){
        itens.add(item);
    }

    public void removeItem (OrderItem item){
        itens.remove(item);
    }

    public Double total(){

       double sum = 0.0;

       for(OrderItem item : itens){
           sum += item.subTotal();
       }
       return sum;

    }

}
