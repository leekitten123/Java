package pos.inputdevice;

import pos.type.ProductName;

/***
 * 
 * 20133243 Lee Sang Wook
 * Keyboard.java
 * 
 ***/

public class Keyboard extends InputDevice{
	
	public void scanProduct() { setInput(new ProductName(scanStr())); }
}
