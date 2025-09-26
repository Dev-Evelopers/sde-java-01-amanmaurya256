import java.util.*;

public class Example2 {

    abstract class Car {
        private boolean isSedan;
        private int seats;

        Car(boolean isSedan, int seats) {
            this.isSedan = isSedan;
            this.seats = seats;
        }

        public String getIsSedan() {
            return isSedan ? "Sedan" : "Not Sedan";
        }

        public int getSeats() {
            return seats;
        }

        abstract String getMileage();
    }

    class WagonR extends Car {
        private int mileage;

        WagonR(int mileage) {
            super(false, 4);
            this.mileage = mileage;
        }

        String getMileage() {
            return mileage + " kmpl";
        }
    }

    class HondaCity extends Car {
        private int mileage;

        HondaCity(int mileage) {
            super(true, 4);
            this.mileage = mileage;
        }

        String getMileage() {
            return mileage + " kmpl";
        }
    }

    class InnovaCrysta extends Car {
        private int mileage;

        InnovaCrysta(int mileage) {
            super(false, 6);
            this.mileage = mileage;
        }

        String getMileage() {
            return mileage + " kmpl";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        int mileage = sc.nextInt();

        Example2 p = new Example2();
        Car car = null;

        if (type == 0) {
            car = p.new WagonR(mileage);
        } else if (type == 1) {
            car = p.new HondaCity(mileage);
        } else if (type == 2) {
            car = p.new InnovaCrysta(mileage);
        }

        System.out.println(car.getIsSedan() + " " + car.getSeats() + "-seater " + car.getMileage());
    }
}