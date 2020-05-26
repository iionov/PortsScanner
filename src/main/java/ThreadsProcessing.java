public class ThreadsProcessing {
    private static String inputDataThreads;
    public static int inputDataThreadsInteger;

    /**
     * Splitting the start string into blocks (first block with information about IP addresses and ports,
     * second block with numbers of threads)
     * @param inputData - the string entered by the user
     * @return - the string entered by the user without information about numbers of threads
     */
    protected static String ThreadsProcessin(String inputData){
        String delimetr=" -t ";
        String[] subStr;
        subStr=inputData.split(delimetr, 2);
        inputData=subStr[0];
        inputDataThreads=subStr[1];
        inputDataThreadsInteger=Integer.parseInt(inputDataThreads);
        return inputData;
    }
}
