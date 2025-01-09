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
    public static TalonFX drive1, drive2, drive3, drive4; //Drive1 = Front Left, Drive2 = Front Right, Drive3 = Back Left, Drive4 = Back Right
  /**
   * 
   *
   * @return a command
   */
  public double[] getSpeed() {
    double[] getSpeedArray = {drive1.get(), drive2.get(), drive3.get(), drive4.get()};
    return getSpeedArray;
  }
  public void rightWheels(double speed) {
    drive2.setVoltage(speed);
    drive4.setVoltage(speed);
  }
  public void leftWheels(double speed) {
    drive1.setVoltage(-speed);
    drive3.setVoltage(-speed);
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean turnRightCommand() {
    drive1.setVoltage(0.01);
    drive2.setVoltage(-0.01);
    drive3.setVoltage(0.01);
    drive4.setVoltage(-0.01);
    if(drive1.get() == 0.01 && drive2.get() == -0.01 && drive3.get() == 0.01 && drive4.get() == -0.01) {
      return true;
    } else {
      return false;
    }
  }
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
