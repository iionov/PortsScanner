import java.util.*;
import java.util.concurrent.*;

public class Scanner {
    static ConcurrentHashMap <String, Object> js=new ConcurrentHashMap();
    static ArrayList <String> portsAfterClone;
    volatile static ArrayList <String> ipRequestAfterClone;
    static int timeout = 80;
    /**
     *
     * @param ipRequestAfter - List with IP addresses after
     * @param portsAfter - List with ports
     */
    public static  void scan (ArrayList ipRequestAfter, ArrayList portsAfter) {
        String ipInTheMoment;
        System.out.println("◆List of IP addresses: " + ipRequestAfter);
        System.out.println("◆List of Ports: " + portsAfter);
        portsAfterClone = new ArrayList<String>(portsAfter);
        ipRequestAfterClone = new ArrayList<String>(ipRequestAfter);
        Collections.shuffle(ipRequestAfterClone);
        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(ThreadsProcessing.inputDataThreadsInteger);
        System.out.println("◆Threads: "+ThreadsProcessing.inputDataThreadsInteger);
        while (ipRequestAfterClone.size()!=0){
            ipInTheMoment=ipRequestAfterClone.get(0);
            executor.execute(new PortsProcessingScanner(portsAfterClone, ipInTheMoment));
       //   TimeUnit.MILLISECONDS.sleep(700);
            ipRequestAfterClone.remove(0);
            Collections.shuffle(ipRequestAfterClone);
        }
        executor.shutdown();
    }
}
