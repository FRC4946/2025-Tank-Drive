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
  private static double closestAngle(double a, double b)
{
        // get direction
        double dir = b%360 - a%360.0;

        // convert from -360 to 360 to -180 to 180
        if (Math.abs(dir) > 180.0)
        {
                dir = -(Math.signum(dir) * 360.0) + dir;
        }
        return dir;
}
  public void TurnMotor6(double wantedDegree) {
   
    double currentDegree = (CANcoder1.getAbsolutePosition().getValueAsDouble())*360;
    double aDifference = (wantedDegree-currentDegree);
    double bDifference =  (wantedDegree-(currentDegree+180)%360);
    //if(currentDegree)
   // if(aDifference>=180){aDifference=-(360-aDifference);}
   
   if(!(currentDegree>=wantedDegree-20&& currentDegree<=wantedDegree+20)){}//if(bDifference>=180){bDifference=-(360-bDifference);}
    double difference=0;
   //motor1.set(1);

   SmartDashboard.putNumber("current",currentDegree);
   SmartDashboard.putNumber("wanted",wantedDegree);


       while (!(currentDegree>=wantedDegree-10 && currentDegree<=wantedDegree+10) || !((currentDegree+180)%180>=wantedDegree-10&& (currentDegree+180)%180<=wantedDegree+10)) {
       
        if(currentDegree>=wantedDegree-20&& currentDegree<=wantedDegree+20 || (currentDegree+180)%180>=wantedDegree-20&& (currentDegree+180)%180<=wantedDegree+20){break;}
      
        if(Math.abs(aDifference)>=Math.abs(bDifference)){
          difference = aDifference;
        }
        else{difference=bDifference;}
      
double test = closestAngle(wantedDegree,currentDegree);
difference=closestAngle(wantedDegree,currentDegree);
// if(wantedDegree>currentDegree){difference*=-1;}

        SmartDashboard.putNumber("current",currentDegree);
        SmartDashboard.putNumber("wanted",wantedDegree);
        SmartDashboard.putNumber("aDifference",aDifference);
        SmartDashboard.putNumber("bDifference",bDifference);
       
        SmartDashboard.putNumber("Difference",difference);

if(difference>=180-difference){difference=(180-difference)*-1;}
difference=closestAngle(wantedDegree,currentDegree);
if(difference>=90){difference=180-difference;}
        motor6.set((difference/Math.abs(difference)*(1-1/Math.abs(difference)))/2);
    
        currentDegree = ((CANcoder1.getAbsolutePosition().getValueAsDouble())*360);
      
  if(currentDegree>=wantedDegree-20&& currentDegree<=wantedDegree+20 ){break;}
       
      }      
motor6.set(0);
    }
      



  public void TurnMotor7(int wantedDegree) {
   
    double currentDegree = (CANcoder2.getAbsolutePosition().getValueAsDouble())*360;
    double difference = wantedDegree-currentDegree;
    int test=1;
    SmartDashboard.putNumber("isWorking",test);
   //motor1.set(1);

       while (!(currentDegree>=wantedDegree-10 && currentDegree<=wantedDegree+10)) {
      
      motor7.set(difference/Math.abs(difference)/10);
      currentDegree = (CANcoder2.getAbsolutePosition().getValueAsDouble())*360;
      difference = wantedDegree-currentDegree;
      SmartDashboard.putNumber("isWorking",test);
      SmartDashboard.putNumber("difference",difference);
      SmartDashboard.putNumber("current",currentDegree);
      SmartDashboard.putNumber("wanted",wantedDegree);
      test++;

    }
    
    motor7.set(0);
    currentDegree=wantedDegree;
  } 
  
  public void TurnMotor8(int wantedDegree) {
   
    double currentDegree = (CANcoder3.getAbsolutePosition().getValueAsDouble())*360;
    double difference = wantedDegree-currentDegree;
    int test=1;
    SmartDashboard.putNumber("isWorking",test);
   //motor1.set(1);
 double speed=0;
       while (!(currentDegree>=wantedDegree-10 && currentDegree<=wantedDegree+10)) {
        difference = wantedDegree-currentDegree;
        if(difference>180){speed = -0.1;}
        else{speed = 0.1;}
      motor8.set(speed);
      currentDegree = (CANcoder3.getAbsolutePosition().getValueAsDouble())*360;
 currentDegree=wantedDegree;
      SmartDashboard.putNumber("isWorking",test);
      SmartDashboard.putNumber("difference",difference);
      SmartDashboard.putNumber("current",currentDegree);
      test++;
      if(difference>=wantedDegree-1 && difference<=1+wantedDegree){break;}
    }

    motor8.set(0);
  } 
  public void TurnMotor9(int wantedDegree) {
   
    double currentDegree = (CANcoder4.getAbsolutePosition().getValueAsDouble())*360;
    double difference = wantedDegree-currentDegree;
    int test=1;
    SmartDashboard.putNumber("isWorking",test);
   //motor1.set(1);
   
      while (!(currentDegree>=wantedDegree-10 && currentDegree<=wantedDegree+10)) {
      
      motor9.set(difference/Math.abs(difference)/10);
      currentDegree = (CANcoder4.getAbsolutePosition().getValueAsDouble())*360;
      difference = wantedDegree-currentDegree;
      SmartDashboard.putNumber("isWorking",test);
      SmartDashboard.putNumber("difference",difference);
      SmartDashboard.putNumber("current",currentDegree);
      test++;
      if(difference>=wantedDegree-1 && difference<=1+wantedDegree){break;}
    }

    motor9.set(0);
  }   
 

  public void turnAll(int wantedDegree) {
    TurnMotor6(wantedDegree);
    TurnMotor7(wantedDegree);
    TurnMotor8(wantedDegree);
    TurnMotor9(wantedDegree);

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
  