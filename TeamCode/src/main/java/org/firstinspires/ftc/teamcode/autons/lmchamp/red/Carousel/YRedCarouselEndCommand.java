package org.firstinspires.ftc.teamcode.autons.lmchamp.red.Carousel;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;

public class YRedCarouselEndCommand extends SequentialCommandGroup {
    public YRedCarouselEndCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, Camera camera, SensorColor sensorColor, WobbleGoal wobbleGoal) {

        addCommands();
    }
}