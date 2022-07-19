package org.firstinspires.ftc.teamcode.commands.LiftCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class LiftMidCommand extends SequentialCommandGroup {
    private Shooter lift;

    public LiftMidCommand(Shooter lift, ShooterFlipper shooterFlipper){
        addCommands(
                new InstantCommand(lift::liftMid, lift),
                new InstantCommand(shooterFlipper::armDrop , shooterFlipper)
                );
        
    }   
}
