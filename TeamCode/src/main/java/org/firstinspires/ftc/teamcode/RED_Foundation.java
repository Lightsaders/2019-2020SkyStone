package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RED_FOUNDATION_GRAB")
public class RED_Foundation extends Auto_Methods{
    String  sounds[] =  { "ss_wookie" };

    boolean soundPlaying = false;
    @Override
    public void runOpMode() throws InterruptedException {

        // init robot
        initCompBot();
        // Variables for choosing from the available sounds
        int     soundIndex      = 0;
        int     soundID         = -1;
        boolean was_dpad_up     = false;
        boolean was_dpad_down   = false;

        Context myApp = hardwareMap.appContext;

        // create a sound parameter that holds the desired player parameters.
        SoundPlayer.PlaySoundParams params = new SoundPlayer.PlaySoundParams();
        params.loopControl = 0;
        params.waitForNonLoopingSoundsToFinish = true;

        waitForStart();

        if (opModeIsActive() && !isStopRequested()) {

            strafeDriveEncoder(0.3, 29,  "RIGHT",2);
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
            gyroDrive(.2, 88, 0,2);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.1);
            sleep(1600);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.1);
            straightDriveEncoder(.4,-100,3);
            leftFoundation.setPosition(0.2);
            rightFoundation.setPosition(.9);
            sleep(1500);
            leftFoundation.setPosition(0.2);
            rightFoundation.setPosition(.9);
            strafeDriveEncoder(.5,60,"LEFT",2);
            straightDriveEncoder(.3,-15,1);
            clamp("CLOSE", 700);
            strafeDriveEncoder(.5,40,"LEFT",3);
            if ((soundID = myApp.getResources().getIdentifier(sounds[soundIndex], "raw", myApp.getPackageName())) != 0){

                // Signal that the sound is now playing.
                soundPlaying = true;

                // Start playing, and also Create a callback that will clear the playing flag when the sound is complete.
                SoundPlayer.getInstance().startPlaying(myApp, soundID, params, null,
                        new Runnable() {
                            public void run() {
                                soundPlaying = false;

                            }} );
            }

        }
    }
}

