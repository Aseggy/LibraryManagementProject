//Parent class of Book and Magazine
public abstract class Media {

    // TOPIC: Encapsulation
    // This field is common to ALL children, so we put it here.
    private String title;

    // The constructor for the parent class
    public Media(String title) {
        this.title = title;
    }

    // The getter, which all children will inherit
    public String getTitle() {
        return title;
    }

    // TOPIC: Abstraction
    // This is an "abstract method". It's a rule.
    // It forces every child class (like Book) to create its own
    // getDetails() method, or the code won't compile.
    public abstract String getDetails();

}
