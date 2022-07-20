package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util;

import java.util.logging.Level;
//Test
@Config
public class Camera extends SubsystemBase {
    public static double CAM_POS_ONE = 0;
    public static double CAM_POS_TWO = 0;

    Telemetry telemetry;
    private ServoEx camServo;

    public Camera(HardwareMap hw, Telemetry tl) {
        this.camServo = new SimpleServo(hw,"camServo", 0, 270);
        this.telemetry = tl;
        camServo.setPosition(CAM_POS_ONE);
    }


    @Override
    public void periodic() {
        Util.logger(this, telemetry, Level.INFO, "Cam Servo Pos: ", camServo.getPosition());
    }

    public void set(double camServoPos) {
        camServo.setPosition(camServoPos); }

    public void setFlipperServo(double armServoPosition) {camServo.setPosition(armServoPosition);}
    public void camPosOne() {setFlipperServo(CAM_POS_ONE);}
    public void camPosTwo() {setFlipperServo(CAM_POS_TWO);}
}
