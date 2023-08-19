package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.DrivetrainSub;

import java.util.function.DoubleSupplier;

public class DriveCmd extends CommandBase {

    private final DrivetrainSub drivetrainSub;
    private final GamepadEx gamepad;
    private final DoubleSupplier angleDegrees;
    private final boolean fieldCentric;

    public DriveCmd(DrivetrainSub dts, GamepadEx gp1, DoubleSupplier ad, Boolean fc){
        drivetrainSub = dts;
        gamepad = gp1;
        angleDegrees = ad;
        fieldCentric = fc;
        addRequirements(drivetrainSub);
    }

    @Override
    public void execute(){
        double multiplier = 1-gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);
        if (fieldCentric) {
            // optional fifth parameter for squared inputs
            drivetrainSub.getDrive().driveFieldCentric(
                    gamepad.getLeftX()*multiplier,
                    gamepad.getLeftY()*multiplier,
                    gamepad.getRightX()*multiplier,
                    angleDegrees.getAsDouble(),   // gyro value passed in here must be in degrees
                    false
            ); ;
        } else {
            // optional fourth parameter for squared inputs
            drivetrainSub.getDrive().driveRobotCentric(
                    gamepad.getLeftX()*multiplier,
                    gamepad.getLeftY()*multiplier,
                    gamepad.getRightX()*multiplier,
                    false
            );
        }
    }
}
