package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class superAlgaeInatorSubsystem extends SubsystemBase {
    
    private final SparkMax sparkleMax1 = new SparkMax(DriveConstants.aNeoMotorCanId, MotorType.kBrushless);
    private final SparkMax sparkleMax2 = new SparkMax(DriveConstants.aNeoMotorCanIdTheSequel, MotorType.kBrushless);

    private final TalonSRX superTalonInator = new TalonSRX(DriveConstants.aWristMotorCanId);
    private final TalonSRX superTalonInator2 = new TalonSRX(DriveConstants.aWristMotorCanIdTheSequel);

    public double wristSpeed = 0.25;
    public double grabIntatorSpeed = 0.33333333333333333333333;

    public void wristUp(){
        superTalonInator.set(ControlMode.PercentOutput, wristSpeed * 1.15);
        superTalonInator2.set(ControlMode.PercentOutput, -wristSpeed * 1.15);
    }

    public void wristDown(){
        superTalonInator.set(ControlMode.PercentOutput, wristSpeed *.8);
        superTalonInator2.set(ControlMode.PercentOutput, -wristSpeed *.8);
    }
    
    public void intake(){
        sparkleMax1.set(grabIntatorSpeed);
        sparkleMax2.set(grabIntatorSpeed);
    }

    public void outake(){
        sparkleMax1.set(-grabIntatorSpeed);
        sparkleMax2.set(-grabIntatorSpeed);
    }

    public void WEREGONNACRASH(){
        sparkleMax1.set(0);
        sparkleMax2.set(0);
        superTalonInator.set(ControlMode.PercentOutput, 0);
        superTalonInator2.set(ControlMode.PercentOutput, 0);
    }

}
