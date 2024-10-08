
import java.util.List;

public class Clothes {
    private String type;  
    private String brand; 
    private String color; 
    private String size; 
    private List<String> seasons; 
    private List<String> formality; 

    // Constructor 
    public Clothes(String type, String brand, String color, String size, List<String> seasons, List<String> formality) {
        this.type = type;        
        this.brand = brand;  
        this.color = color; 
        this.size = size; 
        this.seasons = seasons; 
        this.formality = formality; 
    }

    // Getter method 
    public String getName() {
        return type + " by " + brand + " (" + color + ", " + size + ")"; 
    }

    // Getter methods
    public String getType() {
        return type; // Returns the type of clothing
    }

    public String getBrand() {
        return brand; // Returns the brand of clothing
    }

    public String getColor() {
        return color; // Returns the color of clothing
    }

    public String getSize() {
        return size; // Returns the size of clothing
    }

    public List<String> getSeasons() {
        return seasons; // Returns the list of seasons suitable for the clothing item
    }

    public List<String> getFormality() {
        return formality; // Returns the list of formalities of clothes 
    }

    // toString method to provide a string representation of the Clothes object
    @Override
    public String toString() { //This will display the details of the clothes.
        return "Clothes Details:\n" +
                "Type: " + type + '\n' + 
                "Brand: " + brand + '\n' + 
                "Color: " + color + '\n' + 
                "Size: " + size + '\n' + 
                "Seasons: " + String.join(", ", seasons) + '\n' +
                "Formality: " + String.join(", ", formality) + '\n'; 
    }
}