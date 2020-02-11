import static org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void test(){
        StudentArrayDeque<Integer> sad=new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads=new ArrayDequeSolution<>();
        for(int i=0;i<10;i++){
            Integer n=StdRandom.uniform(1,100);
            int d=StdRandom.uniform(0,4);
            sad.addFirst(n);
            ads.addFirst(n);
        }
    }
}
