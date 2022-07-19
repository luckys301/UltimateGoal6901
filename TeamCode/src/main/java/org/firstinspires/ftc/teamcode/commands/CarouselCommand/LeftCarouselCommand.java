package org.firstinspires.ftc.teamcode.commands.CarouselCommand;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.SlowestDriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

//nowadays lance isnt a very common name, but in older times people were named lance a lot
public class LeftCarouselCommand extends SequentialCommandGroup{
    private Camera camera;
    private Drivetrain drivetrain;

    public LeftCarouselCommand(Camera camera, Drivetrain drivetrain){
        addCommands(
                new SlowestDriveForwardCommand(drivetrain, 10),
                new WaitCommand(4000)
        );
    }
}