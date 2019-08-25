package code;

//拼多多笔试
public class 时针与分针 {
    public static void main(String[]args){
        /*Scanner scanner=new Scanner(System.in);
        String s2=scanner.nextLine();*/

        String s="09:15";
        String[]res=s.split(":");

        int h= Integer.parseInt(res[0]);
        float m= Float.parseFloat(res[1]);

        if(h<24&&h>=1&&m<=59&&m>=0) {

            float hbase=h*30;
            float mbase=m*6;
            float base;
            if(hbase>mbase){
                base=hbase-mbase-m/2;
            }else {
                base=mbase-hbase+m/2;
            }
            base=base>180?360-base:base;

            if (base%1==0)
            System.out.print((int)(base));
            else
                System.out.print(base);
        }

    }
}
