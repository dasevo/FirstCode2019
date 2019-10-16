/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
	
	


    public static Joystick controllerL = new Joystick(0);
    public static Joystick controllerR = new Joystick(1);

    public static Talon driveFR = new Talon(0);
    public static Talon driveFL = new Talon(1);
    public static Talon driveBL = new Talon(2);
    public static Talon driveBR = new Talon(3);

    public static SpeedControllerGroup left = new SpeedControllerGroup(driveFL, driveBL);
    public static SpeedControllerGroup right = new SpeedControllerGroup(driveFR, driveBR);

    public DifferentialDrive drive = new DifferentialDrive(left, right);
	
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
		return -deadzone(controllerL.getY());
	}
	
	public double getLeftX()
	{
		return deadzone(controllerL.getX());
	}
	
	public double getRightY()
	{
		return -deadzone(controllerR.getY());
	}
	
	public double getRightX()
	{
		return deadzone(controllerR.getX());
	}


}