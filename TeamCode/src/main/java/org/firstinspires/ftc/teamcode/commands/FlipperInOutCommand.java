package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class FlipperInOutCommand extends SequentialCommandGroup {

    public FlipperInOutCommand(ShooterFlipper shooterFlipper) {
        addCommands(
                new InstantCommand(shooterFlipper::flipperPush, shooterFlipper),
                new WaitCommand(500),
                new InstantCommand(shooterFlipper::flipperHome, shooterFlipper)

        );
    }
}