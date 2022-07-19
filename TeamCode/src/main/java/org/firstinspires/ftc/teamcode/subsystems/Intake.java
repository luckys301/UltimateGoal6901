package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

@Config
public class Intake extends SubsystemBase {
    public static double INTAKE_SPEED = -0.75;
    public static double AUTO_INTAKE_SPEED = -0.5;
    public static double OUTTAKE_SPEED = 0.5;

    Telemetry telemetry;
    private MotorEx intakeMotorOne;
    private MotorEx intakeMotorTwo;


    public Intake(MotorEx intakeMotorOne, ServoEx intakeServo, Telemetry tl, HardwareMap hw) {
        this.intakeMotorOne = intakeMotorOne;
        this.telemetry = tl;
        this.intakeMotorOne = new MotorEx(hw, "intake1");

        this.intakeMotorTwo = intakeMotorTwo;
        this.telemetry = tl;
        this.intakeMotorTwo = new MotorEx(hw, "intake2");
    }

    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Intake Motor 1 Speed: ", intakeMotorOne.get());
        Util.logger(this, telemetry, Level.INFO, "Intake Motor 2 Speed: ", intakeMotorTwo.get());
    }

    private void setM1(double speed) {intakeMotorOne.set(speed);}
    private void setM2(double speed) {intakeMotorTwo.set(speed);}

    public void intake() {
        setM1(INTAKE_SPEED);
        setM2(INTAKE_SPEED);
    }
    public void autoIntake() {
        setM1(AUTO_INTAKE_SPEED);
        setM2(AUTO_INTAKE_SPEED);
    }
    public void outtake() {
        setM1(OUTTAKE_SPEED);
        setM2(OUTTAKE_SPEED);
    }
    public void stop() {
        intakeMotorOne.stopMotor();
        intakeMotorTwo.stopMotor();
    }


}
