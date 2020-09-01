package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "auto straight drive")
public class auto_straught_drive extends LinearOpMode {
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
        RightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        RightRear.setDirection(DcMotorSimple.Direction.REVERSE);

       // resetting encoders
        LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LeftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        RightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        //waitForStart();
        if (opModeIsActive() && !isStopRequested()) {
            telemetry.addData(" Left Front DRIVING TO: %7d ", LeftFront.getCurrentPosition());

            telemetry.addData("Left Rear DRIVING TO: %7d ", LeftRear.getCurrentPosition());
            telemetry.addData("Right Rear DRIVING TO: %7d ", RightRear.getCurrentPosition()*-1);
            telemetry.update();
            // running the motors after restart
            LeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            LeftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            RightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            // variable is postion of encoders relative to each other
            int x = LeftFront.getCurrentPosition()-RightRear.getCurrentPosition();
            double motorspeed = 0.5;

            if (x == 0 ) {

                RightFront.setPower(motorspeed);
                RightRear.setPower(motorspeed);
                telemetry.addLine("equal");
            }else if (x < 200 && x>50){

                RightFront.setPower(motorspeed + 0.02);
                RightRear.setPower(motorspeed + 0.02);
                telemetry.addLine("50-200");
            }
            else if (x < 600 && x>200){

                RightFront.setPower(motorspeed + 0.05);
                RightRear.setPower(motorspeed + 0.05);
                telemetry.addLine("200-600");
            }else if (x < 1000 && x>600){

                RightFront.setPower(motorspeed + 0.15);
                RightRear.setPower(motorspeed + 0.15);
                telemetry.addLine("600-1000");
            }else if (x < -50 && x>-200){
                RightFront.setPower(motorspeed - 0.02);
                RightRear.setPower(motorspeed - 0.02);
                telemetry.addLine("-50-2 -200");
             }else if (x < -200 && x>-600){
            RightFront.setPower(motorspeed - 0.05);
            RightRear.setPower(motorspeed - 0.05);
                telemetry.addLine("-200--600");
            }else if (x < -600 && x>1000){
                RightFront.setPower(motorspeed - 0.15);
                RightRear.setPower(motorspeed -0.15);
                telemetry.addLine("-600--1000");
            }else{
                LeftRear.setPower(0.5);
                LeftFront.setPower(0.5);
                RightFront.setPower(0.5);
                RightRear.setPower(0.5);
                telemetry.addLine("In the else loop");
            }




        }
    }
}

