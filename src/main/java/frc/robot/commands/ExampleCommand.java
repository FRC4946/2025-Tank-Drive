// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends Command {
  XboxController con = new XboxController(0);
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
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
    double y = con.getLeftY();
    while(true){

    y = con.getLeftY();
    if(y>=0.1){m_subsystem.leftDrive(0.01);}
    if(y<=-0.1){m_subsystem.leftDrive(0.01);}
    else{m_subsystem.leftDrive(0);}
      
    y = con.getRightY();
    if(y>=0.1){m_subsystem.rightDrive(0.01);}
    if(y<=-0.1){m_subsystem.rightDrive(0.01);}
    else{m_subsystem.rightDrive(0);}

    if(con.getAButtonPressed()){
      m_subsystem.armMotor(0.1);
    }
    if(con.getBButtonPressed()){
      m_subsystem.armMotor(-0.1);
    }
    else{m_subsystem.armMotor(-0);}

        }
      }
      
    

    

      // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

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
