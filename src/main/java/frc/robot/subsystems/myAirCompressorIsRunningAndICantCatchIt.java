package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class myAirCompressorIsRunningAndICantCatchIt extends SubsystemBase {

    private final Solenoid coralAngleInator = new Solenoid(PneumaticsModuleType.REVPH, 0);

    private final Solenoid climbLegFeetPistons = new Solenoid(PneumaticsModuleType.REVPH, 1);

    public void ClimberToggle(){
        climbLegFeetPistons.toggle();
    }

    public void CoralToggle(){
        coralAngleInator.toggle();
    }
}
