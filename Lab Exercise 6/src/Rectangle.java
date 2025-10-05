import java.util.Scanner;

public class Rectangle {

    private double width = 1;
    private double height = 1;

    Rectangle(){

    }

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return 2 * (this.width + this.height);
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double rect1_width;
        double rect1_height;
        double rect2_width;
        double rect2_height;

        System.out.print("Enter the width of the first rectangle:");
        rect1_width = scanner.nextDouble();
        System.out.print("Enter the height of the first rectangle:");
        rect1_height = scanner.nextDouble();
        System.out.print("Enter the width of the second rectangle:");
        rect2_width = scanner.nextDouble();
        System.out.print("Enter the height of the second rectangle:");
        rect2_height = scanner.nextDouble();

        Rectangle rectangle1 = new Rectangle(rect1_width, rect1_height);
        Rectangle rectangle2 = new Rectangle(rect2_width, rect2_height);

        System.out.println("First Rectangle:");
        System.out.println("Width: " + rectangle1.getWidth());
        System.out.println("Height: " + rectangle1.getHeight());
        System.out.println("Area: " + rectangle1.getArea());
        System.out.println("Perimeter: " + rectangle1.getPerimeter());

        System.out.println("Second Rectangle:");
        System.out.println("Width: " + rectangle2.getWidth());
        System.out.println("Height: " + rectangle2.getHeight());
        System.out.println("Area: " + rectangle2.getArea());
        System.out.println("Perimeter: " + rectangle2.getPerimeter());



        scanner.close();
    }
}
