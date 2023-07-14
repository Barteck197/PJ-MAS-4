import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("[+] Ograniczenie na atrybucie");
        /*
         * Agent ubezpieczeniowy może naliczyć znikę na polisie,
         * jednak suma zniżek nie może przekroczyć 40%
         */
        InsurancePolicy hestia = new InsurancePolicy(LocalDate.now(), LocalDate.of(2023, 12, 18), 3000.00f);

        System.out.println("Initial Discount: " + hestia.getInsuranceTotalDiscounts());

        hestia.addInsuranceDiscount(30.00f);
        System.out.println("After first discount: " + hestia.getInsuranceTotalDiscounts());

        // Próba obniżki ponad limit
//        hestia.addInsuranceDiscount(15.00f);
//        System.out.println("After second discount: " + hestia.getInsuranceTotalDiscounts());

        System.out.println("[+] Ograniczenie {unique}");
        /*
         * W systemie sprzedażowym każde zamówienie
         * ma swój unikalny numer: orderID
         */
        Order o1 = new Order(1, LocalDateTime.of(2022, 12, 15, 6, 3), 25);
        Order o2 = new Order(2, LocalDateTime.of(2022, 12, 16, 9, 31), 3);
        Order o3 = new Order(3, LocalDateTime.of(2022, 12, 17, 15, 28), 1);
        Order o4 = new Order(4, LocalDateTime.of(2022, 12, 18, 13, 19), 9);

        // Uwaga, próba złamania ograniczenia "unique" na orderId
//        Order o5 = new Order(2, LocalDateTime.of(2022,12,18,22,33),100);

        // Możemy też łatwo znaleźć konkretny obiekt po ID
        System.out.println(Order.getOrderById(3));

        System.out.println("[+] Ograniczenie {subset}");
        /*
         * W systemie chcemy przechowywać informację o tym do jakiego zespołu
         * należy dany zawodnik, dodatkowo wybrani zawodnicy mogą być wyznaczeni
         * jako kapitanowie i tą informację także chcielibyśmy przechowywać.
         */
        Player p1 = new Player("Jakub", "Wawrzyniak", "POL");
        Player p2 = new Player("Lautaro", "Martinez", "ARG");
        Player p3 = new Player("Olivier", "Giroud", "FRA");
        Player p4 = new Player("Wojciech", "Szczęsny", "POL");

        Team kadra = new Team("Reprezentacja Polski");
        Team klub = new Team("Paris Saint-Germain");

        // Dla uniknięcia błędów role "nazywamy"
        final String roleIncludes = "Includes";
        final String rolePlaysIn = "Plays in";

        // Tworzymy połączenia podstawowe
        kadra.addLink(roleIncludes, rolePlaysIn, p1);
        kadra.addLink(roleIncludes, rolePlaysIn, p4);

        klub.addLink(roleIncludes, rolePlaysIn, p2);
        klub.addLink(roleIncludes, rolePlaysIn, p3);

        // "Nowe" role
        final String roleIsCapitan = "Is Capitan";
        final String roleHasCapitan = "Has Capitan";

        // Tworzymy połączenia drugorzędne - wyznaczamy kapitanów drużyn
        kadra.addLink_subset(roleHasCapitan, roleIsCapitan, roleIncludes, p1);
        klub.addLink_subset(roleHasCapitan, roleIsCapitan, roleIncludes, p3);

        kadra.showLinks(roleHasCapitan, System.out);
        klub.showLinks(roleHasCapitan, System.out);

//        klub.showLinks("Includes", System.out);
//        p2.showLinks("Plays in", System.out);
//        p3.showLinks("Plays in", System.out);
//        p4.showLinks("Plays in", System.out);

        System.out.println("[+] Ograniczenie {bag}");
        /*
         * Klient, który zamawia określone produkty - tworzy zamówienie.
         * To samo zamówienie można złożyć kilka razy.
         */
        Client client1 = new Client("Kacper");
        Client client2 = new Client("Karolina");

        Product product1 = new Product("Pomarańcza", 3.89f);
        Product product2 = new Product("Burak", 7.99f);

        Order order1 = new Order(5, LocalDateTime.now(), 3, client1, product1);
        Order order2 = new Order(6, LocalDateTime.now(), 3, client2, product2);
        Order order3 = new Order(7, LocalDateTime.now(), 3, client1, product1);

        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);

    }
}