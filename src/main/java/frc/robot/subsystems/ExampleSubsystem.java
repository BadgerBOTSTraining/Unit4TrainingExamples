package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class ExampleSubsystem extends SubsystemBase{

    // Sensor to read values from a digital port on the RoboRIO
    private final DigitalInput sensor = new DigitalInput(EXAMPLE_SENSOR_ID);

    // Initialization of a motor
    private final CANSparkMax motor = new CANSparkMax(EXAMPLE_MOTOR_ID, MotorType.kBrushless);

    private double targetSpeed;

    public ExampleSubsystem(){
        motor.setIdleMode(IdleMode.kBrake);
    }

    @Override
    public void periodic(){
        //Set the motor to the target speed
        motor.set(targetSpeed);

        //Sends a number to SmartDashboard
        SmartDashboard.putNumber("Example target speed", targetSpeed);
    }

    /**
     * Method to get the value of the sensor reading
     * @return the sensor's value
     */
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
