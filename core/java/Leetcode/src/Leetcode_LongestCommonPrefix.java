/**
 * Created by sruthirameshvani on 9/29/16.
 */
public class Leetcode_LongestCommonPrefix {
    //Application -1
    public static String longestCommonPrefix(String[] strs) {
        //Check if the string length = 0
        String prefix = strs[0];
        System.out.println("String"+prefix);
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println("String"+prefix);
                if (prefix.isEmpty()) return "";
            }
        }
            System.out.println("PREFIX"+prefix);
        return prefix;
    }

    public static void main(String [] args){
        String [] strs = {"Educate", "Education","Educating"};
        System.out.println("OUTPUT");
        System.out.println(longestCommonPrefix(strs));
        

    }
}
