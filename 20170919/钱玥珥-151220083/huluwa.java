import java.util.*;
class yigewa{
    private int number;
    public yigewa(int x){
        number=x;
    }
    public void pri_order(){
        switch(number){
            case 1: System.out.print("老大");break;
            case 2: System.out.print("老二");break;
            case 3: System.out.print("老三");break;
            case 4: System.out.print("老四");break;
            case 5: System.out.print("老五");break;
            case 6: System.out.print("老六");break;
            case 7: System.out.print("老七");
        }
    }
    public void pri_color(){
        switch(number){
            case 1: System.out.print("红色");break;
            case 2: System.out.print("橙色");break;
            case 3: System.out.print("黄色");break;
            case 4: System.out.print("绿色");break;
            case 5: System.out.print("青色");break;
            case 6: System.out.print("蓝色");break;
            case 7: System.out.print("紫色");
        }
    }
    private void pri_change(int ori,int now){
        System.out.print("："+ori+"->"+now+"\n");
    }
    public void exch(yigewa []b,int ori,int now){
        int ex=b[now].number;
        b[now].number=number;
        number=ex;
    }
    public boolean larger(yigewa b){
        if(number>b.number)
            return true;
        else
            return false;
    }

    public void ex_with(yigewa []b,int ori,int now){
        if(ori==now)
            return;
        pri_order();
        pri_change(ori,now);

        b[now].pri_order();
        pri_change(now,ori);

        exch(b,ori,now);
    }
}
class qigewa{
    yigewa []a;
    public qigewa(){
        a=new yigewa[8];
        for (int i = 1; i <= 7; i++) {
            a[i] = new yigewa(i);
        }
    }

    public void my_bubble(){
        for(int i = 7;i>1;i--){
            int j =1;
            while(j<i){
                if(a[j].larger(a[j+1])){
                    a[j].ex_with(a,j,j+1);
                }
                j++;
            }
        }

    }

    public void quicksort(){
        my_quicksort(1,7);
    }
    private  void my_quicksort(int p,int r) {
        if(p<r) {
            int q = partition(p,r);
            my_quicksort(p,q-1);
            my_quicksort(q+1,r);
        }
    }
    private  int partition(int p,int r){
        int i=p-1,j=p;
        yigewa x=a[r];
        while(j<r) {
            if(!a[j].larger(x)) {
                i=i+1;
                a[i].ex_with(a,i,j);
            }
            j++;
        }
        a[i+1].ex_with(a,i+1,r);
        return i+1;
    }

    public void cof_order() {
        for (int i = 1; i <= 7; i++) {
            a[i].pri_order();
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    public void cof_color() {
        for (int i = 1; i <= 7; i++) {
            a[i].pri_color();
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    public void m_random () {
        Random random = new Random();
        for (int i = 1; i <= 7; i++) {
            int p = random.nextInt(i) + 1;
            if (p != i)
                a[i].exch(a, i, p);
        }
    }
}
public class huluwa {
    public static void main(String[] args) {
        qigewa a = new qigewa();

        a.m_random();
        a.my_bubble();
        a.cof_order();

        a.m_random();
        a.quicksort();
        a.cof_color();
    }
}
