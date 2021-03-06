package org.usfirst.frc3482.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3482.robot.Robot;

/**
 *
 */
public class Move extends Command {
	
	private double moveValue = -1;
	private double rotateValue = -1;
	private double distance = -1;
	private double voltage = -1;
	private double desiredAngle = 0;
	private double acceptableError;
	double rotations;
	
	public Move(double moveValue, double rotateValue, double distance) {
    	requires(Robot.chassis);	
    	this.moveValue = moveValue;
    	this.rotateValue = rotateValue;
    	this.distance = distance;
    }
	
	public Move(double speed, double maintainVoltage, double acceptableError, boolean b) {
		requires(Robot.chassis);
		this.moveValue = speed;
		this.voltage = maintainVoltage;
		this.acceptableError = acceptableError;
	}
	
	public Move(double distance) {
    	requires(Robot.chassis);
    	moveValue = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(voltage == -1 && rotateValue == 0) {
	    	desiredAngle = Robot.chassis.getCurrentAngle();
	    	if(moveValue < 0 && distance > 0) {
	    		distance = -distance;
	    	}
	    	rotations = Robot.chassis.distanceToTargetRotations(distance);
    	} else if(voltage == -1 && distance == 0) {
	    	if(moveValue < 0 && rotateValue > 0) {
	    		rotateValue = -rotateValue;
	    	}
	    	rotations = Robot.chassis.angleToTargetRotations(rotateValue);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(voltage == -1 && rotateValue == 0) {
	    	//System.out.println("Straight line at " + desiredAngle + "degrees");
	    	Robot.chassis.moveStraight(moveValue, rotations, desiredAngle);
    	} else if(voltage == -1 && distance == 0) {
	    	Robot.chassis.rotateByEncoder(moveValue, rotations);
    	} else {
    		Robot.chassis.maintainDistanceVoltage(voltage, 0, acceptableError, false);
    	}
    	
    	
    	//Robot.chassis
//    	if(time != -1) {
//	    	//disabled safety and moves to a location
//			Robot.chassis.setSafety(false);
//			Robot.chassis.move(moveValue, rotateValue);
//			//waits for a given time
//			Timer.delay(time);
//			//enables safety and stops
//			Robot.chassis.move(0.0, 0.0);
//			Robot.chassis.setSafety(true);
//    	} else {
//    		Robot.chassis.setSafety(false);
//    		Robot.chassis.moveDistance(moveValue);
//    		Robot.chassis.setSafety(true);
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stopMoving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
