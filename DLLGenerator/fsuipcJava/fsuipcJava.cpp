

#include <windows.h>
#include <iostream>
#include "headers\com_flightSim_wrapper_FSWrapper.h"
#include "lib\fsuipc_user.h"

BOOL APIENTRY DllMain(HANDLE hModule,
	DWORD  ul_reason_for_call,
	LPVOID lpReserved
	)
{
	switch (ul_reason_for_call)
	{
	case DLL_PROCESS_ATTACH:
	case DLL_THREAD_ATTACH:
	case DLL_THREAD_DETACH:
	case DLL_PROCESS_DETACH:
		break;
	}
	return TRUE;
}

static DWORD iResult;

JNIEXPORT jint JNICALL Java_com_flightSim_wrapper_FSWrapper_Open(JNIEnv *, jclass, jint aFlightSim)
{
	return FSUIPC_Open(aFlightSim, &iResult);
}

JNIEXPORT void JNICALL Java_com_flightSim_wrapper_FSWrapper_Close(JNIEnv *, jclass)
{
	FSUIPC_Close();
}


JNIEXPORT void JNICALL Java_com_flightSim_wrapper_FSWrapper_ReadData(JNIEnv * env, jclass, jint aOffset, jint aCount, jbyteArray aData)
{
	jbyte* data = env->GetByteArrayElements(aData, 0);
	FSUIPC_Read(aOffset, aCount, (void*)data, &iResult);
	FSUIPC_Process(&iResult);
	env->ReleaseByteArrayElements(aData, data, 0);

}

JNIEXPORT void JNICALL Java_com_flightSim_wrapper_FSWrapper_WriteData(JNIEnv * env, jclass, jint aOffset, jint aCount, jbyteArray aData)
{
	jbyte* data = env->GetByteArrayElements(aData, 0);
	FSUIPC_Write(aOffset, aCount, (void*)data, &iResult);
	FSUIPC_Process(&iResult);
	env->ReleaseByteArrayElements(aData, data, 0);
}


JNIEXPORT void JNICALL Java_com_flightSim_wrapper_FSWrapper_Process(JNIEnv *, jclass)
{
	FSUIPC_Process(&iResult);
}
