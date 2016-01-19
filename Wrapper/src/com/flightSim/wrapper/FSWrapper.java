package com.flightSim.wrapper;

/**
 * Created by Brian on 1/15/2016.
 */
public class FSWrapper {

    public static final int SIM_ANY=0;
    public static final int SIM_FS98=1;
    public static final int SIM_FS2K=2;
    public static final int SIM_CFS2=3;
    public static final int SIM_CFS1=4;
    public static final int SIM_FS2K2=6;

    static
    {
        // load library
        System.loadLibrary("fsuipcJava" );
    }
    public static synchronized native int Open(int aFlightSim);
    public static synchronized native void Close();

    public static synchronized native void ReadData(int aOffset,int aCount,byte[] aData);
    public static synchronized native void WriteData(int aOffset,int aCount,byte[] aData);
    public static synchronized native void Process();
}

