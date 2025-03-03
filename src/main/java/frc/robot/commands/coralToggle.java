package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.myAirCompressorIsRunningAndICantCatchIt;

public class coralToggle extends Command {
    
    myAirCompressorIsRunningAndICantCatchIt m_pnuematics;

    public coralToggle(myAirCompressorIsRunningAndICantCatchIt m_pneumatics){
        this.m_pnuematics = m_pneumatics;
    }
    @Override
    public void initialize(){
        m_pnuematics.CoralToggle();
    }

    public void execute(){}

    public boolean isFinished(){
        return true;
    }

}
