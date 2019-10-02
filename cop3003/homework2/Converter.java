package homework2;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//suppresses the serial warning eclipse tries to give
@SuppressWarnings("serial")

//creates the Converter class, extends the JFrame class, and implements the KeyListener method 
public class Converter extends JFrame implements KeyListener{
    //instance variables
    private String sRoman;
    private int iArabic;
    private JLabel aLabel = new JLabel("Arabic Numural");
    private JTextField aText = new JTextField(12);
    private JLabel rLabel = new JLabel("Roman Numural");
    private JTextField rText = new JTextField(12);
    private char[] rValues = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

    //creates the Converter constructor with String input
    public Converter(String title){
    	//sets the title, and adds the containers and Key Listeners
        super(title);
        setLayout(new FlowLayout());
        Container con = getContentPane();
        con.add(aLabel);
        con.add(aText);
        con.add(rLabel);
        con.add(rText);
        aText.addKeyListener(this);
        rText.addKeyListener(this);
    }
    //returns String and accepts int input; converts from Arabic to Roman
    public String aConversion(int iArabic){
        if(iArabic < 1 || iArabic > 3999){
            return "";
        }
        //ensures the Roman text field is empty before converting
        sRoman = "";
        
        //while loops to account for all of the Roman rules for least number of numerals
        while(iArabic >= 1000){
            sRoman = sRoman + "M";
            iArabic = iArabic - 1000;
        }
        while (iArabic >= 900){
            sRoman = sRoman + "CM";
            iArabic = iArabic - 900;
        }
        while (iArabic >= 500){
            sRoman = sRoman + "D";
            iArabic = iArabic - 500;
        }
        while (iArabic >= 400){
            sRoman = sRoman + "CD";
            iArabic = iArabic - 400;
        }
        while (iArabic >= 100){
            sRoman = sRoman + "C";
            iArabic = iArabic - 100;
        }
        while (iArabic >= 90){
            sRoman = sRoman + "XC";
            iArabic = iArabic - 90;
        }
        while (iArabic >= 50){
            sRoman = sRoman + "L";
            iArabic = iArabic - 50;
        }
        while (iArabic >= 40){
            sRoman = sRoman + "XL";
            iArabic = iArabic - 40;
        }
        while (iArabic >= 10){
            sRoman = sRoman + "X";
            iArabic = iArabic - 10;
        }
        while (iArabic >= 9){
            sRoman = sRoman + "IX";
            iArabic = iArabic - 9;
        }
        while (iArabic >= 5){
            sRoman = sRoman + "V";
            iArabic = iArabic - 5;
        }
        while (iArabic >= 4){
            sRoman = sRoman + "IV";
            iArabic = iArabic - 4;
        }
        while (iArabic >= 1){
            sRoman = sRoman + "I";
            iArabic = iArabic - 1;
        }
        return sRoman;
    }
    //returns int and accepts string input; converts from Roman to Arabic
    public int rConversion(String sRoman){
    	int len = sRoman.length();
    	int sum = 0;
    	
    	//capitalizes the Roman numerals if they were lower case
    	rText.setText(sRoman);
        for (int i=0; i<len; i++){
            int aNumber = rConvert(sRoman.charAt(i));
            
            //deletes the character if 0 is returned (not a valid roman numeral)
            if(aNumber == 0){
            	rText.setText(rText.getText().substring(0, i));
            }
            //only continues if the Roman conversion is less than 3999
            if(sum+aNumber<=3999){
            	sum = sum + aNumber;
            }
            //deletes the character if it would cause the conversion to exceed 3999
            else{
            	rText.setText(rText.getText().substring(0, i));
            }
        }
        iArabic = sum;
        return iArabic;
    }
    //returns int and accepts char input
    public int rConvert(char rNumeral){
        //returns value of Roman numeral in Arabic
    	switch (rNumeral){
    		case 'M':
    			return 1000;
    		case 'D':
    			return 500;
    		case 'C':
    			return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
            	return 0;
        }
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
    }
    //returns void and accepts key event, starts if key is released
    public void keyReleased(KeyEvent e) {
        //checks if Arabic number was entered
        if(getFocusOwner() == aText){
        	//tries to parse the text field into int, catches and resets if fails
            try{
                //parses text field into int
                iArabic = Integer.parseInt(aText.getText());

                aText.setText(aText.getText().replaceAll("^0+",""));
                
                //doesn't accept input over 3999
                if(iArabic > 3999){
                    aText.setText(aText.getText().substring(0, aText.getText().length() - 1));
                }
                //won't continue if iArabic is 0
                if(iArabic != 0){
                	//converts into Roman numeral
                	aConversion(iArabic);
                
                	//places Roman numeral in text field 
                	rText.setText(sRoman);
                }
            }
            catch(NumberFormatException exception){
                aText.setText("");
                rText.setText("");
            }
        }
        //checks if Roman numeral was entered
        else if(getFocusOwner() == rText){
            sRoman = rText.getText();
            int len = sRoman.length();
            boolean valid = false;
            
            for (int i=0; i<len; i++){
            	for(int j=0; j<rValues.length; j++){
            		if(Character.toUpperCase(sRoman.charAt(i)) == rValues[j]){
            			//converts into Arabic number
            			rConversion(sRoman.toUpperCase());
                    
            			//places Arabic number in text field
            			aText.setText(Integer.toString(iArabic));
            			if(iArabic==0){
            				aText.setText("");
            			}
            			valid = true;
            		}
            	}
            }
            //tries to delete character if not found, catches exception if text field is empty
            try{
            	if(!valid){
            		rText.setText(rText.getText().substring(0, rText.getText().length() - 1));
            	}
            }
            catch(IndexOutOfBoundsException i){
            	aText.setText("");
            }
            //resets valid to false
            valid = false;
        }
    }
}
