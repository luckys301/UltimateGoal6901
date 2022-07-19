package org.firstinspires.ftc.teamcode.autons.lmchamp.red.Carousel;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.CarouselCommand.RightCarouselCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class YRedCarouselCommand extends SequentialCommandGroup {
    public YRedCarouselCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, Camera camera, SensorColor sensorColor, WobbleGoal wobbleGoal) {

        addCommands(
                new DriveForwardCommand(drivetrain,10),
                new TurnToCommand(drivetrain, 90, true),
                new DriveForwardCommand(drivetrain, 20),
                new TurnToCommand(drivetrain, 130),

                new DriveForwardCommand(drivetrain, 3),
                new KindaSlowDriveForwardCommand(drivetrain, 4),
                new RightCarouselCommand(camera, drivetrain),

                new DriveForwardCommand(drivetrain, -4),
                new TurnToCommand(drivetrain, 360, true),
                new DriveForwardCommand(drivetrain, 33)
                );
    }
}