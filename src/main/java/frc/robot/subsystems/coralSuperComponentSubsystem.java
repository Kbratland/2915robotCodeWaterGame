package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class coralSuperComponentSubsystem extends SubsystemBase {

    private final SparkMax motor = new SparkMax(DriveConstants.cUpMotorCanId,MotorType.kBrushed);

    public void cWinchPositive(){
        motor.set(1);
    }

    public void cWinchNegative(){
        motor.set(-1);
    }

    public void noMoreUppies(){
        motor.set(0);
    }

    public void end(){
        motor.set(0);
    }
}
