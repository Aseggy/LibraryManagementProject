public class Magazine extends Media {

    private int issueNumber; // issue# magazine

    // Constructor: title, issue#
    public Magazine(String title, int issueNumber) {
        super(title); // Set title in the parent Media class
        this.issueNumber = issueNumber;
    }

    // Get the issue number
    public int getIssueNumber() {
        return issueNumber;
    }

    // Return magazine details as a string
    public String getDetails() {
        return "Magazine: " + getTitle() + " (Issue #" + issueNumber + ")";
    }
}