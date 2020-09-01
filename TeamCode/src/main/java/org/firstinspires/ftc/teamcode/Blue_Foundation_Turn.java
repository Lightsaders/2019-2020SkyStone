package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BLUE_FOUNDATION_GRAB_TURN")
public class Blue_Foundation_Turn extends Auto_Methods{
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
            strafeDriveEncoder(0.3, 10,  "LEFT",1);

            turnClamp("PAR", 700);
            clamp("OPEN", 500);

            gyroDrive(.2, 88, 0,2);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.1);
            sleep(1600);
            turnEncoder(0.7,55,"CC", 2);
            straightDriveEncoder(0.6,-30,2);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.1);
            turnEncoder(0.7,75,"CC",2);
            straightDriveEncoder(.6,80,3);
            leftFoundation.setPosition(0.2);
            rightFoundation.setPosition(.9);
            sleep(1500);
            strafeDriveEncoder(.5,50,"LEFT",2);
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


