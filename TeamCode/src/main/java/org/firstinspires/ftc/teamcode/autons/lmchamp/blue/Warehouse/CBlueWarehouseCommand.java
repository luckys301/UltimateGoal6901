package org.firstinspires.ftc.teamcode.autons.lmchamp.blue.Warehouse;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.CapArmCommands.CapArmWarehouseCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.DropFreightCommands.AutoDropFreightCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommands.AutoIntakeCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.AutoLiftResetCommand;
import org.firstinspires.ftc.teamcode.commands.LiftCommands.LiftHighCommand;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class CBlueWarehouseCommand extends SequentialCommandGroup {
    public CBlueWarehouseCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, SensorColor sensorColor, WobbleGoal wobbleGoal) {
        //declare variables here
        addCommands(
                new CapArmWarehouseCommand(wobbleGoal, drivetrain),

                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-4.5,37), Math.toRadians(90)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 82),
                new SplineCommand(drivetrain, new Vector2d(18.5,   -18), Math.toRadians(2), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-6.5, 43), Math.toRadians(90)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 83  ),
                new SplineCommand(drivetrain, new Vector2d(17.5,-13.5), Math.toRadians(5), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-7.8, 47), Math.toRadians(90)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 84),
                new SplineCommand(drivetrain, new Vector2d(18,-8.5), Math.toRadians(4), true),
//                new TurnToCommand(drivetrain, 180),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new SplineCommand(drivetrain, new Vector2d(-5,49), Math.toRadians(90))
        );
    }
}