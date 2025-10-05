import javax.swing.JOptionPane;

public class Main {

    public static void Add_Appliance(Appliance[] appliances){
        String appliance_name = JOptionPane.showInputDialog("Enter the name of the appliance:");
        String appliance_powerLevel = JOptionPane.showInputDialog("Enter the power level of the " + appliance_name + ": ");
        if(!(appliance_name.isEmpty() || appliance_powerLevel.isEmpty())){
            int power_level = Integer.parseInt(appliance_powerLevel);//TYPECAST
            if(power_level <= 0){
                System.out.println("Appliance Power level must be greater than zero");
            }
            for(int x = 0; x < appliances.length; x++){
                if(appliances[x] == null){
                    appliances[x] = new Appliance(appliance_name, power_level);
                    System.out.println("Successfully Added the Appliance");
                    break;
                }
            }
        }
        else{
            if(appliance_name != null){
                for(int x = 0; x < appliances.length; x++){
                    if(appliances[x] == null){
                        appliances[x] = new Appliance(appliance_name);
                        System.out.println("Successfully Added the Appliance");
                        break;
                    }
                }
            }else{
                System.out.println("Both entries must have a value");
            }

        }

    }

    public static void Display_Appliances(Appliance[] appliances){
        System.out.println("---ALL APPLIANCES---");
        for(int x = 0; x < appliances.length;x++){
            if(appliances[x] == null){
                break;
            }else{
                System.out.print(appliances[x].name + " - " + appliances[x].status + " - ");
                if(appliances[x].powerlevel == 0){
                    System.out.println("No PowerLevel");
                }else{
                    System.out.println(appliances[x].powerlevel);
                }
            }
        }
    }


    public static void main(String[] args){
        Appliance[] appliances = new Appliance[10];
        boolean isRunning = true;

        while(isRunning){
            System.out.println("1.Add a new appliance.");
            System.out.println("2.View all appliances.");
            System.out.println("3.Turn an appliance ON/OFF.");
            System.out.println("4.Adjust appliance power level");
            System.out.println("5.Exit the program.");
            String choice = JOptionPane.showInputDialog("Enter a mode:");
            switch(choice){
                case "1":
                    Add_Appliance(appliances);
                    break;
                case "2":
                    Display_Appliances(appliances);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
