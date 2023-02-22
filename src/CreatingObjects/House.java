/**
 * OOP Exercise 1: Creating Objects - House
 * <p>
 * Course: ICS3U0
 * Teacher: Ms. Krasteva
 * Created: 2023-02-09
 * Purpose: Objects representing a House with an address and size.
 *
 * @author Ms. Krasteva
 */
package CreatingObjects;

public class House {
    private int street_num;
    private String street;
    private String city;
    private String province;
    private String postal_code;
    @SuppressWarnings("unused")
    private double size;
    @SuppressWarnings("unused")
    private boolean detached;
    @SuppressWarnings("unused")
    private int stories;

    /**
     * Creates 5 instances of House and runs each of the instance methods..
     *
     * @param args ignored command-line arguments
     */
    public static void main(String[] args) {
        House[] houses = new House[5];
        houses[0] = new House(1, "Tillplain Road", "Toronto", "Ontario", "M3H 5R2", 1, true, 2);
        houses[1] = new House(2, "Tillplain Road", "Toronto", "Ontario", "M3H 5R2", 2, true, 2);
        houses[2] = new House(3, "Tillplain Road", "Toronto", "Ontario", "M3H 5R2", 3, false, 2);
        houses[3] = new House(4, "Tillplain Road", "Toronto", "Ontario", "M3H 5R2", 4, false, 2);
        houses[4] = new House(5, "Tillplain Road", "Toronto", "Ontario", "M3H 5R2", 5, true, 1);
        for (House h : houses) {
            h.displayAddress();
        }
    }

    /**
     * House initialises a House with all attributes!
     *
     * @param n  street number
     * @param s  street name
     * @param c  city
     * @param pv province/territory
     * @param p  postal code
     * @param si size
     * @param d  detached
     * @param l  num of stories
     */
    public House(int n, String s, String c, String pv, String p, double si, boolean d, int l) {
        street_num = n;
        street = s;
        city = c;
        province = pv;
        postal_code = p;
        size = si;
        detached = d;
        stories = l;
    }

    /**
     * displays the address of this House to standard output.
     */
    public void displayAddress() {
        System.out.println(street_num + " " + street);
        System.out.println(city + ", " + province);
        System.out.println(postal_code);
    }
} // House class
