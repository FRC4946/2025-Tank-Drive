// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ExampleSubsystem extends SubsystemBase {
  private final TalonFX motor1,motor2,motor3,motor4,motor6,motor7,motor8,motor9;
  public ExampleSubsystem() {
 motor1 = new TalonFX(9, "Drivetrain CANivore");
 motor2 = new TalonFX(0, "Drivetrain CANivore");
 motor3 = new TalonFX(10, "Drivetrain CANivore");
 motor4 = new TalonFX(19, "Drivetrain CANivore");


 motor6 = new TalonFX(8, "Drivetrain CANivore");
 motor7 = new TalonFX(1, "Drivetrain CANivore");
 motor8 = new TalonFX(11, "Drivetrain CANivore");
 motor9 = new TalonFX(18, "Drivetrain CANivore");

motor6.setNeutralMode(NeutralModeValue.Brake);
motor7.setNeutralMode(NeutralModeValue.Brake);
motor8.setNeutralMode(NeutralModeValue.Brake);
motor9.setNeutralMode(NeutralModeValue.Brake);
motor1.setNeutralMode(NeutralModeValue.Brake);
motor2.setNeutralMode(NeutralModeValue.Brake);
motor3.setNeutralMode(NeutralModeValue.Brake);
motor4.setNeutralMode(NeutralModeValue.Brake);
  }
  /** Creates a new ExampleSubsystem. */
  /**
   * 
   *
   * @return a command
   */
  public double[] getAllSpeeds() {
    double[] getSpeedArray = {motor1.get(), motor2.get(), motor3.get(), motor4.get()};
    return getSpeedArray;
  }
  public void rightWheels(double speed) {
    motor1.set(speed);
    motor3.set(speed);
  }
  public void leftWheels(double speed) {
    motor2.set(speed);
    motor4.set(speed);
  }
  public void turnRightCommand() {
    rightWheels(0.5);
    leftWheels(-0.5);
  }
  public void noTurn() {
    motor1.setPosition(0);
    motor2.setPosition(0);
    motor3.setPosition(0);
    motor4.setPosition(0);
    motor6.setPosition(0);
    motor7.setPosition(0);
    motor8.setPosition(0);
    motor9.setPosition(0);
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
