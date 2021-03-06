
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "BLUE_2_BLOCK")

public class Blue_2Block extends Auto_Methods {

    @Override
    public void runOpMode() throws InterruptedException {
        initCompBot();
        waitForStart();
        if (opModeIsActive() && !isStopRequested()) {
            rightFoundation.setPosition(.4);
            sleep(1000);
            actuator.setPower(1);
            sleep(900);
            actuator.setPower(0);
            turnClamp("PAR", 700);
            clamp("OPEN", 500);
            actuator.setPower(-1);
            rotation.setPosition(.54);
            sleep(500);
            actuator.setPower(0);
            clamp.setPosition(.8);
            rightFoundation.setPosition(.9);
            sleep(1000);
            turnClamp("PAR", 700);
            straightDriveEncoder(0.2, 86.5, 2.2);
            skystoneColorScan("BLUE");
            sleep(1000);
            telemetry.addLine("Skystone position: " + positionSkystone);
            sleep(1000);
            telemetry.update();
            switch (positionSkystone) {
                case "WALL":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(0.2, -12, 0.75);
                        strafeDriveEncoder(1, 10, "RIGHT", 0.75);
                        actuator.setPower(1);//TODO use method created however it requires encoders on actuator
                        sleep(500);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.6, -20, 0.75);
                        turnEncoder(0.5, 76, "CC", 1);
                        straightDriveEncoder(0.7, 190, 1.75);
                        clamp("OPEN", 250);
                        straightDriveEncoder(0.7, -130, 2);
                        turnEncoder(0.5, 77, "C", 1.75);
                        straightDriveEncoder(0.4, 20,  2);
                        //turnEncoder(0.5,25,"CC",0.75);
                        turnClamp("PAR", 250);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.4, -10, 0.5);
                        turnEncoder(0.5, 80, "CC", 1.75);
                        straightDriveEncoder(0.7, 120, 2);
                        clamp("OPEN", 250);
                        straightDriveEncoder(0.4, -38, 1);
                    }
                    break;
                case "MIDDLE":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(0.2, -9, 0.75);
                        strafeDriveEncoder(1, 8, "LEFT", 1.3);
                        actuator.setPower(1);//TODO use method created however it requires encoders on actuator
                        sleep(500);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.6, -20, 0.75);
                        turnEncoder(0.5, 78, "CC", 1);
                        straightDriveEncoder(0.7, 160, 2.25);
                        clamp("OPEN", 250);
                        straightDriveEncoder(0.7, -235, 2.5);
                        turnEncoder(0.5, 76, "C", 1);
                        clamp("OPEN", 250);
                        straightDriveEncoder(0.4, 30, 1.75);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.6, -22, 0.75);
                        turnEncoder(0.5, 78, "CC", 1.5);
                        straightDriveEncoder(0.7, 220, 2.25);

                        clamp("OPEN", 250);
                        straightDriveEncoder(.7, -50, 1.5);
                    }
                    break;
                case "BRIDGE":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(0.2, -9, 0.75);
                        strafeDriveEncoder(0.4, 25, "LEFT", .75);
                        actuator.setPower(1);//TODO use method created
                        sleep(500);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.2, -30, 1);
                        turnEncoder(.4, 82, "CC", 1);
                        straightDriveEncoder(0.6, 129, 1.5);
                        clamp("OPEN", 250);
                        straightDriveEncoder(.5, -214, 3);
                        turnEncoder(0.5, 80, "C", 1);
                        clamp("OPEN", 250);
                        straightDriveEncoder(0.3, 42, 2.25);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(.5, -30, 1);
                        turnEncoder(0.5, 76, "CC", 1);
                        straightDriveEncoder(0.7, 200, 2);
                        clamp("OPEN", 250);
                        straightDriveEncoder(0.4, -55, 1.75);
                    }
                    break;
            }
        }
    }
}


