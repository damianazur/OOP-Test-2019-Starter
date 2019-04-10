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

    /**
     * @return the hundreds
     */
    public int getHundreds() {
        return hundreds;
    }

    /**
     * @param hundreds the hundreds to set
     */
    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    /**
     * @return the tens
     */
    public int getTens() {
        return tens;
    }

    /**
     * @param tens the tens to set
     */
    public void setTens(int tens) {
        this.tens = tens;
    }

    /**
     * @return the ones
     */
    public int getOnes() {
        return ones;
    }

    /**
     * @param ones the ones to set
     */
    public void setOnes(int ones) {
        this.ones = ones;
    }
}