package org.firstinspires.ftc.teamcode.commands.Multithreading;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.driveTrain.SampleTankDrive;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

//Extend ThreadOpMode rather than OpMode
public class TestMultitreading extends ThreadOpMode {

    //Define global variables
    private Drivetrain drivetrain;

    @Override
    public void mainInit() {
        //Perform your normal init
        drivetrain = new Drivetrain(new SampleTankDrive(hardwareMap), telemetry);
        drivetrain.init();

        //Below is a new thread
        registerThread(new TaskThread(new TaskThread.Actions() {
            @Override
            public void loop() {
                new DriveForwardCommand(drivetrain,10);
            }
        }));
    }

    @Override
    public void mainLoop() {
        //Anything you want to constantly run in the MAIN thread goes here
    }
}
