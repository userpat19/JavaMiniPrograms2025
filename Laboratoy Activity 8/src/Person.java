class TitledPerson extends Person{

    public class Person {

        private String name;
        public Person(){
            name = "No name";
        }

        public Person(String InitialName){
            name = InitialName;
        }

        public void setName(String newName){
            name = newName;
        }

        public String getName(){
            return name;
        }

        public void writeOutput(){
            System.out.println("Name: " + name);
        }

        public boolean sameName(Person OtherPerson){

            return(this.name.equalsIgnoreCase(OtherPerson.name));
        }



    }
    private String title;

    public TitledPerson(){

        super();
        title = "No title";

    }

    public TitledPerson(String name, String the_title){
        super(name);
        title = the_title;
    }

    public void writeOutput(){
        System.out.println("Name:" + this.getName());
        System.out.println("Title:"+ this.title);
    }

    public void reset(String name, String title){
        setName(name);
        this.title = title;
    }

    public boolean sameNameTitle(TitledPerson OtherPerson){
        return (this.getName().equalsIgnoreCase(OtherPerson.getName()) && this.title.equalsIgnoreCase(OtherPerson.title));
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }


}
