package machine.caterpillar.factory;
import machine.Machine;
import machine.MachineFactory;
import machine.MachineType;
import machine.caterpillar.*;


public class CaterpillarMachineFactory extends MachineFactory {
    private static CaterpillarMachineFactory machineFactory;

    public static CaterpillarMachineFactory getInstance() {
        if (machineFactory == null) {
            machineFactory = new CaterpillarMachineFactory();
        }
        return machineFactory;
    }

    Machine createMachine(MachineType machineType) {
        if (machineType.equals(MachineType.COMPACTOR)) {
            return new CaterpillarCompactor();
        } else if (machineType.equals(MachineType.DOZER)) {
            return new CaterpillarDozer();
        } else if (machineType.equals(MachineType.DRILL)) {
            return new CaterpillarDrill();
        } else if (machineType.equals(MachineType.EXCAVATOR)) {
            return new CaterpillarExcavator();
        } else if (machineType.equals(MachineType.TRACK_LOADER)) {
            return new CaterpillarTrackLoader();
        } else if (machineType.equals(MachineType.TRUCK)) {
            return new CaterpillarTruck();
        } else return null;
    }
}
