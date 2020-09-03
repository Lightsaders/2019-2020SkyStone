package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name = "auto straight drive")
public class auto_straight_drive extends LinearOpMode {
    DcMotor LeftFront;
    DcMotor LeftRear;
    DcMotor RightFront;
    DcMotor RightRear;

    @Override
    public void runOpMode() {
        //defining motors
        LeftFront = hardwareMap.dcMotor.get("MotorLeftFront");
        LeftRear = hardwareMap.dcMotor.get("MotorLeftRear");
        RightFront = hardwareMap.dcMotor.get("MotorRightFront");
        RightRear = hardwareMap.dcMotor.get("MotorRightRear");
        // reversing motors
        LeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftRear.setDirection(DcMotorSimple.Direction.REVERSE);

       // resetting encoders

        LeftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // running the motors after restart

        LeftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        RightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
             telemetry.addData("Left DRIVING TO: %7d ", LeftRear.getCurrentPosition()*-1);
            telemetry.addData("Right DRIVING TO: %7d ", RightRear.getCurrentPosition());
            telemetry.update();

                // variable is postion of encoders relative to each other
                int x = (LeftRear.getCurrentPosition()*-1) - RightRear.getCurrentPosition();
                double motorspeed = 0.3;

                if (x == 0) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed);
                    RightRear.setPower(motorspeed);
                    telemetry.addLine("equal");
                    telemetry.addData("right side speed",motorspeed);
                    telemetry.update();
                    sleep(1750);
                } else if (x < -2000 && x > -100) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed + 0.02);
                    RightRear.setPower(motorspeed + 0.02);
                    telemetry.addLine("50-200");
                    telemetry.addData("right side speed",motorspeed+0.02);
                    telemetry.update();
                //    Log.("FTC ROBOT",str(LeftFront.getPower()));
                    sleep(1750);
                } else if (x < -6500 && x > -2000) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed + 0.05);
                    RightRear.setPower(motorspeed + 0.05);
                    telemetry.addData("right side speed",motorspeed+0.05);
                    telemetry.addLine("2000-6500");
                    telemetry.update();
                    sleep(1750);
                } else if (x < -100000000 && x > -6500) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed + 0.1);
                    RightRear.setPower(motorspeed + 0.1);
                    telemetry.addLine("6500-1000000");
                    telemetry.addData("right side speed",motorspeed+0.15);
                    telemetry.update();
                    sleep(1750);
                } else if (x < 50 && x > 2000) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed - 0.02);
                    RightRear.setPower(motorspeed - 0.02);
                    telemetry.addLine("-50-2000");
                    telemetry.addData("right side speed",motorspeed-0.02);
                    telemetry.update();
                    sleep(1750);
                } else if (x < 2000 && x > 6000) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed - 0.05);
                    RightRear.setPower(motorspeed - 0.05);
                    telemetry.addLine("-200--600");
                    telemetry.addData("right side speed",motorspeed-0.05);
                    telemetry.update();
                    sleep(1750);
                } else if (x < 6000 && x > 10000000) {
                    LeftFront.setPower(motorspeed);
                    LeftRear.setPower(motorspeed);
                    RightFront.setPower(motorspeed - 0.1);
                    RightRear.setPower(motorspeed - 0.1);
                    telemetry.addLine("-600--1000");
                    telemetry.addData("right side speed",motorspeed-0.1);
                    telemetry.update();
                    sleep(1750);
                }



        }
        telemetry.addData("Left Rear DRIVING TO: %7d ", LeftRear.getCurrentPosition()*-1);
        telemetry.addData("Right Rear DRIVING TO: %7d ", RightRear.getCurrentPosition());
        telemetry.update();
    }
}

