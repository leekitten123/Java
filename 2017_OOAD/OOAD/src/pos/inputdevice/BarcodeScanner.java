package pos.inputdevice;

import pos.type.Barcode;

/***
 * 
 * 20133243 Lee Sang Wook
 * BarcodeScanner.java
 * 
 ***/

public class BarcodeScanner extends InputDevice{

	public void scanProduct() { setInput(new Barcode(scanInt(), scanInt())); }
}