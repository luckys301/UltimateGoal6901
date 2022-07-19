package org.firstinspires.ftc.teamcode.autons.lm2.red.Carousel;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DropFreightCommands.DropFreightCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.AutoLiftResetCommand;
import org.firstinspires.ftc.teamcode.commands.CarouselCommand.RightCarouselCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.LiftLowCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class RedCarouselCommandL extends SequentialCommandGroup {
    public RedCarouselCommandL(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, Carousel carousel) {
        //declare variables here


        addCommands(
                new DriveForwardCommand(drivetrain, -24),
                new TurnToCommand(drivetrain, -60, true),
                new LiftLowCommand(lift, shooterFlipper),
                new WaitCommand(1000),

                new KindaSlowDriveForwardCommand(drivetrain, -6.5),
                new DropFreightCommand(shooterFlipper, drivetrain),
                new WaitCommand(3000),
                new DriveForwardCommand(drivetrain, 3),
                new InstantCommand(shooterFlipper::armUp, shooterFlipper),

                new TurnToCommand(drivetrain, 360),
                new AutoLiftResetCommand(shooterFlipper, lift),
                new DriveForwardCommand(drivetrain, 25),
                new TurnToCommand(drivetrain, -90,true),
                new DriveForwardCommand(drivetrain,20),

                new WaitCommand(1000),
                new KindaSlowDriveForwardCommand(drivetrain, 3),
                new RightCarouselCommand(carousel, drivetrain),

                new TurnToCommand(drivetrain, 180),
                new DriveForwardCommand(drivetrain, 25),
                new InstantCommand(shooterFlipper::armUp, shooterFlipper)
        );
    }
}