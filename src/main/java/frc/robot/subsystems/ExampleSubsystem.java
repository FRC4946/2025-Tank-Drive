// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
 TalonFX motor1,motor2,motor3,motor4,armMotor,motor6,motor7,motor8,motor9;
  public ExampleSubsystem() {
TalonFX motor1 = new TalonFX(9);
TalonFX motor2 = new TalonFX(0);
TalonFX motor3 = new TalonFX(10);
TalonFX motor4 = new TalonFX(19);


TalonFX motor6 = new TalonFX(8);
TalonFX motor7 = new TalonFX(1);
TalonFX motor8 = new TalonFX(11);
TalonFX motor9 = new TalonFX(18);

motor6.setNeutralMode(NeutralMode.Brake);
motor7.setNeutralMode(NeutralMode.Brake);
motor8.setNeutralMode(NeutralMode.Brake);
motor9.setNeutralMode(NeutralMode.Brake);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });

  }
  public void noTurn() {

  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public void rightDrive(double speed) {
    motor1.setVoltage(speed);
    motor3.setVoltage(speed);
  }
  public void leftDrive(double speed) {
    motor2.setVoltage(speed);
    motor4.setVoltage(speed);
  }
  public void armMotor(double speed){
   armMotor.setVoltage(speed);
  }
  public double getSpeed(){return motor1.get();}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
