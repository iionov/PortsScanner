import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PortsProcessingTest {

    @Test
    public void testPorts() {
        ArrayList<String> list=new ArrayList<String>();
        list.add("1");list.add("2");list.add("3");list.add("4");
        ArrayList<String> listReal=PortsProcessing.portsProcessing("127.0.0.1-2,192.0.0.2 -p 1-4");
        for (int i=0;i<list.size();i++){
            Assert.assertEquals(list.get(i), listReal.get(i));
        }
        Assert.assertEquals(4,listReal.size());
    }
}