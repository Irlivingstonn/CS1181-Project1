import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {


    private static Random rng;
    public Chromosome(){
        Random rng = null;
    }

    public Chromosome(ArrayList<Item> items){
        Random rng = new Random();
        ArrayList<Item> list_of_items = new ArrayList<>();

        for (Item item: items){
            Item new_item = new Item(item);

            if(rng.nextBoolean()){
                new_item.setIncluded(true);
            }
            this.add(new_item);
        }
    }




    // Crossover Method: Takes in 2 Chromosomes and Combines it to make an New Chromosome
    public Chromosome crossover(Chromosome other){
        Random rng = new Random();



        Chromosome child = new Chromosome();

        for(Integer gene = 0; gene < other.size(); gene++){
            if (rng.nextInt(10) <= 5) {
                child.add(this.get(gene));

            } else {
                child.add(other.get(gene));
            }
        }
        return child;
    }

    // Mutate Method: Generates random numbers for every gene the person has
    //                If the number is equal to 1, then it mutates it
    public void mutate(){
        Random rng = new Random();

        for (Item gene: this){
            if (rng.nextInt(10) == 1){
                if(gene.isIncluded()){
                    gene.setIncluded(false);
                }
                else{
                    gene.setIncluded(true);
                }
            }
        }
    }

    // GetFitness Method: Adds all Included Items' weights, if it's greater than 10 then the fitness is 0
    //                    Otherwise the fitness is the included items' weights
    public int getFitness(){
        // Declaring Variables
        int total_fitness = 0;

        // Gets the sum of all the included items' weights
        for (Item item: this){
            if(item.isIncluded()){

                total_fitness += item.getWeight();
            }
        }

        // If the sum of all the weights is greater than 10, then the fitness is 0
        if (total_fitness > 10){
            return 0;
        }
        else{
            return total_fitness;
        }
    }

    // CompareTo Method: Compares the Total Fitness of 2 Chromosomes
    @Override
    public int compareTo(Chromosome other) {

        // Returns 0 if the fitness is the same
        if(this.getFitness() == other.getFitness()){
            return 0;
        }

        // Returns +1 if this fitness is less than the other fitness
        else if (this.getFitness() < other.getFitness()){
            return 1;
        }

        // Returns -1 if the other fitness is greater than this fitness
        else{
            return -1;
        }

    }

    // ToString Method: Displays the name, weight and value of all included items of this chromosome
    public String toString(){
        String str = "";

        for (Item gene: this){
            if (gene.isIncluded()){
                str += (gene + "\n");
            }
        }

        str += this.getFitness();

        return str;
    }







}
