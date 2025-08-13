package mainPackage;

import java.util.Collections;
import java.util.ArrayList;

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
}

/**
 * The class for a country linked list (multilist).
 * Each node stores the name, population and area of the given country.
 * Countries can be ordered by their name (alphabetically), population or area.
 */
public class CountryLinkedList {
    private CountryNode alphaHead, alphaTail; // The first and last nodes in the alphabetically-ordered list
    private CountryNode popHead, popTail; // The first and last nodes in the population-ordered list
    private CountryNode areaHead, areaTail; // The first and last nodes in the area-ordered list
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

    private void AddAuxFunc(CountryNode newNode, String which) {
        CountryNode head, tail; boolean bool;

        switch (which) {
            case "alpha": head = alphaHead; tail = alphaTail; break;
            case "pop": head = popHead; tail = popTail; break;
            default: head = areaHead; tail = areaTail; break;
        }

        if (head == null) { 
            // If the list is empty
            switch (which) {
                case "alpha": alphaHead = newNode; alphaTail = alphaHead; break;
                case "pop": popHead = newNode; popTail = popHead; break;
                default: areaHead = newNode; areaTail = areaHead; break;
            }

        } else { 
            // If the list is not empty
            switch (which) {
                case "alpha": bool = newNode.data.name.compareToIgnoreCase(head.data.name) < 0; break;
                case "pop": bool = newNode.data.population < head.data.population; break;
                default: bool = newNode.data.area < head.data.area; break;
            }

            if (bool) {
                // If the new node should become the head of the respective list
                switch (which) {
                    case "alpha": newNode.alphaNext = head; head.alphaPrev = newNode; alphaHead = newNode; break;
                    case "pop": newNode.popNext = head; head.popPrev = newNode; popHead = newNode; break;
                    default: newNode.areaNext = head; head.areaPrev = newNode; areaHead = newNode; break;
                }

            } else {
                CountryNode pNode = head; // pNode is the node before the current iteration node
                CountryNode cNode = pNode; // cNode is the current iteration node

                while (true) {
                    if (cNode == tail) {
                        // If the new node should become the tail of the respective list
                        switch (which) {
                            case "alpha": cNode.alphaNext = newNode; newNode.alphaPrev = cNode; alphaTail = newNode; break;
                            case "pop": cNode.popNext = newNode; newNode.popPrev = cNode; popTail = newNode; break;
                            default: cNode.areaNext = newNode; newNode.areaPrev = cNode; areaTail = newNode; break;
                        }
                        break;

                    }

                    switch (which) {
                        case "alpha": bool = newNode.data.name.compareToIgnoreCase(cNode.alphaNext.data.name) < 0; break;
                        case "pop": bool = newNode.data.population < cNode.popNext.data.population; break;
                        default: bool = newNode.data.area < cNode.areaNext.data.area; break;
                    }

                    if (bool) {
                        // If the new node should be placed before another node in the respective list
                        switch (which) {
                            case "alpha": newNode.alphaPrev = cNode; newNode.alphaNext = cNode.alphaNext; cNode.alphaNext.alphaPrev = newNode; cNode.alphaNext = newNode; break;
                            case "pop": newNode.popPrev = cNode; newNode.popNext = cNode.popNext; cNode.popNext.popPrev = newNode; cNode.popNext = newNode; break;
                            default: newNode.areaPrev = cNode; newNode.areaNext = cNode.areaNext; cNode.areaNext.areaPrev = newNode; cNode.areaNext = newNode; break;
                        }
                        break;
                    }

                    switch (which) {
                        case "alpha": cNode = cNode.alphaNext; pNode = cNode.alphaPrev; break;
                        case "pop": cNode = cNode.popNext; pNode = cNode.popPrev; break;
                        default: cNode = cNode.areaNext; pNode = cNode.areaPrev; break;
                    }
                }
            }
        }
    }

    /**
     * Adds a new node (country) to the list.
     * If the population and area are not given as parameters, then this country will not be included on those lists.
     * @param name - The name of the country to be added.
     */
    public void Add(String name) {
        CountryNode newNode = new CountryNode(new CountryData(name));
        AddAuxFunc(newNode, "alpha");
    }

    /**
     * Adds a new node (country) to the list.
     * @param name - The name of the country to be added.
     * @param population - The population of the country.
     * @param area - The area of the country
     */
    public void Add(String name, int population, int area) {
        CountryNode newNode = new CountryNode(new CountryData(name, population, area));
        AddAuxFunc(newNode, "alpha");
        AddAuxFunc(newNode, "pop");
        AddAuxFunc(newNode, "area");
    }

    /**
     * Removes the node (country) with the given name from the list.
     * @param countryName - The name of the country to be removed.
     */
    public void Remove(String countryName) {
        CountryNode node = alphaHead;

        if (printMessages && node == null) { System.out.println("List " + listName + " is empty."); }

        while (node != null) {
            if (node.data.name == countryName) {
                if (node.alphaNext == null && node.alphaPrev == null) {
                    alphaHead = null;
                    alphaTail = null;
                } else if (node.alphaNext == null) {
                    alphaTail = node.alphaPrev;
                    node.alphaPrev.alphaNext = null;
                } else if (node.alphaPrev == null) {
                    alphaHead = node.alphaNext;
                    node.alphaNext.alphaPrev = null;
                } else {
                    node.alphaPrev.alphaNext = node.alphaNext;
                    node.alphaNext.alphaPrev = node.alphaPrev;
                }
                break;
            }
            node = node.alphaNext;
        }
    }

    /**
     * Prints the values of each node (country) in the list to the console.
     * Ignores the value of the printMessages attribute.
     * If no parameters are given, then country names, populatuons and areas will be printed in ascending alphabetical order.
     */
    public void Print() {
        Print(false, true, "alpha");
    }

    /**
     * Prints the values of each node (country) in the list to the console.
     * Ignores the value of the printMessages attribute.
     * @param onlyNames - Set to 'true' to only print country names, or 'false' to print names, populations and areas.
     * @param asc - Set to 'true' to print countries in ascending order, or 'false' to print in descending order.
     * @param orderBy - Set to 'alpha' to order countries alphabetically, 'pop' to order by population, or 'area' to order by area.
     * For the latter two, countries without values for their population or area will not be listed.
     */
    public void Print(boolean onlyNames, boolean asc, String orderBy) {
        System.out.println("Countries in " + this.listName + " :");
        CountryNode node;
        ArrayList<String> output = new ArrayList<String>();

        CountryNode listHead, listTail;
        switch (orderBy) {
            case "alpha": listHead = alphaHead; listTail = alphaTail; break;
            case "pop": listHead = popHead; listTail = popTail; break;
            case "area": default: listHead = areaHead; listTail = areaTail; break;
        }

        if (listHead != null) {
            node = listHead;
            while (true) {
                if (onlyNames == true) {
                    output.add("\t" + node.data.name);
                } else {
                    output.add("\t" + node.data.name + " - Population: " + String.valueOf(node.data.population) 
                    + " - Area: " + String.valueOf(node.data.area));
                }
                if (node == listTail) { break; }
                
                switch (orderBy) {
                    case "alpha": node = node.alphaNext; break;
                    case "pop": node = node.popNext; break;
                    case "area": default: node = node.areaNext; break;
                }
            }
        }

        if (asc == false) { Collections.reverse(output); }

        for (String countryString : output) {
            System.out.println(countryString);
        }
    }
}
