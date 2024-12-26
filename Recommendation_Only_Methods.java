import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Recommendation_Only_Methods { //fix time
    public static void main(String[] args) { 
		String Name; //name of the user.
		String Help = null; // What the user wants help with
		// Create the main frame
        JFrame frame = new JFrame("Recommendation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        Name = GetUserName();
        if (Name.equalsIgnoreCase("Asif")) {
        	Map<String, Cologne> CologneMap = CreateCologneMap();
        	Map<String, Clothes> ClothesMap = CreateClothesMap();    	
        	JOptionPane.showMessageDialog(frame, "Welcome Back, Sir!\nHow can I help you today?\nWill it be Cologne Recommendations or Clothes Recommendations?\nOr maybe both?");
        	Help = GetHelpChoice();
        	UserRequest(Help, CologneMap, ClothesMap);
        }
    }
    // Method to get the user name
    private static String GetUserName() {
    	String Name;
    	while (true) {
        Name = JOptionPane.showInputDialog(null, "Can you please enter your name");
        if (Name != null && Name.equalsIgnoreCase("Asif")) {
        	break;
        	}else if (Name != null && Name.equalsIgnoreCase("END")) {
        		JOptionPane.showMessageDialog(null, "Guess you don't need my help...\nGoodbye!");
        		System.exit(0); // Ends the program
        		} else {
        			JOptionPane.showMessageDialog(null, "That is not the correct name.\nIf you wish to exit, please type 'END'.");
        		}
    	}
    	return Name;
    }
    // Method to create and populate the cologne 
    private static Map<String, Cologne> CreateCologneMap() {
    	Map<String, Cologne> CologneMap = new HashMap<>(); //Creating a new map
    	// Creating lists of notes for Dior Sauvage 
    	List<String>SauvageTopNotes = Arrays.asList("Bergamont");
    	List<String>SauvageMiddleNotes = Arrays.asList("Sichuan Pepper", "Lavender", "Star Anise", "Nutmeg");
    	List<String>SauvageBaseNotes = Arrays.asList("Ambroxan(Musky Amber)", "Vanilla");
        //Creating lists of notes for Parfums De Marley Greenly
        List<String>GreenleyTopNotes = Arrays.asList("Green Apple", "Calabrian Bergamont", "Mandarin Orange");
        List<String>GreenleyMiddleNotes = Arrays.asList("Petitgrain", "Cedar", "Cashmeran", "Pomarose", "Violet");
        List<String>GreenleyBaseNotes = Arrays.asList("Oakmoss", "Musk", "Amberwood");
        //Creating lists of notes for Jean Paul Gaultier Le Beau Le Parfum
        List<String>LeBeauParfumTopNotes = Arrays.asList("Pineapple", "Iris", "Ginger", "Cypress");
        List<String>LeBeauParfumMiddleNotes = Arrays.asList("Coconut", "Woody Notes");
        List<String>LeBeauParfumBaseNotes = Arrays.asList("Tonka Bean", "SandalWood", "Amber", "Ambergris");	        
        //Creating Lists of Notes for  "Stronger with you Intensely"
        List<String>StrongerWithYouTopNotes = Arrays.asList("Pink Pepper", "Juniper", "Violet");
        List<String>StrongerWithYouMiddleNotes = Arrays.asList("Toffee", "Cinnamon", "Lavender", "Sage");
        List<String>StrongerWithYouBaseNotes = Arrays.asList("Vanilla", "Amber", "Tonka Bean", "Suede");
        //Creating Lists of Notes for Azzaro The Most Wanted Parfum
        List<String>MostWantedTopNotes = Arrays.asList("Ginger");
        List<String>MostWantedMiddleNotes = Arrays.asList("Woody Notes");
        List<String>MostWantedBaseNotes = Arrays.asList("Bourbon Vanilla");
        //Creating List of Notes for Valentino Born in Roma
        List<String>RomaTopNotes = Arrays.asList("Mineral Notes", "Violet Leaf", "Salt");
        List<String>RomaMiddleNotes = Arrays.asList("Ginger" , "Sage");
        List<String>RomaBaseNotes = Arrays.asList("Woody Notes", "Vetiver");        
        //Creating Notes for YSL L'Homme
        List<String>LHommeTopNotes = Arrays.asList("Ginger", "Bergamot", "Lemon");
        List<String>LHommeMiddleNotes = Arrays.asList("Spices", "Violet Leaf", "White Pepper", "Basil");
        List<String>LHommeBaseNotes = Arrays.asList("Tonka Bean", "Cedar", "Tahitian Vetiver");
        //Creating Notes for Dolce&Gabbana Pour Homme Intenso
        List<String>IntensoTopNotes = Arrays.asList("Lavender", "Water Notes", "Basil", "Geranium", "Marigold");
        List<String>IntensoMiddleNotes = Arrays.asList("Tobacco", "Hay", "Clary Sage", "Moepel Accord", "Bran");
        List<String>IntensoBaseNotes = Arrays.asList("Sandalwood", "Cypress", "Musk", "Amber", "Labdanum");
        //Creating Cologne Objects
        Cologne Sauvage = new Cologne("Dior", "Sauvage", SauvageTopNotes, SauvageMiddleNotes, SauvageBaseNotes, Arrays.asList("Date Night/Evening Events", "Formal Events/Weddings"));
        Cologne Greenley = new Cologne("Parfums De Marley", "Greenley", GreenleyTopNotes, GreenleyMiddleNotes, GreenleyBaseNotes, Arrays.asList("Sporting/Outdoor Activities", "Daily Wear/Casual Outing"));
        Cologne LeBeauParfum = new Cologne("Jean Paul Gaultier", "Le Beau Le Parfum", LeBeauParfumTopNotes, LeBeauParfumMiddleNotes, LeBeauParfumBaseNotes, Arrays.asList("Date Night/Evening Events"));
        Cologne StrongerWithYou = new Cologne("Giorgio Armani", "Stronger With You Intensely", StrongerWithYouTopNotes, StrongerWithYouMiddleNotes, StrongerWithYouBaseNotes, Arrays.asList("Date Night/Evening Events"));
        Cologne MostWanted = new Cologne("Azzaro", "The Most Wanted Parfum", MostWantedTopNotes, MostWantedMiddleNotes, MostWantedBaseNotes, Arrays.asList("Date Night/Evening Events", "Formal Events/Weddings"));
        Cologne Roma = new Cologne("Valentino", "Born in Roma", RomaTopNotes, RomaMiddleNotes, RomaBaseNotes, Arrays.asList("Date Night/Evening Events", "Daily Wear/Casual Outing"));
        Cologne LHomme = new Cologne("Yves Saint Laurent", "L'Homme", LHommeTopNotes, LHommeMiddleNotes, LHommeBaseNotes, Arrays.asList("Daily Wear/Casual Outing", "Formal Events/Weddings"));
        Cologne Intenso = new Cologne("Dolce & Gabbana", "Pour Homme Intenso", IntensoTopNotes, IntensoMiddleNotes, IntensoBaseNotes, Arrays.asList("Daily Wear/Casual Outing", "Date Night/Evening Events"));               
        //Storing Cologne objects in the map
        CologneMap.put("Sauvage", Sauvage);
        CologneMap.put("Greenley", Greenley);
        CologneMap.put("LeBeauParfum", LeBeauParfum);
        CologneMap.put("StrongerWithYou",StrongerWithYou);
        CologneMap.put("MostWanted", MostWanted);
        CologneMap.put("Roma", Roma);
        CologneMap.put("LHomme", LHomme);
        CologneMap.put("Intenso", Intenso);
        return CologneMap;
    }
    // Method to create the clothes map
    private static Map<String, Clothes> CreateClothesMap() {
    	Map<String, Clothes> ClothesMap = new HashMap<>(); // Creating a new map
    	//Creating Clothes Objects
    	Clothes GreyTShirt = new Clothes("T-Shirt", "H&M", "Grey", "M", Arrays.asList("Spring", "Summer"), Arrays.asList("Casual"));
    	Clothes CasualPants = new Clothes("Pants", "Uniqlo", "Beige", "M", Arrays.asList("Spring", "Summer", "Fall"), Arrays.asList("Casual", "Smart Casual"));
        Clothes NavyChinos = new Clothes("Chinos", "Dockers", "Navy", "M", Arrays.asList("Spring", "Summer", "Fall"), Arrays.asList("Smart Casual", "Business Casual"));
        Clothes DressShirt = new Clothes("Dress Shirt", "Calvin Klein", "White", "M", Arrays.asList("Year Round"), Arrays.asList("Business Casual", "Business Formal"));
        Clothes FormalSuit = new Clothes("Suit", "Men's Wearhouse", "Charcoal", "M", Arrays.asList("Year Round"), Arrays.asList("Business Formal", "Semi Formal"));
        Clothes Tuxedo = new Clothes("Tuxedo", "Macy's", "Black", "M", Arrays.asList("Year Round"), Arrays.asList("Black Tie"));
        Clothes Blazer = new Clothes("Blazer", "Zara", "Navy", "M", Arrays.asList("Year Round"), Arrays.asList("Semi Formal", "Business Casual"));
        Clothes FormalDressShirt = new Clothes("Formal Dress Shirt", "Van Heusen", "Light Blue", "M", Arrays.asList("Year Round"), Arrays.asList("Business Formal", "Black Tie"));
        Clothes BrownLeatherJacket = new Clothes("Leather Jacket", "AllSaints", "Brown", "M", Arrays.asList("Fall", "Winter"), Arrays.asList("Casual", "Smart Casual"));
        Clothes BlackJeans = new Clothes("Jeans", "Levi's", "Black", "M", Arrays.asList("Year Round"), Arrays.asList("Casual"));
        Clothes KhakiPants = new Clothes("Pants", "Gap", "Khaki", "M", Arrays.asList("Spring", "Summer", "Fall"), Arrays.asList("Casual", "Smart Casual"));
        Clothes LightGreySuit = new Clothes("Suit", "Hugo Boss", "Light Grey", "M", Arrays.asList("Spring", "Summer"), Arrays.asList("Business Formal", "Semi Formal"));
        Clothes WoolOvercoat = new Clothes("Overcoat", "Burberry", "Grey", "M", Arrays.asList("Fall", "Winter"), Arrays.asList("Semi Formal", "Business Casual"));
        Clothes DenimJacket = new Clothes("Jacket", "Levi's", "Blue", "M", Arrays.asList("Spring", "Fall"), Arrays.asList("Casual"));
        Clothes NavyTurtleneck = new Clothes("Turtleneck", "Uniqlo", "Navy", "M", Arrays.asList("Fall", "Winter"), Arrays.asList("Smart Casual", "Business Casual"));
        Clothes FormalBlackShoes = new Clothes("Dress Shoes", "Allen Edmonds", "Black", "M", Arrays.asList("Year Round"), Arrays.asList("Business Formal", "Black Tie"));
        Clothes BrownChelseaBoots = new Clothes("Boots", "Blundstone", "Brown", "M", Arrays.asList("Fall", "Winter"), Arrays.asList("Smart Casual", "Business Casual"));
        Clothes DarkGreyTrousers = new Clothes("Trousers", "Brooks Brothers", "Dark Grey", "M", Arrays.asList("Year Round"), Arrays.asList("Business Formal", "Semi Formal"));
        // Storing Clothes objects in the map
        ClothesMap.put("White Shirt", new Clothes("Shirt", "Primark", "White", "M", Arrays.asList("Spring", "Summer", "Fall"), Arrays.asList("Casual", "Smart Casual")));
        ClothesMap.put("Black Shirt", new Clothes("Shirt", "Primark", "Black", "M", Arrays.asList("Spring", "Summer", "Fall"), Arrays.asList("Casual", "Smart Casual")));
        ClothesMap.put("Grey T-Shirt", GreyTShirt);
        ClothesMap.put("Casual Pants", CasualPants);
        ClothesMap.put("Navy Chinos", NavyChinos);
        ClothesMap.put("Dress Shirt", DressShirt);
        ClothesMap.put("Formal Suit", FormalSuit);
        ClothesMap.put("Tuxedo", Tuxedo);
        ClothesMap.put("Blazer", Blazer);
        ClothesMap.put("Formal Dress Shirt", FormalDressShirt);
        ClothesMap.put("Brown Leather Jacket", BrownLeatherJacket);
        ClothesMap.put("Black Jeans", BlackJeans);
        ClothesMap.put("Khaki Pants", KhakiPants);
        ClothesMap.put("Light Grey Suit", LightGreySuit);
        ClothesMap.put("Wool Overcoat", WoolOvercoat);
        ClothesMap.put("Denim Jacket", DenimJacket);
        ClothesMap.put("Navy Turtleneck", NavyTurtleneck);
        ClothesMap.put("Formal Black Shoes", FormalBlackShoes);
        ClothesMap.put("Brown Chelsea Boots", BrownChelseaBoots);
        ClothesMap.put("Dark Grey Trousers", DarkGreyTrousers);
        return ClothesMap;
    }
    // Method to get help choice from the user
	private static String GetHelpChoice() {
		// Define the options for the user to select
		String[] options = {"Cologne", "Clothes", "Both"};
		// Display the option dialog with buttons
		int choice = JOptionPane.showOptionDialog(null,"Please choose an option:", "Help Choice", 
		  JOptionPane.DEFAULT_OPTION, 
		  JOptionPane.INFORMATION_MESSAGE,
		  null,  options,  options[0]);
		// Check if the user canceled the action
		if (choice == JOptionPane.CLOSED_OPTION) {
			return null;  // User pressed cancel or closed the dialog
		}
		// Return the selected option
		return options[choice];
	}
	//Process User Request 
	private static void UserRequest(String help, Map<String, Cologne> CologneMap, Map<String, Clothes> ClothesMap) {
		String Answer = ""; 
		if (help.equalsIgnoreCase("Cologne")) {
			JOptionPane.showMessageDialog(null, "Looks like you just need help with picking a fragrance today!\nNo worries, I can help!");
			while (true) {
				// Use showOptionDialog to make a clickable option instead of text input
				int option = JOptionPane.showOptionDialog(null, 
						"Before we start, would you like to see your collection of colognes?", 
						"View Cologne Collection", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						new Object[] {"Yes", "No"}, 
						"No");
	
				if (option == JOptionPane.YES_OPTION) { 
					// If the user wants to see their collection
					StringBuilder CologneDetails = new StringBuilder("Your Fragrances:\n\n");
					for (String CologneName : CologneMap.keySet()) {
						CologneDetails.append(CologneMap.get(CologneName).toString()).append("\n"); // Append cologne details
					}
					// Create a JTextArea to display the cologne details
					JTextArea textArea = new JTextArea(CologneDetails.toString());
					textArea.setEditable(false); // Make it non-editable
					textArea.setLineWrap(true); // Wrap lines
					textArea.setWrapStyleWord(true); // Wrap by words
					// Create a JScrollPane to allow scrolling
					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setPreferredSize(new Dimension(300, 200)); // Set preferred size for the scroll pane
					// Show the scroll pane in a JOptionPane
					JOptionPane.showMessageDialog(null, scrollPane, "Cologne Collection", JOptionPane.INFORMATION_MESSAGE);
					break; // Exit the loop after displaying the collection
				} else if (option == JOptionPane.NO_OPTION) {
					// If the user doesn't want to see their collection
					JOptionPane.showMessageDialog(null, "Ok, let's continue!");
					break; // Exit the loop
				}
			}
			String[] TimeDetails = GetTime(); 
			String CologneFormality = GetFormalityCologne();
			String[] WeatherDetails = GetWeatherDetails();
			String CologneRecommendation = RecommendCologne(WeatherDetails[0], TimeDetails[0], CologneFormality, CologneMap);
			JOptionPane.showMessageDialog(null, "Based on the formality, weather, and the time of the event,\n" + CologneRecommendation);
		} else if (help.equalsIgnoreCase("Clothes")) {
			JOptionPane.showMessageDialog(null, "Looks like you just need help with picking an outfit today!\nNo worries, I can help!");
			while (true) {
				// Use showOptionDialog to make a clickable option instead of text input
				int option = JOptionPane.showOptionDialog(null, 
						"Before we start, would you like to see your wardrobe?", 
						"View Wardrobe Collection", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						new Object[] {"Yes", "No"}, 
						"No");
	
				if (option == JOptionPane.YES_OPTION) {
					// If the user wants to see their wardrobe
					StringBuilder wardrobeDetails = new StringBuilder("Your Wardrobe:\n\n");
					for (Map.Entry<String, Clothes> entry : ClothesMap.entrySet()) {
						wardrobeDetails.append(entry.getKey()).append(":\n").append(entry.getValue().toString()).append("\n"); // Append clothes details
					}
					// Create a JTextArea to display the wardrobe details
					JTextArea textArea = new JTextArea(wardrobeDetails.toString());
					textArea.setEditable(false); // Make it non-editable
					textArea.setLineWrap(true); // Wrap lines
					textArea.setWrapStyleWord(true); // Wrap by words
					// Create a JScrollPane to allow scrolling
					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setPreferredSize(new Dimension(300, 200)); // Set preferred size for the scroll pane
					// Show the scroll pane in a JOptionPane
					JOptionPane.showMessageDialog(null, scrollPane, "Wardrobe Collection", JOptionPane.INFORMATION_MESSAGE);
					break; // Exit the loop after displaying the collection
				} else if (option == JOptionPane.NO_OPTION) {
					// If the user does not want to see their wardrobe
					JOptionPane.showMessageDialog(null, "Ok, let's continue!");
					break; // Exit the loop
				}
			}
			String[] TimeDetails = GetTime();
			JOptionPane.showMessageDialog(null, "Thank you! Your event is at " + TimeDetails[1] + " " + TimeDetails[2] + " in the " + TimeDetails[0] + ".");
			String FormalityLevel = GetFormalityClothes();
			String[] WeatherDetails = GetWeatherDetails();
			// Get recommendations
			String ClothingRecommendation = RecommendClothing(WeatherDetails[0], 0, TimeDetails[0], FormalityLevel, ClothesMap);
			String Message = "Based on the formality, weather, and the time of the event:\n" +  "Recommended clothing: " + ClothingRecommendation;
			JOptionPane.showMessageDialog(null, Message, "Clothing Recommendation", JOptionPane.INFORMATION_MESSAGE);
		} else if (help.equalsIgnoreCase("Both")) {
			JOptionPane.showMessageDialog(null, "Seems like you need help with both an outfit and a fragrance\nI can help with that!"); 
			// Display wardrobe
			while (true) {
				// Use showOptionDialog to make a clickable option instead of text input
				int option = JOptionPane.showOptionDialog(null, 
						"Before we start, would you like to see your wardrobe?\nIncluding your fragrances?", 
						"View Wardrobe and Cologne Collection", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						new Object[] {"Yes", "No"}, 
						"No");
	
				if (option == JOptionPane.YES_OPTION) {
					// If the user wants to see their collection
					StringBuilder cologneDetails = new StringBuilder("Your Fragrances:\n\n");
					for (String cologneName : CologneMap.keySet()) {
						cologneDetails.append(CologneMap.get(cologneName).toString()).append("\n"); // Append cologne details
					}
					// Create a JTextArea to display the cologne details
					JTextArea textArea = new JTextArea(cologneDetails.toString());
					textArea.setEditable(false); // Make it non-editable
					textArea.setLineWrap(true); // Wrap lines
					textArea.setWrapStyleWord(true); // Wrap by words
					// Create a JScrollPane to allow scrolling
					JScrollPane scrollPane = new JScrollPane(textArea);
					scrollPane.setPreferredSize(new Dimension(300, 200)); // Set preferred size for the scroll pane
					// Show the scroll pane in a JOptionPane
					JOptionPane.showMessageDialog(null, scrollPane, "Cologne Collection", JOptionPane.INFORMATION_MESSAGE);
					break; // Exit the loop after displaying the collection
				} else if (option == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Ok, let's continue!");
					break; 
				}
			}
			if (Answer.equalsIgnoreCase("YES")) {
				// Display wardrobe collection
				StringBuilder wardrobeDetails = new StringBuilder("Your Wardrobe:\n\n");
				for (Map.Entry<String, Clothes> entry : ClothesMap.entrySet()) {
					wardrobeDetails.append(entry.getKey()).append(":\n").append(entry.getValue().toString()).append("\n"); // Append clothes details
				}
				// Create a JTextArea to display the wardrobe details
				JTextArea wardrobeTextArea = new JTextArea(wardrobeDetails.toString());
				wardrobeTextArea.setEditable(false); // Make it non-editable
				wardrobeTextArea.setLineWrap(true); // Wrap lines
				wardrobeTextArea.setWrapStyleWord(true); // Wrap by words
				// Create a JScrollPane to allow scrolling
				JScrollPane wardrobeScrollPane = new JScrollPane(wardrobeTextArea);
				wardrobeScrollPane.setPreferredSize(new Dimension(300, 200)); // Set preferred size for the scroll pane
				// Show the scroll pane in a JOptionPane
				JOptionPane.showMessageDialog(null, wardrobeScrollPane, "Wardrobe Collection", JOptionPane.INFORMATION_MESSAGE);
			}
	
			String[] TimeDetails = GetTime();
			JOptionPane.showMessageDialog(null, "Thank you! Your event is at " + TimeDetails[1] + " " + TimeDetails[2] + " in the " + TimeDetails[0] + ".");
			
			String CologneFormality = GetFormalityCologne();
			String FormalityLevel = GetFormalityClothes();
			String[] WeatherDetails = GetWeatherDetails();
			String CologneRecommendation = RecommendCologne(WeatherDetails[0], TimeDetails[0], CologneFormality, CologneMap);
			String ClothingRecommendation = RecommendClothing(WeatherDetails[0], 0, TimeDetails[0], FormalityLevel, ClothesMap);
			JOptionPane.showMessageDialog(null, "Based on the formality, weather, and the time of the event,\n" + CologneRecommendation);
			JOptionPane.showMessageDialog(null, "Based on the formality, weather, and the time of the event,\n" + ClothingRecommendation);
		}
	}		
	private static String[] GetTime() {
		String TimeOfDay;
		String AmPm;
		int Hour = 0; // Initialize hour
	
		// Loop until the user selects a valid time of day
		while (true) {
			String[] options = {"Morning", "Afternoon", "Night"};
			int option = JOptionPane.showOptionDialog(null, 
					"What time of day will this event be?\n" +
					"The options are: Morning (4am-11am), Afternoon (12pm-6pm), Night (7pm-3am)", 
					"Select Time of Day", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					options, 
					options[0]);
	
			if (option == JOptionPane.CLOSED_OPTION) { // If user presses Cancel
				JOptionPane.showMessageDialog(null, "Action canceled.");
				System.exit(0); // Exit if the user pressed Cancel
			}
	
			TimeOfDay = options[option].trim();
	
			// Validate the selected time of day
			if (TimeOfDay.equalsIgnoreCase("Morning") || TimeOfDay.equalsIgnoreCase("Afternoon") || TimeOfDay.equalsIgnoreCase("Night")) {
				break; 
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input. Please select Morning, Afternoon, or Night.");
			}
		}
	
		// Loop until the user selects a valid hour
		while (true) {
			String InputHour = JOptionPane.showInputDialog(null, "Enter the specific hour (1-12) for the event:");
			if (InputHour == null) { // Check if user pressed Cancel
				JOptionPane.showMessageDialog(null, "Action canceled.");
				System.exit(0); // Exit if the user pressed Cancel
			}
	
			Hour = Integer.parseInt(InputHour); // Parse the input to an integer
			if (Hour >= 1 && Hour <= 12) {
				break; // Valid hour
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter an hour between 1 and 12.");
			}
		}
	
		// Loop until the user selects AM or PM
		while (true) {
			String[] ampmOptions = {"AM", "PM"};
			int ampmChoice = JOptionPane.showOptionDialog(null, 
					"Is it AM or PM?", 
					"Select AM/PM", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					ampmOptions, 
					ampmOptions[0]);
	
			if (ampmChoice == JOptionPane.CLOSED_OPTION) { // Check if user pressed Cancel
				JOptionPane.showMessageDialog(null, "Action canceled. Exiting...");
				System.exit(0); // Exit if the user pressed Cancel
			}
	
			AmPm = ampmOptions[ampmChoice].trim().toUpperCase();
	
			// Validate AM or PM input
			if (AmPm.equals("AM") || AmPm.equals("PM")) {
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input. Please select AM or PM.");
			}
		}
	
		// Validate the time based on the time of day
		while (true) {
			boolean IsValid = true;
			if (TimeOfDay.equalsIgnoreCase("Morning")) {
				if (AmPm.equals("PM") || Hour < 4 || Hour > 11) {
					IsValid = false; // Set flag to false if invalid
					JOptionPane.showMessageDialog(null, "Invalid input. Morning is between 4am and 11am. Please try again.");
				}
			} else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
				if (AmPm.equals("AM") || Hour < 12 || Hour > 6) {
					IsValid = false; // Set flag to false if invalid
					JOptionPane.showMessageDialog(null, "Invalid input. Afternoon is between 12pm and 6pm. Please try again.");
				}
			} else if (TimeOfDay.equalsIgnoreCase("Night")) {
				if ((AmPm.equals("AM") && Hour >= 4) || (AmPm.equals("PM") && Hour < 7)) {
					IsValid = false; // Set flag to false if invalid
					JOptionPane.showMessageDialog(null, "Invalid input. Night is between 7pm and 3am. Please try again.");
				}
			}
	
			if (IsValid) {
				break;
			}
			// Prompt user to re-enter the time
			String InputHour = JOptionPane.showInputDialog(null, "Enter the specific hour (1-12) for the event:");
			if (InputHour == null) { // Check if user pressed Cancel
				JOptionPane.showMessageDialog(null, "Action canceled.");
				System.exit(0); // Exit if the user pressed Cancel
			}
			Hour = Integer.parseInt(InputHour); // Parse the input to an integer
	
			// Check if the hour is valid
			while (true) {
				if (Hour >= 1 && Hour <= 12) {
					break; // Valid hour
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter an hour between 1 and 12.");
				}
			}
	
			String[] ampmOptionsReenter = {"AM", "PM"};
			int ampmChoiceReenter = JOptionPane.showOptionDialog(null, 
					"Is it AM or PM?", 
					"Select AM/PM", 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					ampmOptionsReenter, 
					ampmOptionsReenter[0]);
	
			if (ampmChoiceReenter == JOptionPane.CLOSED_OPTION) { // Check if user pressed Cancel
				JOptionPane.showMessageDialog(null, "Action canceled.");
				System.exit(0); // Exit if the user pressed Cancel
			}
	
			AmPm = ampmOptionsReenter[ampmChoiceReenter].trim().toUpperCase();
		}
	
		return new String[] { TimeOfDay, String.valueOf(Hour), AmPm };
	}		
    //Method to Get Cologne Formality.
    private static String GetFormalityCologne(){
    	String Helper;
    	String CologneForm = "";
    	while (true) {
    		String input = JOptionPane.showInputDialog(null, "What kind of formality will this event be?\n" + "If you are confused on formality level, please type in HELP.\n" +"If not, type in NO.");
    		Helper = input != null ? input.trim() : "";
    		if (Helper.equalsIgnoreCase("HELP")) {
    			ShowHelpCologne(); 
    			break; 
    			} else if (Helper.equalsIgnoreCase("NO")) {
    				JOptionPane.showMessageDialog(null, "That's great, you know your formality types.\nLet's move on then!");
    				break; 
    				} else {
    					JOptionPane.showMessageDialog(null, "Invalid Input. Please type either HELP or NO.");
    				}
    	}
    	// Create options for formality levels
    	String[] Options = {
    			"Daily Wear/Casual Outing",
    			"Sporting/Outdoor Activities",
    			"Date Night/Evening Events",
    			"Formal Events/Weddings"
    	};
    	// Create a JList for scrollable options
    	JList<String> formalityList = new JList<>(Options);
    	formalityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	formalityList.setVisibleRowCount(4); // Show all options
    	// Create a JScrollPane to allow scrolling
    	JScrollPane scrollPane = new JScrollPane(formalityList);
    	scrollPane.setPreferredSize(new Dimension(300, 100)); // Set preferred size for the scroll pane
    	// Show the scroll pane in a JOptionPane
    	JOptionPane.showMessageDialog(null, scrollPane, "Select Formality Level", JOptionPane.QUESTION_MESSAGE);
    	// Get the selected value
        String selectedValue = formalityList.getSelectedValue();
        if (selectedValue != null) {
        	CologneForm = selectedValue; // Set the cologneForm based on user selection
        	} else {
        		JOptionPane.showMessageDialog(null, "No selection made.");
        		System.exit(0); // Exit if no selection is made
        		}
        return CologneForm; // Return the selected formality level
    }
    //Display the Cologne formalities if asked.
    private static void ShowHelpCologne() {
    	String HelpMessage = "Don't worry! Formality types for events can be confusing.\n" +
    			"There are a few different formality types, they include:\n\n" +
    			"Different fragrances for different occasions:\n\n" +
    			"1) Daily Wear & Work/Professional Settings:\n" +
    			"   Scents that are typically subtle and non-intrusive.\n\n" +
    			"2) Casual Outings & Sports/Outdoor Activities:\n" +
    			"   Invigorating and clean scents for active lifestyles.\n\n" +
    			"3) Date Nights & Evening Events:\n" +
    			"   Warm, sensual colognes that transition smoothly for romantic occasions.\n\n" +
    			"4) Formal Events & Weddings:\n" +
    			"   Sophisticated colognes with complex notes for special occasions.";
    	JOptionPane.showMessageDialog(null, HelpMessage); // Display help information
    }
  //Display the Clothes formalities if asked.
  private static String GetFormalityClothes() {
	  String Helper;
	  JOptionPane.showMessageDialog(null, "What kind of formality will this event be?\n" +
	  "If you are confused about formality levels, please type in HELP.\n" +"If not, type in NO.");
	  while (true) {
		  Helper = JOptionPane.showInputDialog(null, "Type 'HELP' for information or 'NO' to proceed:");
		  if (Helper != null) {
			  Helper = Helper.trim(); 
			  if (Helper.equalsIgnoreCase("HELP")) {
				  ShowHelpClothes(); 
				  } else if (Helper.equalsIgnoreCase("NO")) {
					  JOptionPane.showMessageDialog(null, "That's great, you know your formality types. Let's move on!");
					  break; 
					  } else {
						  JOptionPane.showMessageDialog(null, "Invalid Input! Please type in either HELP or NO.");
					  }
		  } else {
			  //Cancel action
			  JOptionPane.showMessageDialog(null, "Action canceled.");
			  System.exit(0); 
		  }
	  }
	  String[] Options = {"Casual", "Smart Casual", "Business Casual", "Business Formal", "Semi Formal", "Black Tie"};
      // Create a JList for scrollable options
	  JList<String> formalityList = new JList<>(Options);
	  formalityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	  formalityList.setVisibleRowCount(6); // Show all options
	  // Create a JScrollPane to allow scrolling
	  JScrollPane scrollPane = new JScrollPane(formalityList);
	  scrollPane.setPreferredSize(new Dimension(300, 100)); // Set preferred size for the scroll pane
	  // Show the scroll pane in a JOptionPane
	  JOptionPane.showMessageDialog(null, scrollPane, "Select Formality Level", JOptionPane.QUESTION_MESSAGE);
	  // Get the selected value
	  String selectedValue = formalityList.getSelectedValue();
	  if (selectedValue != null) {
		  return selectedValue; // Return the selected formality level
		  } else {
			  JOptionPane.showMessageDialog(null, "No selection made.");
			  System.exit(0); 
			  return " "; 
		  }
  }
  //Display Clothes Formalities if asked 
  private static void ShowHelpClothes() {
	  String HelpMessage = "Don't worry! Formality types for events can be confusing.\n" +
			  "There are a few different formality types, they include:\n\n" +
			  "1) Casual: Everyday wear, casual social gatherings, relaxed office environments.\n" +
			  "2) Smart Casual: Informal dinner parties, casual dates, or upscale casual events.\n" +
			  "3) Business Casual: Less formal office environments, casual client meetings.\n" +
			  "4) Business Formal: Business meetings, job interviews, formal workplace environments.\n" +
			  "5) Semi-Formal: Evening weddings, corporate parties, or sophisticated social events.\n" +
			  "6) Black Tie: Formal weddings, gala dinners, award ceremonies.";
	  JOptionPane.showMessageDialog(null, HelpMessage); 
  }
  // Method to show help information for formality levels
  private static String[] GetWeatherDetails() {
	  String WeatherCondition;
	  while (true) {
		  String input = JOptionPane.showInputDialog(null, "Please enter the current weather condition:\n" +  "Is it warm, cool, hot, or cold outside?");
		  if (input == null) {
			  JOptionPane.showMessageDialog(null, "Action canceled. ");
			  System.exit(0);
		  }
		  WeatherCondition = input.trim(); 
		  if (WeatherCondition.equalsIgnoreCase("Warm") || WeatherCondition.equalsIgnoreCase("Cool")||WeatherCondition.equalsIgnoreCase("Hot") ||WeatherCondition.equalsIgnoreCase("Cold")) {
			  break; 
			  } else {
				  JOptionPane.showMessageDialog(null, "Invalid Input.\nPlease enter either warm, cool, hot, or cold.");
			  }
	  }
	  // Prompt for the current temperature
	  while (true) {
		  String input = JOptionPane.showInputDialog(null, "Please enter the current temperature in degrees Fahrenheit:");
		  if (input == null) {
			  JOptionPane.showMessageDialog(null, "Action canceled.");
			  System.exit(0); 
		  }       
		  try {
			  int Temperature = Integer.parseInt(input); 
			  // Validate input for temperature
			  if (Temperature < 150 && Temperature > -75) {
				  break; 
				  } else {
					  String Message = Temperature >= 150 ? "Wow, that's hot!" : "That's really cold!";
        			JOptionPane.showMessageDialog(null, Message + "\nPlease enter a valid temperature:");
				  }
			  } catch (NumberFormatException e) {
				  JOptionPane.showMessageDialog(null, "Invalid temperature. Please enter a valid integer value.");
			  }
	  }
	  // Return the valid weather condition as an array
	  return new String[] { WeatherCondition }; 
  }
  //Method to return Recommended Cologne
  private static String RecommendCologne(String WeatherCondition, String TimeOfDay, String Formal, Map<String, Cologne> CologneMap) {
	  String Cologne = "";  // Variable to store the recommended cologne
	  // Daily Wear/Casual Outing recommendations
	  if (Formal.equalsIgnoreCase("Daily Wear/Casual Outing")) {
		  Cologne = GetCologneForDailyWear(TimeOfDay, WeatherCondition, CologneMap);
	  }
	  // Sporting/Outdoor Activities recommendations
	  else if (Formal.equalsIgnoreCase("Sporting/Outdoor Activities")) {
		  Cologne = GetCologneForOutdoorActivities(TimeOfDay, WeatherCondition, CologneMap);
	  }
	  // Date Night/Evening Events recommendations
	  else if (Formal.equalsIgnoreCase("Date Night/Evening Events")) {
		  Cologne = GetCologneForDateNight(TimeOfDay, WeatherCondition, CologneMap);
	  }
	  // Formal Events/Weddings recommendations
	  else if (Formal.equalsIgnoreCase("Formal Events/Weddings")) {
		  Cologne = GetCologneForFormalEvents(TimeOfDay, WeatherCondition, CologneMap);
	  }
	  // If no cologne is selected, return a default message
	  if (Cologne.isEmpty()) {
		  return "No specific cologne recommendation found for this combination.";  
	  }
	  return String.format(
			    "Your recommended cologne for the occasion is:\n\n" + "🌸 Cologne: %s\n\n" + "Enjoy wearing it and make a lasting impression!",      
			    Cologne );
  }
  //Method For Daily Wear Cologne.
  private static String GetCologneForDailyWear(String TimeOfDay, String WeatherCondition, Map<String, Cologne> CologneMap) {
	  if (TimeOfDay.equalsIgnoreCase("Morning")) {
		  return GetMorningCologne(WeatherCondition, CologneMap);
		  } else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
			  return GetAfternoonCologne(WeatherCondition, CologneMap);
			  } else if (TimeOfDay.equalsIgnoreCase("Night")) {
				  return GetNightCologne(WeatherCondition, CologneMap);
			  }
	  return " "; 
  }
  //Method Outdoor Activites.
  private static String GetCologneForOutdoorActivities(String timeOfDay, String weatherCondition, Map<String, Cologne> cologneMap) {
      if (timeOfDay.equalsIgnoreCase("Morning")) {
          if (weatherCondition.equalsIgnoreCase("Hot") || weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Greenley").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("LHomme").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("Sauvage").getName();  
          }
      } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
          if (weatherCondition.equalsIgnoreCase("Hot") || weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Greenley").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("LHomme").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("Sauvage").getName();  
          }
      } else if (timeOfDay.equalsIgnoreCase("Night")) {
          if (weatherCondition.equalsIgnoreCase("Hot") || weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Greenley").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("LHomme").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("Sauvage").getName();  
          }
      }
      return " "; 
  }
  //Method for Night Cologne.
  private static String GetCologneForDateNight(String timeOfDay, String weatherCondition, Map<String, Cologne> cologneMap) {
      if (timeOfDay.equalsIgnoreCase("Morning")) {
          if (weatherCondition.equalsIgnoreCase("Hot")) {
              return cologneMap.get("LeBeauParfum").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("MostWanted").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("StrongerWithYou").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Roma").getName();  
          }
      } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
          if (weatherCondition.equalsIgnoreCase("Hot")) {
              return cologneMap.get("LeBeauParfum").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("MostWanted").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("StrongerWithYou").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Roma").getName();  
          }
      } else if (timeOfDay.equalsIgnoreCase("Night")) {
          if (weatherCondition.equalsIgnoreCase("Hot")) {
              return cologneMap.get("LeBeauParfum").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("MostWanted").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("StrongerWithYou").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Roma").getName();  
          }
      }
      return " "; 
  }
  //Method Formal Events
  private static String GetCologneForFormalEvents(String timeOfDay, String weatherCondition, Map<String, Cologne> cologneMap) {
      if (timeOfDay.equalsIgnoreCase("Morning")) {
          if (weatherCondition.equalsIgnoreCase("Hot") || weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Sauvage").getName();  
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("Intenso").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("MostWanted").getName();  
          }
      } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
          if (weatherCondition.equalsIgnoreCase("Hot") || weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Sauvage").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("Intenso").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("MostWanted").getName();  
          }
      } else if (timeOfDay.equalsIgnoreCase("Night")) {
          if (weatherCondition.equalsIgnoreCase("Hot") || weatherCondition.equalsIgnoreCase("Warm")) {
              return cologneMap.get("Sauvage").getName();
          } else if (weatherCondition.equalsIgnoreCase("Cold")) {
              return cologneMap.get("Intenso").getName(); 
          } else if (weatherCondition.equalsIgnoreCase("Cool")) {
              return cologneMap.get("MostWanted").getName();  
          }
      }
      return " "; 
  }
  //Method for Morning Cologne
  private static String GetMorningCologne(String WeatherCondition, Map<String, Cologne> CologneMap) {
	  if (WeatherCondition.equalsIgnoreCase("Hot")) {
		  return CologneMap.get("Greenley").getName();  
		  } else if (WeatherCondition.equalsIgnoreCase("Cold")) {
			  return CologneMap.get("Intenso").getName(); 
			  } else if (WeatherCondition.equalsIgnoreCase("Cool")) {
				  return CologneMap.get("LHomme").getName(); 
				  } else if (WeatherCondition.equalsIgnoreCase("Warm")) {
					  return CologneMap.get("Sauvage").getName(); 
				  }
	  return " "; 
  }
  //Method for Afternoon Colgone.
  private static String GetAfternoonCologne(String weatherCondition, Map<String, Cologne> cologneMap) {
	  if (weatherCondition.equalsIgnoreCase("Hot")) {
		  return cologneMap.get("Greenley").getName();  
		  } else if (weatherCondition.equalsIgnoreCase("Cold")) {
			  return cologneMap.get("Intenso").getName();  
			  } else if (weatherCondition.equalsIgnoreCase("Cool")) {
				  return cologneMap.get("Roma").getName(); 
				  } else if (weatherCondition.equalsIgnoreCase("Warm")) {
					  return cologneMap.get("LeBeauParfum").getName(); 
				  }
	  return ""; 
  }
  //Method for Night Cologne.
  private static String GetNightCologne(String weatherCondition, Map<String, Cologne> cologneMap) {
	  if (weatherCondition.equalsIgnoreCase("Hot")) {
		  return cologneMap.get("LeBeauParfum").getName();  
		  } else if (weatherCondition.equalsIgnoreCase("Cold")) {
			  return cologneMap.get("MostWanted").getName(); 
			  } else if (weatherCondition.equalsIgnoreCase("Cool")) {
				  return cologneMap.get("StrongerWithYou").getName();  
				  } else if (weatherCondition.equalsIgnoreCase("Warm")) {
					  return cologneMap.get("Roma").getName();  
				  }
	  return ""; 
  }
  //Method to return Reccomended Outfit
  private static String RecommendClothing(String Weather, int Temp, String TimeOfDay, String Formal, Map<String, Clothes> Wardrobe) {
	  String Top = "";
	  String Pants = "";
	  String Shoes = "";    
	  // Check for Casual formality
	  if (Formal.equalsIgnoreCase("Casual")) {
		  if (TimeOfDay.equalsIgnoreCase("Morning")) {
			  Top = Wardrobe.get("Grey T-Shirt").getType();  
			  Pants = "Shorts";  
	          Shoes = "Sneakers";  
	          } else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
	        	  Top = "Short-Sleeve Shirt";  
	        	  Pants = "Shorts";  
	        	  Shoes = "Sandals";  
	        	  } else if (TimeOfDay.equalsIgnoreCase("Night")) {
	        		  Top = "Light T-Shirt";  
	        		  Pants = "Shorts";  
	        		  Shoes = "Sandals";  
	        	  }
	  }
	  // Check for Smart Casual formality
	  else if (Formal.equalsIgnoreCase("Smart Casual")) {
		  if (TimeOfDay.equalsIgnoreCase("Morning")) 
			  Top = Wardrobe.get("White Shirt").getType();  
			  Pants = "Light Chinos"; 
			  Shoes = "Loafers";  
			  } else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
				  Top = Wardrobe.get("Blazer").getType();  
				  Pants = Wardrobe.get("Navy Chinos").getType(); 
				  Shoes = "Smart Casual Shoes"; 
				  } else if (TimeOfDay.equalsIgnoreCase("Night")) {
					  Top = "Dress Shirt"; 
					  Pants = "Chinos or Dress Pants"; 
					  Shoes = "Smart Casual Shoes";  
				  }
	  // Check for Business Casual formality
	  else if (Formal.equalsIgnoreCase("Business Casual")) {
		  if (TimeOfDay.equalsIgnoreCase("Morning")) {
			  Top = Wardrobe.get("Dress Shirt").getType();  
			  Pants = Wardrobe.get("Khaki Pants").getType();  
			  Shoes = "formal shoes"; 
			  } else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
				  Top = Wardrobe.get("Blazer").getType();  
				  Pants = Wardrobe.get("Dark Grey Trousers").getType();  
				  Shoes = Wardrobe.get("Formal Black Shoes").getType();  
				  } else if (TimeOfDay.equalsIgnoreCase("Night")) {
					  Top = Wardrobe.get("Dress Shirt").getType();  
					  Pants = "dress pants";  
					  Shoes = Wardrobe.get("Formal Black Shoes").getType();  
				  }
	  }
	  // Check for Business Formal formality
	  else if (Formal.equalsIgnoreCase("Business Formal")) {
		  if (TimeOfDay.equalsIgnoreCase("Morning")) {
			  Top = Wardrobe.get("Formal Dress Shirt").getType();  
			  Pants = Wardrobe.get("Dark Grey Trousers").getType(); 
			  Shoes = Wardrobe.get("Formal Black Shoes").getType();
			  } else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
				  Top = Wardrobe.get("Formal Dress Shirt").getType();  
				  Pants = Wardrobe.get("Formal Suit").getType();
				  Shoes = Wardrobe.get("Formal Black Shoes").getType();
				  } else if (TimeOfDay.equalsIgnoreCase("Night")) {
					  Top = Wardrobe.get("Formal Dress Shirt").getType();  
					  Pants = "Tailored trousers"; 
					  Shoes = Wardrobe.get("Formal Black Shoes").getType(); 
				  }
	  }
	    // Check for Semi Formal formality
	    else if (Formal.equalsIgnoreCase("Semi Formal")) {
	        if (TimeOfDay.equalsIgnoreCase("Morning")) {
	            Top = Wardrobe.get("Blazer").getType(); 
	            Pants = Wardrobe.get("Dark Grey Trousers").getType();  
	            Shoes = "formal shoes";  
	        } else if (TimeOfDay.equalsIgnoreCase("Afternoon")) {
	            Top = "dress shirt";  
	            Pants = Wardrobe.get("Dark Grey Trousers").getType();  
	            Shoes = "formal shoes";  
	        } else if (TimeOfDay.equalsIgnoreCase("Night")) {
	            Top = "semi-formal suit";  
	            Pants = "matching trousers";  
	            Shoes = Wardrobe.get("Formal Black Shoes").getType();  
	        }
	    }
	  // Black Tie formality
	    else if (Formal.equalsIgnoreCase("Black Tie")) {
	        if (TimeOfDay.equalsIgnoreCase("Evening")) {
	            Top = Wardrobe.get("Tuxedo").getType();  
	            Pants = "matching trousers"; 
	            Shoes = Wardrobe.get("Formal Black Shoes").getType();  
	        }
	    }
	  if (Top.isEmpty() || Pants.isEmpty() || Shoes.isEmpty()) {
	        return "No specific recommendation found for this combination.";  // if no valid combination is found
	    }
	  return String.format("Here's your recommended outfit:\n\n" +
              "👕 Top: %s\n" +
              "👖 Pants: %s\n" +
              "👟 Shoes: %s\n\n" +
              "Enjoy your day and dress with style!", Top, Pants, Shoes);
  }
}