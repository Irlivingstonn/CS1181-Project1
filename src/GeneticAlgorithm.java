import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GeneticAlgorithm {

    public ArrayList<Item> readData(String filename) throws FileNotFoundException{

        ArrayList<Item> list_of_items = new ArrayList<>();

        File text = new File(filename);

        Scanner scanner = new Scanner(text);

        while(scanner.hasNextLine()){
            String[] split_string = (scanner.nextLine()).split("[,]", 0);


            Item new_item = new Item(split_string[0], Double.valueOf(split_string[1]), Integer.parseInt(split_string[2].replaceAll("\\s", "")));

            list_of_items.add(new_item);

        }

        return list_of_items;

    }

    public static void initializePopulation(ArrayList<Item> items, int populationSize){ // 10 = popualation size      // ArrayList<Chromosome>

        Chromosome parent1 = new Chromosome(items);
        Chromosome parent2 = new Chromosome(items);

        parent1.crossover(parent2);


    }


    public static void main(String[] args) throws FileNotFoundException{
        // --------- DECLARING ---------
        // Insert Path of File Below this Line
        String path_of_file = "/home/amnesia/IdeaProjects/CS1181-Project1/src/items.txt";
        int populationSize = 10;

        GeneticAlgorithm reading_file = new GeneticAlgorithm();
        ArrayList<Item> list_of_items = reading_file.readData(path_of_file);


        initializePopulation(list_of_items, populationSize);




        // --------- INPUT ---------
        // --------- PROCESSING ---------
        // --------- OUTPUT ---------
    }




}
