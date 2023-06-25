import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws NumberFormatException, IOException {

        // Your class should be named Solution
        // Write your code here

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        boolean [] primes=new boolean[n+1];
        Arrays.fill(primes, true);



 primes[0]=  primes[1]=false;
        for(int i=2;i*i<=n;i++){
            if(primes[i]){
                for(int j=i*i;j<=n;j+=i){
                    primes[j]=false;
                }
            }
        }

        ArrayList<Integer> ans=new ArrayList<Integer>();

        for(int i=1;i<=n;i++){
            if(primes[i]){
                ans.add(i);
            }
        }

        int count=0;
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<i-1;j++){
           if(ans.get(j)+ans.get(j+1)+1==ans.get(i)){
                count++;
                break;
            }
            }
            
        }


        System.out.println(count);

    }
}
