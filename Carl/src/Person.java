public class Person {
    private String name;

    public Person() {
        name = "No name";
    }

    public Person(String initialName) {
        name = initialName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void writeOutput() {
        System.out.println("Name: " + name);
    }

    public boolean sameName(Person otherPerson) {
        return this.name.equalsIgnoreCase(otherPerson.name);
    }

    public static void main(String[] args) {
        TitledPerson p1 = new TitledPerson();
        TitledPerson p2 = new TitledPerson("Alice", "Ms");

        p1.writeOutput();
        p2.writeOutput();

        p1.reset("Bob", "Mr");
        p1.writeOutput();

        System.out.println("Title of p2: " + p2.getTitle());
        p2.setTitle("Dr");
        p2.writeOutput();

        TitledPerson p3 = new TitledPerson("Alice", "Dr");
        System.out.println("p2 equals p3? " + p2.equals(p3));
    }
}

class TitledPerson extends Person {
    private String title;

    public TitledPerson() {
        super();
        title = "No title";
    }

    public TitledPerson(String initialName, String initialTitle) {
        super(initialName);
        title = initialTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public void reset(String newName, String newTitle) {
        setName(newName);
        title = newTitle;
    }

    @Override
    public void writeOutput() {
        System.out.println("Title: " + title + " " + getName());
    }

    public boolean equals(TitledPerson other) {
        return this.getName().equalsIgnoreCase(other.getName()) &&
                this.title.equalsIgnoreCase(other.title);
    }
