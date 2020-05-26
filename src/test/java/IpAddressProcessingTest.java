import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IpAddressProcessingTest {

    @Test
    public void testIp() {
        ArrayList<String> list=new ArrayList<String>();
        list.add("192.0.0.2");list.add("127.0.0.1");list.add("127.0.0.2");
        ArrayList<String> listReal =IpAddressProcessing.ipAddressProcessing("127.0.0.1-2,192.0.0.2 -p 1-65");
        for (int i=0;i<list.size();i++){
            Assert.assertEquals(list.get(i), listReal.get(i));
        }
        Assert.assertEquals(3,listReal.size());
    }
}