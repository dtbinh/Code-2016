// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3482.robot.subsystems;

import org.usfirst.frc3482.robot.RobotMap;
import org.usfirst.frc3482.robot.commands.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Arm extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon lowerJoint = RobotMap.armlowerJoint;
    private final Encoder lowerJointEncoder = RobotMap.armlowerJointEncoder;
    private final Encoder upperJointEncoder = RobotMap.armupperJointEncoder;
    private final CANTalon upperJoint = RobotMap.armupperJoint;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    StringBuilder sb = new StringBuilder();
	int loops = 0;
	final double lowerPosition = -0.17;
	final double restPosition = 0;
	double targetPositionRotations;
    
	
    public Arm() {
		targetPositionRotations = restPosition;
        
		int absolutePosition = lowerJoint.getPulseWidthPosition() & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        lowerJoint.setEncPosition(absolutePosition);
        lowerJoint.reverseSensor(true);
        lowerJoint.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        
        lowerJoint.configEncoderCodesPerRev(7 * 50); //only for quad
        lowerJoint.configNominalOutputVoltage(+0f, -0f);
        lowerJoint.configPeakOutputVoltage(+12f,  -12f);
        
        lowerJoint.setProfile(0);
        lowerJoint.setF(0.0);
        lowerJoint.setP(3.0);
        lowerJoint.setI(0.0); 
        lowerJoint.setD(0.0);
    }
    
    public void setTargetLower() {
    	targetPositionRotations = lowerPosition;
    }
    
    public void setTargetRest() {
    	targetPositionRotations = restPosition;
    }
    
    public void maintainPosition() { 
    	double motorOutput = lowerJoint.getOutputVoltage()/lowerJoint.getBusVoltage();
    	sb.append("\tout:");
	  	sb.append(motorOutput);
	  	sb.append("\tpos:");
        sb.append(lowerJoint.getPosition() );
        lowerJoint.changeControlMode(TalonControlMode.Position);
    	lowerJoint.set(targetPositionRotations);
    	sb.append("\terrNative:");
    	sb.append(lowerJoint.getClosedLoopError());
    	sb.append("\ttrg:");
    	sb.append(targetPositionRotations);
    	if(++loops >= 10) {
          	loops = 0;
          	System.out.println(sb.toString());
        }
        sb.setLength(0);
    }
    
    public void spinLowerJointForward() {
    	lowerJoint.set(0.5);
    }
    
    public void spinUpperJointForward() {
    	upperJoint.set(0.5);
    }
    
    public void spinUpperJointBackward() {
    	upperJoint.set(-0.5);
    }
    
    public void spinLowerJointAtSpeed(double speed) {
    	lowerJoint.set(speed);
    }
    
    public void spinUpperJointAtSpeed(double speed) {
    	upperJoint.set(speed);
    }
    
    public void spinLowerJointBackward() {
    	lowerJoint.set(-0.5);
    }
    
    public void stopUpperJoint() {
    	upperJoint.set(0.0);
    }
    
    public void stopLowerJoint() {
    	lowerJoint.set(0.0);
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	} 
    
    public void runLowerJointWithXboxController(Joystick s) {
		double y = s.getAxis(AxisType.kY);
		lowerJoint.set(-y);
	}
    
    public void runUpperJointWithXboxController(Joystick s) {
		double y = s.getAxis(AxisType.kY);
		upperJoint.set(y);
	}
    
} 

