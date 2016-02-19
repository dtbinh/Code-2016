// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3482.robot;

import com.kauailabs.navx.frc.AHRS;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	public static AnalogInput chassisrangeFinder;
    public static AHRS chassisIMU;
    public static CANTalon chassisfrontLeft;
    public static CANTalon chassisbackLeft;
    public static CANTalon chassisfrontRight;
    public static CANTalon chassisbackRight;
    public static RobotDrive chassisRobotDrive41;
    public static CANTalon shootershooter;
    public static CANTalon armlowerJoint;
    public static CANTalon armupperJoint;
    public static CANTalon intake;
    public static CANTalon wheels;
    public static Relay intakeFeed;
    public static CANTalon climber;
    public static TalonSRX climberExtender;
    
    public static void init() {
    	//TODO: Initialize range finder
        //LiveWindow.addSensor("Chassis", "rangeFinder", chassisrangeFinder);
        
        try{
    		chassisIMU = new AHRS(SerialPort.Port.kMXP);
    	} catch(Exception ex) {
    		DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
    	}
        LiveWindow.addSensor("IMU", "Gyro", chassisIMU);
        
        chassisfrontLeft = new CANTalon(0);
        LiveWindow.addActuator("Chassis", "frontLeft", chassisfrontLeft);
        chassisbackLeft = new CANTalon(8);
        LiveWindow.addActuator("Chassis", "backLeft", chassisbackLeft);
        chassisfrontRight = new CANTalon(2);
        LiveWindow.addActuator("Chassis", "frontRight", chassisfrontRight);
        chassisbackRight = new CANTalon(3);
        LiveWindow.addActuator("Chassis", "backRight", chassisbackRight);

        chassisRobotDrive41 = new RobotDrive(chassisfrontLeft, chassisbackLeft, chassisfrontRight, chassisbackRight);
        chassisRobotDrive41.setSafetyEnabled(true);
        chassisRobotDrive41.setExpiration(0.1);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);

        shootershooter = new CANTalon(4);
        LiveWindow.addActuator("Shooter", "shooter", (CANTalon) shootershooter);
        
        armlowerJoint = new CANTalon(1); 
        LiveWindow.addActuator("Arm", "lowerJoint", (CANTalon) armlowerJoint);
        armupperJoint = new CANTalon(6);
        LiveWindow.addActuator("Arm", "upperJoint", (CANTalon) armupperJoint);

        intake = new CANTalon(5);
        LiveWindow.addActuator("Intake", "intake", (CANTalon) intake);
        wheels = new CANTalon(7);
        LiveWindow.addActuator("Intake", "intake", (CANTalon) wheels);
        intakeFeed = new Relay(0);
        LiveWindow.addActuator("Intake", "intake", (Relay) intakeFeed);

        climber = new CANTalon(9);
        LiveWindow.addActuator("Climber", "climber", (CANTalon) climber);
        climberExtender = new TalonSRX(0);
        LiveWindow.addActuator("Climber Extender", "climberExtender", (TalonSRX) climberExtender);
    }
}
