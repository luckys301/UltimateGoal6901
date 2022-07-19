package org.firstinspires.ftc.teamcode.autons.lm2.blue.Warehouse;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SelectCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.Util;
import org.firstinspires.ftc.teamcode.driveTrain.MatchOpMode;
import org.firstinspires.ftc.teamcode.driveTrain.SampleTankDrive;
import org.firstinspires.ftc.teamcode.pipelines.TeamMarkerPipeline;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.Vision;

import java.util.HashMap;
import java.util.logging.Level;
@Disabled
@Autonomous(name = "Blue Warehouse", group = "BLUE")
public class BlueWarehouseAuton extends MatchOpMode {
public static double startPoseX = 0;
public static double startPoseY = 0;
public static double startPoseHeading = 0;

// Motors
private MotorEx leftFront, leftRear, rightRear, rightFront;
private MotorEx intakeMotor;
private ServoEx intakeServo;
private MotorEx liftMotor, liftMotor2;
private CRServo carouselServo;
private ServoEx dropServo, armServo;

// Gamepad
private GamepadEx driverGamepad;

// Subsystems
private Drivetrain drivetrain;
private Intake intake;
private Shooter lift;
private Vision vision;
private ShooterFlipper shooterFlipper;
private Carousel carousel;

@Override
public void robotInit() {
    // Subsystems
    drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap), telemetry);
    drivetrain.init();
    intakeMotor = new MotorEx(hardwareMap, "intake");
    liftMotor = new MotorEx(hardwareMap, "lift", Motor.GoBILDA.RPM_117);
    liftMotor2 = new MotorEx(hardwareMap, "lift2", Motor.GoBILDA.RPM_117);

    //drivetrain.setPoseEstimate(Trajectories.BlueLeftTape.startPose);
    vision = new Vision(hardwareMap, "Webcam 1", telemetry);
    armServo = new SimpleServo(hardwareMap,"arm", 0, 360);
    dropServo = new SimpleServo(hardwareMap, "drop",0,360);

    drivetrain.setPoseEstimate(new Pose2d(startPoseX, startPoseY, Math.toRadians(startPoseHeading)));
    intake = new Intake(intakeMotor, intakeServo, telemetry, hardwareMap);
    //lift = new Lift(liftMotor, liftMotor2, telemetry, hardwareMap);
    lift = new Shooter(liftMotor, liftMotor2, telemetry, hardwareMap);
    //armServos = new ArmServos(armServo, dropServo, telemetry, hw);
}

@Override
public void disabledPeriodic() {
    Util.logger(this, telemetry, Level.INFO, "Current Position", vision.getCurrentPosition());
    vision.periodic();
}

@Override
public void matchStart() {
    schedule(
            new SelectCommand(new HashMap<Object, Command>() {{
                put(TeamMarkerPipeline.Position.LEFT, new SequentialCommandGroup(
                        new BlueWarehouseCommandL(drivetrain, intake, lift, shooterFlipper))
                );
                put(TeamMarkerPipeline.Position.MIDDLE, new SequentialCommandGroup(
                        new BlueWarehouseCommandC(drivetrain, intake, lift, shooterFlipper))
                );
                put(TeamMarkerPipeline.Position.RIGHT, new SequentialCommandGroup(
                        new BlueWarehouseCommandR(drivetrain, intake, lift, shooterFlipper))
                );
            }}, vision::getCurrentPosition)
    );
    }
}