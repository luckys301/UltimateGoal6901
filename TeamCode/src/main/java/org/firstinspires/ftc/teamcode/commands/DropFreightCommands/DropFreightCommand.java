package org.firstinspires.ftc.teamcode.commands.DropFreightCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class DropFreightCommand extends SequentialCommandGroup {
    private ShooterFlipper shooterFlipper;

    public DropFreightCommand(ShooterFlipper shooterFlipper, Drivetrain drivetrain){
        addRequirements(shooterFlipper, drivetrain);
        addCommands(
                new InstantCommand(shooterFlipper::armDrop),
                new InstantCommand(shooterFlipper::boxAutoPush)
                );
    }

}
