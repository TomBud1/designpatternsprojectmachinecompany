package machine;

import java.util.List;

public class MachineListIterator implements MachineIterator {

    List<Machine> boughtMachines;
    int position = 0;

    public MachineListIterator(List<Machine> boughtMachines) {
        this.boughtMachines = boughtMachines;
    }

    @Override
    public boolean hasNext() {
        if (position >= boughtMachines.size() || boughtMachines.get(position)== null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Machine next() {
        Machine Machine = boughtMachines.get(position);
        position++;
        return Machine;
    }
}
