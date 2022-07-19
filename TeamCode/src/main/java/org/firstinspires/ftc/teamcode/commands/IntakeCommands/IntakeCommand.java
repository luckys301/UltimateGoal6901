package org.firstinspires.ftc.teamcode.commands.IntakeCommands;

        import com.arcrobotics.ftclib.command.InstantCommand;
        import com.arcrobotics.ftclib.command.SequentialCommandGroup;
        import com.arcrobotics.ftclib.command.WaitCommand;

        import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
        import org.firstinspires.ftc.teamcode.subsystems.Intake;
        import org.firstinspires.ftc.teamcode.subsystems.Shooter;
        import org.firstinspires.ftc.teamcode.subsystems.SensorColor;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand(Shooter lift, Intake intake, SensorColor colorSensor, ShooterFlipper shooterFlipper) {
        addRequirements(lift, intake, shooterFlipper);
        addCommands(
                new InstantCommand(intake::intake, intake),
                new InstantCommand(intake::stop),
                new InstantCommand(intake::outtake, intake),
                new WaitCommand(500),
                new InstantCommand(intake::stop, intake)

        );
    }
}