package lambdaexpression;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class HeroUtils {
    public static double getAverageHeightOfTheHeroesIsMoreThanZero(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> hero.getHeight() > 0)
                .mapToDouble(Hero::getHeight)
                .average()
                .orElseThrow(() -> new RuntimeException("List of Heroes is empty"));
    }

    public static String getNameOfTheHighestHero(List<Hero> heroes) {
        return heroes.stream()
                .max(Comparator.comparingDouble(Hero::getHeight))
                .orElseThrow(() -> new RuntimeException("Heroes list is empty!"))
                .getName();
    }

    public static String getNameOfTheMostHeaviestHero(List<Hero> heroes) {
        return heroes.stream()
                .max(Comparator.comparingDouble(Hero::getWeight))
                .orElseThrow(() -> new RuntimeException("Heroes list is empty!"))
                .getName();
    }

    public static Map<String, Long> getNumberOfHeroesInEachGenderGroup(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getGender, Collectors.counting()));
    }

    public static Map<String, Long> getNumberOfPeopleInEachAlignmentGroup(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getAlignment, Collectors.counting()));
    }

    public static List<String> getNamesOfTheMostPopularPublishers(List<Hero> heroes, int howMuchView) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getPublisher, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(howMuchView)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getNamesOfTheMostCommonHairColors(List<Hero> heroes, int howMuchView) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getHairColor, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(howMuchView)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static String getMostCommonEyeColor(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::getEyeColor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .orElseThrow(() -> new RuntimeException("List of Heroes is empty"))
                .getKey();
    }

    public static List<Hero> getHeroesListFromFile(String fileName) {
        InputStream is = HeroUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (is == null)
            return new LinkedList<>();
        var scanner = new Scanner(is);
        List<Hero> heroes = new LinkedList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] heroFields = line.split(";");
            if (heroFields[0].equals("Id"))
                continue;
            double weight;
            if (heroFields[6].contains(","))
                weight = Double.parseDouble(heroFields[6].replace(",", "."));
            else
                weight = Double.parseDouble(heroFields[6]);
            heroes.add(new Hero(heroFields[1],
                    heroFields[2],
                    heroFields[3],
                    heroFields[4],
                    heroFields[5],
                    weight,
                    heroFields[7],
                    heroFields[8],
                    heroFields[9],
                    Integer.parseInt(heroFields[10])));
        }
        return heroes;
    }
}
