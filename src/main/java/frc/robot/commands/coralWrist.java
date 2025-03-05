package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.coralSuperComponentSubsystem;

public class coralWrist extends Command {

    coralSuperComponentSubsystem m_coralSubsystem;
    private boolean goingUp;

    public coralWrist(coralSuperComponentSubsystem m_coralSubsystem, boolean goingUp){
        this.m_coralSubsystem = m_coralSubsystem;
        this.goingUp = goingUp;
    }
    @Override
    public void initialize(){

    }
    public void execute(){
        if(goingUp){
            m_coralSubsystem.cWinchPositive();
        }
        else{
            m_coralSubsystem.cWinchNegative();
        }
    }

    public boolean isFinished(){
        return false;
    }
    public void end(boolean interupted){
        m_coralSubsystem.end();
    }
}
