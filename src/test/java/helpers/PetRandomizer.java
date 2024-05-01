package helpers;

import com.github.javafaker.Faker;

import java.util.List;

public class PetRandomizer {

    public static String getPetName() {
        Faker faker = new Faker();
        return faker.animal().name();
    }

    public static int getPetAge() {
        Faker faker = new Faker();
        return faker.random().nextInt(10);
    }

    public static String getPetType() {
        List<String> types = List.of("DOG", "CAT", "RABBIT");
        Faker faker = new Faker();
        return types.get(faker.random().nextInt(types.size()));
    }
}
