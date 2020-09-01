package org.firstinspires.ftc.teamcode;
import android.content.Context;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Disabled
@Autonomous(name = "BLUE_FOUNDATION_GRAB")
public class Blue_FoundationSGCS extends Auto_Methods {
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
            strafeDriveEncoder(0.3, 13,  "LEFT",1);
            clamp.setPosition(.75);
            gyroDrive(.2, 92, 0,2);
            leftFoundation.setPosition(1);
            rightFoundation.setPosition(0.15);
            sleep(1600);
            gyroDrive(.5, -154, 0,4);
            leftFoundation.setPosition(0.2);
            rightFoundation.setPosition(.9);
            liftleft.setPower( -.65);
            liftright.setPower( .65);
            sleep(2000);
            liftleft.setPower( -0.16);
            liftright.setPower( 0.16);
            sleep(9500);

            strafeDriveEncoder(.4,60,"RIGHT",2);
            straightDriveEncoder(.3,-15,1);
            clamp("CLOSE", 700);
            liftleft.setPower( .05);
            liftright.setPower(- .05);
            sleep(2000);
            liftleft.setPower( 0);
            liftright.setPower( 0);
            clamp("CLOSE", 700);
            strafeDriveEncoder(.5,40,"RIGHT",3);
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

