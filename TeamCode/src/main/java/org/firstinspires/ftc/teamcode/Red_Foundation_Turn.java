package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "RED_FOUNDATION_GRAB_TURN")
public class Red_Foundation_Turn extends Auto_Methods {
    String  sounds[] =  { "ss_wookie" };

    boolean soundPlaying = false;
    @Override
    public void runOpMode() throws InterruptedException {
        int     soundIndex      = 0;
        int     soundID         = -1;
        boolean was_dpad_up     = false;
        boolean was_dpad_down   = false;

        Context myApp = hardwareMap.appContext;

        // create a sound parameter that holds the desired player parameters.
        SoundPlayer.PlaySoundParams params = new SoundPlayer.PlaySoundParams();
        params.loopControl = 0;
        params.waitForNonLoopingSoundsToFinish = true;

        // init robot
        initCompBot();
        waitForStart();

        if (opModeIsActive() && !isStopRequested()) {
            strafeDriveEncoder(0.3, 10,  "RIGHT",2);
            turnClamp("PAR", 250);
            clamp("OPEN", 250);
            gyroDrive(.2, 88, 0,2);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.1);
            sleep(1600);
            turnEncoder(0.6,55,"C", 2);
            straightDriveEncoder(0.6,-30,2);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.1);
            turnEncoder(0.6,75,"C",2);
            straightDriveEncoder(.5,80,3);
            leftFoundation.setPosition(0.2);
            rightFoundation.setPosition(.9);
            sleep(1500);
            strafeDriveEncoder(.5,50,"RIGHT",2);
            straightDriveEncoder(.5,-140,2);
            clamp("CLOSE", 700);
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

