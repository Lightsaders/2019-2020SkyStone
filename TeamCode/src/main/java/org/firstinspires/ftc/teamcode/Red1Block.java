package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorREV2mDistance;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "RED_1_BLOCK")

public class Red1Block extends Auto_Methods{
    public DcMotor liftleft;
    public DcMotor liftright;
    private DistanceSensor sensorRange;
    @Override
    public void runOpMode() throws InterruptedException {

        // init robot
        initCompBot();
        liftright = hardwareMap.dcMotor.get("liftright");
        liftleft = hardwareMap.dcMotor.get("liftleft");
        sensorRange = hardwareMap.get(DistanceSensor.class, "sensor_range");

        // you can also cast this to a Rev2mDistanceSensor if you want to use added
        // methods associated with the Rev2mDistanceSensor class.
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor)sensorRange;


        waitForStart();

        if (opModeIsActive() && !isStopRequested()) {
            rightFoundation.setPosition(.4);
            sleep(1000);
            actuator.setPower(1);//TODO use method created however it requires encoders on actuator
            sleep(300);
            actuator.setPower(0);
            turnClamp("PAR", 700);
            clamp("OPEN", 500);
            actuator.setPower(-1);//TODO use method created however it requires encoders on actuator
            sleep(100);
            actuator.setPower(0);
            rightFoundation.setPosition(.8);
            turnClamp("PAR", 250);
            clamp("OPEN", 250);
            straightDriveEncoder(0.2, 86.5, 2.2);// TODO adjust tomorrow morning
            skystoneColorScan("RED");
            telemetry.addLine("Skystone position: " + positionSkystone);
            telemetry.update();
            switch (positionSkystone) {
                case "WALL":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(0.2, -12, 0.75);
                        strafeDriveEncoder(1, 10, "LEFT", 0.75);
                        actuator.setPower(1);//TODO use method created however it requires encoders on actuator
                        sleep(500);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.6, -20, 0.75);
                        turnEncoder(0.5, 76, "C", 1);
                        straightDriveEncoder(0.7, 200, 1.75);
                        turnEncoder(0.5, 76, "CC", 1.75);
                        strafeDriveEncoder(.6,60,"RIGHT",3);
                        strafeDriveEncoder(.6,40,"LEFT",3);


                            liftleft.setPower( -.65);
                            liftright.setPower( .65);
                            sleep(700);
                        liftleft.setPower( -0.16);
                        liftright.setPower( 0.16);
                        straightDriveEncoder(0.3, 80, 1.5);
                        clamp("OPEN", 250);
                        leftFoundation.setPosition(1);
                        rightFoundation.setPosition(0.1);
                        sleep(1600);


                        straightDriveEncoder(.4,-200,3);
                        strafeDriveEncoder(.4,40,"RIGHT",.25);
                        straightDriveEncoder(.8,-20,1);

                        leftFoundation.setPosition(0.2);
                        rightFoundation.setPosition(.9);
                        sleep(1500);
                        leftFoundation.setPosition(0.2);
                        rightFoundation.setPosition(.9);
                        strafeDriveEncoder(.5,50,"LEFT",3);
                        turnEncoder(.5,78,"CC",1);
                        liftleft.setPower( .65);
                        liftright.setPower(- .65);
                        sleep(900);
                        liftleft.setPower( 0);
                        liftright.setPower( 0);
                        straightDriveEncoder(.3,55,1);


                        strafeDriveEncoder(.5,40,"LEFT",3);
                    }
                    break;
                case "MIDDLE":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(0.2, -9, 0.75);
                        strafeDriveEncoder(1, 10, "RIGHT", 1.3);
                        actuator.setPower(1);//TODO use method created however it requires encoders on actuator
                        sleep(500);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.6, -20, 0.75);
                        turnEncoder(0.5, 78, "C", 1);
                        straightDriveEncoder(0.7, 160, 2.25);
                        turnEncoder(0.5, 76, "CC", 1.75);
                        strafeDriveEncoder(.6,80,"RIGHT",3);
                        strafeDriveEncoder(.6,40,"LEFT",3);


                        liftleft.setPower( -.65);
                        liftright.setPower( .65);
                        sleep(700);
                        liftleft.setPower( -0.16);
                        liftright.setPower( 0.16);
                        straightDriveEncoder(0.3, 80, 1.5);
                        clamp("OPEN", 250);
                        leftFoundation.setPosition(1);
                        rightFoundation.setPosition(0.1);
                        sleep(1600);


                        straightDriveEncoder(.4,-200,3);
                        strafeDriveEncoder(.4,40,"RIGHT",.25);
                        straightDriveEncoder(.8,-20,1);

                        leftFoundation.setPosition(0.2);
                        rightFoundation.setPosition(.9);
                        sleep(1500);
                        leftFoundation.setPosition(0.2);
                        rightFoundation.setPosition(.9);
                        strafeDriveEncoder(.5,50,"LEFT",3);
                        turnEncoder(.5,78,"CC",1);
                        liftleft.setPower( .65);
                        liftright.setPower(- .65);
                        sleep(900);
                        liftleft.setPower( 0);
                        liftright.setPower( 0);
                        straightDriveEncoder(.3,55,1);


                        strafeDriveEncoder(.5,40,"LEFT",3);
                    }
                    break;
                case "BRIDGE":
                    if (!isStopRequested() && opModeIsActive()) {
                        straightDriveEncoder(0.2, -9, 0.75);
                        strafeDriveEncoder(0.4, 20, "RIGHT", .75);
                        actuator.setPower(1);//TODO use method created
                        sleep(500);
                        actuator.setPower(0);
                        clamp("CLOSE", 250);
                        straightDriveEncoder(0.2, -30, 1);
                        turnEncoder(.4, 82, "C", 1);
                        straightDriveEncoder(0.6, 129, 1.5);
                        turnEncoder(0.5, 76, "CC", 1.75);
                        strafeDriveEncoder(.6,90,"RIGHT",3);
                        strafeDriveEncoder(.6,40,"LEFT",3);


                        liftleft.setPower( -.65);
                        liftright.setPower( .65);
                        sleep(700);
                        liftleft.setPower( -0.16);
                        liftright.setPower( 0.16);
                        straightDriveEncoder(0.3, 80, 1.5);
                        clamp("OPEN", 250);
                        leftFoundation.setPosition(1);
                        rightFoundation.setPosition(0.1);
                        sleep(1600);


                        straightDriveEncoder(.4,-200,3);
                        strafeDriveEncoder(.4,40,"RIGHT",.25);
                        straightDriveEncoder(.8,-20,1);

                        leftFoundation.setPosition(0.2);
                        rightFoundation.setPosition(.9);
                        sleep(1500);
                        leftFoundation.setPosition(0.2);
                        rightFoundation.setPosition(.9);
                        strafeDriveEncoder(.5,50,"LEFT",3);
                        turnEncoder(.5,78,"CC",1);
                        liftleft.setPower( .65);
                        liftright.setPower(- .65);
                        sleep(900);
                        liftleft.setPower( 0);
                        liftright.setPower( 0);

                        straightDriveEncoder(.3,55,1);


                        strafeDriveEncoder(.5,40,"LEFT",3);
                    }
                    break;
            }
        }
    }
}



