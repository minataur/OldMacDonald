import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class OldMacDonald extends PApplet {

//your variable declarations here
public void setup() {
	/*Cow k = new Cow("cow", "moo");
	System.out.println(k.getType() + " goes " + k.getSound());
	Pig p = new Pig("pig", "oink");
	System.out.println(p.getType() + " goes " + p.getSound());
	Chick c = new Chick("chicken", "peep");
	System.out.println(c.getType() + " goes " + c.getSound());*/

	Farm lucky = new Farm();
	lucky.animalSounds();
}
//declare classes and the interface below
interface Animal {
	public String getSound();
	public String getType();
}

class Farm {
	private Animal[] aBunchOfAnimals = new Animal[3];

	public Farm() {
		aBunchOfAnimals[0] = new namedCow("cow","Elsie", "moo");
		aBunchOfAnimals[1] = new Pig("pig", "oink");
		aBunchOfAnimals[2] = new Chick("chick", "cluck", "cheep");
	}

	public void animalSounds() {

		for (int nI = 0; nI < aBunchOfAnimals.length; nI++) {
			System.out.println(aBunchOfAnimals[nI].getType() + " goes " + aBunchOfAnimals[nI].getSound());
		}

		System.out.println("The cow known as" + ((namedCow)aBunchOfAnimals[0]).getName());
	}

}

class Cow implements Animal {
	protected String myType;
	protected String mySound;

	public Cow(String type, String sound) {
		myType = type;
		mySound = sound;
	}

	public Cow() {
		myType="unknown";
		mySound="unknown";
	}

	public String getSound() {
		return mySound;
	}
	
	public String getType() {
		return myType;
	} 

}

class Pig implements Animal {
	protected String myType;
	protected String mySound;

	public Pig(String type, String sound) {
		myType = type;
		mySound = sound;
	}

	public Pig() {
		myType = "unknown";
		mySound = "unknown";
	}

	public String getSound() {
		return mySound;
	}
	public String getType() {
		return myType;
	}

}

class Chick implements Animal {
	protected String myType;
	protected String mySound;
	protected double i;

	public Chick(String type, String sound, String sound2) {
		myType = type;
		
		i=Math.random();
		if (i < 0.5f) {
			mySound = sound;
		} else if (i < 0.9f) {
			mySound = sound2;
		}
		
	}

	public Chick() {
		myType = "unknown";
		mySound = "unknown";
	}

	public String getSound() {
		return mySound;
	}
	public String getType() {
		return myType;
	}

}

class namedCow extends Cow {
	String myName;

	public namedCow(String type, String name, String sound) {
		myName = name;
	}

	public String getName() {
		return myName;
	}

}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "OldMacDonald" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
