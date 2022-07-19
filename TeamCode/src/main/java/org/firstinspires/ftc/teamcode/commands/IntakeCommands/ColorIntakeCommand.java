package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class ColorIntakeCommand extends SequentialCommandGroup {

    public ColorIntakeCommand(Intake intake, SensorColor colorSensor, ShooterFlipper shooterFlipper) {
        addRequirements(intake, colorSensor, shooterFlipper);
        addCommands(
                new ConditionalCommand(
                        new SequentialCommandGroup(
                                new InstantCommand(shooterFlipper::armUp),
                                new InstantCommand(shooterFlipper::boxClose),
                                new InstantCommand(intake::stop),
                                new WaitCommand(500),
                                new InstantCommand(shooterFlipper::armHalfDrop)),

                        new InstantCommand(),
                        () -> (colorSensor.freightInBox()) && (ShooterFlipper.boxCanMove)
                )
        );
    }
}