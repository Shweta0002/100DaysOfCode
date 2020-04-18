//LeetCode
//qestion Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.Arrays; 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Arrays.sort(nums);
        int[] b= {0,0};
        int n = nums.length;
        for(int i = 0 ; i<n-1;i++)
        {    b[0]=i;
            for(int j = i+1 ; j<n;j++){
              if(nums[b[0]]+nums[j]==target )
              {  
                 b[1] = j;
                 return  b;
                
                  }
               
            }   
        }
         return b; 
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int[] ret = new Solution().twoSum(nums, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}