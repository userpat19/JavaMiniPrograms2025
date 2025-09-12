public class Car extends Vehicle implements Insurance{


    Car(String name, int speed, int fuel, double distance){

        super(name, speed, fuel, distance);
    }

    @Override
    void start(){
        System.out.println("Car named " + this.name + " is starting its engine.");
    }

    @Override
    void stop(){
        System.out.println("Car named " + this.name + " is stopping its engine.");
    }

    @Override
    void fuelEfficiency(){
        System.out.println("This car named " + this.name + " can run " + this.distance + "km using " + this.fuel + " Litters of fuel.");
    }

    @Override
    public String insurance_type(){

        return "Comprehensive Insurance";
    }



}
