// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Xbox controller used to schedule commands in the bindings
  private final CommandXboxController driverController =
      new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);

  private final ExampleSubsystem exampleSubsystem;
  private final ExampleCommand exampleCommand;

  public RobotContainer() {
    exampleSubsystem = new ExampleSubsystem();
    exampleCommand = new ExampleCommand(exampleSubsystem, driverController::getLeftX);
    configureBindings();
  }

  /**
   * Method to configure the binding of commands to a controller's buttons
   */
  private void configureBindings() {
    driverController.a().onTrue(exampleCommand);
  }

  public Command getAutonomousCommand() {
    return new InstantCommand();
  }
}
