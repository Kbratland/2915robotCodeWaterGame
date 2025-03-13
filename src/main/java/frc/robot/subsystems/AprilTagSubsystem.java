package frc.robot.subsystems;

import java.util.List;
import java.util.Vector;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;

public class AprilTagSubsystem {
    PhotonCamera camera = new PhotonCamera("photonvision");
    private static List<Double> posX;
    private static List<Double> posY;
    private static List<Double> angle;

    public void rePosition(int tagID){
        var result = camera.getLatestResult();
        if(result.hasTargets()){
            PhotonTrackedTarget target = result.getBestTarget();
            double yaw = target.getYaw();
            double pitch = target.getPitch();
            double area = target.getArea();
            double skew = target.getSkew();
            Transform3d pose = target.getBestCameraToTarget();
            List<TargetCorner> corners = target.getDetectedCorners();
            int targetID = target.getFiducialId();

        }
        else{
            
        }
        return;
    }
}
