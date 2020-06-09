import machine.MachineType;
import Machine.Machine;
import Machine.factory.MachineFactory;
import Machine.factory.CaterpillarMachineFactory;
import org.junit.Test;

public class MachineTest {
    @Test
    public void create_all_ford_Machines_by_fabric_methods_factory() {
        MachineFactory bmwFactory = CaterpillarMachineFactory.getInstance();
        Machine hatchBagMachine = bmwFactory.orderMachine(MachineType.RIFLE);
        Machine kombiMachine = bmwFactory.orderMachine(MachineType.KOMBI);
        Machine limousineMachine = bmwFactory.orderMachine(MachineType.LIMOUSINE);
        Machine MINI_RIFLEMachine = bmwFactory.orderMachine(MachineType.MINI_RIFLE);
        Machine GUNMachine = bmwFactory.orderMachine(MachineType.GUN);
        Machine MODULARMachine = bmwFactory.orderMachine(MachineType.MODULAR);
    }
}
