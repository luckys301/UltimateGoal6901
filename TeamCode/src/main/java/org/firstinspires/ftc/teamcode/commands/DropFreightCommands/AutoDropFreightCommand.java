package org.firstinspires.ftc.teamcode.commands.DropFreightCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class AutoDropFreightCommand extends SequentialCommandGroup {
    private ShooterFlipper shooterFlipper;
    public AutoDropFreightCommand(ShooterFlipper shooterFlipper, Drivetrain drivetrain){
        addRequirements(shooterFlipper, drivetrain);
        addCommands(
                new InstantCommand(shooterFlipper::boxAutoPush),
                new WaitCommand(60)
        );
    }

}
