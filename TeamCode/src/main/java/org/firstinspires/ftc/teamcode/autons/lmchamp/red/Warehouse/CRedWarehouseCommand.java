package org.firstinspires.ftc.teamcode.autons.lmchamp.red.Warehouse;

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

public class CRedWarehouseCommand extends SequentialCommandGroup {
    public CRedWarehouseCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, SensorColor sensorColor, WobbleGoal wobbleGoal) {
        //declare variables here
        addCommands(
                new CapArmWarehouseCommand(wobbleGoal, drivetrain),

                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-8,-34), Math.toRadians(270)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 275),
                new SplineCommand(drivetrain, new Vector2d(18.5,18.2), Math.toRadians(6), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-8,-39), Math.toRadians(270)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 272),
                new SplineCommand(drivetrain, new Vector2d(16.5,17.3), Math.toRadians(0), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new InstantCommand(intake::autoIntake),
                new SplineCommand(drivetrain, new Vector2d(-8,-42), Math.toRadians(270)),

                new AutoIntakeCommand(lift, intake, shooterFlipper, drivetrain, sensorColor),
                new LiftHighCommand(lift, shooterFlipper),
                new TurnToCommand(drivetrain, 270),
                new SplineCommand(drivetrain, new Vector2d(15.5,15.9), Math.toRadians(357), true),
                new AutoDropFreightCommand(shooterFlipper, drivetrain),

                new AutoLiftResetCommand(shooterFlipper, lift),
                new SplineCommand(drivetrain, new Vector2d(-8,-45), Math.toRadians(270))
        );
    }
}