package org.firstinspires.ftc.teamcode.TeleOps;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.SharedSlowDriveCommand;
import org.firstinspires.ftc.teamcode.commands.FlipperInOutCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.ColorIntakeCommand;
import org.firstinspires.ftc.teamcode.driveTrain.MatchOpMode;
import org.firstinspires.ftc.teamcode.driveTrain.SampleTankDrive;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;

@Config
@TeleOp(name = "Blue TeleOp")
public class BlueTeleOp extends MatchOpMode {
    // Gamepads
    private GamepadEx driverGamepad, operatorGamepad;

    // Motors and Servos
    private ColorSensor colorSensor;
    private MotorEx leftFront,  leftRear, rightRear,  rightFront;
    private MotorEx liftMotor, liftMotor2;
    private MotorEx intakeMotor;

    private ServoEx intakeServo;
    private CRServo carouselServo;
    private ServoEx armServo, dropServo;

    private ServoEx capArmServo, realCapArmServo, clawServo;

    // Subsystems
    private SensorColor sensorColor;
    private Drivetrain drivetrain;
    private Shooter shooter;
    private Intake intake;
    private Camera camera;
    private ShooterFlipper shooterFlipper;
    private WobbleGoal wobbleGoal;

    // Buttons
    private Button intakeTrigger, outtakeTrigger;
    private Button slowModeBumper;
    private Button liftLowButton, liftMidButton, liftHighButton;
    private Button slideResetButton;
    private Button startShooterButton;
    private Button flipperInOutButton;

    @Override
    public void robotInit() {
        driverGamepad = new GamepadEx(gamepad1);    //Used for button config
        operatorGamepad = new GamepadEx(gamepad2);

        //Subsystems
        sensorColor = new SensorColor(hardwareMap, telemetry, "colorSensor");
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap), telemetry);
        shooter = new Shooter(liftMotor, liftMotor2, telemetry, hardwareMap);
        intake = new Intake(intakeMotor, intakeServo, telemetry, hardwareMap);
        camera = new Camera(hardwareMap, telemetry);
        shooterFlipper = new ShooterFlipper(armServo, dropServo, telemetry, hardwareMap);
        wobbleGoal = new WobbleGoal(clawServo, capArmServo, realCapArmServo, telemetry, hardwareMap);

        intake.setDefaultCommand(new ColorIntakeCommand(intake, sensorColor, shooterFlipper));   //Color Sensor default command
        drivetrain.setDefaultCommand(new DefaultDriveCommand(drivetrain, driverGamepad));   //Drivetrain default command
        drivetrain.init();
    }

    @Override
    public void configureButtons() {
        slowModeBumper = (new GamepadButton(driverGamepad, GamepadKeys.Button.RIGHT_BUMPER))    //Slowmode
                .whileHeld(new SharedSlowDriveCommand(drivetrain, driverGamepad));



        outtakeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)   //Outtake
                .whileHeld(intake::outtake)
                .whenReleased(intake::stop));
        intakeTrigger = (new GamepadTrigger(driverGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER)   //Intake
                .whileHeld(intake::intake)
                .whenReleased(intake::stop));


//        slideResetButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.BACK))    //Reset encoders (hopefully)
//                .whenPressed(shooter::reset);

        startShooterButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.X)   //Start Shooter
                .whenPressed(shooter::halfSpeed));
        flipperInOutButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.B)   //Start Shooter
                .whenPressed(new FlipperInOutCommand(shooterFlipper)));

        liftLowButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.X)   //Lift Low
                .whenPressed(shooter::liftLow));
        liftMidButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.B)   //Lift Mid
                .whenPressed(shooter::liftMid));
        liftHighButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.Y)  //Lift Shared High
                .whenPressed(shooter::liftSharedHigh));
    }

    @Override
    public void matchLoop() { }
    @Override
    public void disabledPeriodic() { }
    @Override
    public void matchStart() { }
    @Override
    public void robotPeriodic() {
        sensorColor.periodic();
    }
}
