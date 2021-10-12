package thread;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import reader.FlightReader;

public class FileBackGroundThread implements Runnable {
    private volatile boolean exit = false;

    @Override
    public void run() {

        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            FlightReader.readfile();

            Map<WatchKey, Path> keyMap = new HashMap();
            Path path = Paths.get("src\\main\\resources");
            keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY), path);
            WatchKey watchKey = null;

            do {
                watchKey = service.take();
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    FlightReader.readfile();

                }
            } while (watchKey.reset());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void stop() {
        exit = true;
    }

}
