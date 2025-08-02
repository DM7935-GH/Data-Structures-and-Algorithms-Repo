package mainPackage;

/**
 * The class used to store a country's values.
 */
class CountryData {
    String name;
    int population;
    int area;

    public CountryData (String name) {
        this.name = name;
    }

    public CountryData (String name, int population, int area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }
}

/**
 * The class for nodes of a CountryLinkedList object.
 */
class CountryNode {
    CountryData data;
    CountryNode alphaNext, alphaPrev; // Pointers to the next/previous node in the alphabetically-ordered list
    CountryNode popNext, popPrev; // Pointers to the next/previous node in the population-ordered list
    CountryNode areaNext, areaPrev; // Pointers to the next/previous node in the area-ordered list

    public CountryNode () {}

    public CountryNode (CountryData data) {
        this.data = data;
    }

    public CountryNode (CountryData data, CountryNode aln, CountryNode alp, CountryNode pon, CountryNode pop, CountryNode arn, CountryNode arp ) {
        this.data = data;
        SetPointers(aln, alp, pon, pop, arn, arp);
    } 

    public void SetPointers (CountryNode aln, CountryNode alp, CountryNode pon, CountryNode pop, CountryNode arn, CountryNode arp) {
        this.alphaNext = aln; this.alphaPrev = alp;
        this.popNext = pon; this.popPrev = pop;
        this.areaNext = arn; this.areaPrev = arp;
    }
}

/**
 * The class for a country linked list (multilist).
 * Each node stores the name, population and area of the given country.
 * Countries can be ordered by their name (alphabetically), population or area.
 */
public class CountryLinkedList {
    private CountryNode alphaHead, alphaTail; // The first node in the alphabetically-ordered list
    private CountryNode popHead, popTail; // The first node in the population-ordered list
    private CountryNode areaHead, areaTail; // The first node in the area-ordered list
    private String listName;
    private boolean printMessages;

    /**
     * Creates a country linked list object with no given name.
     */
    public CountryLinkedList() {
        this.listName = "";
        this.printMessages = false;
    }

    /**
     * Creates a country linked list object.
     * @param name - The name that this list will be referred to by.
     */
    public CountryLinkedList(String name) {
        this.listName = name;
        this.printMessages = false;
    }

    /**
     * Creates a country linked list object.
     * @param name - The name that this list will be referred to by.
     * @param printMessages - Determines whether debug messages will be printed to the console.
     * Does not affect the Print() method.
     */
    public CountryLinkedList(String name, boolean printMessages) {
        this.listName = "";
        this.printMessages = printMessages;
    }

    /**
     * Checks whether the list is empty.
     * @return True if there are no nodes in the list, false if otherwise.
     */
    public boolean IsEmpty() {
        if (alphaHead == null) {
            if (printMessages) { System.out.println("List " + listName + " is empty."); }
            return true;
        } else {
            if (printMessages) { System.out.println("List " + listName + " is not empty."); }
            return false;
        }
    }

    /** 
     * Gets the length/size of the list
     * @return An integer equal to the number of nodes currently in the list.
     */
    public Integer Length() {
        int length = 0;
        if (alphaHead != null) {
            // The list of names is used for counting (and most other operations)
            CountryNode node = alphaHead;
            length++;
            while (node != alphaTail) {
                node = node.alphaNext;
                length++;
            }
        }
        return length;
    }
}
