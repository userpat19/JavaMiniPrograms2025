public class Person {

    String name;
    int age;
    boolean breathing = true;

    Person(){
        name = "Bot";
        age = 0;
    }

    Person(String name, int age){
        System.out.println("Always ni siya ma print");
        this.name = name;
        this.age = age;
    }

}
