package org.ttl.javafundas.labs.interfaces;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author whynot
 */
public class RunInterfaceLab {

    @Test
    public void testSensors() {
        //TODO - uncomment out the code below and make it compile and run.
        // You will have to write some new code, and change some existing
        // code.  You should make your sensors print out a message indicating
        // the operation they are performing when their 'takeReading' methods
        // is called.
        // i.e. Temperature Sensors say "Taking temperature", etc.
        // The basic idea here is to think of how you can treat different things
        // (Temperature Sensors, Humidity Sensors) etc. as if they are they same,
        // and invoke a common operation ('takeReading') on them.

//        List<EnvSensor> sensors = new ArrayList<>();
//        sensors.add(new TemperatureSensor());
//        sensors.add(new HumiditySensor());
//        sensors.add(new UVSensor());
//
//        for(EnvSensor s : sensors) {
//            s.takeReading();
//        }
//
//        assertEquals(UVSensor.class, sensors.get(2).getClass());
    }
}
