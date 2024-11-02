package Projects;
import javax.swing.*;  
import java.io.*;  
import java.util.*;  
import java.time.LocalDate;  

public class GamifiedQuiz {
    // Maps to hold questions and answers for each topic and difficulty level
    static Map<String, Map<String, List<String>>> questions = new HashMap<>();
    static Map<String, Map<String, List<String>>> answers = new HashMap<>();
    
    // UserData object to track user progress, points, and badges
    static UserData userData;

    public static void main(String[] args) {
        InitializeQuestionsAndAnswers();  // Initialize all questions and answers
        LoadUserData();  // Load existing user data 

        while (true) {  //Loop to display menu and handle choices
            String[] Options = {"Take a Quiz", "View Stats and Achievements", "Daily Challenge", "Reset Progress", "Exit"};
            
            int Choice = JOptionPane.showOptionDialog(null,
                    "Points: " + userData.points + ", Streak: " + userData.streak +
                            "\nBadges: " + (userData.badges.isEmpty() ? "None" : String.join(", ", userData.badges)),
                    "Welcome to Gamified Quiz ",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
            if (Choice == 0) {
                TakeQuiz();  // Start a quiz
            } else if (Choice == 1) {
                ViewStats();  // View user stats and badges
            } else if (Choice == 2) {
                DailyChallenge();  // Daily challenge
            } else if (Choice == 3) {
                ResetUserData();  // Reset user progress
            } else if (Choice == 4) {
                SaveUserData();  // Save data before exiting
                JOptionPane.showMessageDialog(null, "Goodbye!");  // Exit message
                System.exit(0);  // Terminate the program
            } else {
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");  // Handle invalid input
            }
        }
    }
    static void InitializeQuestionsAndAnswers() {
        // Populate questions for reading topic at different difficulties
        questions.put("reading", Map.of(
            "easy", List.of("What does the word 'benevolent' mean in this context: 'She was known for her benevolent nature.'?"),
            "medium", List.of("What does the author imply by stating 'it was a fleeting moment of joy'?"),
            "hard", List.of("Identify the tone of a passage discussing climate change's impact on coral reefs.")
        ));
        // Populate questions for writing topic at different difficulties
        questions.put("writing", Map.of(
            "easy", List.of("Choose the correct form: 'They (is/are) going to the concert.'"),
            "medium", List.of("In the sentence 'The group of students (was/were) ready,' which is correct?"),
            "hard", List.of("What is the purpose of the semicolon in the sentence: 'She enjoys reading; however, she also likes hiking'?")
        ));
        // Populate questions for math topic at different difficulties
        questions.put("math", Map.of(
            "easy", List.of("What is 7 + 3?"),
            "medium", List.of("Solve for x: 4x + 2 = 18."),
            "hard", List.of("If 2x^2 = 8, what is x?")
        ));
        // Answers corresponding to reading questions by difficulty
        answers.put("reading", Map.of(
            "easy", List.of("Kind"),
            "medium", List.of("Brief happiness"),
            "hard", List.of("Concerned")
        ));
        // Answers corresponding to writing questions by difficulty
        answers.put("writing", Map.of(
            "easy", List.of("are"),
            "medium", List.of("was"),
            "hard", List.of("To connect clauses")
        ));
        // Answers corresponding to math questions by difficulty
        answers.put("math", Map.of(
            "easy", List.of("10"),
            "medium", List.of("4"),
            "hard", List.of("±2")
        ));
    }
    // Start quiz 
    static void TakeQuiz() {
        try {
            String Topic = JOptionPane.showInputDialog(null, "Choose a topic (reading/writing/math):");
            if (Topic == null) {
                JOptionPane.showMessageDialog(null, "Quiz canceled.");
                return;
            }
            Topic = Topic.trim().toLowerCase();

            String Difficulty = JOptionPane.showInputDialog(null, "Choose difficulty (easy/medium/hard):");
            // Check if the user pressed Cancel 
            if (Difficulty == null) {
                JOptionPane.showMessageDialog(null, "Quiz canceled.");
                return;
            }
            Difficulty = Difficulty.trim().toLowerCase();
            
            // Check if chosen topic and difficulty exist
            if (questions.containsKey(Topic) && questions.get(Topic).containsKey(Difficulty)) {
                List<String> QuestionSet = questions.get(Topic).get(Difficulty);
                List<String> AnswerSet = answers.get(Topic).get(Difficulty);

                //Make sure question and answer sets are not empty
                if (QuestionSet == null || AnswerSet == null || QuestionSet.isEmpty() || AnswerSet.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No questions available for this topic and difficulty. Please try another.");
                    return;
                }

                // Display a random question and get the user answer
                int QuestionIndex = new Random().nextInt(QuestionSet.size());
                String UserAnswer = JOptionPane.showInputDialog(null, "Question: " + QuestionSet.get(QuestionIndex));

                // Check if answer is correct
                if (UserAnswer != null && UserAnswer.equalsIgnoreCase(AnswerSet.get(QuestionIndex))) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    UpdatePointsAndStreak(Difficulty);  // Update points and streak
                } else if (UserAnswer != null) {
                    JOptionPane.showMessageDialog(null, "Incorrect. The correct answer was: " + AnswerSet.get(QuestionIndex));
                    userData.streak = 0;  // Reset streak if the answer is wrong
                } else {
                    JOptionPane.showMessageDialog(null, "Quiz canceled.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid topic or difficulty. Please try again.");
            }
            SaveUserData(); // Save progress 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            e.printStackTrace();  // Print error stack trace for debugging
        }
    }
    // Update user points and streak based on difficulty level
    static void UpdatePointsAndStreak(String difficulty) {
        Map<String, Integer> pointsAward = Map.of("easy", 10, "medium", 20, "hard", 30);  // Points for each difficulty
        userData.points += pointsAward.get(difficulty);  // Add points to user's total
        userData.streak += 1;  // Increment streak count

        JOptionPane.showMessageDialog(null, "Points: " + userData.points + ", Streak: " + userData.streak);
    }
    // List of all badges that can be earned
    static List<String> AllBadges = List.of(
        "5-Question Streak\n", 
        "10-Question Streak\n", 
        "50 Points Milestone\n", 
        "100 Points Milestone\n",
        "Perfect Daily Streak\n",
        "All-Difficulties Master\n",
        "Category Master - Reading\n",
        "Category Master - Writing\n",
        "Category Master - Math\n",
        "7-Day Daily Streak"
    );
    // View statistics of user 
    static void ViewStats() {
        // Separate unlocked and locked badges
        List<String> UnlockedBadges = new ArrayList<>();
        List<String> LockedBadges = new ArrayList<>();

        for (String Badge : AllBadges) {
            if (userData.badges.contains(Badge)) {
                UnlockedBadges.add(Badge);
            } else {
                LockedBadges.add(Badge);
            }
        }
        String UnlockedBadgesText = UnlockedBadges.isEmpty() ? "None" : String.join("\n", UnlockedBadges);
        String LockedBadgesText = LockedBadges.isEmpty() ? "None" : String.join("\n", LockedBadges);
        // Display points, streak, and badge status with each badge on a new line
        String StatsMessage = "Points: " + userData.points + "\nStreak: " + userData.streak +
                "\n\nUnlocked Badges:\n" + UnlockedBadgesText +
                "\n\nLocked Badges:\n" + LockedBadgesText;

        JOptionPane.showMessageDialog(null, StatsMessage);
    }
    // Run the daily challenge with a random question 
    static void DailyChallenge() {
        try {
            // Get today's date as a string 
            String Today = LocalDate.now().toString();

            // Check if today's challenge has already been completed by comparing today's date with the last date completed
            if (Today.equals(userData.lastDaily)) {
                // If the challenge was completed today, tell the user and exit
                JOptionPane.showMessageDialog(null, "You've already completed today's challenge!");
            } else {
                // Update the last daily challenge date to today
                userData.lastDaily = Today;

                // Randomly select a difficulty level from easy, medium, or hard
                String Difficulty = List.of("easy", "medium", "hard").get(new Random().nextInt(3));

                // Randomly select a topic from reading, writing, or math
                String Topic = List.of("reading", "writing", "math").get(new Random().nextInt(3));

                // Retrieve the list of questions for the topic and difficulty
                List<String> QuestionSet = questions.get(Topic).get(Difficulty);

                // Retrieve the list of answers for the topic and difficulty
                List<String> AnswerSet = answers.get(Topic).get(Difficulty);

                // Select a random index for the question and answer within the topic and difficulty
                int QuestionIndex = new Random().nextInt(QuestionSet.size());

                // Display the randomly selected question and get the user's answer
                String UserAnswer = JOptionPane.showInputDialog(null, "Today's question (Difficulty: " + Difficulty + "): " + QuestionSet.get(QuestionIndex));

                // Check if the user's answer matches the correct answer 
                if (UserAnswer != null && UserAnswer.equalsIgnoreCase(AnswerSet.get(QuestionIndex))) {
                    // If the answer is correct, award 50 points and add points to daily streak
                    JOptionPane.showMessageDialog(null, "Correct! You've earned 50 points!");
                    userData.points += 50;
                    userData.dailyStreak += 1;
                } else {
                    // If the answer is incorrect,reset the daily streak
                    JOptionPane.showMessageDialog(null, "Incorrect. The correct answer was: " + AnswerSet.get(QuestionIndex));
                    userData.dailyStreak = 0;
                }

                // Save the updated user data 
                SaveUserData();
            }
        } catch (Exception e) {
            // If an error occurs during the daily challenge
            JOptionPane.showMessageDialog(null, "An error occurred in the daily challenge: " + e.getMessage());

            // Print the stack trace to help with debugging the error
            e.printStackTrace();
        }
    }
    // Reset all user data, including points, streak, and badges
    static void ResetUserData() {
        int Confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset your progress?", "Reset Progress", JOptionPane.YES_NO_OPTION);

        if (Confirmation == JOptionPane.YES_OPTION) {
            // Create a new UserData object, effectively clearing all previous data
            userData = new UserData();  
            SaveUserData();  
            JOptionPane.showMessageDialog(null, "Your progress has been reset.");
        }
    }
    // Save user data to a file for persistence
    static void SaveUserData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userData.ser"))) {
            out.writeObject(userData);  
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user data.");
        }
    }
    // Load user data from file if it exists
    static void LoadUserData() {
        // Attempt to load the user data from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userData.ser"))) {
            // Read the UserData object from the file and assign it to userData
            userData = (UserData) in.readObject();  
        } catch (FileNotFoundException e) {  
            // If the file does not exist, initialize userData with a new UserData object
            userData = new UserData();  
        } catch (IOException | ClassNotFoundException e) {
            // Show an error message if there's a problem loading the data
            JOptionPane.showMessageDialog(null, "Error loading user data.");
            //Initialize userData with a new UserData object in case of an error so the program can still run
            userData = new UserData();  
        }
    }
}
//Class to store user progress data
class UserData implements Serializable {
    int points = 0;  // User total points
    int streak = 0;  // Current correct answer streak
    int dailyStreak = 0;  // Consecutive daily challenge streak
    String lastDaily = "";  // Date of last daily challenge completion
    List<String> badges = new ArrayList<>();  // List of earned badges
}