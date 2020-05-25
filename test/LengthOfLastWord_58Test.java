import junit.framework.TestCase;


public class LengthOfLastWord_58Test extends TestCase {

    public void testLengthOfLastWord() {
        String s = "d ";
        int index=s.lastIndexOf(" ");
        System.out.println("index"+index+" "+s.length());
        if (index==(s.length()-1)){
//            return 0;
            System.out.println(0);
        }
        if ( index == -1){
            System.out.println("1"+s.length());
        }
        s=s.substring(index+1);
//        return s.length();
        System.out.println("2"+s.length());
    }
}