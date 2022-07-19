package org.firstinspires.ftc.teamcode.autons.lmchamp.red.Warehouse;

import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.commands.CapArmCommands.CapArmWarehouseCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.SplineCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnCommand;
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

public class CRedWarehouseCommandLow extends SequentialCommandGroup {
    public CRedWarehouseCommandLow(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, SensorColor sensorColor, WobbleGoal wobbleGoal) {
        //NOT USED
        addCommands(
                new CapArmWarehouseCommand(wobbleGoal, drivetrain),

                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-8,-37), Math.toRadians(278)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 275),
                new SplineCommand(drivetrain, new Vector2d(19.2,17), Math.toRadians(6), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-8,-40), Math.toRadians(270)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 275),
                new SplineCommand(drivetrain, new Vector2d(15.5,15.2), Math.toRadians(355), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-8,-48), Math.toRadians(270)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 275),
                new SplineCommand(drivetrain, new Vector2d(13.5,13.7), Math.toRadians(357), true),
                new TurnCommand(drivetrain, -5),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new SplineCommand(drivetrain, new Vector2d(-8,-50), Math.toRadians(270))
        );
    }
}