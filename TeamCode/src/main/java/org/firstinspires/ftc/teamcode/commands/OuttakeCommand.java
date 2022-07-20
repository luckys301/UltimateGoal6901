package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;

public class OuttakeCommand extends SequentialCommandGroup {

    public OuttakeCommand(Shooter shooter, Intake intake, SensorColor colorSensor, ShooterFlipper shooterFlipper) {
        addRequirements(shooter, intake, shooterFlipper);
        addCommands(
                new InstantCommand(shooter::halfSpeed, shooter),
                new WaitCommand(500),
                new FlipperInOutCommand(shooterFlipper),
                new WaitCommand(500),
                new FlipperInOutCommand(shooterFlipper),
                new WaitCommand(500),
                new FlipperInOutCommand(shooterFlipper),
                new InstantCommand(intake::stop, intake)
        );
    }
}