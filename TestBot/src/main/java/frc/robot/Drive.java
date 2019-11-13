package frc.robot;

public class Drive {

    private RobotMap robotMap;

    public Drive(RobotMap robotMap)
    {
        this.robotMap = robotMap;
    }

    public void drive() {
        robotMap.drive.arcadeDrive(robotMap.getLeftY(), robotMap.getRightX());
    }

}