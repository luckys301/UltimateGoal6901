package org.firstinspires.ftc.teamcode.autons.lmchamp.blue.Carousel;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.CapArmCommands.CapArmCarouselCommand;
import org.firstinspires.ftc.teamcode.commands.CarouselCommand.LeftCarouselCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;
import org.firstinspires.ftc.teamcode.subsystems.Carousel;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class CBlueCarouselCommand extends SequentialCommandGroup {
    public CBlueCarouselCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, Carousel carousel, SensorColor sensorColor, WobbleGoal wobbleGoal) {

        addCommands(
                new DriveForwardCommand(drivetrain, 21),
                new TurnToCommand(drivetrain, 63, true),

                new DriveForwardCommand(drivetrain, 9.3),
                new CapArmCarouselCommand(wobbleGoal, drivetrain),

                new TurnToCommand(drivetrain, 270),
                new DriveForwardCommand(drivetrain, 26.8),

                new TurnToCommand(drivetrain, 180),
                new DriveForwardCommand(drivetrain, 7.5),

                new KindaSlowDriveForwardCommand(drivetrain, 5),
                new LeftCarouselCommand(carousel, drivetrain),

                new DriveForwardCommand(drivetrain,-17)
        );
    }
}
/*new DriveForwardCommand(drivetrain, 21),
                new TurnToCommand(drivetrain, 60, true),

                new DriveForwardCommand(drivetrain, 10.5),
                new CapArmAutoCommand(capServos, drivetrain),

                new TurnToCommand(drivetrain, 225),
                new DriveForwardCommand(drivetrain, 27),
                new KindaSlowDriveForwardCommand(drivetrain, 5),
                new LeftCarouselCommand(carousel, drivetrain),

                new DriveForwardCommand(drivetrain, -10),
                new TurnToCommand(drivetrain, 180),
                new DriveForwardCommand(drivetrain,-17.5),

                new TurnToCommand(drivetrain, 90),
                new DriveForwardCommand(drivetrain,-14)*/