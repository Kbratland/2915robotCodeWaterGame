// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.DriveConstants;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private Compressor compressor = new Compressor(PneumaticsModuleType.REVPH);
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    compressor.enableDigital();
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    SmartDashboard.putData("Swerve Drive", new Sendable() {
      @Override
      public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("SwerveDrive");
    
        builder.addDoubleProperty("Front Left Angle", () -> (m_robotContainer.m_driveSubsystem.m_frontLeft.m_turningEncoder.getPosition() - DriveConstants.kFrontLeftChassisAngularOffset), null);
        builder.addDoubleProperty("Front Left Velocity", () -> m_robotContainer.m_driveSubsystem.m_frontLeft.m_drivingEncoder.getVelocity(), null);
    
        builder.addDoubleProperty("Front Right Angle", () -> (m_robotContainer.m_driveSubsystem.m_frontRight.m_turningEncoder.getPosition() - DriveConstants.kFrontRightChassisAngularOffset), null);
        builder.addDoubleProperty("Front Right Velocity", () ->m_robotContainer.m_driveSubsystem.m_frontRight.m_drivingEncoder.getVelocity(), null);
    
        builder.addDoubleProperty("Back Left Angle", () -> (m_robotContainer.m_driveSubsystem.m_rearLeft.m_turningEncoder.getPosition() - DriveConstants.kBackLeftChassisAngularOffset), null);
        builder.addDoubleProperty("Back Left Velocity", () -> m_robotContainer.m_driveSubsystem.m_rearLeft.m_drivingEncoder.getVelocity(), null);
    
        builder.addDoubleProperty("Back Right Angle", () -> (m_robotContainer.m_driveSubsystem.m_rearRight.m_turningEncoder.getPosition() - DriveConstants.kBackRightChassisAngularOffset), null);
        builder.addDoubleProperty("Back Right Velocity", () -> m_robotContainer.m_driveSubsystem.m_rearRight.m_drivingEncoder.getVelocity(), null);
    
        builder.addDoubleProperty("Robot Angle", () -> (m_robotContainer.m_driveSubsystem.m_gyro.getAngle()%360)*(Math.PI/180), null);
      }
    });
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
