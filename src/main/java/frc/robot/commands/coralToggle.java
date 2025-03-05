package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.myAirCompressorIsRunningAndICantCatchIt;

public class coralToggle extends Command {
    
    myAirCompressorIsRunningAndICantCatchIt m_pnuematics;
    private boolean tFlip;

    public coralToggle(myAirCompressorIsRunningAndICantCatchIt m_pneumatics, boolean tFlip){
        this.m_pnuematics = m_pneumatics;
        this.tFlip = tFlip;
    }
    @Override
    public void initialize(){
        if(tFlip){
            m_pnuematics.CoralUp();
        }
        else{
            m_pnuematics.CoralDown();
        }
        
    }

    public void execute(){}

    public boolean isFinished(){
        return true;
    }

}
