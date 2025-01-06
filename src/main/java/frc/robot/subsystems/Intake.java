// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Intake extends SubsystemBase {
  private SparkFlex intakeSparkFlex;
  private static Intake instance;

  public Intake() {
    this.intakeSparkFlex = new SparkFlex(Constants.INTAKE_SPARK_FLEX_ID, null);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void inOutTake(double volt) {
    if(volt >= -12 && volt <= 12)
    {
      intakeSparkFlex.setVoltage(volt);
    }
  }
  
  public void stopIntake()
  {
    intakeSparkFlex.stopMotor();
  }

  public static synchronized Intake getInstance() {
    if (instance == null) {
        instance = new Intake();
    }
    return instance;
  }
}
