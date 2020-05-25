public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s){
        int lastsum=0,tempsum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if (tempsum!=0){
                    lastsum=tempsum;
                    tempsum=0;
                }

            }
            else {
                tempsum++;
            }
        }
        if (tempsum==0){
            return lastsum;
        }
        else {
            return tempsum;
        }
    }

}
