package org.firstinspires.ftc.teamcode.autons.lm2.blue.Warehouse;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DropFreightCommands.DropFreightCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.AutoLiftResetCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.LiftMidCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class BlueWarehouseCommandR extends SequentialCommandGroup {
    public BlueWarehouseCommandR(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper) {
        //declare variables here


        addCommands(
                new InstantCommand(shooterFlipper::armUp, shooterFlipper),

                new DriveForwardCommand(drivetrain, -24),
                new TurnToCommand(drivetrain, 298),
                new LiftMidCommand(lift, shooterFlipper),
                new WaitCommand(1000),

                new KindaSlowDriveForwardCommand(drivetrain, -4.5),
                new DropFreightCommand(shooterFlipper, drivetrain),
                new KindaSlowDriveForwardCommand(drivetrain, -0.5),
                new WaitCommand(1000),
                new InstantCommand(shooterFlipper::armUp, shooterFlipper),

                new TurnToCommand(drivetrain, 0, true),
                new AutoLiftResetCommand(shooterFlipper, lift),
                new DriveForwardCommand(drivetrain, 22),
                new TurnCommand(drivetrain,90),
                new DriveForwardCommand(drivetrain, -40)
        );
    }
}