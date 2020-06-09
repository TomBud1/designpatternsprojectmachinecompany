package headquarter;

import machine.MachineType;
import Machine.Machine;

import Machine.factory.MachineFactory;
import Machine.factory.CaterpillarMachineFactory;
import order.CompletedOrder;
import order.Order;
import shop.Showroom;
import java.util.ArrayList;
import java.util.List;

public class Headquarter {

        private static Headquarter headquarter;

        private List<Showroom> showroomList;

        private List<Order> orderList;

        private List<CompletedOrder> availableMachinesList;

        private MachineFactory bmwFactory;

        private Headquarter() {
            this.showroomList = new ArrayList();
            this.orderList = new ArrayList();
            this.availableMachinesList = new ArrayList();
            this.bmwFactory = new CaterpillarMachineFactory();
        }

        public static Headquarter getInstance() {
            if (headquarter == null) {
                headquarter = new Headquarter();
            }
            return headquarter;
        }

        public void addNewShowroom(Showroom showroom) {
            showroomList.add(showroom);
        }

        public Showroom getShowroomFromList(String showroomName) {
            return showroomList.stream()
                    .filter( showroom -> showroom.getShowroomName().equals(showroomName))
                    .findFirst()
                    .orElse(null);
        }

        public void informAboutNewMachines() {
            showroomList.stream().forEach( showroom -> showroom.getNewMachines(availableMachinesList));
            availableMachinesList = new ArrayList();
        }

        public void produceAllMachines() {
            orderList.stream()
                    .forEach((order) -> {
                        Machine Machine = bmwFactory.orderMachine(order.getMachineType());
                        availableMachinesList.add(new CompletedOrder(Machine, order.getUserName(), order.getShowroomName()));
                    });
            orderList = new ArrayList();
        }

        public void addMachineToOrderList(MachineType MachineType, String userName, String showroomName) {
            orderList.add(new Order(MachineType, userName, showroomName));
        }

    public static Headquarter getHeadquarter() {
        return headquarter;
    }

    public List<Showroom> getShowroomList() {
        return showroomList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<CompletedOrder> getAvailableMachinesList() {
        return availableMachinesList;
    }

    public MachineFactory getFordFactory() {
        return bmwFactory;
    }
}
