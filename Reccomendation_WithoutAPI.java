import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Recommendation_WithoutAPI { 
	@SuppressWarnings("null") 
	public static void main(String[] args) {
		//All the variables that are used in the program.
		String name; //name of the user.
		String help = null; // What the user wants help with
		String Answer = null; //Answer for if they want to see there wardrobe.

		int hour = 0; //the time of the event 
		String TimeOfDay = null;// if the event is in the morning, afternoon or the night
		String AmPm = null; // if the time is either am or pm for the user
		
		String Helper = null; // help for formality types
		int cologne; // which colgone formailty level
		String Cologne_Form = null; // depending on the number the user chooses 
		String formal = null; //which clothes formality level.
		String Cologne_Help; //if the user wants to see the notes of the cologne
		
        String WeatherCondition = " "; // current weather condition for the reccomendation
        int temperature = 0; //current weather condition of the user area
		
		Scanner sc = new Scanner(System.in); //Scanner initalization
	
	System.out.println("Can you please enter your name");
	name = sc.next(); //user input
	
	while (!name.equalsIgnoreCase("Asif")){ //if the user types in the correct name.
	    if (!name.equalsIgnoreCase("Asif")) {
	        System.out.println("That is not the correct name."); 
	        System.out.println("If you wish to exit, please type 'END'."); 
	        System.out.println("If not, please try again:"); 
	        name = sc.next(); //user input
	    }

	    if (name.equalsIgnoreCase("Asif")) {
	    	break;
	    } 
	    else if (name.equalsIgnoreCase("END")){
	    	sc.close(); //closes scanner.
	    	System.out.println("Guess you dont need my help..."); 
	    	System.out.println("Goodbye!"); 
	    	System.exit(0); // Ends the program
	    }
	}
	
	if(name.equalsIgnoreCase("Asif")) {
		
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
        
        //Creating Notes for YSL L'Homme(Summer spring day time)
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
               
        Map<String, Cologne> CologneMap = new HashMap<>(); //Creating a new map

		//Storing Cologne objects in the map
        CologneMap.put("Sauvage", Sauvage); 
        CologneMap.put("Greenley", Greenley);
        CologneMap.put("LeBeauParfum", LeBeauParfum);
        CologneMap.put("StrongerWithYou",StrongerWithYou);
        CologneMap.put("MostWanted", MostWanted);
        CologneMap.put("Roma", Roma);
        CologneMap.put("LHomme", LHomme);
        CologneMap.put("Intenso", Intenso);
        
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

        	        
		System.out.println("Welcome Back Sir!" ); 
		System.out.println("How can i help you today?"); 
		System.out.println("Will it be Cologne Recommendations or Clothes Recommendations?"); 
		System.out.println("Or maybe both?"); 
		help = sc.next().trim(); //input for the help variable

		//While the user enters the wrong input
		while(!help.equalsIgnoreCase("Both") && !help.equalsIgnoreCase("Cologne") && !help.equalsIgnoreCase("Clothes")) { 
			System.out.println("Invalid Input,Please type in Cologne,Clothes or Both: "); 
			help = sc.next().trim(); //input for help variable
		}
		
		//if the user needs help with just colognes.
		if(help.equalsIgnoreCase("Cologne")) { 
			System.out.println("Looks like you just need help with picking a fragrance today!"); 
			System.out.println("No worries, i can help!");
			
			System.out.println("Before we Start would you like to see your collection of colognes?");
			Answer = sc.next().trim(); //input for answer variable

			while(!Answer.equalsIgnoreCase("YES") && !Answer.equalsIgnoreCase("NO")) { //while the user enters the incorrect input 
				System.out.println("Invalid Input, Please answer Yes Or No:"); 
				Answer = sc.next().trim(); //User input 
			}

			if(Answer.equalsIgnoreCase("YES")) { 
				System.out.println("Your Fragrances:");
				System.out.println(" "); //empty line for spacing
		        for (String cologneName : CologneMap.keySet()) {
		            System.out.println(CologneMap.get(cologneName));  // Print cologne details
		        } 
			}
			else if(Answer.equalsIgnoreCase("No")) { //if the user types in no
				System.out.println("Ok, lets continue!");
			}
			System.out.println("What time of day will this event be?"); 
			System.out.println("The options are:");
			System.out.println("Morning, which is between 4am and 11am");
			System.out.println("Afternoon, which is between 12pm and 6pm");
			System.out.println("Night, which is between 7pm and 3am");
			String timeOfDay = sc.next().trim();//user input
			
			while (!timeOfDay.equalsIgnoreCase("Morning") && !timeOfDay.equalsIgnoreCase("Afternoon") && !timeOfDay.equalsIgnoreCase("Night")) {
				System.out.println("Invalid input. Please enter Morning, Afternoon, or Night:");
				timeOfDay = sc.next().trim();
			}
			
			System.out.println("Enter the specific hour (1-12) for the event:");
			hour = sc.nextInt();
			while (hour < 1 || hour > 12) {
				System.out.println("Invalid input. Please enter an hour between 1 and 12:");
				hour = sc.nextInt();
			}
			
			System.out.println("Is it AM or PM?");
			String amPm = sc.next().trim().toUpperCase();
			while (!amPm.equals("AM") && !amPm.equals("PM")) {
				System.out.println("Invalid input. Please enter AM or PM:");
				amPm = sc.next().trim().toUpperCase();
			}
			
			// Validate based on the time of day
			if (timeOfDay.equalsIgnoreCase("Morning") && (amPm.equals("PM") || hour < 4 || hour > 11)) {
				System.out.println("Invalid input. Morning is between 4am and 11am. Please try again.");
			} else if (timeOfDay.equalsIgnoreCase("Afternoon") && 
					   (amPm.equals("AM") || (hour != 12 && hour > 6))) {
				System.out.println("Invalid input. Afternoon is between 12pm and 6pm. Please try again.");
			} else if (timeOfDay.equalsIgnoreCase("Night") && 
					   ((amPm.equals("AM") && hour >= 4) || (amPm.equals("PM") && hour < 7 && hour != 12))) {
				System.out.println("Invalid input. Night is between 7pm and 3am. Please try again.");
			} else {
				// If all checks pass
				System.out.println("Thank you! Your event is at " + hour + " " + amPm + " in the " + timeOfDay + ".");
			}
			
			System.out.println(" ");
			System.out.println("What kind of formality will this event be?"); 
			System.out.println("If you are confused on formality level please type in HELP"); 
			System.out.println("If not type in NO"); 
			Helper = sc.next().trim(); //User Input
			
			while(!Helper.equalsIgnoreCase("HELP") && !Helper.equalsIgnoreCase("NO")){ // While loop that plays incase the user enters the wrong input
				System.out.println("Invalid Input"); //Prints this line to the console
				System.out.println("Please type in either HELP or NO"); 
				Helper = sc.next().trim(); //User input 
				
				if(Helper.equalsIgnoreCase("HELP") && Helper.equalsIgnoreCase("NO")) { //if the user enters the right input
					break; //break out of the loop
				}
			}
			
			if(Helper.equalsIgnoreCase("HELP")) {
				System.out.println(" "); //Extra line for spacing
				System.out.println("Dont worry"); 
				System.out.println("Formality types for events can be confusing"); 
				System.out.println("Their are a few different formality types, they include:"); 
				
				System.out.println("");//Extra line for spacing 
				System.out.println("Different fragrances for different occasions");
				System.out.println("These occasions include: ");
				System.out.println("");//Extra line for spacing
				
				System.out.println("Daily Wear & Work/Professional Settings");
				System.out.println("These scents are typically subtle and non-intrusive, making them versatile for casual settings and professional environments alike."); //Prints this line to the console
				System.out.println("");//Extra line for spacing

				System.out.println("Casual Outings & Sports/Outdoor Activities");
				System.out.println("These scents are invigorating and clean, complementing active lifestyles and relaxed settings.");//Prints this line to the console
				System.out.println("");//Extra line for spacing

				System.out.println("Date Nights & Evening Events");
				System.out.println("Warm, sensual colognes with notes like amber, vanilla, or musk can transition smoothly from a romantic date to a more formal evening event");//Prints this line to the console
				System.out.println("");//Extra line for spacing

				System.out.println("Formal Events & Weddings");
				System.out.println("Sophisticated colognes with complex, elegant notes such as sandalwood, oud, or leather can be worn at formal events, weddings, or special occasions. These colognes often leave a lasting impression and are ideal for events where dressing up is key.");//Prints this line to the console
				System.out.println("");//Extra line for spacing
				
			}
			else if (Helper.equalsIgnoreCase("NO")){
				System.out.println("Thats great, you know your formality types");
				System.out.println("Lets move on then");
			}
			System.out.println(" ");//Extra line for spacing
			System.out.println("What level of formality will this event be?"); 
			System.out.println("Please Choose From the Following:"); 
			System.out.println("1)Daily Wear/Casual Outing"); 
			System.out.println("2)Sporting/OutDoor Activites"); 
			System.out.println("3)Date Night/ Evening Events"); 
			System.out.println("4)Formal Events/Weddings"); 
			
			cologne = sc.nextInt(); //User input 
			
			while(cologne <= 0 || cologne > 4){// add the conditions
				System.out.println("Wrong input"); 
				System.out.println("Please type in a number 1 through 4"); 
				System.out.println(""); 
				cologne = sc.nextInt(); //User input
			}
			
			if(cologne == 1) {
				Cologne_Form = "Daily Wear/Casual Outing";
			}
			else if(cologne == 2) {
				Cologne_Form = "Sporting/OutDoor Activites";
			}
			else if(cologne == 3) {
				Cologne_Form = "Date Night/ Evening Events";
			}
			else if(cologne == 4) {
				Cologne_Form = ("Formal Events/Weddings");
			}
			System.out.println("You have selected " + Cologne_Form + "."); 

			System.out.println("Please enter the current weather condition");
			System.out.println("is it warm,cool,hot,or cold outside?");
			WeatherCondition = sc.next().trim(); //User input
			
			while (!WeatherCondition.equalsIgnoreCase("Warm")&& !WeatherCondition.equalsIgnoreCase("Cool") &&!WeatherCondition.equalsIgnoreCase("Hot")&&!WeatherCondition.equalsIgnoreCase("Cold")) {
				System.out.println("Invalid Input");
				System.out.println("Please enter either warm,cool,hot, or cold:");
				WeatherCondition = sc.next().trim(); //User input
			}
			
			System.out.print("Please enter the current temperature in degrees Fahrenheit:");
			temperature = sc.nextInt(); //User input
			
			while(temperature >= 150 || temperature <= -75 ) {
				if(temperature >= 150) {
					System.out.println("Wow thats hot");
					System.out.println("Please enter a valid temperture:");
					temperature = sc.nextInt(); //User input
				}
				else if(temperature <= -75) {
					System.out.println("Thats really cold");
					System.out.println("Please enter a valid input");
					temperature = sc.nextInt(); //User input
				}
			}

			// Get recommendations
			String cologneRecommendation = recommendCologne(WeatherCondition, TimeOfDay,Cologne_Form,CologneMap);
			System.out.println(cologneRecommendation);

			System.out.println("Would you like to see the notes of this colgone?");
			Cologne_Help = sc.next().trim(); //User input

			while(!Cologne_Help.equalsIgnoreCase("YES")&& !Cologne_Help.equalsIgnoreCase("NO")){
				System.out.println("Invalid Input!");
				System.out.println("Please enter either yes or no:");

			}
			if(Cologne_Help.equalsIgnoreCase("YES")) {
				while(Cologne_Help.equalsIgnoreCase("YES")){
					//print out the cologne details here
					System.out.println("Would you like to see any other cologne notes?");
					System.out.println("If yes please enter the cologne you wish to see.");
					System.out.println("If not please enter END");
					Cologne_Help = sc.next().trim();//User input
					if(Cologne_Help.equalsIgnoreCase("END")){
						break;
					}
				}
			}
			else if(Cologne_Help.equalsIgnoreCase("NO")) {
				System.out.println();//Empty Line for Spacing 
			}
		}
		
		//if the user just needs help with clothes
		else if(help.equalsIgnoreCase("Clothes")) {
			System.out.println("Seems like you just need help choosing an outfit today."); 
			System.out.println("Dont worry i can help with that!"); 
			System.out.println("Before we start would you like to see your wardrobe?"); 
			Answer = sc.next().trim(); //User input
			
			while(!Answer.equalsIgnoreCase("Yes") && !Answer.equalsIgnoreCase("No")) {
				System.out.println(" ");
				System.out.println("Invalid Input!");
				System.out.println("Please type in either yes or no");
				Answer = sc.next().trim(); //User input
				if(Answer.equalsIgnoreCase("Yes")|| Answer.equalsIgnoreCase("No")) {
					break;
				}
			}
			if(Answer.equalsIgnoreCase("Yes")) {
				System.out.println("Your Wardrobe:"); 
				System.out.println(" "); //empty line for spacing				
				for (Map.Entry<String, Clothes> entry : ClothesMap.entrySet()) {
		            System.out.println(entry.getKey() + ":");
		            System.out.println(entry.getValue().toString());
				}
			}
			else if(Answer.equalsIgnoreCase("No")) {
				System.out.println("Ok that is fine.");
				System.out.println("Lets Continue");
			}
			System.out.println(" ");
			System.out.println("What time of day will this event be?"); 
			System.out.println("The options are:");
			System.out.println("Morning, which is between 4am and 11am");
			System.out.println("Afternoon, which is between 12pm and 6pm");
			System.out.println("Night, which is between 7pm and 3am");
			String timeOfDay = sc.next().trim();//user input
			
			while (!timeOfDay.equalsIgnoreCase("Morning") && !timeOfDay.equalsIgnoreCase("Afternoon") && !timeOfDay.equalsIgnoreCase("Night")) {
				System.out.println("Invalid input. Please enter Morning, Afternoon, or Night:");
				timeOfDay = sc.next().trim();//user input
			}
			
			System.out.println("Enter the specific hour (1-12) for the event:");
			hour = sc.nextInt();
			while (hour < 1 || hour > 12) {
				System.out.println("Invalid input. Please enter an hour between 1 and 12:");
				hour = sc.nextInt();
			}
			
			System.out.println("Is it AM or PM?");
			String amPm = sc.next().trim().toUpperCase();
			while (!amPm.equals("AM") && !amPm.equals("PM")) {
				System.out.println("Invalid input. Please enter AM or PM:");
				amPm = sc.next().trim().toUpperCase();
			}
			
			// Validate based on the time of day
			if (timeOfDay.equalsIgnoreCase("Morning") && (amPm.equals("PM") || hour < 4 || hour > 11)) {
				System.out.println("Invalid input. Morning is between 4am and 11am. Please try again.");
			} else if (timeOfDay.equalsIgnoreCase("Afternoon") && 
					   (amPm.equals("AM") || (hour != 12 && hour > 6))) {
				System.out.println("Invalid input. Afternoon is between 12pm and 6pm. Please try again.");
			} else if (timeOfDay.equalsIgnoreCase("Night") && 
					   ((amPm.equals("AM") && hour >= 4) || (amPm.equals("PM") && hour < 7 && hour != 12))) {
				System.out.println("Invalid input. Night is between 7pm and 3am. Please try again.");
			} else {
				// If all checks pass
				System.out.println("Thank you! Your event is at " + hour + " " + amPm + " in the " + timeOfDay + ".");
			}
						
			System.out.println(" ");
			System.out.println("What kind of formality will this event be?"); 
			System.out.println("If you are confused on formality level please type in HELP"); 
			System.out.println("If not type in NO"); 
			Helper = sc.next().trim(); //User input
			
			while(!Helper.equalsIgnoreCase("HELP") && !Helper.equalsIgnoreCase("NO")) {
				System.out.println("Invalid Input"); 
				System.out.println("Please type in either HELP or NO"); 
				Helper = sc.next().trim(); //User input
				if(Helper.equalsIgnoreCase("HELP")||Helper.equalsIgnoreCase("NO")) {
					break;
				}
			}
			if(Helper.equalsIgnoreCase("HELP")) {
				System.out.println(" "); //Extra line for spacing
				System.out.println("Dont worry");
				System.out.println("Formality types for events can be confusing"); 
				System.out.println("Their are a few different formality types, they include:"); 
				
				System.out.println(" ");//Extra line for spacing 
				System.out.println("We will run through the different levels of formality from least formal to most formal");
				System.out.println("The first level of formality is: Casual");
				System.out.println("Everyday wear, casual social gatherings, relaxed office environments."); 
				
				System.out.println("The second level of formality is: Smart Casual");
				System.out.println("Informal dinner parties, casual dates, or upscale casual events."); 
				
				System.out.println("The third level of formality is: Business Casual"); 
				System.out.println("Less formal office environments, casual client meetings."); 
				
				System.out.println("The fourth level of formality is: Business Formal"); 
				System.out.println("Business meetings, job interviews, formal workplace environments."); 
				
				System.out.println("The fifth level of formality is: Semi-Formal "); 
				System.out.println("Evening weddings, corporate parties, or sophisticated social events."); 
				
				System.out.println("The sixth and last level of formality is: Black Tie");
				System.out.println("Formal weddings, gala dinners, award ceremonies."); 
			}
			else if (Helper.equalsIgnoreCase("NO")){
				System.out.println("Thats great, you know your formality types"); 
				System.out.println("Lets move on then"); 
			}
			System.out.println(" ");
			System.out.println("What formality level will this event be?");
			System.out.println("Your choices are:");
			System.out.println("Casual"); 
			System.out.println("Smart Casual"); 
			System.out.println("Business Casual"); 
			System.out.println("Business Formal"); 
			System.out.println("Semi Formal"); 
			System.out.println("Black Tie"); 
			formal = sc.next().trim(); //User input

			while(!formal.equalsIgnoreCase("Casual")&&!formal.equalsIgnoreCase("Smart Casual")&& !formal.equalsIgnoreCase("Business Casual")&&!formal.equalsIgnoreCase("Business Formal")&&!formal.equalsIgnoreCase("Black Tie")){
				System.out.println("Invalid Input!"); 
				System.out.println("Please try again:"); 
				formal = sc.next().trim(); //User input
			}

			if(formal.equalsIgnoreCase("Casual")){
				formal.equals("Casual");
			}
			else if(formal.equalsIgnoreCase("Smart Casual")){
				formal.equals("Smart Casual");
			}
			else if(formal.equalsIgnoreCase("Business Casual")){
				formal.equals("Business Casual");
			}
			else if(formal.equalsIgnoreCase("Business Formal")){
				formal.equals("Business Formal");
			}
			else if(formal.equalsIgnoreCase("Semi Formal")){
				formal.equals("Semi Formal");
			}
			else if(formal.equalsIgnoreCase("Black Tie")){
				formal.equals("Black Tie");
			}

			System.out.println("You have chosen " + formal + "."); 
			
			System.out.println("Please enter the current weather condition");
			System.out.println("is it warm,cool,hot,or cold outside?");
			WeatherCondition = sc.next().trim(); //User input
			
			while (!WeatherCondition.equalsIgnoreCase("Warm")&&!WeatherCondition.equalsIgnoreCase("Cool")&&!WeatherCondition.equalsIgnoreCase("Hot")||!WeatherCondition.equalsIgnoreCase("Cold")) {
				System.out.println("Invalid Input");
				System.out.println("Please enter either warm,cool,hot, or cold:");
				WeatherCondition = sc.next().trim(); //User input
			}			
			System.out.print("Please enter the current temperature in degrees Fahrenheit:");
			temperature = sc.nextInt(); //User input
			
			while(temperature >= 150 || temperature <= -75 ) {
				if(temperature >= 150) {
					System.out.println("Wow thats hot");
					System.out.println("Please enter a valid temperture:");
					temperature = sc.nextInt(); //User input
				}
				else if(temperature <= -75) {
					System.out.println("Thats really cold");
					System.out.println("Please enter a valid input");
					temperature = sc.nextInt(); //User input
				}
			}
			// Get recommendations
			String clothingRecommendation = RecommendClothing(WeatherCondition, temperature, TimeOfDay,formal, ClothesMap);
			System.out.println("Recommended clothing: " + clothingRecommendation); //Print the reccomendations
		}

		//if the user needs help with both
		else if(help.equalsIgnoreCase("Both")){
			System.out.println("Seems like you need help with both a outfit and a fragrance"); 
			System.out.println("i can help with that!");

			System.out.println("Before we start would you like to see your wardrobe?");
			System.out.println("Including your fragrances");
			Answer = sc.next().trim();

			while(!Answer.equalsIgnoreCase("YES")&& !Answer.equalsIgnoreCase("NO")){
				System.out.println("Invalid Input!");
				System.out.println("Please enter either yes or no:");
				Answer = sc.next().trim();
			}
			if(Answer.equalsIgnoreCase("YES")){
				System.out.println("Your Frangrances:");
				System.out.println(" "); //empty line for spacing
		        for (String cologneName : CologneMap.keySet()) {
					System.out.println(CologneMap.get(cologneName));  // Print cologne details
		        }
				System.out.println(" "); //Empty line for spacing
				System.out.println("Your Wardrobe:"); 
				System.out.println(" "); //empty line for spacing				
				for (Map.Entry<String, Clothes> entry : ClothesMap.entrySet()) { //Print Clothes in wardrobe
		            System.out.println(entry.getKey() + ":");
		            System.out.println(entry.getValue().toString());
				}
			}
			else if(Answer.equalsIgnoreCase("NO")){
				System.out.println("Ok then, Lets Continue!");
			}
			
			System.out.println("What time of day will this event be?"); 
			System.out.println("The options are:");
			System.out.println("Morning, which is between 4am and 11am");
			System.out.println("Afternoon, which is between 12pm and 6pm");
			System.out.println("Night, which is between 7pm and 3am");
			String timeOfDay = sc.next().trim();//user input
			
			while (!timeOfDay.equalsIgnoreCase("Morning") && !timeOfDay.equalsIgnoreCase("Afternoon") &&  !timeOfDay.equalsIgnoreCase("Night")) {
				System.out.println("Invalid input. Please enter Morning, Afternoon, or Night:");
				timeOfDay = sc.next().trim();//user input
			}
			
			System.out.println("Enter the specific hour (1-12) for the event:");
			hour = sc.nextInt(); //user input
			while (hour < 1 || hour > 12) {
				System.out.println("Invalid input. Please enter an hour between 1 and 12:");
				hour = sc.nextInt();
			}
			
			System.out.println("Is it AM or PM?");
			String amPm = sc.next().trim().toUpperCase();
			while (!amPm.equals("AM") && !amPm.equals("PM")) {
				System.out.println("Invalid input. Please enter AM or PM:");
				amPm = sc.next().trim().toUpperCase();
			}
			
			// Validate based on the time of day
			if (timeOfDay.equalsIgnoreCase("Morning") && (amPm.equals("PM") || hour < 4 || hour > 11)) {
				System.out.println("Invalid input. Morning is between 4am and 11am. Please try again.");
			} else if (timeOfDay.equalsIgnoreCase("Afternoon") && 
					   (amPm.equals("AM") || (hour != 12 && hour > 6))) {
				System.out.println("Invalid input. Afternoon is between 12pm and 6pm. Please try again.");
			} else if (timeOfDay.equalsIgnoreCase("Night") && 
					   ((amPm.equals("AM") && hour >= 4) || (amPm.equals("PM") && hour < 7 && hour != 12))) {
				System.out.println("Invalid input. Night is between 7pm and 3am. Please try again.");
			} else {
				// If all checks pass
				System.out.println("Thank you! Your event is at " + hour + " " + amPm + " in the " + timeOfDay + ".");
			}
			
			System.out.println(" ");
			System.out.println("What kind of formality will this event be?"); 
			System.out.println("If you are confused on formality level please type in HELP"); 
			System.out.println("If not type in NO"); 
			Helper = sc.next().trim(); //User Input
			
			while(!Helper.equalsIgnoreCase("HELP") && !Helper.equalsIgnoreCase("NO")){ // While loop that plays incase the user enters the wrong input
				System.out.println("Invalid Input"); //Prints this line to the console
				System.out.println("Please type in either HELP or NO"); 
				Helper = sc.next().trim(); //User input 
				
				if(Helper.equalsIgnoreCase("HELP")||Helper.equalsIgnoreCase("NO")) { //if the user enters the right input
					break; //break out of the loop
				}
			}
			if(Helper.equalsIgnoreCase("HELP")) {
				System.out.println(" "); //Extra line for spacing
				System.out.println("Dont worry");
				System.out.println("Formality types for events can be confusing"); 
				System.out.println("Their are a few different formality types");
				
				System.out.println("For Colognes/Fragrances:"); 
				System.out.println(" ");//Extra Line for Spacing 
				System.out.println("Daily Wear & Work/Professional Settings");
				System.out.println("These scents are typically subtle and non-intrusive, making them versatile for casual settings and professional environments alike."); //Prints this line to the console
				System.out.println("");//Extra Line for Spacing 
				System.out.println("Casual Outings & Sports/Outdoor Activities");
				System.out.println("These scents are invigorating and clean, complementing active lifestyles and relaxed settings.");//Prints this line to the console
				System.out.println("");//Extra Line for Spacing 
				System.out.println("Date Nights & Evening Events");
				System.out.println("Warm, sensual colognes with notes like amber, vanilla, or musk can transition smoothly from a romantic date to a more formal evening event");//Prints this line to the console
				System.out.println("");//Extra Line for Spacing 
				System.out.println("Formal Events & Weddings");
				System.out.println("Sophisticated colognes with complex, elegant notes such as sandalwood, oud, or leather can be worn at formal events, weddings, or special occasions. These colognes often leave a lasting impression and are ideal for events where dressing up is key.");//Prints this line to the console
				System.out.println("");//Extra Line for Spacing 


				System.out.println(" ");//Extra Line for Spacing 
				System.out.println("For Clothes it is a little different");
				System.out.println("We will run through the different levels of formality from least formal to most formal");
				System.out.println("The first level of formality is: Casual");
				System.out.println("Everyday wear, casual social gatherings, relaxed office environments."); 
				System.out.println(" ");//Extra Line for Spacing
				System.out.println("The second level of formality is: Smart Casual");
				System.out.println("Informal dinner parties, casual dates, or upscale casual events."); 
				System.out.println(" ");//Extra Line for Spacing
				System.out.println("The third level of formality is: Business Casual"); 
				System.out.println("Less formal office environments, casual client meetings."); 
				System.out.println(" ");//Extra Line for Spacing
				System.out.println("The fourth level of formality is: Business Formal"); 
				System.out.println("Business meetings, job interviews, formal workplace environments."); 
				System.out.println(" ");//Extra Line for Spacing
				System.out.println("The fifth level of formality is: Semi-Formal "); 
				System.out.println("Evening weddings, corporate parties, or sophisticated social events."); 
				System.out.println(" ");//Extra Line for Spacing
				System.out.println("The sixth and last level of formality is: Black Tie");
				System.out.println("Formal weddings, gala dinners, award ceremonies."); 
			}
			else if (Helper.equalsIgnoreCase("NO")){
				System.out.println("Thats great, you know your formality types"); 
				System.out.println("Lets move on then"); 
			}

			System.out.println(" ");//Extra line for spacing
			System.out.println("What level of formality will this event be for your cologne?"); 
			System.out.println("Please Choose From the Following:"); 
			System.out.println("1)Daily Wear/Casual Outing"); 
			System.out.println("2)Sporting/OutDoor Activites"); 
			System.out.println("3)Date Night/ Evening Events"); 
			System.out.println("4)Formal Events/Weddings"); 
			cologne = sc.nextInt(); //User input 
			
			while(cologne <= 0 || cologne > 4){
				System.out.println("Wrong input"); 
				System.out.println("Please type in a number 1 through 4"); 
				System.out.println(""); 
				cologne = sc.nextInt(); //User input
			}
			
			if(cologne == 1) {
				Cologne_Form = "Daily Wear/Casual Outing";
			}
			else if(cologne == 2) {
				Cologne_Form = "Sporting/OutDoor Activites";
			}
			else if(cologne == 3) {
				Cologne_Form = "Date Night/ Evening Events";
			}
			else if(cologne == 4) {
				Cologne_Form = ("Formal Events/Weddings");
			}

			System.out.println(" ");
			System.out.println("What formality level will this event be for your clothing?");
			System.out.println("Your choices are:");
			System.out.println("Casual"); 
			System.out.println("Smart Casual"); 
			System.out.println("Business Casual"); 
			System.out.println("Business Formal"); 
			System.out.println("Semi Formal"); 
			System.out.println("Black Tie"); 
			formal = sc.next().trim();//User input

			while(!formal.equalsIgnoreCase("Casual")&&!formal.equalsIgnoreCase("Smart Casual")&& !formal.equalsIgnoreCase("Business Casual")&& !formal.equalsIgnoreCase("Business Formal")&& !formal.equalsIgnoreCase("Black Tie")){
				System.out.println("Invalid Input!"); 
				System.out.println("Please try again:"); 
				formal = sc.next().trim(); //User input
			}

			if(formal.equalsIgnoreCase("Casual")){
				formal.equals("Casual");
			}
			else if(formal.equalsIgnoreCase("Smart Casual")){
				formal.equals("Smart Casual");
			}
			else if(formal.equalsIgnoreCase("Business Casual")){
				formal.equals("Business Casual");
			}
			else if(formal.equalsIgnoreCase("Business Formal")){
				formal.equals("Business Formal");
			}
			else if(formal.equalsIgnoreCase("Semi Formal")){
				formal.equals("Semi Formal");
			}
			else if(formal.equalsIgnoreCase("Black Tie")){
				formal.equals("Black Tie");
			}

			System.out.println("You have selected " + Cologne_Form + "."); 
			System.out.println("You have chosen " + formal + ".");
			
			System.out.println("Please enter the current weather condition");
			System.out.println("is it warm,cool,hot,or cold outside?");
			WeatherCondition = sc.next().trim(); //User input
			
			while (!WeatherCondition.equalsIgnoreCase("Warm")&&!WeatherCondition.equalsIgnoreCase("Cool")&&!WeatherCondition.equalsIgnoreCase("Hot")||!WeatherCondition.equalsIgnoreCase("Cold")) {
				System.out.println("Invalid Input");
				System.out.println("Please enter either warm,cool,hot, or cold:");
				WeatherCondition = sc.next().trim(); //User input
			}
			
			System.out.print("Please enter the current temperature in degrees Fahrenheit:");
			temperature = sc.nextInt(); //User input
			
			while(temperature >= 150 || temperature <= -75 ) {
				if(temperature >= 150) {
					System.out.println("Wow thats hot");
					System.out.println("Please enter a valid temperture:");
					temperature = sc.nextInt(); //User input
				}
				else if(temperature <= -75) {
					System.out.println("Thats really cold");
					System.out.println("Please enter a valid input");
					temperature = sc.nextInt(); //User input
				}
			}

			
			String clothingRecommendation = RecommendClothing(WeatherCondition, temperature, TimeOfDay,formal, ClothesMap);
			String cologneRecommendation = recommendCologne(WeatherCondition, TimeOfDay,Cologne_Form,CologneMap);
		}
			System.out.println("Have fun on your outing");
			System.out.println("Goodbye!"); 
			sc.close(); // closing the scanner
			System.exit(0); // end the program
	}
}
	
    // Recommendation methods
	private static String RecommendClothing(String weather, int temp, String timeOfDay, String formal, Map<String, Clothes> wardrobe) {
	    String top = "";
	    String pants = "";
	    String shoes = "";
	    
	    // Check for Casual formality
	    if (formal.equalsIgnoreCase("Casual")) {
	        if (timeOfDay.equalsIgnoreCase("Morning")) {
	            if (weather.equalsIgnoreCase("Hot")) {
	                top = wardrobe.get("Grey T-Shirt").getType();  
	                pants = "shorts";  
	                shoes = "sneakers";  
	            // Cold weather in the morning
	            } else if (weather.equalsIgnoreCase("Cold")) {
	                top = "warm sweater";
	                pants = "jeans";  
	                shoes = "boots";  
	            } else if (weather.equalsIgnoreCase("Cool")) {
	                top = "light jacket";  
	                pants = "chinos";  
	                shoes = "casual shoes";  
	            } else if (weather.equalsIgnoreCase("Warm")) {
	                top = "breathable polo shirt"; 
	                pants = "shorts";  
	                shoes = "sneakers";  
	            }
	        } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
	            if (weather.equalsIgnoreCase("Hot")) {
	                top = "tank top";  
	                pants = "shorts";  
	                shoes = "sandals";  
	            } else if (weather.equalsIgnoreCase("Cold")) {
	                top = "warm sweater";  
	                pants = "jeans"; 
	                shoes = "boots";  
	            } else if (weather.equalsIgnoreCase("Cool")) {
	                top = "light jacket"; 
	                pants = "long pants"; 
	                shoes = "casual shoes";  
	            } else if (weather.equalsIgnoreCase("Warm")) {
	                top = "short-sleeve shirt";  
	                pants = "shorts";  
	                shoes = "sneakers"; 
	            }
	        } else if (timeOfDay.equalsIgnoreCase("Night")) {
	            if (weather.equalsIgnoreCase("Hot")) {
	                top = "light t-shirt";  
	                pants = "shorts";  
	                shoes = "sandals"; 
	            } else if (weather.equalsIgnoreCase("Cold")) {
	                top = "warm sweater";  
	                pants = "jeans"; 
	                shoes = "boots";  
	            } else if (weather.equalsIgnoreCase("Cool")) {
	                top = "light jacket";  
	                pants = "pants";  
	                shoes = "casual shoes";  
	            } else if (weather.equalsIgnoreCase("Warm")) {
	                top = "comfortable shirt"; 
	                pants = "light pants";  
	                shoes = "sneakers";  
	            }
	        }
	    }

	    // Check for Smart Casual formality
	    else if (formal.equalsIgnoreCase("Smart Casual")) {
	        if (timeOfDay.equalsIgnoreCase("Morning")) {
	            if (weather.equalsIgnoreCase("Hot")) {
	                top = wardrobe.get("White Shirt").getType();  
	                pants = "light chinos"; 
	                shoes = "loafers";  
	            } else if (weather.equalsIgnoreCase("Cold")) {
	                top = "light sweater over a collared shirt";  
	                pants = wardrobe.get("Navy Chinos").getType();  
	                shoes = "casual shoes";  
	            } else if (weather.equalsIgnoreCase("Cool")) {
	                top = wardrobe.get("Blazer").getType(); 
	                pants = wardrobe.get("Navy Chinos").getType();  
	                shoes = "loafers";  
	            } else if (weather.equalsIgnoreCase("Warm")) {
	                top = wardrobe.get("White Shirt").getType();  
	                pants = "light pants";  
	                shoes = "smart casual shoes";  
	            }
	        // Afternoon recommendations for Smart Casual formality
	        } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
	            top = wardrobe.get("Blazer").getType();  
	            pants = wardrobe.get("Navy Chinos").getType(); 
	            shoes = "smart casual shoes"; 
	        } else if (timeOfDay.equalsIgnoreCase("Night")) {
	            top = "dress shirt"; 
	            pants = "chinos or dress pants"; 
	            shoes = "smart casual shoes";  
	        }
	    }
	    // Check for Business Casual formality
	    else if (formal.equalsIgnoreCase("Business Casual")) {
	        if (timeOfDay.equalsIgnoreCase("Morning")) {
	            if (weather.equalsIgnoreCase("Hot")) {
	                top = wardrobe.get("Dress Shirt").getType();  
	                pants = wardrobe.get("Khaki Pants").getType();  
	                shoes = "formal shoes"; 
	            } else if (weather.equalsIgnoreCase("Cold")) {
	                top = "dress shirt and sweater"; 
	                pants = wardrobe.get("Dark Grey Trousers").getType();  
	                shoes = "formal shoes";  
	            } else if (weather.equalsIgnoreCase("Cool")) {
	                top = wardrobe.get("Blazer").getType();  
	                pants = wardrobe.get("Navy Chinos").getType(); 
	                shoes = "formal shoes";  
	            } else if (weather.equalsIgnoreCase("Warm")) {
	                top = "light dress shirt";  
	                pants = wardrobe.get("Khaki Pants").getType(); 
	                shoes = "formal shoes";  
	            }
	        } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
	            top = wardrobe.get("Blazer").getType();  
	            pants = wardrobe.get("Dark Grey Trousers").getType();  
	            shoes = wardrobe.get("Formal Black Shoes").getType();  
	        } else if (timeOfDay.equalsIgnoreCase("Night")) {
	            top = wardrobe.get("Dress Shirt").getType();  
	            pants = "dress pants";  
	            shoes = wardrobe.get("Formal Black Shoes").getType();  
	        }
	    }

	    // Check for Business Formal formality
	    else if (formal.equalsIgnoreCase("Business Formal")) {
	        if (timeOfDay.equalsIgnoreCase("Morning")) {
	            top = wardrobe.get("Formal Dress Shirt").getType();  
	            pants = wardrobe.get("Dark Grey Trousers").getType(); 
	            shoes = wardrobe.get("Formal Black Shoes").getType();
	        } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
	            top = wardrobe.get("Formal Dress Shirt").getType();  
	            pants = wardrobe.get("Formal Suit").getType();
	            shoes = wardrobe.get("Formal Black Shoes").getType();
	        } else if (timeOfDay.equalsIgnoreCase("Night")) {
	            top = wardrobe.get("Formal Dress Shirt").getType();  
	            pants = "tailored trousers"; 
	            shoes = wardrobe.get("Formal Black Shoes").getType(); 
	        }
	    }

	    // Check for Semi Formal formality
	    else if (formal.equalsIgnoreCase("Semi Formal")) {
	        if (timeOfDay.equalsIgnoreCase("Morning")) {
	            top = wardrobe.get("Blazer").getType(); 
	            pants = wardrobe.get("Dark Grey Trousers").getType();  
	            shoes = "formal shoes";  
	        } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
	            top = "dress shirt";  
	            pants = wardrobe.get("Dark Grey Trousers").getType();  
	            shoes = "formal shoes";  
	        } else if (timeOfDay.equalsIgnoreCase("Night")) {
	            top = "semi-formal suit";  
	            pants = "matching trousers";  
	            shoes = wardrobe.get("Formal Black Shoes").getType();  
	        }
	    }

	    //Black Tie formality
	    else if (formal.equalsIgnoreCase("Black Tie")) {
	        if (timeOfDay.equalsIgnoreCase("Evening")) {
	            top = wardrobe.get("Tuxedo").getType();  
	            pants = "matching trousers"; 
	            shoes = wardrobe.get("Formal Black Shoes").getType();  
	        }
	    }
	    System.out.println("After taking into consideration the formality of the event, the weather in your current area nad the time of the event..");
	    // Return the recommendation
	    if (top.isEmpty() || pants.isEmpty() || shoes.isEmpty()) {
	        return "No specific recommendation found for this combination.";  // if no valid combination is found
	    }

	    return "Recommended Outfit: Top - " + top + ", Pants - " + pants + ", Shoes - " + shoes + ".";  // Return the outfit recommendation
	}
	private static String recommendCologne(String weather, String timeOfDay, String formal, Map<String, Cologne> CologneMap) {
		String Recommended_Cologne = "";  // Variable to store the recommended cologne
	
		// Daily Wear/Casual Outing recommendations
		if (formal.equalsIgnoreCase("Daily Wear/Casual Outing")) {
			if (timeOfDay.equalsIgnoreCase("Morning")) {
				if (weather.equalsIgnoreCase("Hot")) {
					cologne = CologneMap.get("Greenley").getName();  
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("Intenso").getName(); 
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("LHomme").getName(); 
				} else if (weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Sauvage").getName(); 
				}
			} else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
				if (weather.equalsIgnoreCase("Hot")) {
					cologne = CologneMap.get("Greenley").getName();  
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("Intenso").getName();  
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("Roma").getName(); 
				} else if (weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("LeBeauParfum").getName(); 
				}
			} else if (timeOfDay.equalsIgnoreCase("Night")) {
				if (weather.equalsIgnoreCase("Hot")) {
					cologne = CologneMap.get("LeBeauParfum").getName();  
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("MostWanted").getName();  
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("StrongerWithYou").getName();  
				} else if (weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Roma").getName();  
				}
			}
		}
	
		// Sporting/Outdoor Activities recommendations
		else if (formal.equalsIgnoreCase("Sporting/OutDoor Activites")) {
		    if (timeOfDay.equalsIgnoreCase("Morning")) {
		        if (weather.equalsIgnoreCase("Hot") || weather.equalsIgnoreCase("Warm")) {
		            cologne = CologneMap.get("Greenley").getName(); 
		        } else if (weather.equalsIgnoreCase("Cold")) {
		            cologne = CologneMap.get("LHomme").getName();  
		        } else if (weather.equalsIgnoreCase("Cool")) {
		            cologne = CologneMap.get("Sauvage").getName();  
		        }
		    } else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
		        if (weather.equalsIgnoreCase("Hot") || weather.equalsIgnoreCase("Warm")) {
		            cologne = CologneMap.get("Greenley").getName();  
		        } else if (weather.equalsIgnoreCase("Cold")) {
		            cologne = CologneMap.get("LHomme").getName();  
		        } else if (weather.equalsIgnoreCase("Cool")) {
		            cologne = CologneMap.get("Sauvage").getName();  
		        }
		    } else if (timeOfDay.equalsIgnoreCase("Night")) {
		        if (weather.equalsIgnoreCase("Hot") || weather.equalsIgnoreCase("Warm")) {
		            cologne = CologneMap.get("Greenley").getName();  
		        } else if (weather.equalsIgnoreCase("Cold")) {
		            cologne = CologneMap.get("LHomme").getName();  
		        } else if (weather.equalsIgnoreCase("Cool")) {
		            cologne = CologneMap.get("Sauvage").getName();  
		        }
		    }
		}
		// Date Night/Evening Events recommendations
		else if (formal.equalsIgnoreCase("Date Night/ Evening Events")) {
			if (timeOfDay.equalsIgnoreCase("Morning")) {
				if (weather.equalsIgnoreCase("Hot")) {
					cologne = CologneMap.get("LeBeauParfum").getName();  
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("MostWanted").getName();  
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("StrongerWithYou").getName(); 
				} else if (weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Roma").getName();  
				}
			} else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
				if (weather.equalsIgnoreCase("Hot")) {
					cologne = CologneMap.get("LeBeauParfum").getName();  
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("MostWanted").getName(); 
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("StrongerWithYou").getName();  
				} else if (weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Roma").getName();  
				}
			} else if (timeOfDay.equalsIgnoreCase("Night")) {
				if (weather.equalsIgnoreCase("Hot")) {
					cologne = CologneMap.get("LeBeauParfum").getName(); 
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("MostWanted").getName(); 
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("StrongerWithYou").getName(); 
				} else if (weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Roma").getName();  
				}
			}
		}
	
		// Formal Events/Weddings recommendations
		else if (formal.equalsIgnoreCase("Formal Events/Weddings")) {
			if (timeOfDay.equalsIgnoreCase("Morning")) {
				if (weather.equalsIgnoreCase("Hot") || weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Sauvage").getName();  
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("Intenso").getName(); 
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("MostWanted").getName();  
				}
			} else if (timeOfDay.equalsIgnoreCase("Afternoon")) {
				if (weather.equalsIgnoreCase("Hot") || weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Sauvage").getName(); 
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("Intenso").getName(); 
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("MostWanted").getName();  
				}
			} else if (timeOfDay.equalsIgnoreCase("Night")) {
				if (weather.equalsIgnoreCase("Hot") || weather.equalsIgnoreCase("Warm")) {
					cologne = CologneMap.get("Sauvage").getName();
				} else if (weather.equalsIgnoreCase("Cold")) {
					cologne = CologneMap.get("Intenso").getName(); 
				} else if (weather.equalsIgnoreCase("Cool")) {
					cologne = CologneMap.get("MostWanted").getName();  
				}
			}
		}
		if (cologne.isEmpty()) {
			return "No specific cologne recommendation found for this combination.";  // Default if no valid combination is found
		}
	
		return "Recommended Cologne: " + cologne;  // Return the recommended cologne
	}	
}