/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.*;

public class RobotMap {
	
	


    public final XboxController xBox = new XboxController(0);

    public final Talon driveFR = new Talon(0);
    public final Talon driveFL = new Talon(1);
    public final Talon driveBL = new Talon(2);
    public final Talon driveBR = new Talon(3);

    public final SpeedControllerGroup left = new SpeedControllerGroup(driveFL, driveBL);
    public final SpeedControllerGroup right = new SpeedControllerGroup(driveFR, driveBR);

	public final DifferentialDrive drive = new DifferentialDrive(left, right);
	
	public final Servo servo = new Servo(1);
	

	
	/*
	public final JoystickButton buttonA = new JoystickButton(controller, Constants.aButton);
	public final JoystickButton buttonB = new JoystickButton(controller, Constants.bButton);
	public final JoystickButton buttonX = new JoystickButton(controller, Constants.xButton);
	public final JoystickButton buttonY = new JoystickButton(controller, Constants.yButton);
	public final JoystickButton bumperL = new JoystickButton(controller, Constants.leftBumper);
	public final JoystickButton bumperR = new JoystickButton(controller, Constants.rightBumper);
	public final JoystickButton backB = new JoystickButton(controller, Constants.backButton);	
	public final JoystickButton startB = new JoystickButton(controller, Constants.startButton);
	public final JoystickButton leftStickB = new JoystickButton(controller, Constants.lStickButton);
    public final JoystickButton rightStickB = new JoystickButton(controller, Constants.rStickButton);
    */

	//public final DigitalInput hatchSensor = new DigitalInput(1);
    
	private static RobotMap robotMap;
	
	public static RobotMap getRobotMap() {
		if(robotMap == null) {
			robotMap = new RobotMap();
		}
		return robotMap;
	}
   

    public RobotMap ()
    {

    }
    
/*    public static RobotMap getRobotMap()
    {
        if (robotMap == null)
        {
            robotMap = new RobotMap();
        }

        return robotMap;
    }
    */
	
	public double deadzone(double input)
	{
		if(Math.abs(input)>Constants.deadzone)
		{
			return input;
		}
		else
		{
			return 0;
		}
	}
	
	public double getLeftY()
	{
		return -deadzone(xBox.getY(GenericHID.Hand.kLeft));
	}
	
	public double getLeftX()
	{
		return deadzone(xBox.getX(GenericHID.Hand.kLeft));
	}
	
	public double getRightY() 
	{
		return -deadzone(xBox.getY(GenericHID.Hand.kLeft));
	}
	
	public double getRightX()
	{
		return deadzone(xBox.getX(GenericHID.Hand.kRight));
	}	


}