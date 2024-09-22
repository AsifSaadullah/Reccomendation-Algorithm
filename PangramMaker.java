import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PangramMaker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> pangram = new ArrayList<>(); // the arraylist is used to store words from the user

        System.out.println("Welcome to the Pangram Maker");
        System.out.println(" ");

        while (!Pangram_Complete(pangram)) { // this loop will keep going till the pangram is complete
            Display_Pangram(pangram); // Display the pangram
            System.out.println("Enter the next word (in all uppercase) or enter HELP for suggestions:");
            String input = scanner.nextLine(); // This is will read in the user's input

            if (input.equals("HELP")){
                Helper(pangram, Dictionary()); // This is the help function when the user types in help
            } else {
                if (ValidWord(input, Dictionary())) { // Check if the entered word is valid
                    pangram.add(input); // if the word is in the dictonary it will add it to the pangram
                } else {
                    System.out.println("That's not a valid word! Try again"); // if the word isnt in the dictonary it will tell the user
                }
            }
        }

        Display_Pangram(pangram); // This is will show the pangram after it is finished 
        System.out.println("Your pangram is complete!"); 
        System.out.println("Total Words: " + pangram.size()); // Shows the total number of words after the pangram is complete
        System.out.println("Total Letters: " + letters(pangram)); // Shows the total number of letters in the entire pangram
    }

    private static ArrayList<String> Dictionary() { 
    	// This method is going to read in the words in words.txt and add them into an arraylist.
        ArrayList<String> dictionary = new ArrayList<>();
        try {
            File file = new File("words.txt");
            Scanner wordstxt = new Scanner(file);
            while (wordstxt.hasNextLine()) {
                String word = wordstxt.nextLine().trim().toUpperCase();
                dictionary.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found."); 
        }
        return dictionary;
    }
    
    private static void Display_Pangram(ArrayList<String> pangram) { 
    	// This method is to display and store the pangram as the user enters
        System.out.print("Your pangram so far is: ");
        for (String word : pangram) {
            System.out.print(word + " "); // Display each word in the pangram
        }
        System.out.println();
    }
    
    private static boolean ValidWord(String word, ArrayList<String> dictionary) {
    	// Method to check if a word is in the dictonary/words.txt
        return dictionary.contains(word); 
    }

    private static void Helper(ArrayList<String> pangram, ArrayList<String> dictionary) {
        // This is the helper function in case the user doesn't know what to type and needs suggestions
        ArrayList<Character> UnusedLetters = FindUnusedLetters(pangram); // Find unused letters in the pangram
        ArrayList<String> suggestions = Suggestions(UnusedLetters, dictionary);  // Find suggestions based on unused letters found
        
        int count = 0; // Counter to limit the output to five words
        for (int i = 0; i < suggestions.size(); i++) {
            String word = suggestions.get(i);
            System.out.println(word); // Output the suggestion
            count++;
            if (count >= 5) {
                break;
            }
        }
    }

    private static ArrayList<Character> FindUnusedLetters(ArrayList<String> pangram) {
        // Method to find unused letters in the pangram
        ArrayList<Character> UnusedLetters = new ArrayList<>();
        for (char letter = 'A'; letter <= 'Z'; letter++) { // looping through all the letters in the alphabet
            boolean found = false;
            for (int i = 0; i < pangram.size(); i++) { // for loop to check if certain letters were or were not used in the pangram
                String word = pangram.get(i);
                if (word.indexOf(letter) != -1) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                UnusedLetters.add(letter); // Add unused letters to the list
            }
        }
        return UnusedLetters;
    }

    private static ArrayList<String> Suggestions(ArrayList<Character> UnusedLetters, ArrayList<String> Dictionary) {
        // This method uses the unused letters to find suggestions when help is called 
        ArrayList<String> suggestions = new ArrayList<>();
        
        for (int i = 0; i < Dictionary.size(); i++) { // for loop to look through the dictonary to find the suggestions
            String word = Dictionary.get(i);
            boolean IsValid = false;
            
            for (int j = 0; j < UnusedLetters.size(); j++) {// check if the words has at least one unused letter
                char letter = UnusedLetters.get(j);
                if (word.indexOf(letter) != -1) {
                    IsValid = true;
                    break;
                }
            }
            
            if (IsValid) {
                suggestions.add(word); // Add suggestions
                if (suggestions.size() >= 5) {
                    break; //only five suggestions are going to be given
                }
            }
        }
        return suggestions;
    }

    private static boolean Pangram_Complete(ArrayList<String> pangram) {
        boolean[] letters = new boolean[26]; // an array to track the letters used
        for (int w = 0; w < pangram.size(); w++) { // for loop to go through each word in the pangram
            String word = pangram.get(w); // Get the word
            
            for (int i = 0; i < word.length(); i++) { // loop to go through each letter in the word
                char letter = word.charAt(i);
               if (letter >= 'A' && letter <= 'Z') {// Check if the character is an uppercase letter
                    letters[letter - 'A'] = true;  //if the letter is there it says its there in the alphabet array
                }
            }
        }
        for (int k = 0; k < letters.length; k++) { //Checking if all letters of the alphabet are given
            if (!letters[k]) {
                return false; // If any letter is missing, the pangram is not complete
            }
        }
        return true; // If all letters are present, the pangram is complete
    }

    private static int letters(ArrayList<String> pangram) {
    	// Method to count the total number of letters in the pangram
        int letters = 0;
        for (String word : pangram) {
            letters += word.length(); // Count the number of letters in each word and sums them up
        }
        return letters;
    }
}