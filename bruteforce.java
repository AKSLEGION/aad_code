import java.util.*;

class bruteforce{
    static ArrayList<Integer> bruteforce_match(String text, String pattern){
        int n = text.length;
        int m = pattern.length;

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int i=0;i<=n-m;i++){
            boolean matched = true;
            for(int j=0;j<m;j++){
                if(text.charAt(i+j) != pattern.charAt(j)){
                    matched = false;
                    break;
                }
            }
            if(matched){
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String args[]){
        String text = "37928o3712983712";
        String pattern = "3712";

        ArrayList<Integer> arr = bruteforce_match(text,pattern);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

}