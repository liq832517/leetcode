package leetcode;

import java.util.ArrayList;
import java.util.List;

public class OnOffLight {

    public static void main(String[] args) {
        OnOffLight o=new OnOffLight();
        System.out.println(o.method(10, 5));
    }

    public List<Integer> method(int n,int k){
        boolean []lights=new boolean[n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++){
                if ((j+1)%(i+1)==0){
                    lights[j]=!lights[j];
                }
            }
        }

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (lights[i]){
                list.add(i+1);
            }
        }
        return list;
    }
}
