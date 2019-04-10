package ie.tudublin;

public class Resistor {
    private int hundreds;
    private int tens;
    private int ones;

    public Resistor(int value) {
        hundreds = (value / 100);
        tens = (value - (hundreds * 100)) / 10;
        ones = value - ((hundreds * 100)  + (tens * 10));

        System.out.print(hundreds + ",");
        System.out.print(tens + ",");
        System.out.println(ones);
    }
}