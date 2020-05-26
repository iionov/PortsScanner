import java.util.ArrayList;

public class IpAddressProcessing {
    /**
     * @param ipRequestBefore - the string entered by the user
     * @return ArrayList with IP addresses
     */
    public static ArrayList ipAddressProcessing(String ipRequestBefore){
        String singleIp = "";
        System.out.println(ipRequestBefore);
        char[] str=ipRequestBefore.toCharArray();
        ArrayList <String> ipRequestAfter = new ArrayList<>();
        for (int i=0;i<str.length;i++){
            if (str[i]==','){
            ipRequestAfter.add(singleIp);
            singleIp="";
            }
            else{
                singleIp=singleIp+str[i];
            }
            if ((str[i+1]==' ') && (str[i+2]=='-')){
                ipRequestAfter.add(singleIp);
                break;
            }
            if ((str[i]=='-') && (str[i+1]!='p')){
            }
        }
        for (int j=0; j<ipRequestAfter.size();j++){
            String x,y,z= "";
            String ip=ipRequestAfter.get(j), sub="-";
            if (ip.indexOf(sub)!= -1){
                ipRequestAfter.remove(j);
                j--;
                int indDash=ip.indexOf('-');
                z=ip.substring(0,indDash);
                y=ip.substring(indDash+1);
                String [] splitted=z.split("\\.");
                x=splitted[3];
                int intX=Integer.valueOf(x);
                int intY=Integer.valueOf(y);
                for (int i=intX; i<=intY;i++){
                    String ipRange=splitted[0]+"."+splitted[1]+"."+splitted[2]+"."+(i);
                    ipRequestAfter.add(ipRange);
                }
            }
        }
        return ipRequestAfter;
    }
}
