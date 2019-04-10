/*
	Damian Wojtowicz
	C17413722
	DT228/2
	OOP Lab Test 
	10/04/2019
*/

package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet {	
	private int gap = 50;
	private int boxSide = 100;

	private ArrayList<Colour> colours = new ArrayList<Colour>();
	private ArrayList<Resistor> resistors = new ArrayList<Resistor>();

	public void separate(int value)
	{
		int hundreds = (value / 100);
		int tens = (value - (hundreds * 100)) / 10;
		int ones = value - ((hundreds * 100)  + (tens * 10));
		print(hundreds + ",");
		print(tens + ",");
		println(ones);
	}

	public void settings()
	{
		size(500, 800);
		
		separate(381);
		separate(1);
		separate(92);
	}

	public void setup() 
	{
		loadColours();
		printColours();
		Colour c = findColor(1);
		System.out.println("Colour found: " + c.getColour());
		c = findColor(2);
		System.out.println("Colour found: " + c.getColour());
		loadResistors();
	}

	public void drawResistors() {
		int i = 1;
		for (Resistor r : resistors) {
			// get resistor colour number
			int hundreds = r.getHundreds();
			int tens = r.getTens();
			int ones = r.getOnes();
			
			// get colour from that resistor number
			Colour cHun = findColor(hundreds);
			Colour cTen = findColor(tens);
			Colour cOne = findColor(ones);

			// draw the resistor
			float y = (gap*i)+boxSide*(i - 1);
			float halfSide = boxSide/2;
			stroke(0, 0, 0);
			textAlign(LEFT, CENTER);

			// draw line going through the resistor
			line(200 - halfSide, y + halfSide, 200 + boxSide + halfSide, y + halfSide);
			fill(150);
			// draw the box
			rect(200, y, boxSide, boxSide);
			// draw hundred bar
			fill(cHun.getR(), cHun.getG(), cHun.getB());
			rect(200 + 10, y, 10, boxSide);
			text(20, 600, y + halfSide, cHun.getValue());
			// draw tens bar
			fill(cTen.getR(), cTen.getG(), cTen.getB());
			rect(200 + 30, y, 10, boxSide);
			text(20, 600, y + halfSide, cHun.getValue());
			// draw ones bar
			fill(cOne.getR(), cOne.getG(), cOne.getB());
			rect(200 + 50, y, 10, boxSide);
			text(20, 600, y + halfSide, cHun.getValue());

			i++;
		}
	}
	
	public void draw()
	{	
		background(150);
		drawResistors();
	}

	public void loadColours() {
		Table table = loadTable("colours.csv", "header");

		for (TableRow row : table.rows()) {
			Colour c = new Colour(row);
			colours.add(c);
		}
	}

	public void printColours() {
		for (Colour c : colours) {
			System.out.println(c.toString());
		}
	}

	public Colour findColor(int value) {
		for (Colour c : colours) {
			if (c.getValue() == value) {
				return c;
			}
		}
		return null;
	}

	public void loadResistors() {
		Table table = loadTable("resistors.csv", "header");

		for (TableRow row : table.rows()) {
			int value = row.getInt(0);
			Resistor r = new Resistor(value);
			resistors.add(r);
		}
	}
}
