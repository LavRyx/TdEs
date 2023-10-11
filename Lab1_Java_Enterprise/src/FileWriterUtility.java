import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * Класс для работы с файлами и завершения потоков
 */
class FileWriterUtility {
    private final String currentFileName = "currentdata.txt";


    public synchronized void writeToFile() {
        try (FileWriter fileWriter = new FileWriter(currentFileName, true)) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String timeString = dateFormat.format(calendar.getTime());

            for (char c : ("the first thread writes the time: " + timeString).toCharArray()) {
                fileWriter.write(c);
                fileWriter.flush();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkAndBackupFile() {
        synchronized (this) {
            File file = new File(currentFileName);
            if (file.length() > 200) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String timeString = dateFormat.format(calendar.getTime());
                String newFileName ="data_" + timeString + ".txt";

                // Сохраняем содержимое текущего файла в бэкапе
                try (BufferedReader reader = new BufferedReader(new FileReader(currentFileName));
                     FileWriter backupWriter = new FileWriter(newFileName)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        backupWriter.write(line);
                        backupWriter.write("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Обнуляем текущий файл
                try (FileWriter fileWriter = new FileWriter(currentFileName)) {
                    fileWriter.write(""); // Очищаем текущий файл
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("File saved as: " + newFileName);
            }
        }
    }

    public void stopThreads(FileWriterThread stop1, FileCheckerThread stop2) {
        stop1.interrupt();
        stop2.interrupt();
    }
}