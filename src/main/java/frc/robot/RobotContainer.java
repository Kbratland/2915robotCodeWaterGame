// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.coralSuperComponentSubsystem;
import frc.robot.subsystems.myAirCompressorIsRunningAndICantCatchIt;
import frc.robot.subsystems.superAlgaeInatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.List;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final coralSuperComponentSubsystem m_coralSubsystem = new coralSuperComponentSubsystem();
  private final superAlgaeInatorSubsystem m_algaeSubsystem = new superAlgaeInatorSubsystem();
  private final myAirCompressorIsRunningAndICantCatchIt m_pneumatics = new myAirCompressorIsRunningAndICantCatchIt();

  // The driver's controller
  Joystick m_driverController = new Joystick(OIConstants.kDriverControllerPort);

  JoystickButton button1 = new JoystickButton(m_driverController, 1);
  JoystickButton button2 = new JoystickButton(m_driverController, 2);
  JoystickButton button3 = new JoystickButton(m_driverController, 3);
  JoystickButton button4 = new JoystickButton(m_driverController, 4);
  JoystickButton button5 = new JoystickButton(m_driverController, 5);
  JoystickButton button6 = new JoystickButton(m_driverController, 6);
  JoystickButton button7 = new JoystickButton(m_driverController, 7);
  JoystickButton button8 = new JoystickButton(m_driverController, 8);
  JoystickButton button9 = new JoystickButton(m_driverController, 9);
  JoystickButton button10 = new JoystickButton(m_driverController, 10);
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_driveSubsystem.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () -> m_driveSubsystem.drive(
                -MathUtil.applyDeadband(m_driverController.getY(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getX(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getZ(), OIConstants.kDriveDeadband),
                true),
            m_driveSubsystem));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {

    // new JoystickButton(m_driverController, Button.kR1.value).whileTrue(new RunCommand(() -> m_driveSubsystem.setX(),m_driveSubsystem));
    button1.onTrue(new RunCommand(() -> m_pneumatics.ClimberToggle(), m_pneumatics));
    button2.onTrue(new RunCommand(() -> m_pneumatics.CoralToggle(), m_pneumatics));
    button3.onTrue(new RunCommand(() -> m_coralSubsystem.cWinchPositive(), m_coralSubsystem));
    button4.onTrue(new RunCommand(() -> m_coralSubsystem.cWinchNegative(),m_coralSubsystem));
    button5.onTrue(new RunCommand(() -> m_algaeSubsystem.wristUp(),m_algaeSubsystem));
    button6.onTrue(new RunCommand(() -> m_algaeSubsystem.wristDown(),m_algaeSubsystem));
    button7.onTrue(new RunCommand(() -> m_algaeSubsystem.intake(), m_algaeSubsystem));
    button8.onTrue(new RunCommand(() -> m_algaeSubsystem.outake(), m_algaeSubsystem));
    button9.onTrue(new RunCommand(() -> m_driveSubsystem.setX(), m_driveSubsystem));
    button10.onTrue(new RunCommand(() -> m_driveSubsystem.zeroHeading(), m_driveSubsystem));
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Create config for trajectory
    TrajectoryConfig config = new TrajectoryConfig(
        AutoConstants.kMaxSpeedMetersPerSecond,
        AutoConstants.kMaxAccelerationMetersPerSecondSquared)
        // Add kinematics to ensure max speed is actually obeyed
        .setKinematics(DriveConstants.kDriveKinematics);

    // An example trajectory to follow. All units in meters.
    Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(

        // Start at the origin facing the +X direction
        new Pose2d(0, 0, new Rotation2d(0)),

        // Pass through these two interior waypoints, making an 's' curve path
        List.of(new Translation2d(0.5, 0)),

        // End 3 meters straight ahead of where we started, facing forward
        new Pose2d(1, 0, new Rotation2d(0)),

        config);

    var thetaController = new ProfiledPIDController(
        AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
    thetaController.enableContinuousInput(-Math.PI, Math.PI);

    SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
        exampleTrajectory,
        m_driveSubsystem::getPose, // Functional interface to feed supplier
        DriveConstants.kDriveKinematics,

        // Position controllers
        new PIDController(AutoConstants.kPXController, 0, 0),
        new PIDController(AutoConstants.kPYController, 0, 0),
        thetaController,
        m_driveSubsystem::setModuleStates,
        m_driveSubsystem);

    // Reset odometry to the starting pose of the trajectory.
    m_driveSubsystem.resetOdometry(exampleTrajectory.getInitialPose());

    // Run path following command, then stop at the end.
    return swerveControllerCommand.andThen(() -> m_driveSubsystem.drive(0, 0, 0, false))
                                  .andThen(new RunCommand(() -> m_pneumatics.CoralToggle(), m_pneumatics));
  }
}
