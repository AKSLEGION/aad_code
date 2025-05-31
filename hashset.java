import java.util.*;

class hashset{
    static ArrayList<Integer> remove_duplicate(ArrayList<Integer> arr){
        ArrayList<Integer> new_arr = new ArrayList<Integer>();

        HashSet<Integer> h1 = new HashSet<Integer>();

        for(int i=0;i<arr.size();i++){
            if(h1.contains(arr.get(i))){
                continue;
            }
            else{
                h1.add(arr.get(i));
                new_arr.add(arr.get(i));
            }
        }
        return new_arr;
    }

    static ArrayList<Integer> print_duplicate(ArrayList<Integer> arr){
        ArrayList<Integer> new_arr = new ArrayList<Integer>();

        HashSet<Integer> h1 = new HashSet<Integer>();

        for(int i=0;i<arr.size();i++){
            if(h1.contains(arr.get(i))){
                new_arr.add(arr.get(i));
            }
            else{
                h1.add(arr.get(i));
            }
        }
        return new_arr;
    }

    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        a.add(3);
        a.add(2);
        a.add(4);

        ArrayList<Integer> b = remove_duplicate(a);
        ArrayList<Integer> c = print_duplicate(a);        
    }
}