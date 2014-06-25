package com.beltonp.androidgame.framework.impl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class CompassHandler implements SensorEventListener {
    float yaw;
    float pitch;
    float roll;

    public CompassHandler(Context context) {
        SensorManager manager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0 && manager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD).size() != 0) {
            Sensor accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            Sensor magnetometer = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
            manager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // nothing to do here
    }

    float[] mGravity;
    float[] mGeomagnetic;
    public void onSensorChanged(SensorEvent event) {
    	if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
    	      mGravity = event.values;
    	if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
    	      mGeomagnetic = event.values;
    	if (mGravity != null && mGeomagnetic != null) 
    	{
    	      float R[] = new float[9];
    	      float I[] = new float[9];
    	      boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
    	      if (success) 
    	      {
    	        float orientation[] = new float[3];
    	        SensorManager.getOrientation(R, orientation);
    	        // orientation contains: yaw, pitch and roll
    	        yaw = orientation[0];
    	        pitch = orientation[1];
    	        roll = orientation[2];
    	      }
    	}
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public float getRoll() {
        return roll;
    }
}
