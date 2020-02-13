public class Runner extends Thread {

    private Runner nextRunner;

    public Runner(String name, Runner nextRunner) {
        this.nextRunner = nextRunner;
        this.setName(name);
    }

    public Runner(String name) {
        this.nextRunner = nextRunner;
        this.setName(name);
    }

    public void run() {
        try {
            this.sleep(1000);
        } catch (InterruptedException ie) {
        }
        if (nextRunner != null) {
            nextRunner.start();
        }
        if (nextRunner != null) {
            System.out.printf(
                    "\n%s берет палочку " + "\n" + getName() + " бежит к ", this.getName());
        }
        if (nextRunner != null) {
            System.out.print(nextRunner.getName() + "\n");
            try {
                nextRunner.join();
                this.sleep(1000);
                System.out.printf(
                        "\n%s берет палочку " + "\n" + nextRunner.getName() + " бежит к ", nextRunner.getName());
                System.out.print(this.getName() + "\n");
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        } else {
            System.out.print("\n" + getName() + " бежит к финишу" + "\n");
        }
        if (this.getName().equals("Runner 1")) {
            System.out.println(this.getName() + " берет палочку");
        }
    }
}
