/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  public static RobotMap robotMap = RobotMap.getRobotMap(); 
  public static Drive drive = new Drive(robotMap);
  public static Servo servo = new Servo(robotMap);

  @Override
  public void robotInit() {
    new Thread(() -> {
			UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture();
			camera1.setResolution(640, 480);
			camera1.setFPS(30);
			camera1.setExposureAuto();
			
			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("Camera1", 640, 480); 
			//set up a new camera with this name in SmartDashboard (Veiw->Add->CameraServer Stream Viewer)
			
			Mat source = new Mat();
			Mat output = new Mat();
			
			while(!Thread.interrupted())
			{
				cvSink.grabFrame(source);
				Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2RGB);//this will show the video in black and white 
				outputStream.putFrame(output);
			}					
		}).start();//definition of camera, runs even when disabled

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
    servo.servoControll();
  }

  @Override
  public void testPeriodic() {
  }
}
