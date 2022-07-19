package org.firstinspires.ftc.teamcode.autons.lmchamp.red.Carousel;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.CapArmCommands.CapArmCarouselCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class YRedCarouselEndCommand extends SequentialCommandGroup {
    public YRedCarouselEndCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, Carousel carousel, SensorColor sensorColor, WobbleGoal wobbleGoal) {

        addCommands(
                new TurnToCommand(drivetrain, -90, true),

                new DriveForwardCommand(drivetrain, 23.5),
                new CapArmCarouselCommand(wobbleGoal, drivetrain),

                new TurnToCommand(drivetrain, 90, false),
                new DriveForwardCommand(drivetrain, 18),
                new TurnToCommand(drivetrain, 180),
                new DriveForwardCommand(drivetrain, 16),

                new TurnToCommand(drivetrain, 268),
                new DriveForwardCommand(drivetrain, -16)
                );
    }
}