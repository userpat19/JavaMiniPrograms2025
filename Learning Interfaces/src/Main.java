public class Main {

    public static void main(String[] args){

        Hawk hawk = new Hawk();
        Rabbit rabbit = new Rabbit();
        Fish fish =  new Fish(true);


        fish.flee();
        rabbit.flee();
        hawk.chase();
        fish.chase();
    }
}
