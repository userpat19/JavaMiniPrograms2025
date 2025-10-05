public class TEMPERATURE{

    private double temp_value;
    private char type;

    public TEMPERATURE(){

    }

    public TEMPERATURE(double temp_value, char type){
        this.temp_value = temp_value;
        this.type = type;
    }

    public double getTemp_value(){
        return this.temp_value;
    }

    public char getType(){
        return this.type;
    }

    public void setTemp_value(double temp_value){
        this.temp_value = temp_value;
    }

    public void setType(char type){
        this.type = type;
    }

    public double convertToFahrenheit(){
        if(this.type == 'C'){
            return 9 * this.temp_value / 5 + 32;
        }else{
            return this.temp_value;
        }
    }

    public double convertToCelsius(){
        if(this.type == 'F'){
            return 5 * (this.temp_value - 32) / 9;
        }else{
            return this.temp_value;
        }

    }

    public static void main(String[] args){
        TEMPERATURE celsius = new TEMPERATURE(20, 'C');
        TEMPERATURE fahrenheit = new TEMPERATURE(50, 'F');

        System.out.println("TEMPERATURE OBJECT #1:");
        System.out.println("Temperature Value: " + celsius.getTemp_value());
        System.out.println("Temperature Type: " + celsius.getType());
        System.out.println("Value equivalent to fahrenheit:" + celsius.convertToFahrenheit());
        System.out.println();
        System.out.println("TEMPERATURE OBJECT #2:");
        System.out.println("Temperature Value: " + fahrenheit.getTemp_value());
        System.out.println("Temperature Type: " + fahrenheit.getType());
        System.out.println("Value equivalent to celsius:" + fahrenheit.convertToCelsius());
        System.out.println();
        //I'll reverse the roles of each object

        System.out.println("--REVERSE THE ROLES BY USING THE SETTERS--");
        System.out.println();

        celsius.setTemp_value(50);
        celsius.setType('F');
        fahrenheit.setTemp_value(20);
        fahrenheit.setType('C');

        System.out.println("TEMPERATURE OBJECT #1:");
        System.out.println("Temperature Value: " + celsius.getTemp_value());
        System.out.println("Temperature Type: " + celsius.getType());
        System.out.println("Value equivalent to celsius:" + celsius.convertToCelsius());
        System.out.println();
        System.out.println("TEMPERATURE OBJECT #2:");
        System.out.println("Temperature Value: " + fahrenheit.getTemp_value());
        System.out.println("Temperature Type: " + fahrenheit.getType());
        System.out.println("Value equivalent to fahrenheit:" + fahrenheit.convertToFahrenheit());
        System.out.println();


    }


}
