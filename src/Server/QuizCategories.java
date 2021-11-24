package Server;

import java.util.ArrayList;

public class QuizCategories {
    private ArrayList<QuizQuestions> quizCategories;

    public QuizCategories(){
        this.quizCategories = addQuiz();
    }

    private ArrayList<QuizQuestions> addQuiz() {
        ArrayList<QuizQuestions> quizCategories = new ArrayList<>();

        ArrayList<QuizQuestion> geography = new ArrayList<>();
        geography.add(new QuizQuestion("What is the country of origin of the Olympic Games?",1, "Scandinavia", "Greece", "China", "Egypt"));
        geography.add(new QuizQuestion("What is the capital city of the Maldives called?",0, "Malé", "Bali", "Jakarta", "Abu Dhabi"));
        geography.add(new QuizQuestion("What is the second tallest mountain?", 1, "Mount Everest", "K2", "Chomo Lonzo", "Broad Peak"));
        geography.add(new QuizQuestion("In which country is the geyser 'Old Faithful' located?", 3, "Iceland", "Russia", "Scotland", "United States"));
        geography.add(new QuizQuestion("What is the capital city of Australia called?", 1, "Sydney", "Canberra", "Melbourne", "Perth"));
        quizCategories.add(new QuizQuestions(geography));

        ArrayList<QuizQuestion> animals = new ArrayList<>();
        animals.add(new QuizQuestion("Where are tigers originally from?",2, "Africa", "South America", "Asia", "Europe"));
        animals.add(new QuizQuestion("Where can you find emperor penguins?",3, "Arctic", "Australia", "Greenland", "Antarctica"));
        quizCategories.add(new QuizQuestions(animals));

        ArrayList<QuizQuestion> sport = new ArrayList<>();
        sport.add(new QuizQuestion("Who won the World Football Championship 2002",2, "Germany", "Turkey", "Brazil", "France"));
        sport.add(new QuizQuestion("How many human players does a polo team have",3, "Two", "Six", "Eleven", "Four"));
        quizCategories.add(new QuizQuestions(sport));

        ArrayList<QuizQuestion> food = new ArrayList<>();
        food.add(new QuizQuestion("Which of these spices is the most expensive?",1, "Cardamom", "Saffron", "Pepper", "Vanilla"));
        food.add(new QuizQuestion("What food chain has the most locations?",3, "Pizza Hut", "Burger King", "McDonalds", "Subway"));
        food.add(new QuizQuestion("From which country did the name 'hamburger' originate?",0, "Germany", "United States", "England", "Italy"));
        food.add(new QuizQuestion("What type of food is basmati?",2, "Tomato juice", "Garlic", "Rice", "Milk"));
        food.add(new QuizQuestion("What type of milk was mozarella cheese originally made from?",0, "Buffalo milk", "Cow milk", "Goat milk", "Oat milk"));
        quizCategories.add(new QuizQuestions(food));

        ArrayList<QuizQuestion> swedishHistory = new ArrayList<>();
        swedishHistory.add(new QuizQuestion("What year did the Vasa ship sink?",3, "1598", "1611", "1623", "1628"));
        swedishHistory.add(new QuizQuestion("What year was Olof Palme shot?",2, "1990", "1981", "1986", "1995"));
        swedishHistory.add(new QuizQuestion("When did women get voting rights in Sweden?",2, "1898", "1908", "1918", "1928"));
        swedishHistory.add(new QuizQuestion("Where was Sweden's first university grounded?",0, "Uppsala", "Lund", "Stockholm", "Åbo"));
        swedishHistory.add(new QuizQuestion("What year did Queen Silvia and King Carl-Gustav marry?",2, "1977", "1982", "1976", "1979"));
        quizCategories.add(new QuizQuestions(swedishHistory));

        return quizCategories;
    }

    public ArrayList<QuizQuestions> getQuizCategories() {
        return quizCategories;
    }
}
