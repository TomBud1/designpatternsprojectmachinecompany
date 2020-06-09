package order;
import machine.MachineType;

public class Order {
    private MachineType MachineType;
    private String userName;
    private String showroomName;

    public Order(MachineType MachineType, String userName, String showroomName) {
        this.MachineType = MachineType;
        this.userName = userName;
        this.showroomName = showroomName;
    }

    public MachineType getMachineType() {
        return MachineType;
    }

    public void setMachineType(MachineType MachineType) {
        this.MachineType = MachineType;
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

    @Override
    public String toString() {
        return "Order{" +
                "MachineType=" + MachineType +
                ", userName='" + userName + '\'' +
                ", showroomName='" + showroomName + '\'' +
                '}';
    }
}
