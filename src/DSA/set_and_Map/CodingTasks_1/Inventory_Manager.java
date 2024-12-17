package DSA.set_and_Map.CodingTasks_1;

import java.util.*;

public class Inventory_Manager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Item> inventory = new HashMap<>(); // compare to
        Map<String, Set<Item>> typesInventory = new HashMap<>();

        String input = "";
        while (!"end".equals(input = scanner.nextLine())) {
            String[] parameters = input.split(" ");
            String command = parameters[0];

            StringBuilder output = new StringBuilder();
            output.append("Ok: ");

            if (command.equals("add")) {
                String itemName = parameters[1];
                double itemPrice = Double.parseDouble(parameters[2]);
                String itemType = parameters[3];

                if (inventory.containsKey(itemName)) {
                    System.out.printf("Error: Item %s already exists%n", itemName);
                } else {
                    Item newItem = new Item(itemName, itemPrice, itemType);
                    inventory.put(itemName, newItem);

                    typesInventory.putIfAbsent(itemType, new TreeSet<>());
                    typesInventory.get(itemType).add(newItem);
                    System.out.printf("Ok: Item %s added successfully%n", itemName);
                }
                continue;
            } else if (command.equals("filter")) {
                String filtrationType = parameters[2];

                if (filtrationType.equals("price")) {
                    String priceType = parameters[3];

                    if (priceType.equals("to")) {
                        double maxPrice = Double.parseDouble(parameters[4]);

                        inventory.values().stream()
                                .sorted()
                                .filter(e -> e.getPrice() <= maxPrice)
                                .limit(10)
                                .forEach(e -> output.append(String.format("%s, ", e.asString())));

                    } else if (priceType.equals("from")) {
                        double minValue = Double.parseDouble(parameters[4]);

                        inventory.values().stream()
                                .sorted()
                                .filter(parameters.length == 5 ? e -> e.getPrice() >= minValue : e -> e.getPrice() >= minValue
                                        && e.getPrice() <= Double.parseDouble(parameters[6]))
                                .limit(10)
                                .forEach(e -> output.append(String.format("%s, ", e.asString())));
                    }

                } else if (filtrationType.equals("type")) {
                    String typeToFilter = parameters[3];

                    if (!typesInventory.containsKey(typeToFilter)) {
                        System.out.printf("Error: Type %s does not exist%n", typeToFilter);
                        continue;
                    }


                    typesInventory.get(typeToFilter).stream()
                            .limit(10)
                            .forEach(e -> output.append(String.format("%s, ", e.asString())));
                }
            }

            if (output.length() == 4) {
                System.out.println("Ok: ");
            } else {
                System.out.println(output.substring(0, output.length() - 2));
            }
        }
    }
}

class Item implements Comparable<Item> {
    String name;
    double price;
    String type;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Item(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String asString() {
        return String.format("%s(%.2f)", name, price);
    }

    @Override
    public int compareTo(Item o) {
        return Comparator
                .comparing(Item::getPrice)
                .thenComparing(Item::getName)
                .thenComparing(Item::getType)
                .compare(this, o);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Item)) return false;
        Item item = (Item) obj;
        return item.name.equals(name);
    }
}
