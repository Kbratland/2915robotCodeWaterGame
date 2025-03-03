package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.superAlgaeInatorSubsystem;

public class algaeIntake extends Command {
    
    superAlgaeInatorSubsystem m_algaeSubsystem;
    private boolean grabbing;

    public algaeIntake(superAlgaeInatorSubsystem m_algaeSubsystem, boolean grabbing){
        this.m_algaeSubsystem = m_algaeSubsystem;
        this.grabbing = grabbing;
    }
    @Override
    public void initialize(){

    }
    public void execute(){
        if(grabbing){
            m_algaeSubsystem.intake();
        }
        else{
            m_algaeSubsystem.outake();
        }
    }
    public boolean isFinished(){
        m_algaeSubsystem.WEREGONNACRASH();
        return true;
    }
}
