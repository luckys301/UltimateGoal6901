package org.firstinspires.ftc.teamcode.autons.lm2.blue.Carousel;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class BlueCarouselCommandC extends SequentialCommandGroup {
    public BlueCarouselCommandC(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, Carousel carousel) {
        //declare variables here


        addCommands(
                //distance is in inches
                //Setup
//                new InstantCommand(shooterFlipper::armUp, shooterFlipper),
//
//                new DriveForwardCommand(drivetrain, -24),
//                new TurnToCommand(drivetrain, 68, true),
//                new LiftMidCommand(lift, shooterFlipper),
//                new WaitCommand(1000),
//
//                new KindaSlowDriveForwardCommand(drivetrain, -6.5),
//                new DropFreightCommand(shooterFlipper, drivetrain),
//                new WaitCommand(3000),
//                new DriveForwardCommand(drivetrain, 4),
//                new InstantCommand(shooterFlipper::armUp, shooterFlipper),
//
//                new TurnToCommand(drivetrain, 90),
//                new AutoLiftResetCommand(shooterFlipper, lift),
//
//                new DriveForwardCommand(drivetrain, 23.5)
        );
    }
}