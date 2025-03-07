package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.myAirCompressorIsRunningAndICantCatchIt;

public class climberToggle extends Command {
     myAirCompressorIsRunningAndICantCatchIt m_pnuematics;
     private boolean tFlip;

    public climberToggle(myAirCompressorIsRunningAndICantCatchIt m_pneumatics, boolean tFlip){
        this.m_pnuematics = m_pneumatics;
        this.tFlip = tFlip;
    }
    @Override
    public void initialize(){
        if(tFlip){
            m_pnuematics.ClimberDown();
        }
        else{
            m_pnuematics.ClimberUp();
        }
    }

    public void execute(){}

    public boolean isFinished(){
        return false;
    }
}
