// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Human {
    boolean gender;

    Human(boolean gender){
        this.gender = gender;
    }

    public void Speak(){
        System.out.println("This human is talking.");
    }
}

class Boy extends Human{
    boolean isAlive;
    Boy(boolean gender, boolean alive){
        super(gender);
        isAlive = alive;
    }

    //overriding
    public void Speak(){
        System.out.println("This boy is talking.");
    }

    //overloading
    public void introduce(String name){
        System.out.println("Hello I am " + name);
    }

    public void introduce(String name, String age){
        System.out.println("Hello I am " + name + " currently " + age + " years old.");
    }

    public static void main(String[] args){
        Boy boy1 = new Boy(true, true);
        boy1.Speak();
        boy1.introduce("Trix");
        boy1.introduce("Trix", "34");
    }
}