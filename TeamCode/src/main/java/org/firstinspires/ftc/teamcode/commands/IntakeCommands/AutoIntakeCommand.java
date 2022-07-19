package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class AutoIntakeCommand extends SequentialCommandGroup {

    public AutoIntakeCommand(Shooter lift, Intake intake, ShooterFlipper shooterFlipper, Drivetrain drivetrain, SensorColor sensorColor) {
        addRequirements(lift, intake, shooterFlipper, drivetrain, sensorColor);
        addCommands(
                new WaitUntilCommand(sensorColor::freightInBox).withTimeout(9),
                new ConditionalCommand(
                        new SequentialCommandGroup(
                                new InstantCommand(shooterFlipper::boxClose),
                                new InstantCommand(shooterFlipper::armAutoDrop),
                                new InstantCommand(intake::outtake),
                                new DriveForwardCommand(drivetrain, -2)
                        ),
                        new SequentialCommandGroup(
                                new DriveForwardCommand(drivetrain,5),
                                //new WaitCommand(100),
                                new InstantCommand(shooterFlipper::boxClose),
                                new InstantCommand(shooterFlipper::armAutoDrop),
                                new InstantCommand(intake::outtake),
                                new DriveForwardCommand(drivetrain, -6)
                        ),
                        sensorColor::freightInBox
                ),
                new InstantCommand(shooterFlipper::boxClose)

        );
    }
}