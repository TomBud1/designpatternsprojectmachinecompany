package machine;

public class MachineArrayIterator implements MachineIterator {

    Machine[] boughtMachines;
    int position = 0;

    public MachineArrayIterator(Machine[] boughtMachines) {
        this.boughtMachines = boughtMachines;
    }

    @Override
    public boolean hasNext() {
        if(position >= boughtMachines.length || boughtMachines[position] == null ) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Machine next() {
        Machine Machine = boughtMachines[position];
        position++;
        return Machine;
    }
}