//Leetcoe chjallenge may 2020
// You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

// The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

// Example 1:

// Input: J = "aA", S = "aAAbbbb"
// Output: 3
// Example 2:

// Input: J = "z", S = "ZZ"
// Output: 0
class Solution {
    public int numJewelsInStones(String J, String S) {
        int lens = J.length();
        int count=0;
        HashMap<Integer, Integer> map 
                    = new HashMap<>(); 
        for(int i =0;i<lens;i++){
            map.put(J.charAt(i)-'0',i);
            
            
        }
        int len = S.length();
        for(int i =0;i<len;i++){
        if(map.containsKey(S.charAt(i)-'0'))           {
           count++; 
           }
          
           
        
    }   //System.out.println(map.size());
        // System.out.println(count);
         return count;
}
           }

public class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String J = stringToString(line);
            line = in.readLine();
            String S = stringToString(line);
            
            int ret = new Solution().numJewelsInStones(J, S);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}