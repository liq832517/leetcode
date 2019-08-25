package code;

public class  Run implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[]args){
        Integer integer1=3;
        Integer integer2=new Integer(3);
        System.out.println(integer1==integer2);

    }


}
