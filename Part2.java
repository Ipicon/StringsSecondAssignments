
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        int ainb = 0;
        int counter = 0;
        while (true) {
            ainb = stringb.indexOf(stringa, index);
            if(ainb == -1)
                break;
            counter++;
            index=ainb + stringa.length();
        }
        return counter;
    }
    public void testHowMany() {
        int howMuch = howMany ("aa", "ataaaa");
        System.out.println("The word: aa occures in ataaaa " + howMuch + " times.");
        howMuch = howMany ("GAA", "ATGAACGAATTGAATC");
        System.out.println("The word: GAA occures in ATGAACGAATTGAATC " + howMuch + " times.");
    }
}
