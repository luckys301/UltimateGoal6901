package org.firstinspires.ftc.teamcode.commands.LiftCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class AutoLiftResetCommand extends SequentialCommandGroup {
        public AutoLiftResetCommand(ShooterFlipper shooterFlipper, Shooter lift){
        addCommands(
                new InstantCommand(lift::liftResting, lift),
                new InstantCommand(shooterFlipper::armHome, shooterFlipper),
                new InstantCommand(shooterFlipper::boxOpen, shooterFlipper)

        );
    }

}
