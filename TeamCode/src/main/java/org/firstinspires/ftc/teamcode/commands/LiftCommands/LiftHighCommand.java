package org.firstinspires.ftc.teamcode.commands.LiftCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

public class LiftHighCommand extends SequentialCommandGroup {
    //private Lift lift;
    public LiftHighCommand(Shooter lift, ShooterFlipper shooterFlipper){
        addCommands(
                new InstantCommand(lift::liftAutoHigh, lift),
                new InstantCommand(shooterFlipper::armDrop , shooterFlipper)
                );
        
    }   
}
