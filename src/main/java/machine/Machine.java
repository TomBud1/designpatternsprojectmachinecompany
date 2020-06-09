package machine;

public abstract class Machine {

        protected String name;
        protected String model;
        protected String engine;
        protected int power;

        public void createAllPartsOfTheMachine() {
            System.out.println("Add name: "+name);
            System.out.println("Add model: "+model);
            System.out.println("Add engine: "+engine);
            System.out.println("Creating a machine.");
        }

        public void sendMachineToClient() {
            System.out.println("Sending Machine to client.");
            System.out.println("\n");
        }

        public void certificateMachine(){
            System.out.println("Machine test and certification");
        }

        public void checkMachine(){
            System.out.println("Checking machine before sending to client.");
        }

        @Override
        public String toString() {
            return "Machine{" +
                    "name='" + name + '\'' +
                    ", model='" + model + '\'' +
                    ", engine='" + engine + '\'' +
                    ", power='" + power + '\'' +
                    '}';
        }
}
