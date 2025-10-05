public class Main {

    public static void main(String[] args){
        Circle circle = new Circle(20.5);
        Triangle triangle = new Triangle(20, 60);
        Rectangle rectangle = new Rectangle(10,15);

        circle.display();
        triangle.display();
        rectangle.display();

        System.out.printf("The area of the circle is: %.2f", circle.area());
        System.out.println();
        System.out.println("The area of the triangle is: " + triangle.area());
        System.out.println("The area of the rectangle is: " + rectangle.area());
    }
}
