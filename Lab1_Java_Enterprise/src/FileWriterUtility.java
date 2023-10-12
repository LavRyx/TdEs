import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 * ����� ��� ������ � ������� � ���������� �������
 */
class FileWriterUtility {
    private final String currentFileName = "currentdata.txt";


    public synchronized void writeToFile() {
        try (FileWriter fileWriter = new FileWriter(currentFileName, true)) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String timeString = dateFormat.format(calendar.getTime());

            for (char c : ("������ ������� ������: " + timeString).toCharArray()) {
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

                // �����
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


                try (FileWriter fileWriter = new FileWriter(currentFileName)) {
                    fileWriter.write(""); // ������� ������� ����
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("���� ��������: " + newFileName);
            }
        }
    }

    public void stopThreads(FileWriterThread stop1, FileCheckerThread stop2) {
        stop1.interrupt();
        stop2.interrupt();
    }
}