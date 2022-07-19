package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DropFreightCommands.DropFreightCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.LiftHighCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.AutoLiftResetCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class AutoOuttakeCommand extends SequentialCommandGroup {

    public AutoOuttakeCommand(Shooter lift, Intake intake, ShooterFlipper shooterFlipper, Drivetrain drivetrain) {
        addRequirements(lift, intake, shooterFlipper, drivetrain);
        addCommands(
                new LiftHighCommand(lift, shooterFlipper),
                new DropFreightCommand(shooterFlipper, drivetrain),
                new DriveForwardCommand(drivetrain, -4),
                new WaitCommand(500),
                new AutoLiftResetCommand(shooterFlipper, lift)
        );
    }
}