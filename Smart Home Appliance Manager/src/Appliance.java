public class Appliance {

    String name;
    boolean status;
    int powerlevel;

    Appliance(String name){
        this.name = name;
        this.status = false;
    }

    Appliance(String name, int powerlevel){
        this.name = name;
        this.status = false;
        this.powerlevel = powerlevel;
    }

    public void Turn_On(){
        this.status = true;
        System.out.println(this.name + " has been turned on.");
    }

    public void Turn_Off(){
        this.status = false;
        System.out.println(this.name + " has been turned off.");
    }
}
