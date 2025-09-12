public class Truck extends Vehicle implements Insurance{

    Truck(String name, int speed, int fuel, double distance){

        super(name, speed, fuel, distance);
    }

    @Override
    void start(){
        System.out.println("Truck named " + this.name + " is starting its engine.");
    }

    @Override
    void stop(){
        System.out.println("Truck named " + this.name + " is stopping its engine.");
    }

    @Override
    void fuelEfficiency(){
        System.out.println("This truck can run" + this.distance + "km using " + this.fuel + "Litters of fuel.");
    }

    @Override
    public String insurance_type(){

        return "Commercial Vehicle Insurance";
    }
}
