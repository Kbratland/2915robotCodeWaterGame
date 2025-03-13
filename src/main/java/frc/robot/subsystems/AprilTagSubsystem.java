package frc.robot.subsystems;

import java.util.List;
import java.util.Vector;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Transform2d;

public class AprilTagSubsystem {
    PhotonCamera camera = new PhotonCamera("photonvision");
    private static double posX[];
    private static double posY[];
    private static double angle[];

    public void rePosition(int tagID){
        var result = camera.getLatestResult();
        if(result.hasTargets()){
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            double pitch = target.getPitch();
            double area = target.getArea();
            double skew = target.getSkew();
            Transform2d pose = target.getCameraToTarget();
            List<TargetCorner> corners = target.getCorners();
            int targetID = target.getFiducialId();

        }
        else{

        }
        return;
    }
}
