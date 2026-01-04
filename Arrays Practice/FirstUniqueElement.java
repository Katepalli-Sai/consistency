import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer>hm = new HashMap<>(); // use Map<Integer, Integer> hm = new LinkedHashMap<>() for order gurantee ,hashmap not gurantee the order
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(int num:hm.keySet()){
            if(hm.get(num)==1){
                System.out.println(num);
                break;
            }
        }
        
    }
}