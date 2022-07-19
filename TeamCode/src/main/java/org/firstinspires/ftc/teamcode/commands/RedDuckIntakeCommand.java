package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class RedDuckIntakeCommand extends SequentialCommandGroup {

    public RedDuckIntakeCommand(Shooter lift, Intake intake, ShooterFlipper shooterFlipper, Drivetrain drivetrain, SensorColor sensorColor) {
        addRequirements(lift, intake, shooterFlipper, drivetrain, sensorColor);
        addCommands(
                new WaitUntilCommand(sensorColor::freightInBox).withTimeout(700),
                new ConditionalCommand(
                        new SequentialCommandGroup(
                                new InstantCommand(intake::autoIntake),
                                new DriveForwardCommand(drivetrain, -8),

                                new WaitCommand(100),
                                new InstantCommand(shooterFlipper::boxClose),
                                new InstantCommand(shooterFlipper::armAutoDrop),
                                new TurnToCommand(drivetrain, 180),
                                new DriveForwardCommand(drivetrain,14),

                                new TurnToCommand(drivetrain, 168),
                                new DriveForwardCommand(drivetrain,-9)
                        ),
                        new SequentialCommandGroup(
                                new TurnToCommand(drivetrain, 130),
                                new DriveForwardCommand(drivetrain, 5),
                                new InstantCommand(shooterFlipper::boxClose),
                                new InstantCommand(shooterFlipper::armAutoDrop),

                                new DriveForwardCommand(drivetrain, -8),
                                new TurnToCommand(drivetrain, 180),
                                new DriveForwardCommand(drivetrain,-14),

                                new TurnToCommand(drivetrain, 270),
                                new DriveForwardCommand(drivetrain,-9)
                        ),
                        sensorColor::freightInBox
                ),
                new InstantCommand(shooterFlipper::boxClose)

        );
    }
}
