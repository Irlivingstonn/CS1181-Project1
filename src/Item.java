public class Item {

    private final String name;

    private final double weight;
    private final int value;
    private boolean included;


    public Item(String name, double weight, int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.included = false;
        //  False indicates we should leave that item behind, and true indicates we should take it with us

    }

    public Item(Item other){
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
        this.included = other.included;
    }

    // Getters

    public double getWeight(){
        return this.weight;
    }

    public int getValue(){
        return this.value;
    }

    public boolean isIncluded(){
        return this.included;
    }

    // Setters

    public void setIncluded(boolean bool){
        this.included = bool;
    }

    // toString

    public String toString(){
        return (this.name + "(" + this.weight + " lbs, $" + this.value + ")");
    }



    public int measuring_fitness(){

        if (this.weight > 10){
            return 0;
        }
        else{
            return this.value;
        }
    }


}
