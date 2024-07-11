package secao10.application;

import secao10.entities.Client;
import secao10.entities.Order;
import secao10.entities.OrderItem;
import secao10.entities.Product;
import secao10.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter sdf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data: ");

        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse((sc.nextLine()));

        Client client = new Client(clientName, clientEmail, birthDate);

        System.out.println("Enter Order Data: ");

        System.out.print("Status: ");
        String orderStatus = sc.nextLine();

        LocalDateTime dateOrder = LocalDateTime.now();
        Order order = new Order(dateOrder, OrderStatus.valueOf(orderStatus), client);

        System.out.print("How many items to this order? ");
        int numOrders = sc.nextInt();


        for (int i = 1; i <= numOrders; i++){

            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();

            Product product = new Product(nameProduct, priceProduct);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(quantity, priceProduct, product);

            order.addItem(orderItem);
        }


        System.out.println("ORDER SUMMARY:");
        System.out.print("Order moment: " + sdf2.format(order.getMoment()) + "\n");
        System.out.print("Order status: " + order.getStatus() + "\n");
        System.out.println("Client: " + order.getClient().getName() + " ("
                + sdf.format(order.getClient().getBirthDate()) + ") "
                + " - " + order.getClient().getEmail());

        System.out.println("Order items: ");

        for (OrderItem o : order.getItens()){
            System.out.println(o.getProduct().getName()
                    + ", $" + o.getProduct().getPrice()
                    + ", Quantity: " + o.getQuantity()
                    + ", Subtotal: $" + o.subTotal());
        }

        System.out.println("Total price: $" + order.total());


        sc.close();

    }

}
