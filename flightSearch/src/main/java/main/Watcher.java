package main;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Watcher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WatchService service = FileSystems.getDefault().newWatchService();
		Path path = Paths.get("D:\\files\\AirIndia.csv");
		path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		WatchKey key;

	}

}
