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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
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
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder chassisleftEncoder;
    public static AnalogInput chassisrangeFinder;
    public static Encoder chassisrightEncoder;
    public static CANTalon chassisfrontLeft;
    public static CANTalon chassisbackLeft;
    public static CANTalon chassisfrontRight;
    public static CANTalon chassisbackRight;
    public static RobotDrive chassisRobotDrive41;
    public static Encoder shootershooterEncoder;
    public static CANTalon shootershooter;
    public static CANTalon armlowerJoint;
    public static Encoder armlowerJointEncoder;
    public static Encoder armupperJointEncoder;
    public static CANTalon armupperJoint;
    public static Encoder intakeintakeEncoder;
    public static CANTalon intake;
    public static SpeedController wheels;
    public static Relay intakeFeed;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisleftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "leftEncoder", chassisleftEncoder);
        chassisleftEncoder.setDistancePerPulse(1.0);
        chassisleftEncoder.setPIDSourceType(PIDSourceType.kRate);
        chassisrangeFinder = new AnalogInput(0);
        LiveWindow.addSensor("Chassis", "rangeFinder", chassisrangeFinder);
        
        chassisrightEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Chassis", "rightEncoder", chassisrightEncoder);
        chassisrightEncoder.setDistancePerPulse(1.0);
        chassisrightEncoder.setPIDSourceType(PIDSourceType.kRate);
        chassisfrontLeft = new CANTalon(0);
        LiveWindow.addActuator("Chassis", "frontLeft", chassisfrontLeft);
        
        chassisbackLeft = new CANTalon(1);
        LiveWindow.addActuator("Chassis", "backLeft", chassisbackLeft);
        
        chassisfrontRight = new CANTalon(2);
        LiveWindow.addActuator("Chassis", "frontRight", chassisfrontRight);
        
        chassisbackRight = new CANTalon(3);
        LiveWindow.addActuator("Chassis", "backRight", chassisbackRight);
        
        chassisRobotDrive41 = new RobotDrive(chassisfrontLeft, chassisbackLeft,
              chassisfrontRight, chassisbackRight);
        
        chassisRobotDrive41.setSafetyEnabled(true);
        chassisRobotDrive41.setExpiration(0.1);
        chassisRobotDrive41.setSensitivity(0.5);
        chassisRobotDrive41.setMaxOutput(1.0);

        shootershooter = new CANTalon(4);
        LiveWindow.addActuator("Shooter", "shooter", (CANTalon) shootershooter);
        
        
        armlowerJoint = new CANTalon(6);
        LiveWindow.addActuator("Arm", "lowerJoint", (CANTalon) armlowerJoint);
 
        armupperJoint = new CANTalon(7);
        LiveWindow.addActuator("Arm", "upperJoint", (CANTalon) armupperJoint);

        intake = new CANTalon(5);
        LiveWindow.addActuator("Intake", "intake", (CANTalon) intake);
        wheels = new TalonSRX(2);
        LiveWindow.addActuator("Intake", "intake", (TalonSRX) wheels);
        intakeFeed = new Relay(1);
        LiveWindow.addActuator("Intake", "intake", (Relay) intakeFeed);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
