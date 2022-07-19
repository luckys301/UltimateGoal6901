package org.firstinspires.ftc.teamcode.autons.lm2.red.Warehouse;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DropFreightCommands.DropFreightCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.AutoLiftResetCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.LiftLowCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.KindaSlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class RedWarehouseCommandL extends SequentialCommandGroup {
    public RedWarehouseCommandL(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper) {
        //declare variables here


        addCommands(
                new InstantCommand(shooterFlipper::armUp, shooterFlipper),

                new DriveForwardCommand(drivetrain, -2),
                new TurnToCommand(drivetrain, 50, true),
                //original 60
                new LiftLowCommand(lift, shooterFlipper),
                new WaitCommand(1000),

                new KindaSlowDriveForwardCommand(drivetrain, -21.5),

                new DropFreightCommand(shooterFlipper, drivetrain),
                new WaitCommand(1000),
                new InstantCommand(shooterFlipper::armUp, shooterFlipper),

                new TurnToCommand(drivetrain, 0),
                new AutoLiftResetCommand(shooterFlipper, lift),
                new DriveForwardCommand(drivetrain, 23),
                new TurnCommand(drivetrain,85),
                new DriveForwardCommand(drivetrain, 45)
        );
    }
}