import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of a file");
        String filename = input.nextLine();
        File file = new File("src/" + filename);
        Scanner readline = new Scanner(file);

        List<String> data = new ArrayList<>();

        //initialising the data to an arraylist
        while (readline.hasNext()) {
            data.add(readline.nextLine());
        }
        List<String> salesID = new ArrayList<>();
        List<Double> prices = new ArrayList<>();
        List<String> products = new ArrayList<>();

        //initializing the salesID,prices and products arraylist's
        for (int i = 0; i < data.size(); i++) {
            String[] new_data = data.get(i).split(",");
            salesID.add(new_data[0]);
            //System.out.println(new_data[1]);
            prices.add(Double.parseDouble(new_data[1]));
            products.add(new_data[2]);
        }
        int total_products = products.size();
        int total_salesID = salesID.size();
        double total_price = Math.round(totalprice(prices) * 100.0) / 100.0;
        Hashtable<String,Integer> number_of_products = number_of_products(products);
        AVLTree<String> avltree = salesIDs(salesID);

        System.out.println("For the given data the number of products sold is " + total_products +"\n"+
                "These products were sold for R" + total_price + "\n"+
                "And the total salespersons IDs that worked is " + total_salesID);

        System.out.println("The list of the total products sold per customer can be given as " +"\n"+ number_of_products );

        System.out.println("\n");
        System.out.println("Do you want to Delete a salesID?");
        String node = input.nextLine();

        if(node.equalsIgnoreCase("yes")){
            System.out.println("Ok cool what ID are you looking for? just print it down");
            String take_node = input.nextLine();
            Delete_ID(take_node,avltree);
        }
    }

/**
 creates an AVL Tree**/
    public static AVLTree<String> salesIDs(List<String> IDs) {
        AVLTree<String> bt = new AVLTree<String>();
        for (int i = 0; i < IDs.size(); i++) {
            bt.insert(IDs.get(i));
        }
        return bt;
    }

    /**
     returs the total price of all the products**/
    public static double totalprice(List<Double> prices) {
        double totalprice = 0.0;
        for (int i = 0; i < prices.size(); i++) {
            totalprice += prices.get(i);
        }
        return totalprice;
    }

    /**
     creates the HashTable of totals products bought per products*/
    public static Hashtable<String, Integer> number_of_products(List<String> products) {
        Hashtable<String, Integer> products_num = new Hashtable<>();
        for (int i = 0; i < products.size(); i++) {
            int appearance = 0;
            for (int j = 0; j < products.size(); j++) {
                if (products.get(i).contains(products.get(j))) {
                    appearance++;
                }
            }
            products_num.put(products.get(i), appearance);
        }
        return products_num;
    }

    public static void Delete_ID(String node,AVLTree<String> avltree){
        System.out.println("Before Delete : ");
        avltree.treeOrder();
        avltree.delete(node);
        System.out.println("After Delete : ");
        avltree.treeOrder();
    }

}

