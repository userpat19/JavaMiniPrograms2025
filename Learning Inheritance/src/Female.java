public class Female extends Person{

    boolean defends;

    Female(String name, int age, boolean defends){
        super(name, age);
        System.out.println("This is a female constructor.");
        this.defends = defends;
    }
}
