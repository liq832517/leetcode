package code;

public class 股票交易日 {
    /*在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔
     (即买-卖-买-卖的顺序进行)。
    给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
    给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
    测试样例：[10,22,5,75,65,80],6
    返回：87*/
    //动态规划

    public static void main(String[] args){
        //Stack<Integer> stack=new Stack();
        int[]prices={10,22,5,75,65,80};
        int n=6;
        int buy1 = Integer.MIN_VALUE, sale1 = 0, buy2 = Integer.MIN_VALUE, sale2 = 0;
        for(int i=0; i<prices.length; i++){                      //the more money left, the happier you will be
            buy1 = Math.max(buy1, -prices[i]);                        //left money after buy1
            sale1 = Math.max(sale1, prices[i] + buy1);                //left money after sale1
            buy2 = Math.max(buy2, sale1 - prices[i]);                 //left money after buy2
            sale2 = Math.max(sale2, prices[i] + buy2);                //left money after sale2
        }

        System.out.print(sale2);

    }

}
