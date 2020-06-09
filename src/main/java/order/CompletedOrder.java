package order;
import Machine.Machine;

public class CompletedOrder {
    private Machine Machine;
    private String userName;
    private String showroomName;

    public CompletedOrder(Machine Machine, String userName, String showroomName) {
        this.Machine = Machine;
        this.userName = userName;
        this.showroomName = showroomName;
    }

    public Machine getMachine() {
        return Machine;
    }

    public void setMachine(Machine Machine) {
        this.Machine = Machine;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShowroomName() {
        return showroomName;
    }

    public void setShowroomName(String showroomName) {
        this.showroomName = showroomName;
    }
}


