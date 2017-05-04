package com.oracle.innerclasses;

import com.oracle.innerclasses.controller.*;

/**
 * Created by vanmoj1 on 7/04/2017.
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();

        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
            gc.run();
        }
    }
}
