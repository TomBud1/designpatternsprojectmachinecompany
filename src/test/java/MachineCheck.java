import machine.MachineType;
import machine.Machine;
import machine.MachineFactory;
import machine.caterpillar.factory.CaterpillarMachineFactory;
import org.junit.Test;

public class MachineCheck {
    @Test
    public void create_all_machines_by_fabric_methods_factory() {
        MachineFactory caterpillarFactory = CaterpillarMachineFactory.getInstance();
        Machine compactor = caterpillarFactory.orderMachine(MachineType.COMPACTOR);
        Machine dozer = caterpillarFactory.orderMachine(MachineType.DOZER);
        Machine drill = caterpillarFactory.orderMachine(MachineType.DRILL);
        Machine excavator = caterpillarFactory.orderMachine(MachineType.EXCAVATOR);
        Machine trackHouse = caterpillarFactory.orderMachine(MachineType.TRACK_LOADER);
        Machine truck = caterpillarFactory.orderMachine(MachineType.TRUCK);
    }
}
