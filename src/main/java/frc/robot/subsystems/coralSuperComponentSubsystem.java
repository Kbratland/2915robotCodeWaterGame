package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class coralSuperComponentSubsystem extends SubsystemBase {

    private final TalonSRX motor = new TalonSRX(DriveConstants.cUpMotorCanId);

    public void cWinchPositive(){
        motor.set(ControlMode.PercentOutput, 1);
    }

    public void cWinchNegative(){
        motor.set(ControlMode.PercentOutput, -1);
    }

    public void noMoreUppies(){
        motor.set(ControlMode.PercentOutput,0);
    }
}
