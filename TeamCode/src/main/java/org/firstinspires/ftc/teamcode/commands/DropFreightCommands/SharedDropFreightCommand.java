package org.firstinspires.ftc.teamcode.commands.DropFreightCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class SharedDropFreightCommand extends SequentialCommandGroup {
    private ShooterFlipper shooterFlipper;

    public SharedDropFreightCommand(ShooterFlipper shooterFlipper, Drivetrain drivetrain){
        addRequirements(shooterFlipper, drivetrain);
        addCommands(
                new InstantCommand(shooterFlipper::armShared),
                new InstantCommand(shooterFlipper::boxPush),
                new DriveForwardCommand(drivetrain, 4)
        );
    }

}
