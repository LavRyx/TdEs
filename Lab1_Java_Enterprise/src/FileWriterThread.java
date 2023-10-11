/**
 * Поток для записи
 */
class FileWriterThread extends Thread {
    private FileWriterUtility utility;

    public FileWriterThread(FileWriterUtility utility) {
        this.utility = utility;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            utility.writeToFile();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}