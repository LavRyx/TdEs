/**
 * Поток проверка
 */
class FileCheckerThread extends Thread {
    private FileWriterUtility utility;

    public FileCheckerThread(FileWriterUtility utility) {
        this.utility = utility;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            utility.checkAndBackupFile();
            try {
                sleep(15000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}