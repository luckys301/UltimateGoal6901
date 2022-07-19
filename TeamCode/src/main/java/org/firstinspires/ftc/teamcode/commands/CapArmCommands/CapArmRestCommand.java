package org.firstinspires.ftc.teamcode.commands.CapArmCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;

public class CapArmRestCommand extends SequentialCommandGroup {
    public CapArmRestCommand(WobbleGoal wobbleGoal) {
        addCommands(
                new InstantCommand(wobbleGoal::clawClose, wobbleGoal),
                new InstantCommand(wobbleGoal::capReset, wobbleGoal)
        );
    }}