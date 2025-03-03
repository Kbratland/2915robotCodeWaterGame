package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.superAlgaeInatorSubsystem;

public class algaeWrist extends Command {
    superAlgaeInatorSubsystem m_algaeSubsystem;
    private boolean goingUp;
    public algaeWrist(superAlgaeInatorSubsystem m_algaeSubsystem, boolean goingUp){
        this.m_algaeSubsystem = m_algaeSubsystem;
        this.goingUp = goingUp;
    }
    @Override
    public void initialize(){

    }
    public void execute(){
        if(goingUp){
            m_algaeSubsystem.wristUp();
        }
        else{
            m_algaeSubsystem.wristDown();
        }
    }
    public boolean isFinished(){
        m_algaeSubsystem.WEREGONNACRASH();
        return true;
    }
}
