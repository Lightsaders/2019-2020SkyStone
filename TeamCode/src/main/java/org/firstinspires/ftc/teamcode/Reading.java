
package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
@Disabled
@Autonomous(name = "Reading")

public class Reading extends Auto_Methods {

    @Override
    public void runOpMode() throws InterruptedException {
        initCompBot();
        waitForStart();
        if (opModeIsActive() && !isStopRequested()) {
//            rightFoundation.setPosition(.4);
//            sleep(1000);
            //            actuator.setPower(1);
//            sleep(900);
//            actuator.setPower(0);
//            turnClamp("PAR", 700);
//            clamp("OPEN", 500);
//            actuator.setPower(-1);
//            rotation.setPosition(.98);
//            sleep(500);
//            actuator.setPower(0);
//            clamp.setPosition(.8);
//            rightFoundation.setPosition(.9);
//            sleep(1000);
//            turnClamp("PAR", 700);
//            straightDriveEncoder(0.2, 87, 2.5);
//            skystoneColorScan("BLUE");
            NormalizedRGBA colorsLeft = colorSensorLeft.getNormalizedColors();
            NormalizedRGBA colorsRight = colorSensorRight.getNormalizedColors();

            float[] hsvValuesLeft = new float[3];
            final float valuesLeft[] = hsvValuesLeft;
            float[] hsvValuesRight = new float[3];
            final float valuesRight[] = hsvValuesRight;

            // Settings Colors
            float max = Math.max(Math.max(Math.max(colorsLeft.red, colorsLeft.green), colorsLeft.blue), colorsLeft.alpha);
            colorsLeft.red /= max;
            colorsLeft.green /= max;
            colorsLeft.blue /= max;
            float max0 = Math.max(Math.max(Math.max(colorsRight.red, colorsRight.green), colorsRight.blue), colorsRight.alpha);
            colorsRight.red /= max0;
            colorsRight.green /= max0;
            colorsRight.blue /= max0;
            colorsLeft = colorSensorLeft.getNormalizedColors();
            Color.colorToHSV(colorsLeft.toColor(), hsvValuesLeft);
            telemetry.addLine()
                    .addData("H", "%.3f", hsvValuesLeft[0])
                    .addData("S", "%.3f", hsvValuesLeft[1])
                    .addData("V", "%.3f", hsvValuesLeft[2]);
            telemetry.addLine()
                    .addData("a", "%.3f", colorsLeft.alpha)
                    .addData("r", "%.3f", colorsLeft.red)
                    .addData("g", "%.3f", colorsLeft.green)
                    .addData("b", "%.3f", colorsLeft.blue);

            colorsRight = colorSensorRight.getNormalizedColors();
            Color.colorToHSV(colorsRight.toColor(), hsvValuesRight);
            telemetry.addLine()
                    .addData("H", "%.3f", hsvValuesRight[0])
                    .addData("S", "%.3f", hsvValuesRight[1])
                    .addData("V", "%.3f", hsvValuesRight[2]);
            telemetry.addLine()
                    .addData("a", "%.3f", colorsRight.alpha)
                    .addData("r", "%.3f", colorsRight.red)
                    .addData("g", "%.3f", colorsRight.green)
                    .addData("b", "%.3f", colorsRight.blue);
            sleep(1000);
            telemetry.update();
            sleep(8000);
            telemetry.addLine("Skystone position: " + positionSkystone);
            sleep(8000);
            telemetry.update();
            sleep(20000);
            switch (positionSkystone) {
                case "WALL":
                    if (!isStopRequested() && opModeIsActive()) {
//                        straightDriveEncoder(0.2, -12, 0.75);
//
                        telemetry.addLine("Skystone position: " + positionSkystone);
                        sleep(1000);
                        telemetry.update();

//
//                        strafeDriveEncoder(1, 10, "RIGHT", 0.75);
//                        actuator.setPower(1);//TODO use method created however it requires encoders on actuator
//                        sleep(500);
//                        actuator.setPower(0);
//                        clamp("CLOSE", 250);
//                        straightDriveEncoder(0.6, -20, 0.75);
//                        turnEncoder(0.5, 76, "CC", 1);
//                        straightDriveEncoder(0.7, 190, 1.75);
//                        clamp("OPEN", 250);
//                        straightDriveEncoder(0.7, -215, 2);
//                        turnEncoder(0.5, 77, "C", 1.75);
//                        straightDriveEncoder(0.4, 30,  2);
//                        //turnEncoder(0.5,25,"CC",0.75);
//                        turnClamp("PAR", 250);
//                        clamp("CLOSE", 250);
//                        straightDriveEncoder(0.4, -10, 0.5);
//                        turnEncoder(0.5, 82, "CC", 1.75);
//                        straightDriveEncoder(0.7, 200, 2);
//                        clamp("OPEN", 250);
//                        straightDriveEncoder(0.4, -38, 1);
                    }
                    break;
                case "MIDDLE":
                    if (!isStopRequested() && opModeIsActive()) {
//                        straightDriveEncoder(0.2, -9, 0.75);
//                        strafeDriveEncoder(1, 8, "LEFT", 1.3);
//                        actuator.setPower(1);//TODO use method created however it requires encoders on actuator
//                        sleep(500);
//                        actuator.setPower(0);
//                        clamp("CLOSE", 250);
//                        straightDriveEncoder(0.6, -20, 0.75);
//                        turnEncoder(0.5, 78, "CC", 1);
//                        straightDriveEncoder(0.7, 160, 2.25);
//                        clamp("OPEN", 250);
                        telemetry.addLine("Skystone position: " + positionSkystone);
                        sleep(1000);
                        telemetry.update();

//                        straightDriveEncoder(0.7, -235, 2.5);
//                        turnEncoder(0.5, 76, "C", 1);
//                        clamp("OPEN", 250);
//                        straightDriveEncoder(0.4, 30, 1.75);
//                        clamp("CLOSE", 250);
//                        straightDriveEncoder(0.6, -22, 0.75);
//                        turnEncoder(0.5, 78, "CC", 1.5);
//                        straightDriveEncoder(0.7, 220, 2.25);
//
//                        clamp("OPEN", 250);
//                        straightDriveEncoder(.7, -50, 1.5);
                    }
                    break;
                case "BRIDGE":
                    if (!isStopRequested() && opModeIsActive()) {
//                        straightDriveEncoder(0.2, -9, 0.75);
//                        strafeDriveEncoder(0.4, 25, "LEFT", .75);
//                        actuator.setPower(1);//TODO use method created
//                        sleep(500);
//                        actuator.setPower(0);
//                        clamp("CLOSE", 250);
//                        straightDriveEncoder(0.2, -30, 1);
//                        turnEncoder(.4, 82, "CC", 1);
//                        straightDriveEncoder(0.6, 129, 1.5);
//                        clamp("OPEN", 250);
                        telemetry.addLine("Skystone position: " + positionSkystone);
                        sleep(1000);
                        telemetry.update();

//                        straightDriveEncoder(.5, -214, 3);
//                        turnEncoder(0.5, 80, "C", 1);
//                        clamp("OPEN", 250);
//                        straightDriveEncoder(0.3, 42, 2.25);
//                        clamp("CLOSE", 250);
//                        straightDriveEncoder(.5, -30, 1);
//                        turnEncoder(0.5, 76, "CC", 1);
//                        straightDriveEncoder(0.7, 200, 2);
//                        clamp("OPEN", 250);
//                        straightDriveEncoder(0.4, -55, 1.75);
                    }
                    break;
            }
        }
    }
}


