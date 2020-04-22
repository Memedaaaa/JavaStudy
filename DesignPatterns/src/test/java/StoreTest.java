import com.lg.pattern.factory.simple.RouJiaMo;
import com.lg.pattern.factory.simple.SimpleRouJiaMoFactory;
import org.junit.Test;

/**
 * Description:肉夹馍店
 *
 * @auther: 李果
 * @date: 23:00 2020/4/20
 */

public class StoreTest {

    @Test
    public void getRouJiaMo(){
        SimpleRouJiaMoFactory factory = new SimpleRouJiaMoFactory();
        RouJiaMo rouJiaMo1 = factory.createRouJiaMo("A");
//        RouJiaMo rouJiaMo2 = factory.createRouJiaMo("B");
//        RouJiaMo rouJiaMo3 = factory.createRouJiaMo("C");
    }

}
