import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        // ---------- DECLARING ----------

        ArrayList<Chromosome> initial_population = new ArrayList<>(populationSize);
        ArrayList<Chromosome> next_generation = new ArrayList<>();
        int END_PROGRAM = 20;
        int counter = 0;

        // ---------- INPUT ----------
        // Creates 10 random individuals to serve as the initial population
        for(Integer person = 0; person < populationSize; person++){
            initial_population.add(new Chromosome(items));
        }

        while(counter <= END_PROGRAM){

            // Adds current population to next generation
            for (Chromosome person: initial_population){
                next_generation.add(person);
            }

            for (Integer person = 0; person < initial_population.size(); person++){
                // Shuffles the Initial Population List
                Collections.shuffle(initial_population);


                // Chooses the first element of the list to crossover with another person
                // to make the child
                Chromosome child = next_generation.get(person).crossover(initial_population.get(0));


                // Replaces the Next Generation Person with the Child
                next_generation.add(child);
            }


            // Takes 10 percent of the population and mutates the genes
            for (Integer mutation = 0; mutation<(next_generation.size() * 0.1); mutation++){

                Collections.shuffle(next_generation);
                next_generation.get(0).mutate();

            }

            // Sorts the Next Generation based on the fitness
            Collections.sort(next_generation);

            // Clears out the old population
            initial_population.clear();

            // Adds the top 10 of the next generation back into the population
            for(Integer person = 0; person < populationSize; person++){
                initial_population.add(next_generation.get(person));
            }

            counter += 1;
        }

        System.out.println("Fittest Individual:");
        System.out.println(next_generation.get(0));

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
