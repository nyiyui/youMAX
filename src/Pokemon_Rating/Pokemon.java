package Pokemon_Rating;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

// TODO: top comment

class Pokemon {
    String name;
    int attack;
    int defense;
    int hp;
    int speed;
    /**
     * How cool-looking the Pokemon is.
     */
    int aesthetic;

    /**
     * Names of csv file headers.
     */
    private static final String[] HEADER_NAMES = {"name", "attack", "defense", "hp", "speed", "aesthetic"};

    int rating() {
        return attack + defense + hp + speed + aesthetic;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", hp=" + hp +
                ", speed=" + speed +
                ", aesthetic=" + aesthetic +
                '}';
    }

    public static void main(String[] args) throws ParseException, IOException {
        final FileReader source = new FileReader("./test.csv");
        final BufferedReader r = new BufferedReader(source);
        checkHeader(r);
        Pokemon row = null;
        while(true){
            // sigh...I wish Java had until loops...
            row = parseRow(r);
            System.out.println(row);
            // TODO: check rating output
            if (row==null) break;
        }
    }

    /**
     * Checks whether the first row (header) of an input csv file for Pokemon is valid.
     * See parseRow for the format of the csv file.
     *
     * @param input input reader
     */
    static void checkHeader(BufferedReader input) throws ParseException, IOException {
        Scanner fields = new Scanner(input.readLine());
        fields.useDelimiter(",");
        int offset = 0;
        for (int i = 0; i < HEADER_NAMES.length; i++) {
            // Use a for-not-each loop here as we want to use i.
            String want = HEADER_NAMES[i];
            String got = fields.next().toLowerCase();
            if (!got.equals(want)) {
                throw new ParseException(String.format("header field index %d: wanted %s, got %s", i, want, got), offset);
            }
            offset += got.length() + 1;
        }
    }

    /**
     * parseRow parses a line from an input csv file into a Pokemon object.
     * The headers for the csv file is as follows:
     * name,attack,defense,hp,speed,aesthetic
     * The header names are case insensitive.
     *
     * @param input input reader
     * @return parsed object. Null if EOF is reached.
     * @throws IOException depending on input operations
     */
    static Pokemon parseRow(BufferedReader input) throws IOException {
        String line = input.readLine();
        if (line == null) {
            return null;
        }
        Scanner fields = new Scanner(line);
        fields.useDelimiter(",");
        Pokemon result = new Pokemon();
        assert HEADER_NAMES.length == 6; // so we don't forget to update HEADER_NAMES when we add more fields
        result.name = fields.next();
        result.attack = fields.nextInt();
        result.defense = fields.nextInt();
        result.hp = fields.nextInt();
        result.speed = fields.nextInt();
        result.aesthetic = fields.nextInt();
        return result;
    }
}
