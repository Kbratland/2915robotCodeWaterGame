package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class myAirCompressorIsRunningAndICantCatchIt extends SubsystemBase {

    private final DoubleSolenoid coralAngleInator = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0,7);
    private final DoubleSolenoid climbLegFeetPistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, 8,15);
    
    public void ClimberUp(){
        climbLegFeetPistons.set(DoubleSolenoid.Value.kForward);
        System.out.println("ClimberToggle");
    }

    public void CoralUp(){
        coralAngleInator.set(DoubleSolenoid.Value.kForward);
        System.out.println("CoralToggle");
    }

    public void ClimberDown(){
        climbLegFeetPistons.set(DoubleSolenoid.Value.kReverse);
        System.out.println("ClimberToggle");
    }

    public void CoralDown(){
        coralAngleInator.set(DoubleSolenoid.Value.kReverse);
        System.out.println("CoralToggle");
    }
}
