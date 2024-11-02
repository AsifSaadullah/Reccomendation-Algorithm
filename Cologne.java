import java.util.List; 
public class Cologne {
    private String cologneBrand;
    private String cologneName;
    private List<String> topNotes;
    private List<String> middleNotes; 
    private List<String> baseNotes; 
    private List<String> formalities; 
    // Constructor 
    public Cologne(String cologneBrand, String cologneName, List<String> topNotes, List<String> middleNotes, List<String> baseNotes, List<String> formalities) {
        this.cologneBrand = cologneBrand;
        this.cologneName = cologneName;
        this.topNotes = topNotes; 
        this.middleNotes = middleNotes;
        this.baseNotes = baseNotes;      
        this.formalities = formalities; 
    }
    // Getter 
    public String getName() {
        return cologneName + " by " + cologneBrand; // Returns the cologne's name and brand
    }
    // Getter methods 
    public String getCologneBrand() {
        return cologneBrand; // Returns the brand of the cologne
    }
    public List<String> getTopNotes() {
        return topNotes; // Returns the top notes of the cologne
    }
    public List<String> getMiddleNotes() {
        return middleNotes; // Returns the middle notes of the cologne
    }
    public List<String> getBaseNotes() {
        return baseNotes; // Returns the base notes of the cologne
    }
    public List<String> getFormalities() {
        return formalities; // Returns the list of formalities for the cologne
    }
    @Override
    public String toString() { //Displays the details of the cologne 
        return "Cologne Details:\n" +
                "Brand: " + cologneBrand + '\n' + 
                "Name: " + cologneName + '\n' +   
                "Top Notes: " + String.join(", ", topNotes) + '\n' + 
                "Middle Notes: " + String.join(", ", middleNotes) + '\n' + 
                "Base Notes: " + String.join(", ", baseNotes) + '\n' + 
                "Formalities: " + String.join(", ", formalities) + '\n'; 
    }
}