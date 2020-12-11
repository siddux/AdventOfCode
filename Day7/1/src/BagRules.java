
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BagRules {
    List<String> input;
    HashMap<String, List<BagInformation>> bagAndContents;

    public BagRules() {
        input = new ArrayList<String>();
        try {
            File file = new File( "/Users/eduardriusmartinez/Desktop/AdventOfCode/Day7/1/src/input.txt" );
            Scanner reader = new Scanner( file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                if (data != null){
                    input.add( data );
                }
            }
            bagAndContents = new HashMap<>();

            // Could just use regex on the whole thing I guess..
            final String regexBaginfo = "(?<amount>\\d)(?<bagAndColor>[\\w|\\s]+)";

            input.forEach(
                    rule -> {
                        // This leaves us with a string like
                        // drab blue,3 bright coral,3 dim coral
                        rule = rule.replace("bags contain", ",");
                        rule = rule.replace("bags", "");
                        rule = rule.replace("bag", "");
                        rule = rule.replace(" , ", ",");
                        rule = rule.replace(" .", "");
                        // First element is the bag, afterwards the contents
                        String[] contents = rule.split(",");

                        List<BagInformation> list = new ArrayList<>();
                        Pattern pattern = Pattern.compile(regexBaginfo);
                        Matcher matcher;
                        for (int i = 1; i < contents.length; i++) {
                            matcher = pattern.matcher(contents[i]);
                            if (matcher.find()) {
                                list.add(
                                        new BagInformation(
                                                matcher.group("bagAndColor").trim(),
                                                Integer.parseInt(matcher.group("amount"))));
                            }
                        }
                        bagAndContents.put(contents[0], list);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int partOne() {
        int amountOfBags = 0;
        for (String bag : bagAndContents.keySet()) {
            if (containsColorBag(bag, "shiny gold")) {
                amountOfBags++;
            }
        }
        return amountOfBags;
    }

    public int partTwo() {
        return calculateAmountOfBagsInColorBag("shiny gold") - 1;
    }

    public boolean containsColorBag(String bag, String color) {
        for (BagInformation bagInformation : bagAndContents.get(bag)) {
            // in case we already have the desired color present
            if (bagInformation.color.equalsIgnoreCase(color)) {
                return true;
            }
            if (containsColorBag(bagInformation.color, color)) {
                return true;
            }
        }
        return false;
    }

    public int calculateAmountOfBagsInColorBag(String color) {
        int amount = 1;
        for (BagInformation bagInformation : bagAndContents.get(color)) {
            amount += bagInformation.amount * calculateAmountOfBagsInColorBag(bagInformation.color);
        }
        return amount;
    }


    public void printSolutions() {
        System.out.println("Part one: " + partOne());
        System.out.println("Part two: " + partTwo());
    }

    public static class BagInformation {
        public String color;
        public int amount;

        public BagInformation(String color, int amount) {
            this.color = color;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "BagInformation{" + "color='" + color + '\'' + ", amount=" + amount + '}';
        }
    }
}