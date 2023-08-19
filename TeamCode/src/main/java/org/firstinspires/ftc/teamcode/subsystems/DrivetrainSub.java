package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DrivetrainSub extends SubsystemBase {

    Telemetry telemetry;

    Motor frontLeft;
    Motor frontRight;
    Motor backLeft;
    Motor backRight;

    MecanumDrive drive;

    public DrivetrainSub(HardwareMap hardwareMap, Telemetry tm) {
        this.frontLeft = new Motor(hardwareMap, "frontLeft");
        this.frontRight = new Motor(hardwareMap, "frontRight");
        this.backLeft = new Motor(hardwareMap, "backLeft");
        this.backRight = new Motor(hardwareMap, "backRight");

        this.drive = new MecanumDrive(this.frontLeft, this.frontRight, this.backLeft, this.backRight);

        this.telemetry = tm;
    }

    @Override
    public void periodic() {
        telemetry.addData("Drive", drive.toString());
    }
    /* This may be a quick fix, I don't know
        Returns Drive
     */
    public MecanumDrive getDrive(){
        return drive;
    }


}