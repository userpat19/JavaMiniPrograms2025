public class Fish extends Animal implements Prey,Predator{

    Fish(boolean b){
        super(b);
    }

    public void flee(){
        System.out.println("This fish is swimming away from a bigger fish");
    }

    public void chase(){
        System.out.println("This fish is chasing a smaller fish.");
    }

    void speak(){
        System.out.println("Hello");
    }
}
