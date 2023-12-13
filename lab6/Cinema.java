public class Cinema {
    private int[][][] seats;

    public Cinema(int halls, int rows, int seatsPerRow) {
        seats = new int[halls][rows][seatsPerRow];
        initializeSeats();
    }

    private void initializeSeats() {
       
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                for (int k = 0; k < seats[i][j].length; k++) {
                    seats[i][j][k] = 0;
                }
            }
        }
    }

    public void bookSeats(int hallNumber, int row, int[] seatsToBook) {
        
        for (int seat : seatsToBook) {
            seats[hallNumber][row][seat] = 1;
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        
        for (int seat : seatsToCancel) {
            seats[hallNumber][row][seat] = 0;
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        
        for (int i = 0; i < seats[hallNumber].length; i++) {
            int consecutiveEmptySeats = 0;
            for (int j = 0; j < seats[hallNumber][i].length; j++) {
                if (seats[hallNumber][i][j] == 0) {
                    consecutiveEmptySeats++;
                    if (consecutiveEmptySeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveEmptySeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
      
        System.out.println("Seating arrangement for Hall " + hallNumber + ":");
        for (int i = 0; i < seats[hallNumber].length; i++) {
            for (int j = 0; j < seats[hallNumber][i].length; j++) {
                System.out.print(seats[hallNumber][i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[] findBestAvailable(int hallNumber, int numSeats) {
        
        for (int i = 0; i < seats[hallNumber].length; i++) {
            int consecutiveEmptySeats = 0;
            for (int j = 0; j < seats[hallNumber][i].length; j++) {
                if (seats[hallNumber][i][j] == 0) {
                    consecutiveEmptySeats++;
                    if (consecutiveEmptySeats == numSeats) {
                        int[] bestSeats = new int[numSeats];
                        for (int k = 0; k < numSeats; k++) {
                            bestSeats[k] = j - numSeats + 1 + k;
                        }
                        return bestSeats;
                    }
                } else {
                    consecutiveEmptySeats = 0;
                }
            }
        }
        return null; 
    }

    public void autoBook(int hallNumber, int numSeats) {
       
        int[] bestSeats = findBestAvailable(hallNumber, numSeats);
        if (bestSeats != null) {
            bookSeats(hallNumber, 0, bestSeats);
            System.out.println("Automatically booked seats: " + Arrays.toString(bestSeats));
        } else {
            System.out.println("No available seats for booking.");
        }
    }
}
