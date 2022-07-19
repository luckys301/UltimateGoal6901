package org.firstinspires.ftc.teamcode.TeleOps;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.InstantCommand;
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
@TeleOp(name = "Red TeleOp")
public class RedTeleOp extends MatchOpMode {
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
    private Shooter lift;
    private Intake intake;
    private Camera camera;
    private ShooterFlipper shooterFlipper;
    private WobbleGoal wobbleGoal;

    // Buttons
    private Button intakeTrigger, outtakeTrigger;
    private Button slowModeBumper;
    public Button liftManualUpButton, liftManualDownButton;
    public Button liftLowButton, liftMidButton, liftHighButton;
    public Button carouselRightTrigger, carouselLeftTrigger;
    public Button resetEveryThingButton;
    public Button dropFreightButton, upBoxButton;
    public Button intakeClawUpButton;
    public Button intakeClawDownButton;
    public Button outRealCapHomeTrigger;
    public Button inRealCapHomeTrigger;
    public Button realClawHomeButton, realClawMidButton, realClawLowButton;
    public Button slideResetButton;


    @Override
    public void robotInit() {
        driverGamepad = new GamepadEx(gamepad1);    //Used for button config
        operatorGamepad = new GamepadEx(gamepad2);

        //Subsystems
        sensorColor = new SensorColor(hardwareMap, telemetry, "colorSensor");
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap), telemetry);
        lift = new Shooter(liftMotor, liftMotor2, telemetry, hardwareMap);
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



        liftManualUpButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_RIGHT)     //Manual Lift Up
                .whenPressed(lift::liftManual)
                .whenReleased(lift::stopMotor));
        liftManualDownButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_LEFT)    //Manual Lift Down
                .whenPressed(lift::lowerLiftManual)
                .whenReleased(lift::stopMotor));

        slideResetButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.BACK))    //Reset encoders (hopefully)
                .whenPressed(lift::reset);

        resetEveryThingButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.DPAD_DOWN))  //Resets Lift/Servos
//                .whenPressed(new LiftResetCommandT(shooterFlipper, lift))
                .whenPressed(new InstantCommand(lift::liftResting, lift));
//                .whenPressed(new InstantCommand(wobbleGoal::clawOpen));

        liftLowButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.X)   //Lift Low
                .whenPressed(lift::liftLow));
        liftMidButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.B)   //Lift Mid
                .whenPressed(lift::liftMid));
        liftHighButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.Y)  //Lift Shared High
                .whenPressed(lift::liftSharedHigh));

//        dropFreightButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.LEFT_BUMPER))    //Outtake Freight
//                .whenPressed(new TeleOpDropFreightCommand(shooterFlipper,drivetrain));
//        dropFreightButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.LEFT_BUMPER))    //Outtake Freight Driver
//                .whenPressed(new TeleOpDropFreightCommand(shooterFlipper,drivetrain));
//        upBoxButton = (new GamepadButton(operatorGamepad, GamepadKeys.Button.A))    //Move Lift Box Up
//                .whenPressed(new HalfDropCommandT(shooterFlipper));


        carouselLeftTrigger = (new GamepadTrigger(operatorGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER)   //Carousel Left
                .whileHeld(camera::carouselLeft)
                .whenReleased(camera::stop));
        carouselRightTrigger = (new GamepadTrigger(operatorGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)   //Carousel Right
                .whileHeld(camera::carouselRight)
                .whenReleased(camera::stop));



//        intakeClawUpButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_UP)          //Up Intake Claw
//                .whileHeld(shooterFlipper::boxUp));
//        intakeClawDownButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_DOWN)      //Down Intake Claw
//                .whileHeld(shooterFlipper::boxDown));
//
//
//
//        outRealCapHomeTrigger = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_RIGHT)    //Out Cap Servo
//                .whenPressed(capServos::addToCap));
//        inRealCapHomeTrigger = (new GamepadButton(driverGamepad, GamepadKeys.Button.DPAD_LEFT)      //In Cap Servo
//                .whenPressed(capServos::subtractToCap));
//
//        realClawHomeButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.Y)    //Home
//                .whenPressed(capServos::realCapHome));
//        realClawMidButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.X)     //Mid
//                .whenPressed(capServos::realCapMid));
//        realClawMidButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.B)     //Mid
//                .whenPressed(capServos::realCapMid));
//        realClawLowButton = (new GamepadButton(driverGamepad, GamepadKeys.Button.A)     //Low
//                .whenPressed(capServos::realCapLow));
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
