public class Main {

    public static void main(String[] args){


        SmartPhone phone1 = new SmartPhone();
        SmartPhone phone2 = new SmartPhone("Samsung", 455.0, "Blue", 2019);

        System.out.println(phone2.get_YearMade());
    }
}
