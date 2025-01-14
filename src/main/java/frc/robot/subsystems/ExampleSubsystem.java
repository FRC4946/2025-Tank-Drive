// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}
//    private TalonFX driveLeft, driveRight, driveBackLeft, driveBackRight;
    TalonFX driveLeft = new TalonFX(9, "Drivetrain CANivore");
    TalonFX driveRight = new TalonFX(0, "Drivetrain CANivore");
    TalonFX driveBackLeft = new TalonFX(10, "Drivetrain CANivore");
    TalonFX driveBackRight = new TalonFX(19, "Drivetrain CANivore");
  /**
   * 
   * Example command factory method.
   *
   * @return a command
   */
  public void setLeftSpeed(double speed) {
    driveLeft.set(speed);
    driveBackLeft.set(speed);
  }

  public void setRightSpeed(double speed) {
    driveRight.set(speed);
    driveBackRight.set(speed);
  }

  public double [] getSpeed() {
    double [] SpeedArray = {driveLeft.get(), driveRight.get(), driveBackLeft.get(), driveBackRight.get()};
    return SpeedArray;
  }

  public void noTurn() {
    driveLeft.setPosition(0);
    driveRight.setPosition(0);
    driveBackLeft.setPosition(0);
    driveBackRight.setPosition(0);

    driveLeft.setNeutralMode(NeutralModeValue.Brake);
    driveRight.setNeutralMode(NeutralModeValue.Brake);
    driveBackLeft.setNeutralMode(NeutralModeValue.Brake);
    driveBackRight.setNeutralMode(NeutralModeValue.Brake);
  }


 
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
