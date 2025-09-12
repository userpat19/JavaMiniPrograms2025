public abstract class Vehicle {

    String name;
    int speed;
    int fuel;
    double distance;

    Vehicle(String name, int speed, int fuel, double distance){
        this.name = name;
        this.speed = speed;
        this.fuel = fuel;
        this.distance = distance;
    }

    abstract void start();
    abstract void stop();
    abstract void fuelEfficiency();

}
