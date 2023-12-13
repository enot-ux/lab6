public class CinemaTest {
    public static void main(String[] args) {
     
        Cinema cinema = new Cinema(5, 10, 20);

        
        int[] seatsToBook = {1, 2, 3, 4, 5};
        cinema.bookSeats(1, 3, seatsToBook);
        cinema.printSeatingArrangement(1);

       
        int[] seatsToCancel = {2, 3, 4};
        cinema.cancelBooking(1, 3, seatsToCancel);
        cinema.printSeatingArrangement(1);
    
	}
}
