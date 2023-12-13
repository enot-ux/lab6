public class Main {
    public static void main(String[] args) {
       
        Cinema cinema = new Cinema(5, 10, 20);
        cinema.autoBook(2, 4);
        cinema.printSeatingArrangement(2);
    }
}
