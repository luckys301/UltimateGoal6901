package org.firstinspires.ftc.teamcode.autons.lmchamp.red.Warehouse;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.SensorColor;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.ShooterFlipper;
import org.firstinspires.ftc.teamcode.subsystems.WobbleGoal;

public class CRedWarehouseCommandLow extends SequentialCommandGroup {
    public CRedWarehouseCommandLow(Drivetrain drivetrain, Intake intake, Shooter lift, ShooterFlipper shooterFlipper, SensorColor sensorColor, WobbleGoal wobbleGoal) {
        addCommands();
    }
}