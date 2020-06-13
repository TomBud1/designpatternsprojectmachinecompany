package machine.caterpillar.factory;
import machine.Machine;
import machine.MachineFactory;
import machine.MachineType;
import machine.caterpillar.*;


public class CaterpillarMachineFactory extends MachineFactory {
    private static CaterpillarMachineFactory caterpillarMachineFactory;

    public static CaterpillarMachineFactory getInstance() {
        if (caterpillarMachineFactory == null) {
            caterpillarMachineFactory = new CaterpillarMachineFactory();
        }
        return caterpillarMachineFactory;
    }

    public Machine createMachine(MachineType machineType) {
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
