package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class ColorIntakeCommand extends SequentialCommandGroup {

    public ColorIntakeCommand(Intake intake, SensorColor colorSensor, ShooterFlipper shooterFlipper) {
        addRequirements(intake, colorSensor, shooterFlipper);
        addCommands(
//                new ConditionalCommand(
//                        new SequentialCommandGroup(
//                                new InstantCommand(shooterFlipper::flipperHome),
//
//                        new InstantCommand(),
//                        () -> (colorSensor.freightInBox()) && (ShooterFlipper.FLIPPER_HOME_POS)
//                )
        );
    }
}