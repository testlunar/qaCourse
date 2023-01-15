package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker();
    static Random random = new Random();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String adress = faker.address().fullAddress();
    String gender = getRandomGender();
    String subject = getRandomSubject();
    String hobby = getRandomHobby();
    String state = getRandomState();
    String city = getRandomCityDependsOnState(state);


    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String[] birthDate = dateFormat.format(faker.date().birthday()).split(" ");

    public static String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        int i = random.nextInt(gender.length);
        return gender[i];
    }

    public static String getRandomSubject() {
        String[] subject = {"Hindi", "English", "Physics","Chemistry","Biology","Computer Science","Accounting","Economics","History","Maths","Commerce"};
        int i = random.nextInt(subject.length);
        return subject[i];
    }

    public static String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        int i = random.nextInt(hobby.length);
        return hobby[i];
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana","Rajasthan"};
        int i = random.nextInt(state.length);
        return state[i];
    }

    public static String getRandomCityDependsOnState(String state) {
        String [] city = null;
        if(state.equals("NCR")){
            city = new String[]{"Delhi", "Gurgaon", "Noida"};
        }else if (state.equals("Uttar Pradesh")){
            city = new String[]{"Agra", "Lucknow", "Merrut"};
        }else if (state.equals("Haryana")){
            city = new String[]{"Karnal", "Panipat"};
        }else if (state.equals("Rajasthan")) {
            city = new String[]{"Jaipur", "Jaiselmer"};
        }

        int i = random.nextInt(city.length);
        return city[i];
    }
}
