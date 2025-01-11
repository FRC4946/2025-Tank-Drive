// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
 private final TalonFX motor1,motor2,motor3,motor4,motor6,motor7,motor8,motor9;
 private final CANcoder CANcoder1,CANcoder2,CANcoder3,CANcoder4;
 public ExampleSubsystem() {

CANcoder1 = new CANcoder(0,"Drivetrain CANivore");
CANcoder2 = new CANcoder(1,"Drivetrain CANivore");
CANcoder3 = new CANcoder(2,"Drivetrain CANivore");
CANcoder4 = new CANcoder(3,"Drivetrain CANivore");

motor1 = new TalonFX(9, "Drivetrain CANivore");
motor2 = new TalonFX(0,"Drivetrain CANivore");
motor3 = new TalonFX(10,"Drivetrain CANivore");
motor4 = new TalonFX(19,"Drivetrain CANivore");



motor6 = new TalonFX(8,"Drivetrain CANivore");
motor7 = new TalonFX(1,"Drivetrain CANivore");
motor8 = new TalonFX(11,"Drivetrain CANivore");
motor9 = new TalonFX(18,"Drivetrain CANivore");
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
  public void TurnMotor6(int wantedDegree) {
   
    double currentDegree = (CANcoder1.getAbsolutePosition().getValueAsDouble())/360;
    double difference = wantedDegree-currentDegree;
    int test=1;

   //motor1.set(1);
    while (true) {
      
      motor6.set(1-(1/difference));
      currentDegree = (CANcoder1.getAbsolutePosition().getValueAsDouble())/360;
      difference = wantedDegree-currentDegree;
      SmartDashboard.putNumber("isWorking",test);
      SmartDashboard.putNumber("difference",difference);
      SmartDashboard.putNumber("current",currentDegree);
      test++;
      if(difference>=wantedDegree-1 && difference<=1+wantedDegree){break;}
    }

    motor6.set(0);
  } 
  
 
 

  public void turnAll(int wantedDegree) {
    TurnMotor6(wantedDegree);

  } 
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public void rightDrive(double speed) {
    motor6.set(speed);
    motor7.set(speed);
  }

  public void leftDrive(double speed) {
    motor6.set(speed);
    motor7.set(speed);
  }

  public double getSpeed(){return motor1.get();}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Module 0 CANcoder", CANcoder1.getAbsolutePosition().getValueAsDouble());

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
