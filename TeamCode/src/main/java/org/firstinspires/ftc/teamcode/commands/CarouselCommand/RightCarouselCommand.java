package org.firstinspires.ftc.teamcode.commands.CarouselCommand;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;


public class RightCarouselCommand extends SequentialCommandGroup{
    private Camera camera;
    private Drivetrain drivetrain;

    public RightCarouselCommand(Camera camera, Drivetrain drivetrain){
        addCommands(
                new SlowestDriveForwardCommand(drivetrain, 10),
                new WaitCommand(3000)
        );
    }
}