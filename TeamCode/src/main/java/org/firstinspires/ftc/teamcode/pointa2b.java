package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "pointa2b")
public class pointa2b extends LinearOpMode {
    DcMotor LeftFront;
    DcMotor LeftRear;
    DcMotor RightFront;
    DcMotor RightRear;
    // Gobilda Motor Specs
    double COUNTS_PER_MOTOR_GOBUILDA = 1500;    // gobilda
    double DRIVE_GEAR_REDUCTION = 1;    // 1:1
    double WHEEL_DIAMETER_CM = 2;     // mecanum wheels

    double COUNTS_PER_CM_GOBUILDA = ((COUNTS_PER_MOTOR_GOBUILDA * DRIVE_GEAR_REDUCTION ) / (WHEEL_DIAMETER_CM * Math.PI)) / 2;

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
        //waitForStart();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();




        }
        while (opModeIsActive()) {
            straightDriveEncoder(0.5,10,4);
        }
    }

    public void straightDriveEncoder(double speed, double distanceCM, double timeCutOff) {
        int frontLeftTarget;
        int horizonaltarget;
        int frontRightTarget;
        int backRightTarget;
        double end = 0;
        double t = 0;
        // Setting Zero Behavior for Drive Train Motors
        LeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightRear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        if (opModeIsActive()) {

            LeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            RightRear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            LeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            LeftRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            RightRear.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            // Determine new target position, and pass to motor controller
            frontLeftTarget = LeftFront.getCurrentPosition() + (int) (distanceCM * COUNTS_PER_CM_GOBUILDA);

            backRightTarget = RightRear.getCurrentPosition() + (int) (distanceCM * COUNTS_PER_CM_GOBUILDA);

            // set target position to each motor
            LeftFront.setTargetPosition(frontLeftTarget);

            RightRear.setTargetPosition(backRightTarget);

            // Turn on run to position
            LeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightRear.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            LeftFront.setPower(Math.abs(speed));
            RightFront.setPower(Math.abs(speed));
            LeftRear.setPower(Math.abs(speed));
            RightRear.setPower(Math.abs(speed));

            t = getRuntime();
            end = getRuntime() + timeCutOff; //TODO THIS CAN BE AUTOMATED

            while (opModeIsActive() && !isStopRequested() &&
                    (getRuntime() <= end) &&
                    (LeftFront.isBusy() || RightFront.isBusy() || LeftRear.isBusy() || RightRear.isBusy())) {

                // Display it for the driver.
                telemetry.addData("RUN TIME CURRENT: ", "" + getRuntime());
                telemetry.addData("RUN TIME END: ", "" + end);
                telemetry.addData("FRONT LEFT MOTOR", " DRIVING TO: %7d CURRENTLY AT: %7d", frontLeftTarget, LeftFront.getCurrentPosition());

                telemetry.addData("BACK RIGHT MOTOR", "DRIVING TO: %7d CURRENTLY AT: %7d", backRightTarget, RightRear.getCurrentPosition());
                telemetry.update();

            }

            telemetry.clearAll();
            telemetry.addData("FINISHED RUN: ", "" + (end - t));
            telemetry.update();

            // Stop all motion;
            LeftFront.setPower(0);
            RightFront.setPower(0);
            LeftRear.setPower(0);
            RightRear.setPower(0);

            //Turn off run to position
            LeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightRear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        }
    }
}
