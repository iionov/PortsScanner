import java.util.ArrayList;

public class PortsProcessing {
    /**
     * @param ipRequestBefore - the string entered by the user
     * @return ArrayList with ports
     */
    public static ArrayList portsProcessing(String ipRequestBefore){
    ArrayList <String> portsAfter=new ArrayList<>();
    String[] splitted=ipRequestBefore.split("\\-p ");
    String allPorts=splitted[1], sub="-";
    splitted[0]="";
    if (allPorts.indexOf(sub)!=-1){
        String[] ports=allPorts.split("\\,");
        for (int i=0;i<ports.length;i++){
            String port=ports[i];
            String[] aport=port.split("\\-");
            int x=Integer.valueOf(aport[0]);
            int y=Integer.valueOf(aport[1]);
            for (int j=x;j<=y;j++){
                portsAfter.add(String.valueOf(j));
            }
        }
    }
    else {
        String[] ports=allPorts.split("\\,");
        for (int i=0;i<ports.length;i++){
            portsAfter.add(ports[i]);
        }
    }
    return portsAfter;
    }
}
