/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  public static RobotMap robotMap = new RobotMap(); 
  public static Drive drive = new Drive(robotMap);

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
    
  }


  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopPeriodic() {
    drive.drive();
  }

  @Override
  public void testPeriodic() {
  }
}
