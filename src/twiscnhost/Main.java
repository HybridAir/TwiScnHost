//Main console-based host program for controlling the TwiScnDevice
//TODO: options saving/loading, twitter implementation, gui (tray application maybe?) 
package twiscnhost;

public class Main {

    public static final int VENDOR_ID = 0x16c0;                         
    public static final int PRODUCT_ID = 0x27d9;
    public static final int[] DEVICEIDS = {VENDOR_ID, PRODUCT_ID};
    public static DeviceOptions devOptions;

    public static void main(String[] args) {
        devOptions = new DeviceOptions();                                       //create a new instance of DeviceOptions
        DeviceHandler twiScn = new DeviceHandler(DEVICEIDS, devOptions);        //create a new instance of DeviceHandler, needs the device ids and options      
               
        //set up and send a dummy tweet
        String tweet = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et ma";
        String user = "Blake:";
        twiScn.newTweet(user, tweet);
        
        while(true) {
            //check for button updates
            twiScn.monitorFNs();
        }
    }
}