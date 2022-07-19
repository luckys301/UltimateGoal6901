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
public class WobbleGoal extends SubsystemBase {

    public static double WOBBLE_OPEN_POS = 0;
    public static double WOBBLE_CLOSE_POS = 0;

    private Telemetry telemetry;
    private TelemetryPacket packet;

    private ServoEx wobbleGoalServo;

//    private double realCapServoPos = 0;

    public WobbleGoal(ServoEx wobbleGoalServo, ServoEx clawServo, ServoEx realCapArmServo, Telemetry tl, HardwareMap hw) {
        this.wobbleGoalServo = wobbleGoalServo;
        this.wobbleGoalServo = new SimpleServo(hw,"wobbleServo", 0, 270);

        this.telemetry = tl;
        this.packet = packet;
    }

    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Cap Arm Servo Position: ", wobbleGoalServo.getPosition());
    }

    public void setcapArmServo(double capArmServoPosition){ wobbleGoalServo.setPosition(capArmServoPosition);}

    public void setWobbleOpenPos() {
        setcapArmServo(WOBBLE_OPEN_POS);
    }
    public void setWobbleClosePos() { setcapArmServo(WOBBLE_CLOSE_POS); }
}