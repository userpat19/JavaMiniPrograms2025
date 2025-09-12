import javax.swing.text.DefaultEditorKit;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void add_vehicle(ArrayList<Vehicle> the_list){
        Scanner scanner = new Scanner(System.in);
        Vehicle new_vehicle;
        String name;
        int speed;
        int fuel;
        double distance;
        String choice;
        System.out.print("Type of Vehicle to add(1 for Car, 2 for Bike, 3 for Truck): ");
        choice = scanner.nextLine();
        switch(choice){
            case "1":
                System.out.println("CAR OBJECT ATTRIBUTES");
                System.out.print("Enter the car's name: ");
                name = scanner.nextLine();
                System.out.print("Enter the maximum speed that this car can run in kph: ");
                speed = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the number of galloons of fuel that this car has: ");
                fuel = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the distance that this car can cover(km/decimal): ");
                distance = scanner.nextDouble();
                scanner.nextLine();
                new_vehicle = new Car(name, speed, fuel, distance);
                the_list.add(new_vehicle);
                System.out.println("Car object named " + name + " is added to the collection");
                break;
            case "2":
                System.out.println("BIKE OBJECT ATTRIBUTES");
                System.out.print("Enter the bike's name: ");
                name = scanner.nextLine();
                System.out.print("Enter the maximum speed that this bike can run in kph: ");
                speed = scanner.nextInt();
                scanner.nextLine();
                new_vehicle = new Bike(name, speed, fuel = 0, distance = 0.0);
                the_list.add(new_vehicle);
                System.out.println("Bike object named " + name + " is added to the collection");
                break;
            case "3":
                System.out.println("TRUCK OBJECT ATTRIBUTES");
                System.out.print("Enter the truck's name: ");
                name = scanner.nextLine();
                System.out.print("Enter the maximum speed that this truck can run in kph: ");
                speed = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the number of galloons of fuel that this truck has: ");
                fuel = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the distance that this truck can cover(km/decimal): ");
                distance = scanner.nextDouble();
                scanner.nextLine();
                new_vehicle = new Truck(name, speed, fuel, distance);
                the_list.add(new_vehicle);
                System.out.println("Truck object named " + name + " is added to the collection");
                break;
            default:
                System.out.println("Input invalid, user entered a non recognized value for choice.");
        }
    }

    static void operate_vehicle(ArrayList<Vehicle> the_list){

        Scanner scanner = new Scanner(System.in);
        Vehicle in_use = null;
        String picked_vehicle;
        String choice;
        System.out.println("PICK A TYPE OF VEHICLE TO OPERATE");
        System.out.println("1.Car");
        System.out.println("2.Bike");
        System.out.println("3.Truck");
        System.out.print("Enter here: ");
        choice = scanner.nextLine();

        switch(choice){
            case "1":
                System.out.println("Which car do you want to operate?");
                for(Vehicle current : the_list){

                    if(current instanceof Car){
                        System.out.println(current.name);
                    }

                }
                System.out.print("Enter here: ");
                picked_vehicle = scanner.nextLine();
                for(Vehicle current : the_list){

                    if(current instanceof Car){
                        if(picked_vehicle.equals(current.name)){
                            in_use = current;
                        }
                    }
                }
                if(in_use != null){
                    while(in_use != null){

                        String operation;
                        System.out.println("OPERATING CAR NAMED " + in_use.name);
                        System.out.println("1.Start the Car");
                        System.out.println("2.Stop the Car");
                        System.out.println("3.Check the car's fuel efficiency");
                        System.out.println("4.Stop operating this vehicle");
                        System.out.print("Enter here: ");
                        operation = scanner.nextLine();
                        switch(operation){
                            case "1":
                                in_use.start();
                                break;
                            case "2":
                                in_use.stop();
                                break;
                            case "3":
                                in_use.fuelEfficiency();
                                break;
                            case "4":
                                System.out.println("--Vehicle successfully operated!--");
                                in_use = null;
                                break;
                            default:
                                System.out.println("User entered a unrecognized value");
                        }

                    }

                }else{
                    System.out.println("User entered a unrecognized value");
                }
                break;
            case "2":
                System.out.println("Which bike do you want to operate?");
                for(Vehicle current : the_list){

                    if(current instanceof Bike){
                        System.out.println(current.name);
                    }

                }

                System.out.print("Enter here: ");
                picked_vehicle = scanner.nextLine();
                for(Vehicle current : the_list){

                    if(current instanceof Bike){
                        if(picked_vehicle.equals(current.name)){
                            in_use = current;
                        }
                    }
                }
                if(in_use != null){
                    while(in_use != null){

                        String operation;
                        System.out.println("OPERATING BIKE NAMED " + in_use.name);
                        System.out.println("1.Start the Bike");
                        System.out.println("2.Stop the Bike");
                        System.out.println("3.Stop operating this vehicle");
                        System.out.print("Enter here: ");
                        operation = scanner.nextLine();
                        switch(operation){
                            case "1":
                                in_use.start();
                                break;
                            case "2":
                                in_use.stop();
                                break;
                            case "3":
                                System.out.println("--Vehicle successfully operated!--");
                                in_use = null;
                                break;
                            default:
                                System.out.println("User entered a unrecognized value");
                        }

                    }

                }else{
                    System.out.println("User entered a unrecognized value");
                }
                break;
            case "3":
                System.out.println("Which truck do you want to operate?");
                for(Vehicle current : the_list){

                    if(current instanceof Truck){
                        System.out.println(current.name);
                    }

                }

                System.out.print("Enter here: ");
                picked_vehicle = scanner.nextLine();
                for(Vehicle current : the_list){

                    if(current instanceof Truck){
                        if(picked_vehicle.equals(current.name)){
                            in_use = current;
                        }
                    }
                }
                if(in_use != null){
                    while(in_use != null){

                        String operation;
                        System.out.println("OPERATING TRUCK NAMED " + in_use.name);
                        System.out.println("1.Start the Truck");
                        System.out.println("2.Stop the Truck");
                        System.out.println("3.Check the truck's fuel efficiency");
                        System.out.println("4.Stop operating this vehicle");
                        System.out.print("Enter here: ");
                        operation = scanner.nextLine();
                        switch(operation){
                            case "1":
                                in_use.start();
                                break;
                            case "2":
                                in_use.stop();
                                break;
                            case "3":
                                in_use.fuelEfficiency();
                                break;
                            case "4":
                                System.out.println("--Vehicle successfully operated!--");
                                in_use = null;
                            default:
                                System.out.println("User entered a unrecognized value");
                        }

                    }

                }else{
                    System.out.println("User entered a unrecognized value");
                }
                break;
            default:
                System.out.println("Input invalid, user entered a non recognized value for choice.");
        }
    }


    public static void main(String[] args){

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        vehicles.add(new Car("Honda", 200, 5, 80.0));
        vehicles.add(new Car("Toyota", 150, 3, 70));
        vehicles.add(new Car("Mitsubishi", 210, 7, 100.0));
        vehicles.add(new Bike("Aventon", 50, 0, 0.00));
        vehicles.add(new Bike("Aima", 40, 0, 0.00));
        vehicles.add(new Bike("Colnago", 60, 0, 0.00));
        vehicles.add(new Truck("Kenworth", 200, 6, 95.0));
        vehicles.add(new Truck("Ford", 170, 1, 40.0));
        vehicles.add(new Truck("Isuzu", 215, 10, 115.0));

        boolean isRunning = true;

        while(isRunning){
            String choice;
            System.out.println("VEHICLE MANAGEMENT SYSTEM");
            System.out.println("1.Add a Vehicle");
            System.out.println("2.Operate a Vehicle");
            System.out.println("3.Display all vehicles with its insurance type");
            System.out.println("4.Close the Program");
            System.out.print("Enter choice:");
            choice = scanner.nextLine();

            switch(choice){
                case "1":
                    add_vehicle(vehicles);
                    break;
                case "2":
                    operate_vehicle(vehicles);
                    break;
                case "3":
                    int car_num = 0;
                    int bike_num = 0;
                    int truck_num = 0;

                    System.out.println("--CARS--");
                    for(Vehicle current_vehicle : vehicles){
                        if(current_vehicle instanceof Car){
                            car_num++;
                            Car car_object = (Car) current_vehicle;
                            System.out.println(car_num+"." +car_object.name + " - " + car_object.insurance_type());
                        }
                    }

                    System.out.println("\n--BIKES--");
                    for(Vehicle current_vehicle : vehicles){
                        if(current_vehicle instanceof Bike){
                            bike_num++;
                            Bike bike_object = (Bike) current_vehicle;
                            System.out.println(bike_num+"." +current_vehicle.name + " - " + bike_object.insurance_type());
                        }
                    }

                    System.out.println("\n--TRUCKS--");
                    for(Vehicle current_vehicle : vehicles){
                        if(current_vehicle instanceof Truck){
                            truck_num++;
                            Truck truck_object = (Truck) current_vehicle;
                            System.out.println(truck_num+"." +current_vehicle.name + " - " + truck_object.insurance_type());
                        }
                    }
                    break;
                case "4":
                    System.out.println("Closing the Program");
                    isRunning = false;

            }

        }

    }
}
