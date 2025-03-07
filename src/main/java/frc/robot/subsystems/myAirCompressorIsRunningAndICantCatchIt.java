package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class myAirCompressorIsRunningAndICantCatchIt extends SubsystemBase {

    private final DoubleSolenoid coralAngleInator = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0,8);
    private final DoubleSolenoid climbLegFeetPistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, 15,7);
    
    public void ClimberDown(){
        climbLegFeetPistons.set(DoubleSolenoid.Value.kForward);
        System.out.println("ClimberDown");
    }

    public void CoralUp(){
        coralAngleInator.set(DoubleSolenoid.Value.kForward);
        System.out.println("CoralUp");
    }

    public void ClimberUp(){
        climbLegFeetPistons.set(DoubleSolenoid.Value.kReverse);
        System.out.println("ClimberUp");
    }

    public void CoralDown(){
        coralAngleInator.set(DoubleSolenoid.Value.kReverse);
        System.out.println("CoralDown");
    }
}
