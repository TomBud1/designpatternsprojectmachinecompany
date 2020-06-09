package machine;

public abstract class MachineFactory {

    public abstract Machine createMachine(MachineType machineType);

    public Machine orderMachine(MachineType MachineType){
        Machine Machine = createMachine(MachineType);
        Machine.createAllPartsOfTheMachine();
        Machine.checkMachine();
        Machine.certificateMachine();
        Machine.sendMachineToClient();
        return Machine;
    }

}

