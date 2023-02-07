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

    @Override
    public int compareTo(Chromosome other) {

        return 0;
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

    /**

    public void mutate{
        // make a current change to the chromosome
    }

    public int getFitness(){
        // giving use a measure of how good the items are
        // otherwise it's the total value
        // Sum of all the included items weights are greater than 10
    }

    **/







}
