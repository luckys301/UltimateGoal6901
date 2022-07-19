package org.firstinspires.ftc.teamcode.autons;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.autons.lmchamp.blue.Carousel.YBlueCarouselCommand;
import org.firstinspires.ftc.teamcode.driveTrain.MatchOpMode;
import org.firstinspires.ftc.teamcode.driveTrain.SampleTankDrive;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

@Autonomous(name = "TestAutonWithoutCam", group = "RED/BLUE")
public class TestAutonWithoutCam extends MatchOpMode {
public static double startPoseX = 0;
public static double startPoseY = 0;
public static double startPoseHeading = 0;

// Motors
private MotorEx leftFront, leftRear, rightRear, rightFront;
private MotorEx intakeMotor;
private ServoEx intakeServo;
private MotorEx liftMotor;
private CRServo carouselServo;
private ServoEx dropServo, armServo;
private ServoEx capArmServo, realCapArmServo, clawServo;

// Gamepad
private GamepadEx driverGamepad;
// Subsystems
private Drivetrain drivetrain;
private Intake intake;
private Shooter lift;
private ShooterFlipper shooterFlipper;
private Camera camera;
private WobbleGoal wobbleGoal;
private SensorColor sensorColor;

@Override
public void robotInit() {
    drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap), telemetry);
    drivetrain.init();
    intake = new Intake(intakeMotor, intakeServo, telemetry, hardwareMap);
    lift = new Shooter(liftMotor, liftMotor, telemetry, hardwareMap);
    shooterFlipper = new ShooterFlipper(armServo, dropServo, telemetry, hardwareMap);
    camera = new Camera(hardwareMap, telemetry);
    wobbleGoal = new WobbleGoal(clawServo, capArmServo, realCapArmServo, telemetry, hardwareMap);
    liftMotor = new MotorEx(hardwareMap, "lift");
    sensorColor = new SensorColor(hardwareMap, telemetry, "colorSensor");
}

public void matchStart()
    {
        schedule(new SequentialCommandGroup(
                new YBlueCarouselCommand(drivetrain, intake, lift, shooterFlipper, camera, sensorColor, wobbleGoal))
//        new YRedCarouselCommand(drivetrain, intake, lift, armServos, carousel, sensorColor, capServos))

//                //High
//                new InstantCommand(capServos::autoHigh),
//                new SplineCommand(drivetrain, new Vector2d(23.5,26), Math.toRadians(10)),
//                new CRedWarehouseCommand(drivetrain, intake, lift, armServos, sensorColor, capServos))
        );
    }}