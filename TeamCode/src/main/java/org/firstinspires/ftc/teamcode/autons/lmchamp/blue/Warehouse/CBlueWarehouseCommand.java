package org.firstinspires.ftc.teamcode.autons.lmchamp.blue.Warehouse;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;

public class CBlueWarehouseCommand extends SequentialCommandGroup {
    public CBlueWarehouseCommand(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, SensorColor sensorColor, WobbleGoal wobbleGoal) {
        addCommands();
    }
}