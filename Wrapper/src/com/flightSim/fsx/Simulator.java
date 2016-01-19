package com.flightSim.fsx;

/**
 * Created by Brian on 1/15/2016.
 */

import com.flightSim.util.*;
public class Simulator extends FSData
{
    public Simulator()
    {
        super();
    }
    public String StartSituationName()
    {
        return getString(0x0024,255);
    }
}