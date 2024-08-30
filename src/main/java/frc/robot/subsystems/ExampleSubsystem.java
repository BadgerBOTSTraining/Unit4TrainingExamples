package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase{
    private CANSparkMax motor = new CANSparkMax(0, MotorType.kBrushless);

    private double targetSpeed;

    public ExampleSubsystem(){
        motor.setIdleMode(IdleMode.kBrake);
    }

    @Override
    public void periodic(){
        motor.set(targetSpeed);

        SmartDashboard.putNumber("Example target speed", targetSpeed);
    }

    public void setTargetSpeed(double targetSpeed){
        this.targetSpeed = targetSpeed;
    }

    public double getTargetSpeed(){
        return targetSpeed;
    }


}
