public class Male extends Person{

    boolean fights;
    Male(String name, int age, boolean fights){
        super(name, age);
        System.out.println("This is a male constructor.");
        this.fights = fights;
    }
}
