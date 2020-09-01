package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
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
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

@Disabled
@TeleOp(name = "LastYearTeleop", group = "TeleOp")

public class teleop650 extends LinearOpMode {

    private DcMotor driveFrontLeft;
    private DcMotor driveFrontRight;
    private DcMotor driveBackLeft;
    private DcMotor driveBackRight;
    private Servo rotation;
    private Servo clamp;
    private Servo teamMarker;

    private DcMotor liftleft;
    private DcMotor liftright;
    private DcMotor actuator;
    DigitalChannel limitSwitch;
    public Servo rightFoundation;
    public Servo leftFoundation;
    double toggle;
    private DistanceSensor sensorRange;


    @Override
    public void runOpMode() throws InterruptedException {

        sensorRange = hardwareMap.get(DistanceSensor.class, "sensor_range");
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)sensorRange;

        // you can also cast this to a Rev2mDistanceSensor if you want to use added
        // methods associated with the Rev2mDistanceSensor class.


        driveFrontLeft = hardwareMap.dcMotor.get("driveFrontLeft");
        driveFrontRight = hardwareMap.dcMotor.get("driveFrontRight");
        driveBackLeft = hardwareMap.dcMotor.get("driveBackLeft");
        driveBackRight = hardwareMap.dcMotor.get("driveBackRight");
        rotation = hardwareMap.servo.get("rotation");
        actuator = hardwareMap.dcMotor.get("actuator");
        clamp = hardwareMap.servo.get("clamp");
        teamMarker = hardwareMap.servo.get("teamMarker");
        liftright = hardwareMap.dcMotor.get("liftright");
        liftleft = hardwareMap.dcMotor.get("liftleft");

        driveFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        driveBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        liftright.setDirection(DcMotor.Direction.REVERSE);
        actuator.setDirection(DcMotor.Direction.REVERSE);

        limitSwitch = hardwareMap.get(DigitalChannel.class, "limitSwitch");
        rightFoundation = hardwareMap.servo.get("rightFoundation");
        leftFoundation = hardwareMap.servo.get("leftFoundation");

        // set the digital channel to input.
        limitSwitch.setMode(DigitalChannel.Mode.INPUT);

        toggle = 0.6;



        //waitForStart();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();


        }

        while (opModeIsActive()) {
            telemetry.addData("LEFT STICK Y",gamepad1.left_stick_y*-1);
            telemetry.addData("LEFT STICK X",gamepad1.left_stick_x);
            telemetry.addData("RIGHT STICK X",gamepad1.right_stick_x);
            telemetry.addData("deviceName",sensorRange.getDeviceName() );
            telemetry.addData("range", String.format("%.01f mm", sensorRange.getDistance(DistanceUnit.MM)));
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
            telemetry.addData("range", String.format("%.01f m", sensorRange.getDistance(DistanceUnit.METER)));
            telemetry.addData("range", String.format("%.01f in", sensorRange.getDistance(DistanceUnit.INCH)));
            telemetry.update();

            //Gamepad 1 left joystick x strafe
//            while ((Math.abs(gamepad1.left_stick_x) > 0.05 || Math.abs(gamepad1.left_stick_y) > 0.05 || Math.abs(gamepad1.right_stick_x) > 0.04) && gamepad1.y && opModeIsActive()) {
//                driveBackLeft.setPower(gamepad1.left_stick_y * 0.4 + gamepad1.left_stick_x * 0.4 + gamepad1.right_stick_x * -0.4);
//                driveFrontLeft.setPower(gamepad1.left_stick_y * 0.4 + gamepad1.left_stick_x * -0.4 + gamepad1.right_stick_x * -0.4);
//                driveFrontRight.setPower(gamepad1.left_stick_y * 0.4 + gamepad1.left_stick_x * 0.4 + gamepad1.right_stick_x * 0.4);
//                driveBackRight.setPower(gamepad1.left_stick_y * 0.4 + gamepad1.left_stick_x * -0.4 + gamepad1.right_stick_x * 0.4);
//                telemetry.addLine("SLOWMO");
//            }

            //Gamepad 1 left joystick x strafe
            while ((Math.abs(gamepad1.left_stick_x) > 0.05 || Math.abs(gamepad1.left_stick_y) > 0.05 || Math.abs(gamepad1.right_stick_x) > 0.04) && !gamepad1.left_bumper && opModeIsActive()) {
                driveBackLeft.setPower(gamepad1.left_stick_y * 0.7 + gamepad1.left_stick_x * 0.7 + gamepad1.right_stick_x * -0.7);
                driveFrontLeft.setPower(gamepad1.left_stick_y * 0.7 + gamepad1.left_stick_x * -0.7 + gamepad1.right_stick_x * -0.7);
                driveFrontRight.setPower(gamepad1.left_stick_y * 0.7 + gamepad1.left_stick_x * 0.7 + gamepad1.right_stick_x * 0.7);
                driveBackRight.setPower(gamepad1.left_stick_y * 0.7 + gamepad1.left_stick_x * -0.7 + gamepad1.right_stick_x * 0.7);

            }

            driveBackLeft.setPower(0);
            driveFrontLeft.setPower(0);
            driveFrontRight.setPower(0);
            driveBackRight.setPower(0);

            if (gamepad1.right_bumper && opModeIsActive()) {
                clamp.setPosition(.35);
                telemetry.addLine("CLOSED");

            }
            if (gamepad1.left_bumper && opModeIsActive()) {
                clamp.setPosition(.75);
                telemetry.addLine("OPEN");
            }


            actuator.setPower(gamepad2.right_trigger);
            actuator.setPower(gamepad2.left_trigger*-1);


            if (gamepad1.dpad_left && opModeIsActive()) {
                rotation.setPosition(.90);
            }
            if (gamepad1.dpad_right && opModeIsActive()) {
                rotation.setPosition(.54);
            }


            if (gamepad1.left_stick_y < 0 && opModeIsActive() && limitSwitch.getState()) {
                liftleft.setPower(gamepad2.left_stick_y * -0.05);
                liftright.setPower(gamepad2.left_stick_y * -0.05);
                telemetry.addLine("DOWN");
                telemetry.update();
            } else if (gamepad1.left_stick_y > 0 && opModeIsActive()) {
                liftleft.setPower(gamepad2.left_stick_y * -.85);
                liftright.setPower(gamepad2.left_stick_y * -.85);
                telemetry.addLine("UP");
                telemetry.update();
            } else if (gamepad1.left_stick_y == 0 && opModeIsActive() && !limitSwitch.getState()) {
                liftright.setPower(0);
                liftleft.setPower(0);
                telemetry.addLine("LIMIT SWITCH PRESSED");
                telemetry.update();

            } else if (gamepad1.left_stick_y == 0 && opModeIsActive() && limitSwitch.getState()) {
                liftright.setPower(-0.18);
                liftleft.setPower(-0.18);
                telemetry.addLine("HOLD");
                telemetry.update();
            }

            if (gamepad1.x && opModeIsActive()) {
                leftFoundation.setPosition(1);
                rightFoundation.setPosition(0.15);
            } else {
                leftFoundation.setPosition(0.2);
                rightFoundation.setPosition(.9);
            }
            if (gamepad1.a && !gamepad1.y && opModeIsActive()) {
                teamMarker.setPosition(1);

            }else{
                teamMarker.setPosition(0.5);
            }


            idle();
        }

    }
}

