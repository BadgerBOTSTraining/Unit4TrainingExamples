package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ExampleSubsystem;

public class ExampleCommand extends Command{
    
    private final ExampleSubsystem exampleSubsystem;
    private final DoubleSupplier speedSupplier;

    public ExampleCommand(ExampleSubsystem exampleSubsystem, DoubleSupplier speedSupplier){
        this.exampleSubsystem = exampleSubsystem;
        this.speedSupplier = speedSupplier;
        
        addRequirements(exampleSubsystem);
    }

    @Override
    public void initialize(){
        exampleSubsystem.setTargetSpeed(0.5);
    }

    @Override
    public void execute(){
        exampleSubsystem.setTargetSpeed(speedSupplier.getAsDouble());

        SmartDashboard.putNumber("Example Command Speed", speedSupplier.getAsDouble());
    }

    @Override
    public boolean isFinished(){
        return exampleSubsystem.getSensorReading();
    }

    @Override
    public void end(boolean interrupted){
        exampleSubsystem.setTargetSpeed(0);
    }
}
