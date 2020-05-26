import java.io.*;
public class Main {
    /**
     * String "inputData" displays everything that the user entered
     */
    static String inputData;
    public static void main(String[] args) throws  IOException, InterruptedException {
        System.out.println("For example:-h 127.0.0.1,99.232.0.1-10 -p 1-65535 -t 2");
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        inputData = bufferedReader.readLine();
        System.in.close();
        inputData= ThreadsProcessing.ThreadsProcessin(inputData);
        Scanner.scan(IpAddressProcessing.ipAddressProcessing((inputData).substring(3)), PortsProcessing.portsProcessing((inputData).substring(3)));
    }
}
