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
	private ArrayList<Colour> colours = new ArrayList<Colour>();

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

	}
	
	public void draw()
	{	

	}

	public void loadColours() {
		Table table = loadTable("colours", "header");

		for (TableRow row : table.rows()) {
			Colour c = new Colour(row);
			colours.add(c);
		}
	}
}
