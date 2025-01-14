// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final CommandXboxController Controller = new CommandXboxController(0);
  private final ExampleSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleCommand(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  
  @Override
  public void initialize() {
    m_subsystem.noTurn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Controller.getRawAxis(XboxController.Axis.kLeftY.value) > 0.1) {
      m_subsystem.setLeftSpeed(Controller.getRawAxis(XboxController.Axis.kLeftY.value));
    } else if (Controller.getRawAxis(XboxController.Axis.kRightY.value) > 0.1) {
      m_subsystem.setRightSpeed(Controller.getRawAxis(XboxController.Axis.kRightY.value));
    } else if (Controller.getRawAxis(XboxController.Axis.kLeftY.value) < -0.1) {
      m_subsystem.setLeftSpeed(Controller.getRawAxis(XboxController.Axis.kLeftY.value));
    } else if (Controller.getRawAxis(XboxController.Axis.kRightY.value) < -0.1) {
      m_subsystem.setRightSpeed(Controller.getRawAxis(XboxController.Axis.kRightY.value));
    } else if (Controller.getRawAxis(XboxController.Axis.kLeftY.value) < 0.1 || Controller.getRawAxis(XboxController.Axis.kLeftY.value) > -0.1) {
      m_subsystem.setLeftSpeed(0);
    } else if (Controller.getRawAxis(XboxController.Axis.kRightY.value) < 0.1 || Controller.getRawAxis(XboxController.Axis.kRightY.value) > -0.1) {
      m_subsystem.setRightSpeed(0);
    }
    // } else if (Controller.getLeftTriggerAxis() == 0) {
    //  m_subsystem.setLeftSpeed(0);
    //} else if (Controller.getRightTriggerAxis() == 1) {
    //  m_subsystem.setRightSpeed(1);
    //} else if (Controller.getRightTriggerAxis() == 0) {
    //  m_subsystem.setRightSpeed(0);
    //} else if (Controller.getRightTriggerAxis() == -1) {
    //  m_subsystem.setRightSpeed(-1);
    //} else if (Controller.getLeftTriggerAxis() == -1) {
    //  m_subsystem.setLeftSpeed(-1);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
