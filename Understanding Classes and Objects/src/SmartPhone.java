public class SmartPhone {

    private String brand;
    private double price;
    private String color;
    private int year_made;

    SmartPhone(){
        this.brand = "No Brand";
        this.price = 0.00;
        this.color = "No Color";
        this.year_made = 0;
    }

    SmartPhone(String brand, double price, String color, int year_made){
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.year_made = year_made;
    }

    public void turn_on(){
        System.out.println(this.brand + " is turning on.");
    }

    //GETTERS
    public String get_Brand(){
        return this.brand;
    }

    public double get_price(){
        return this.price;
    }

    public String get_Color(){
        return this.color;
    }

    public int get_YearMade(){
        return this.year_made;
    }
}
