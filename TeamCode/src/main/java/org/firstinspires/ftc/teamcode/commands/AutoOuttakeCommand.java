package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class AutoOuttakeCommand extends SequentialCommandGroup {

    public AutoOuttakeCommand(Shooter lift, Intake intake, ShooterFlipper shooterFlipper, Drivetrain drivetrain) {
        addRequirements(lift, intake, shooterFlipper, drivetrain);
        addCommands(
                new DriveForwardCommand(drivetrain, -4),
                new WaitCommand(500)
        );
    }
}