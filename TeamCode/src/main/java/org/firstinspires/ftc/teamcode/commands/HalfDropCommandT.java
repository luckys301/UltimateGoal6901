package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class HalfDropCommandT extends SequentialCommandGroup {
    private ShooterFlipper shooterFlipper;
    public HalfDropCommandT(ShooterFlipper shooterFlipper) {
        addRequirements(shooterFlipper);
        addCommands(
                new InstantCommand(shooterFlipper::boxClose, shooterFlipper),
                new InstantCommand(shooterFlipper::armHalfDrop, shooterFlipper)
        );
    }
}
