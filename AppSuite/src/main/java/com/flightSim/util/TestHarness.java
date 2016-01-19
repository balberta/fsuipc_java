package com.flightSim.util;

import com.flightSim.wrapper.FSWrapper;

/**
 * Created by Brian on 1/15/2016.
 */

public class TestHarness {
    public static final int SIM_ANY=0;


    public static void main(String[] args)
    {

        System.out.println("Beginning Test Execution");
        int ret = FSWrapper.Open(FSWrapper.SIM_ANY);
        System.out.println("ret= " + ret);

        if (ret == 0)
        {
            System.out.println("No flight simulators found");
        }
    }
}
