package headquarter;
import user.iterator.MachineIterator;
import user.UserType;
import Machine.Machine;
import user.model.OldUser;
import user.model.User;
import java.util.ArrayList;
import java.util.List;

public class HeadquarterFacade {

    private Headquarter headquarter;

    public HeadquarterFacade() {
        this.headquarter = headquarter.getInstance();
    }

    public List<User> downloadAllNormalUsers() {
        List<User> allNormalUsers = new ArrayList();
        headquarter.getShowroomList().stream().
                forEach(showroom -> {
                    if(showroom.getTypeOfUsers() == UserType.NORMAL) {
                        allNormalUsers.addAll(showroom.getUserManager().getAllUser());
                    }
                });

        return allNormalUsers;
    }

    public List<OldUser> downloadAllOldUsers() {
        List<OldUser> allOldUsers = new ArrayList();
        headquarter.getShowroomList().stream().
                forEach(showroom -> {
                    if(showroom.getTypeOfUsers() == UserType.OLD) {
                        allOldUsers.addAll(showroom.getUserManager().getAllUser());
                    }
                });

        return allOldUsers;
    }

    public List<Machine> downloadAllBoughtMachines(List<OldUser> allOldUsers, List<User> allNormalUsers) {
        List<Machine> MachineList = new ArrayList();
        getAllMachinesIterator().stream()
                .forEach( (iterator) -> {
                    while(iterator.hasNext()){
                        MachineList.add(iterator.next());
                    }
                });
        return MachineList;
    }

    private List<MachineIterator> getAllMachinesIterator() {
        List<MachineIterator> MachineIterators = new ArrayList();
        downloadAllNormalUsers().stream().forEach(user -> MachineIterators.add(user.createIterator()));
        downloadAllOldUsers().stream().forEach( user -> MachineIterators.add(user.createIterator()));
        return MachineIterators;
    }

}
