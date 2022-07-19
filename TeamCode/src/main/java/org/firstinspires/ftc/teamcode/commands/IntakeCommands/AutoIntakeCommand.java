package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class AutoIntakeCommand extends SequentialCommandGroup {

    public AutoIntakeCommand(Shooter lift, Intake intake, ShooterFlipper shooterFlipper, Drivetrain drivetrain, SensorColor sensorColor) {
        addRequirements(lift, intake, shooterFlipper, drivetrain, sensorColor);
        addCommands(
//                new WaitUntilCommand(sensorColor::freightInBox).withTimeout(9),
//                new ConditionalCommand(
//                        new SequentialCommandGroup(
//                                new InstantCommand(intake::outtake),
//                                new DriveForwardCommand(drivetrain, -2)
//                        ),
//                        new SequentialCommandGroup(
//                                new DriveForwardCommand(drivetrain,5),
//                                new InstantCommand(intake::outtake),
//                                new DriveForwardCommand(drivetrain, -6)
//                        ),
//                        sensorColor::freightInBox
//                ),
//                new InstantCommand(shooterFlipper::boxClose)

        );
    }
}