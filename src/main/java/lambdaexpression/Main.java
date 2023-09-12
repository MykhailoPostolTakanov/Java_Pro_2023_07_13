package lambdaexpression;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hero> heroes = HeroUtils.getHeroesListFromFile("heroes_information.csv");
        System.out.println("average height: "+HeroUtils.getAverageHeightOfTheHeroesIsMoreThanZero(heroes));
        System.out.println("the tallest: "+HeroUtils.getNameOfTheHighestHero(heroes));
        System.out.println("the heaviest: "+HeroUtils.getNameOfTheMostHeaviestHero(heroes));
        System.out.println("gender counts: "+HeroUtils.getNumberOfHeroesInEachGenderGroup(heroes));
        System.out.println("alignment counts: "+HeroUtils.getNumberOfPeopleInEachAlignmentGroup(heroes));
        System.out.println("5 most popular publisher: "+HeroUtils.getNamesOfTheMostPopularPublishers(heroes,5));
        System.out.println("3 most popular hair color: "+HeroUtils.getNamesOfTheMostCommonHairColors(heroes,3));
        System.out.println("the most popular eye color: "+HeroUtils.getMostCommonEyeColor(heroes));
    }
}
