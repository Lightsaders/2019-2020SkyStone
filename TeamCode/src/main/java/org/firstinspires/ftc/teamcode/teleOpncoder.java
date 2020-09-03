package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SampleRevBlinkinLedDriver;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;


@TeleOp(name = "TeleOp", group = "TeleOp")

public class teleOpncoder extends LinearOpMode {
    DcMotor LeftFront;
    DcMotor LeftRear;
    DcMotor RightFront;
    DcMotor RightRear;

    @Override
    public void runOpMode() {

        LeftFront = hardwareMap.dcMotor.get("MotorLeftFront");
        LeftRear = hardwareMap.dcMotor.get("MotorLeftRear");
        RightFront = hardwareMap.dcMotor.get("MotorRightFront");
        RightRear = hardwareMap.dcMotor.get("MotorRightRear");

        RightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        RightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        //waitForStart();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();




        }
        // printIng out the encoder counts
        telemetry.addData(" Left Front DRIVING TO: %7d ", LeftFront.getCurrentPosition());

        telemetry.addData("Left Rear DRIVING TO: %7d ", LeftRear.getCurrentPosition());
        telemetry.addData("Right Rear DRIVING TO: %7d ", RightRear.getCurrentPosition());
        telemetry.update();

        while (opModeIsActive()) {

            //Gamepad 1 left joystick x strafe
            while ((Math.abs(gamepad1.left_stick_x) > 0.1 || Math.abs(gamepad1.left_stick_y) > 0.1 || Math.abs(gamepad1.right_stick_x) > 0.1) && opModeIsActive()) {
                LeftRear.setPower(gamepad1.left_stick_y * 1 + gamepad1.left_stick_x * 1 + gamepad1.right_stick_x * -1);
                LeftFront.setPower(gamepad1.left_stick_y * 1 + gamepad1.left_stick_x * -1 + gamepad1.right_stick_x * -1);
                RightFront.setPower(gamepad1.left_stick_y * 1 + gamepad1.left_stick_x * 1 + gamepad1.right_stick_x * 1);
                RightRear.setPower(gamepad1.left_stick_y * 1 + gamepad1.left_stick_x * -1 + gamepad1.right_stick_x * 1);
                // printIng out the encoder counts
                telemetry.addData(" Left Front DRIVING TO: %7d ", LeftFront.getCurrentPosition());

                telemetry.addData("Left Rear DRIVING TO: %7d ", LeftRear.getCurrentPosition());
                telemetry.addData("Right Rear DRIVING TO: %7d ", RightRear.getCurrentPosition()*-1);
                telemetry.update();

            }
            //Gamepad 1 left joystick x strafe

            LeftRear.setPower(0);
            LeftFront.setPower(0);
            RightFront.setPower(0);
            RightRear.setPower(0);

            if (gamepad1.a){
                LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                LeftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                RightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                sleep(1000);
                telemetry.addData(" Left Front DRIVING TO: %7d ", LeftFront.getCurrentPosition());

                telemetry.addData("Left Rear DRIVING TO: %7d ", LeftRear.getCurrentPosition());
                telemetry.addData("Right Rear DRIVING TO: %7d ", RightRear.getCurrentPosition()*-1);
                telemetry.update();

                LeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                LeftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                RightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            idle();
        }
    }
}




