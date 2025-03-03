package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.myAirCompressorIsRunningAndICantCatchIt;

public class climberToggle extends Command {
     myAirCompressorIsRunningAndICantCatchIt m_pnuematics;

    public climberToggle(myAirCompressorIsRunningAndICantCatchIt m_pneumatics){
        this.m_pnuematics = m_pneumatics;
    }
    @Override
    public void initialize(){
        m_pnuematics.ClimberToggle();
    }

    public void execute(){}

    public boolean isFinished(){
        return true;
    }
}
