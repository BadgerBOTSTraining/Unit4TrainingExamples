package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ExampleSubsystem;

public class ExampleCommand extends Command{
    
    //Reference to the subsystem to add requirements and control subsystem values
    private final ExampleSubsystem exampleSubsystem;
    /*
        A DoubleSupplier is a type that gives you a double when you call .getAsDouble()
        This should be used instead of a reference to a controller or static value when possible
     */
    private final DoubleSupplier speedSupplier;

    public ExampleCommand(ExampleSubsystem exampleSubsystem, DoubleSupplier speedSupplier){
        this.exampleSubsystem = exampleSubsystem;
        this.speedSupplier = speedSupplier;
        
        //Add requirements makes sure that there is only 1 command with each required subsystem
        addRequirements(exampleSubsystem);
    }

    /**
     * Runs once, when the command is scheduled
     */
    @Override
    public void initialize(){
        exampleSubsystem.setTargetSpeed(0.5);
    }

    /**
     * Runs continuously (~20ms between loops) until the command finishes
     */
    @Override
    public void execute(){
        exampleSubsystem.setTargetSpeed(speedSupplier.getAsDouble());

        SmartDashboard.putNumber("Example Command Speed", speedSupplier.getAsDouble());
    }

    /**
     * Decides when the command is finished
     * @return a boolean if the command is finished
     */
    @Override
    public boolean isFinished(){
        return exampleSubsystem.getSensorReading();
    }

    /**
     * Runs whenever the command is finished (whether it was interrupted or not)
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted){
        exampleSubsystem.setTargetSpeed(0);
    }
}
