class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    // Constructor to initialize the number of slots for each car type
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // Method to check availability and park a car
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.big > 0) {
                this.big--;
                return true;
            }
        } else if (carType == 2) {
            if (this.medium > 0) {
                this.medium--;
                return true;
            }
        } else if (carType == 3) {
            if (this.small > 0) {
                this.small--;
                return true;
            }
        }
        
        return false; // No empty space available
    }
}