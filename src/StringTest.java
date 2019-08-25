import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashMap;
import java.util.Iterator;

public class StringTest {
    public static void main(String[]args){

        HashMap<Integer,String> hashMap=new HashMap();
        hashMap.put(1,"sdf");
        hashMap.put(1,"qqq");
        for (int i:hashMap.keySet()
             ) {
            System.out.println("key:"+i+"   value:"+hashMap.get(i));
        }
    }
}
