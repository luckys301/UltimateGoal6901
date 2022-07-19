package org.firstinspires.ftc.teamcode.commands.CapArmCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

public class CapArmHighCommand extends SequentialCommandGroup {
    public CapArmHighCommand(WobbleGoal wobbleGoal, Drivetrain drivetrain) {

        addCommands(
                new InstantCommand(wobbleGoal::clawOpen, wobbleGoal),
                new WaitCommand(200),
                new DriveForwardCommand(drivetrain, -10.5),
                new TurnToCommand(drivetrain,180),
                new InstantCommand(wobbleGoal::capReset, wobbleGoal)
        );
    }}

