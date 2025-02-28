package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class myAirCompressorIsRunningAndICantCatchIt extends SubsystemBase {

    private final DoubleSolenoid coralAngleInator = new DoubleSolenoid(PneumaticsModuleType.REVPH, 8,9);
    private final DoubleSolenoid climbLegFeetPistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, 10,11);
    
    public void ClimberToggle(){
        climbLegFeetPistons.toggle();
    }

    public void CoralToggle(){
        coralAngleInator.toggle();
    }
}
