package code;

import java.util.HashMap;

public class 翻译汉语 {

    static HashMap<Integer,String> hashMap=new HashMap<>();
    public  void Initial(){
        this.hashMap.put(0,"零");
        this.hashMap.put(1,"一");
        this.hashMap.put(2,"二");
        this.hashMap.put(3,"三");
        this.hashMap.put(4,"四");
        this.hashMap.put(5,"五");
        this.hashMap.put(6,"六");
        this.hashMap.put(7,"七");
        this.hashMap.put(8,"八");
        this.hashMap.put(9,"九");
    }

    public static String method(int n,boolean f){

        String res=new String("");
        int t1,t10,t100,t1000;
        if (n/10000>0){
            res+=method(n/10000,f)+"万"+method(n%10000,f);
        }else {
            t1000=n/1000;
            t100=(n%1000)/100;
            t10=n%100/10;
            t1=n%10;
            System.out.println(t1000);
            System.out.println(t100);
            System.out.println(t10);
            System.out.println(t1);
            int target=0;
            int cur=0;
            if(t1000!=0){
                res+=hashMap.get(t1000)+"千";cur++;
            }else {
                if(target<=cur){
                    if (!f){res+="零";target++;}
                }
            }
            if (t100!=0){
                res+=hashMap.get(t100)+"百";cur++;
            }else{
                if(target<=cur){
                    res+="零";target++;
                }
            }
            if(t10!=0){
                res+=hashMap.get(t10)+"十";cur++;
            }else {
                if(target<=cur){
                    res+="零";target++;
                }
            }
            if(t1!=0)
            res+=hashMap.get(t1);
        }


        return res;
    }
    public static void main(String[]args){
        翻译汉语 f=new 翻译汉语();
        f.Initial();
        System.out.println(method(99099,true));
    }
}
