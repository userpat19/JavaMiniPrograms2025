public class Bike extends Vehicle implements Insurance{

    Bike(String name, int speed, int fuel, double distance){

        super(name, speed, fuel, distance);
    }

    @Override
    void start(){
        System.out.println("Bike named " + this.name + " is starting to run using the paddles.");
    }

    @Override
    void stop(){
        System.out.println("Bike named " + this.name + " is starting to stop using it's breaks.");
    }

    @Override
    void fuelEfficiency(){
        System.out.println("A bike doesn't need a fuel to run.");
    }

    @Override
    public String insurance_type(){

        return "Liability Insurance";
    }
}
