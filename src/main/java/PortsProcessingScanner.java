import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class PortsProcessingScanner implements Runnable   {
private String nameIp;
private  String namePort;
private ArrayList myPorts;

    /**
     *
     * @param portsAfterClone ports for scanning
     * @param ipInTheMoment single IP from List for with will be scanning
     */
    public PortsProcessingScanner  (ArrayList<String> portsAfterClone, String ipInTheMoment) {
        nameIp=ipInTheMoment;
        myPorts=portsAfterClone;
    }

@Override
    public  void run() {
        ArrayList openPortsList=new ArrayList();
        ArrayList closePortsList=new ArrayList();
        for (int n=0;n<myPorts.size();n++){
         namePort=(String) myPorts.get(n);
            int arg=Integer.parseInt(namePort);
            try {
                InetSocketAddress isa = new InetSocketAddress(nameIp, arg );
                Socket socket = new Socket();
                socket.connect(isa,Scanner.timeout);
                openPortsList.add(arg);
                socket.close();
                Scanner.js.put(nameIp+"/"+ namePort, "open" +
                        "");
            } catch (IOException ioe) {
                closePortsList.add(arg);
                Scanner.js.put(nameIp+"/"+ namePort, "close");
            }
        }
        WriteToJSON(Scanner.js);
    }

    /**
     * @param js Map which contains IP and ports (keys) and value: close/open
     */
    private static  void WriteToJSON(Map<String, Object> js) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("src\\main\\resources\\PortsList.json"));
            Gson gson = new Gson();
            writer.write(gson.toJson(js));
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
