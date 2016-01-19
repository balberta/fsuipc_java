package com.flightSim.wrapper;

/**
 * Created by Brian on 1/15/2016.
 */
public class Signature {

    public static synchronized native int Open(int aFlightSim);
    public static synchronized native void Close();

    public static synchronized native void ReadData(int aOffset,int aCount,byte[] aData);
    public static synchronized native void WriteData(int aOffset,int aCount,byte[] aData);
    public static synchronized native void Process();
}
