package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class ExampleSubsystem extends SubsystemBase{

    private DigitalInput sensor = new DigitalInput(EXAMPLE_SENSOR_ID);

    private CANSparkMax motor = new CANSparkMax(EXAMPLE_MOTOR_ID, MotorType.kBrushless);

    private double targetSpeed;

    public ExampleSubsystem(){
        motor.setIdleMode(IdleMode.kBrake);
    }

    @Override
    public void periodic(){
        motor.set(targetSpeed);

        SmartDashboard.putNumber("Example target speed", targetSpeed);
    }

    public boolean getSensorReading(){
        return sensor.get();
    }

    public void setTargetSpeed(double targetSpeed){
        this.targetSpeed = targetSpeed;
    }

    public double getTargetSpeed(){
        return targetSpeed;
    }


}
