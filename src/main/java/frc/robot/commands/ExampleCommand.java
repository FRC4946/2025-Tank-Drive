// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/** An example command that uses an example subsystem. */
public class ExampleCommand extends Command {
  CommandXboxController con = new CommandXboxController(0);
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
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

  public void initialize(){
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {    
    double rightY = con.getRawAxis(XboxController.Axis.kRightY.value);
    double leftY = con.getRawAxis(XboxController.Axis.kLeftY.value);
    double leftX = con.getRawAxis(XboxController.Axis.kLeftX.value);

    double thetaRadians = Math.atan(leftY / leftX);
    double thetaDegrees = Math.abs((Math.toDegrees(thetaRadians)));
   if(leftY<0 && leftX > 0){thetaDegrees += 90;}
   else if(leftY<0 && leftX > 0){thetaDegrees += 180;}
   else if(leftY>0 && leftX > 0){thetaDegrees += 270;}


   m_subsystem.TurnMotor6(thetaDegrees);

}
/* 

 m_subsystem.TurnMotor6((int)thetaDeikkkkki.,
 .,,,,,,,,,,,grees);



 if (leftY >= 0.1) {
  m_subsystem.leftDrive(leftY);
 }else
    if (leftY <= 0.1) {
      m_subsystem.leftDrive(leftY);
    } else {
      m_subsystem.leftDrive(0);
    }

    if (rightY >= 0.1) {
      m_subsystem.rightDrive(rightY);
    } else
    if (rightY <= 0.1) {
      m_subsystem.rightDrive(rightY);
    } else {
      m_subsystem.rightDrive(0);
  }

    }
  
*/
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
