package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;

@Config
public class ShooterFlipper extends SubsystemBase {

    public static double FLIPPER_HOME_POS = 0;
    public static double FLIPPER_PUSH_POS = 0;

    private Telemetry telemetry;
    private TelemetryPacket packet;

    private ServoEx flipperServo;

    public ShooterFlipper(ServoEx flipperServo, ServoEx dropServo, Telemetry tl, HardwareMap hw) {
        this.flipperServo = flipperServo;

        this.flipperServo = new SimpleServo(hw,"flipper", 0, 270);
        this.telemetry = tl;
        this.packet = packet;

        this.flipperServo.setPosition(FLIPPER_HOME_POS);
    }
    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Flipper Servo Position: ", flipperServo.getPosition());
//        Util.logger(this, telemetry, Level.INFO, "Flipper Servo Position: ", findPos());
    }

    public void setFlipperServo(double armServoPosition) {flipperServo.setPosition(armServoPosition);}
    public void flipperHome() {setFlipperServo(FLIPPER_HOME_POS);}
    public void flipperPush() {setFlipperServo(FLIPPER_PUSH_POS);}

//    public void findPos () {
//        if (this.flipperServo.getPosition() == FLIPPER_HOME_POS);
//    }
}