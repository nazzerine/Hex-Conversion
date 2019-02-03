
	/***************************************************

	  Name: Nazzerine Waldon
	  Date: 2/22/17
	  Homework #7
	  
	  Program name:        HexConversion
	  Program description: Accepts hexadecimal numbers as input and converts each number to binary
	                       and to the decimal equivalent.
	                       Valid input examples: F00D, 000a, 1010, FFFF, Goodbye, GOODBYE
	                       Enter GOODBYE (case insensitive) to exit the program.
	  
	****************************************************/


	import java.util.Scanner;

	public class HexConversion {

	  public static void main(String[] args) {
	    	
	    // Maximum length of input string
	    final byte INPUT_LENGTH = 4;
	    	
	    String userInput = "";                   // Initialize to null string
	    Scanner input = new Scanner(System.in);

	    // Process the inputs until GOODBYE is entered
	    do {
	      // Input a 4 digit hex number
	      System.out.print("\nEnter a hexadecimal string, or enter GOODBYE to quit:  ");
	      userInput = input.next().toUpperCase();
			  
	      // Process the input
	      switch (userInput) {
			  
	        case "GOODBYE": break;
	            
	        default:        if (isValidHex(userInput, INPUT_LENGTH)) {
	                          // The input is a valid hexadecimal string
					
	                          // Convert the hexadecimal string to binary and print the binary number as a string
	                          String binVal = hex2Bin(userInput, INPUT_LENGTH);
			                      
	                          // Convert the hexadecimal string to decimal and print the decimal number
	                          long decVal = hex2Dec(userInput, INPUT_LENGTH);
	                          System.out.printf("      0x%s = %s in binary = %d in decimal (unsigned).\n", userInput, binVal, decVal);
	                        }
				
	                        else {
	                          // String is either the wrong length or is not a valid hexadecimal string
	                          System.out.printf("      The string %s is not a valid input.\n", userInput);
	                        }
	                        break;
	        }
	    } while (!userInput.equals("GOODBYE"));
			
	    // Exit the program
	    System.out.println("\nGoodbye!");
	    input.close();
	  }

	public static boolean isValidHex(String userIn, byte inputLen) {
	    boolean isValid = false;
	    	
	    // If length of the input string is equal to inputLen, continue with validation,
	    // otherwise return false
	    if (inputLen > 4) {
	    	return false;
	    }
	    else {  
	      // The length is correct, now check that the characters are legal hexadecimal digits
	    	// Hexadecimals have a base of 16
	      char thisChar;
	      for (int i = 0; i < inputLen; i++) {
	        thisChar = userIn.charAt(i);
	          
	        // Is the character a decimal digit (0..9)? If so, advance to the next character
	        if (Character.isDigit(thisChar)) {
	          isValid = true;
	        }
		        
	        else {	
	          // Character is not a decimal digit (0..9), is it a valid hexadecimal digit (A..F)?
	          if (Character.isLetter(thisChar)) {
	        	  Character.toUpperCase(thisChar);
	        	  if (thisChar < 'A') {
	        		  isValid = false;
	        	  }
	        	  if (thisChar > 'F') {
	        		  isValid = false;
	        	  }
	          }
	        }
	      }
	    }
	        
	    // Return true if the string is a valid hexadecimal string, false otherwise
	    if (isValid = true) {
	    	return true;
	    }
	    else{
	    	return false;
	    }
	}
	    
	  // Method to convert the hex number to a binary string
	  public static String hex2Bin(String hexString, byte inputLen) {
	    String binString = "";     // Initialize binString to null string
	    if (hexString.length() > inputLen) {
	    	return binString;
	    }
	    // Convert each hexadecimal digit to its binary equivalent
	    for (int i = 0; i < hexString.length(); i++) {
	      char thisChar = hexString.charAt(i);     
	      // Convert hexString to a binary string, e.g. F00D = 1111000000001101
	      switch ( thisChar ) {
	      	case 'A': binString += "1010";
	      			  break;
	      	case 'B': binString += "1011";
	      			  break;
	      	case 'C': binString += "1100";
 			 		  break;
	      	case 'D': binString += "1101";
	      			  break;
	      	case 'E': binString += "1110";
	      			  break;
	      	case 'F': binString += "1111";
	      			  break;
	      	case '1': binString += "0001";
	      			  break;
	      	case '2': binString += "0010";
	      			  break;
	      	case '3': binString += "0011";
	      			  break;
	      	case '4': binString += "0100";
	      			  break;
	      	case '5': binString += "0101";
	      			  break;
	      	case '6': binString += "0110";
	      			  break;
	      	case '7': binString += "0111";
	      			  break;
	      	case '8': binString += "1000";
	      			  break;
	      	case '9': binString += "1001";
	      			  break;
	      }
	    }
	    return binString;
	  }
	    
	  // Method to convert the hex number to decimal number
	  public static long hex2Dec(String hexString, byte inputLen) {
		  int decimalValue = 0;
		  if (hexString.length() < inputLen) {
	    	return decimalValue;
		  }
		  
		  // Convert hexadecimal string to decimal, e.g. F00D = 61453 in unsigned decimal
		  for (int i = 0; i < hexString.length(); i++) {
			 char hexChar = hexString.charAt(i);
			 decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
		  }
		
		  return decimalValue;
	  }
	  
	  public static int hexCharToDecimal(char ch) {
		  if (ch >= 'A' && ch <= 'F') {
			  return 10 + ch - 'A';
		  }
		  else {
			  return ch - '0';
		  }
	  }
}


