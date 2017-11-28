/**
 * Driver Class that tests the Device class.
 * @author Gohur Ali
 * @version 05192017
 * Created by gohur on 5/15/2017.
 */
public class Driver {
    public static void main(String[] args){
        System.out.println("Positive Testing\n");
        //Create a Device with only device name
        Device nokia = new Device("Nokia N95");

        String[][] someFeaturesSamsung = new String[2][10];

        someFeaturesSamsung[0][0] = "Color";
        someFeaturesSamsung[1][0] = "Navy";

        someFeaturesSamsung[0][1] = "Storage";
        someFeaturesSamsung[1][1] = "256 GB";

        //create a device with both a device name as well as a feature list
        Device samsung = new Device("Samsung Galaxy S8",someFeaturesSamsung);

        samsung.displayFeature();

        String samsungGetValueindex = samsung.getFeatureValue(0);
        System.out.println(samsungGetValueindex);

        nokia.addFeature("Color","Grey");
        nokia.addFeature("Screen Size","2.5 Inches");
        nokia.addFeature("Build","Plastic");
        nokia.addFeature("Music Player","WalkMan");

        nokia.displayFeature();

        String nokiaGetValueString = nokia.getFeatureValue("Screen Size");
        System.out.println(nokiaGetValueString);


        //Negative Testing
        System.out.println("\nNegative Testing\n");
        Device invalidDevice = new Device("");

        String[][] EmptyFeatures = new String[2][10];

        Device lgPhone = new Device("LG",EmptyFeatures);

        lgPhone.addFeature("Color","Black");
        lgPhone.displayFeature();

        //Attempt to add a feature that has already been added to the feature list
        nokia.addFeature("Build","Plastic");

        nokiaGetValueString = nokia.getFeatureValue("Battery");
        System.out.println(nokiaGetValueString);

        String nokiaGetValueIndex = nokia.getFeatureValue(-1);
        System.out.println(nokiaGetValueIndex);

        //Boundary Testing
        System.out.println("\nBoundary Testing\n");

        Device iPhone = new Device("iPhone 7");

        iPhone.addFeature("Color","Matte Black");
        iPhone.addFeature("Storage Capacity","128 GB");
        iPhone.addFeature("Screen Size","4.7 Inches");
        iPhone.addFeature("Wireless Pay","ApplePay");
        iPhone.addFeature("Carrier","T-Mobile");
        iPhone.addFeature("Camera","8 Megapixels");
        iPhone.addFeature("Build","Aluminum");
        iPhone.addFeature("Battery","1,960 mAh");
        iPhone.addFeature("Processor","A10");
        iPhone.addFeature("Resolution","1920 x 1080");

        //Attempting to add a feature that exceeds capacity
        iPhone.addFeature("Water Resistance","IP67");

        iPhone.displayFeature();

        nokia.addFeature("Carrier","");

        Device htc = new Device("HTC M10");

        htc.displayFeature();

        nokia.addFeature("Color","Black");
        nokia.displayFeature();






    }
}
