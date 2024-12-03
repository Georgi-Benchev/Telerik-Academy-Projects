package set_and_Map.CodingTasks_2;

import java.util.*;

public class Gotta_Catch_Them_All {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<Pokemon>> typesOfPokemon = new HashMap<>();
        List<Pokemon> rankList = new LinkedList<>();

        String inputLine = "";
        while (!"end".equals(inputLine = scanner.nextLine())) {
            String[] parameters = inputLine.split(" ");
            String command = parameters[0];

            switch (command) {
                case "add": {
                    String pokemonName = parameters[1];
                    String pokemonType = parameters[2];
                    int pokemonPower = Integer.parseInt(parameters[3]);
                    int pokemonPosition = Integer.parseInt(parameters[4]);

                    Pokemon newPokemon = new Pokemon(pokemonName, pokemonType, pokemonPower);

                    if (!typesOfPokemon.containsKey(pokemonType)) {
                        typesOfPokemon.put(pokemonType, new TreeSet<>());
                    }
                    typesOfPokemon.get(pokemonType).add(newPokemon);

                    if (pokemonPosition - 1 == rankList.size()) {
                        rankList.add(newPokemon);
                    } else {
                        rankList.add(pokemonPosition - 1, newPokemon);
                    }

                    System.out.printf("Added pokemon %s to position %d%n", pokemonName, pokemonPosition);
                    break;
                }
                case "find": {
                    String typeToFind = parameters[1];
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("Type %s: ", typeToFind));
                    typesOfPokemon.get(typeToFind).stream()
                            .limit(5)
                            .forEach(pokemon -> sb.append(pokemon.toString()));
                    System.out.println(sb.substring(0, sb.length() - 2));
                    break;
                }
                case "ranklist": {
                    int startPosition = Integer.parseInt(parameters[1]);
                    int endPosition = Integer.parseInt(parameters[2]);
                    StringBuilder sb = new StringBuilder();

                    int counterFlag = 1;
                    for (int i = startPosition - 1; i < endPosition; i++) {
                        sb.append(String.format("%d. %s", counterFlag++, rankList.get(i).toString()));
                    }

                    if (sb.length() > 2) {
                        System.out.println(sb.substring(0, sb.length() - 2));
                    } else {
                        System.out.println("No items");
                    }
                    break;
                }

            }


        }


    }
}

class Pokemon implements Comparable<Pokemon> {
    private final String name;
    private final String type;
    private final int power;

    public Pokemon(String name, String type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    @Override
    public int compareTo(Pokemon o) {
        return Comparator
                .comparing(Pokemon::getName)
                .thenComparing(Pokemon::getPower).reversed()
                .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("%s(%d); ", getName(), getPower());
    }
}



