package bridge;

import bridge.device.Device;
import bridge.device.Radio;
import bridge.device.Tv;
import bridge.remotes.AdvancedRemote;
import bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Radio());
        testDevice(new Tv());
    }

    public static void testDevice(Device device){
        System.out.println("Test with basic remote");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Test with advanced remote");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
